package org.odiy.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.odiy.spring.model.ApiItem;
import org.odiy.spring.model.TourApi.Response.Body.Items.Item;
import org.odiy.spring.service.TourApiService;

/** @filename	: TourApiServiceImpl.java
 * @description	: 
 * @author		: 박 통 영 (zawookmist@gmail.com)
 */
@Slf4j
@Service
public class TourApiServiceImpl implements TourApiService {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public void collectTourApiList(List<Item> input) throws Exception {
		try {
			for (Item item : input) {
				// contentid가 중복될 경우 update 수행
				if (sqlSession.update("TourApiMapper.updateItem", item) == 0) {
					// update 내용이 없는 경우 insert 수행
					sqlSession.insert("TourApiMapper.insertItem", item);
				}
			}
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 저장 실패");
		}
		
	}

	@Override
	public int getTourApiCount(ApiItem input) throws Exception {
		int result = 0;

		try {
			result = sqlSession.selectOne("TourApiMapper.selectCountAll", input);
		} catch (Exception e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}
	

	@Override
	public List<ApiItem> getTourApiList(ApiItem input) throws Exception {
		List<ApiItem> result = null;

		try {
			result = sqlSession.selectList("TourApiMapper.selectList", input);

			if (result == null) {
				throw new NullPointerException("result = null");
			}

		} catch (NullPointerException e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}
	
	@Override
	public List<ApiItem> getTourApiImage(ApiItem input) throws Exception {
		List<ApiItem> result = null;

		try {
			result = sqlSession.selectList("TourApiMapper.selectImage", input);

			if (result == null) {
				throw new NullPointerException("result = null");
			}

		} catch (NullPointerException e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}
	
	
	@Override
	public List<ApiItem> getTourApiRecommend(ApiItem input) throws Exception {
		List<ApiItem> result = null;

		try {
			result = sqlSession.selectList("TourApiMapper.selectRecommend", input);

			if (result == null) {
				throw new NullPointerException("result = null");
			}

		} catch (NullPointerException e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}
	
	

	@Override
	public ApiItem getTourApiItem(ApiItem input) throws Exception {
		ApiItem result = null;

		try {
			result = sqlSession.selectOne("TourApiMapper.selectItem", input);

			if (result == null) {
				throw new NullPointerException("result = null");
			}

		} catch (NullPointerException e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}

	
	
	@Override
	public List<ApiItem> getDetailRecommend(ApiItem input) throws Exception {
		List<ApiItem> result = null;

		try {
			result = sqlSession.selectList("TourApiMapper.selectDetailRecommend", input);

			if (result == null) {
				throw new NullPointerException("result = null");
			}

		} catch (NullPointerException e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}
	
	@Override
	public List<ApiItem> getDetailFestival(ApiItem input) throws Exception {
		List<ApiItem> result = null;

		try {
			result = sqlSession.selectList("TourApiMapper.selectDetailFestival", input);

			if (result == null) {
				throw new NullPointerException("result = null");
			}

		} catch (NullPointerException e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public int deleteTourApiAll(ApiItem input) throws Exception {
		int result = 0;
		try {
			result=sqlSession.delete("TourApiMapper.deleteAll", input);
			if (result==0) {
				throw new NullPointerException("result=0");
			}
		} catch (NullPointerException e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("삭제된 데이터가 없습니다.");
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 삭제 실패");
		}
		return result;
	}
	
	
}
