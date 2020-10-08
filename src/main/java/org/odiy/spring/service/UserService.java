package org.odiy.spring.service;

import java.util.List;
import java.util.Map;

import org.odiy.spring.model.User;

/** @filename	: UserService.java
 * @description	: 
 * @author		: 박 통 영 (zawookmist@gmail.com)
 */
public interface UserService {
	
	/**
	* 이메일 인증 관련 데이터 불러오기 
	* @param map
	* @param dto
	*/
	public void join (Map<String, Object>map,User dto);
		
	/**
	 * 유저 한 명의 데이터 불러오기
	 * @param input 유저의 고유번호(user_num)를 담는 Beans
	 * @return 조회된 유저의 User객체 데이터
	 * @throws Exception
	 */
	public User getUserItem(User input) throws Exception;
	/**
	 * 유저 목록 불러오기
	 * @param input 검색 조건을 담은 Beans
	 * @return 조회 결과 리스트
	 * @throws Exception
	 */
	public List<User> getUserList(User input) throws Exception;
	/**
	 * 유저 추가(회원가입)
	 * @param input 저장할 정보를 담은 Beans
	 * @return 추가된 유저 수
	 * @throws Exception
	 */
	public int addUser(User input) throws Exception;
	/**
	 * 유저 수정(회원정보수정)
	 * @param input 수정할 정보를 담은 Beans
	 * @return 수정된 데이터 수
	 * @throws Exception
	 */
	public int editUser(User input) throws Exception;
	/**
	 * is_out 변경(회원탈퇴)
	 * @param input 탈퇴할 회원 정보를 담은 Beans
	 * @return 수정된 데이터 수
	 * @throws Exception
	 */
	public int outUser(User input) throws Exception;
	/**
	 * 유저 삭제(회원정보 말소)
	 * @param input 삭제할 회원 정보를 담은 Beans
	 * @return 수정된 데이터 수
	 * @throws Exception
	 */
	public int deleteUser(User input) throws Exception;
	
	/**
	 * 이메일중복검사
	 * @return 
	 */
	public int emailUniqueCheck(User input) throws Exception;
	
	/**
	 * 로그인
	 */
	public User login(User input) throws Exception;
	
}