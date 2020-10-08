package org.odiy.spring.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.odiy.spring.model.ApiItem;
import org.odiy.spring.model.FavorPlan;
import org.odiy.spring.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FavoriteServiceImpl implements FavoriteService {

	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertFavoriteItem(FavorPlan input) throws Exception {
		int result = 0;

		try {
			result = sqlSession.insert("FavoriteMapper.insertItem", input);

			if (result == 0) {
				throw new NullPointerException("result=0");
			}

		} catch (NullPointerException e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("저장된 데이터가 없습니다.");
		} catch (Exception e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("데이터 저장에 실패했습니다.");
		}

		return result;
	}

	@Override
	public int checkFavoriteItem(FavorPlan input) throws Exception {
		int result = 0;

		try {
			result = sqlSession.selectOne("FavoriteMapper.checkItem", input);

			if (result == 0) {
				throw new NullPointerException("result=0");
			}

		} catch (NullPointerException e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("저장된 데이터가 없습니다.");
		} catch (Exception e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("데이터 저장에 실패했습니다.");
		}

		return result;
	}

	@Override
	public int getFavoriteCount(FavorPlan input) throws Exception {
		int result = 0;

		try {
			result = sqlSession.selectOne("FavoriteMapper.selectCountAll", input);
		} catch (Exception e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public List<FavorPlan> getFavoriteList(FavorPlan input) throws Exception {
		List<FavorPlan> result = null;

		try {
			result = sqlSession.selectList("FavoriteMapper.selectList", input);

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
	public int deleteFavorite(FavorPlan input) throws Exception {
		int result = 0;

		try {

			result = sqlSession.delete("FavoriteMapper.deleteItem", input);

			if (result == 0) {
				throw new NullPointerException("result=0");
			}

		} catch (NullPointerException e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("삭제된 데이터가 없습니다.");
		} catch (Exception e) {
			log.debug(e.getLocalizedMessage());
			throw new Exception("데이터 삭제에 실패했습니다.");
		}

		return result;
	}

}
