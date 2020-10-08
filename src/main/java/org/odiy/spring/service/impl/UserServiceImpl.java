package org.odiy.spring.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.odiy.spring.model.User;
import org.odiy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
	
	 /** MyBatis */
    // --> import org.apache.ibatis.session.SqlSession
    @Autowired
    SqlSession sqlSession;

    /* 유저 한 명의 데이터 불러오기
	 * @param input 유저의 고유번호(user_num)를 담는 Beans
	 * @return 조회된 유저의 User객체 데이터
	 * @throws Exception
	 */
    @Override
    public User getUserItem(User input) throws Exception {
        User result = null;

        try {
            result = sqlSession.selectOne("UserMapper.selectItem", input);

            if (result == null) {
                throw new NullPointerException("result=null");
            }
        } catch (NullPointerException e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("조회된 데이터가 없습니다.");
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("데이터 조회에 실패했습니다.");
        }

        return result;
    }

    /**
	 * 유저 목록 불러오기
	 * @param input 검색 조건을 담은 Beans
	 * @return 조회 결과 리스트
	 * @throws Exception
	 */
    @Override
    public List<User> getUserList(User input) throws Exception {
        List<User> result = null;

        try {
            result = sqlSession.selectList("UserMapper.selectList", input);
            if (result == null) {
                throw new NullPointerException("result=null");
            }
        } catch (NullPointerException e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("조회된 데이터가 없습니다.");
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("데이터 조회에 실패했습니다.");
        }

        return result;
    }

    /**
	 * 유저 추가(회원가입)
	 * @param input 저장할 정보를 담은 Beans
	 * @return 추가된 유저 수
	 * @throws Exception
	 */
    @Override
    public int addUser(User input) throws Exception {
        int result = 0;
        
        // 중복검사 기능을 먼저 호출한다. --> 예외가 발생할 경우 이 메서드가 정의하는 throws문에 의해 컨트롤러로 예외가 전달된다.
        
        this.emailUniqueCheck(input);

        try {
            result = sqlSession.insert("UserMapper.insertItem", input);

            if (result == 0) {
                throw new NullPointerException("result=0");
            }
        } catch (NullPointerException e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("저장된 데이터가 없습니다.");
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("데이터 저장에 실패했습니다.");
        }

        return result;
    }

    /**
	 * 유저 수정(회원정보수정)
	 * @param input 수정할 정보를 담은 Beans
	 * @return 수정된 데이터 수
	 * @throws Exception
	 */
    @Override
    public int editUser(User input) throws Exception {
        int result = 0;

        try {
            result = sqlSession.update("UserMapper.updateItem", input);
            if (result == 0) {
                throw new NullPointerException("result=0");
            }
        } catch (NullPointerException e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("수정된 데이터가 없습니다.");
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("데이터 수정에 실패했습니다.");
        }

        return result;
    }
    /**
	 * is_out 변경(회원탈퇴)
	 * @param input 탈퇴할 회원 정보를 담은 Beans
	 * @return 수정된 데이터 수
	 * @throws Exception
	 */
    @Override
    public int outUser(User input) throws Exception {
        int result = 1;

        try {
            result = sqlSession.update("UserMapper.updateItem", input);
            if (result == 0) {
                throw new NullPointerException("result=0");
            }
        } catch (NullPointerException e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("삭제된 데이터가 없습니다.(회원탈퇴)");
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("데이터 삭제에 실패했습니다.");
        }

        return result;
    }
   
    

    /**
	 * 유저 삭제(회원정보 말소)
	 * @param input 삭제할 회원 정보를 담은 Beans
	 * @return 수정된 데이터 수
	 * @throws Exception
	 */
    @Override
    public int deleteUser(User input) throws Exception {
        int result = 0;

        try {
            result = sqlSession.delete("UserMapper.deleteItem", input);
            if (result == 0) {
                throw new NullPointerException("result=0");
            }
        } catch (NullPointerException e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("삭제된 데이터가 없습니다.");
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("데이터 삭제에 실패했습니다.");
        }

        return result;
    }
   

    /**
     * 이메일 중복검사
     * @param input
     * @throws Exception
     */
    @Override
    public int emailUniqueCheck(User input) throws Exception {
        int result = 0;

        try {
            result = sqlSession.selectOne("UserMapper.emailUniqueCheck", input);
            if (result > 0) {
                throw new NullPointerException("result=" + result);
            }
        } catch (NullPointerException e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("이미 사용중인 이메일 주소 입니다.");
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("이메일 중복검사에 실패했습니다.");
        }
		return result;
    }

    /**
     * 로그인
     * @param input
     * @throws Exception
     */
    @Override
    public User login(User input) throws Exception {
        User result = null;

        try {
            result = sqlSession.selectOne("UserMapper.login", input);

            if (result == null) {
                throw new NullPointerException("result=null");
            }
            
            // 조회에 성공하면 result에 저장되어 있는 PK를 활용하여 로그인 시간을 갱신한다.
             sqlSession.update("UserMapper.updateTime", result);
        } catch (NullPointerException e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("아이디나 비밀번호가 잘못되었습니다.");
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("데이터 조회에 실패했습니다.");
        }

        return result;
    }
    
    
    /**
     * 이메일 인증 관련
     * 
     */
   // @Inject    
   // MemberDAO memberdao; //dao를 사용하기 위해 의존성을 주입
    private JavaMailSender mailSender;
    
	@Override
	public void join(Map<String, Object> map, User dto) {
		map.get("userEmail");
		
	}


}
