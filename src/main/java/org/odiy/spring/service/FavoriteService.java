package org.odiy.spring.service;

import java.util.List;

import org.odiy.spring.model.ApiItem;
import org.odiy.spring.model.FavorPlan;

public interface FavoriteService {

	/**
	 * 즐겨찾기 추가
	 * @param 추가할 객체정보
	 * @return int
	 * @throws Exception
	 */
	public int insertFavoriteItem(FavorPlan input) throws Exception;
	
	/**
	 * 중복데이터 확인
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public int checkFavoriteItem(FavorPlan input) throws Exception;
	
	
	/**
	 * FavorPlan 데이터베이스의 해당하는 데이터 개수 불러오기
	 * -> 결과목록 페이지를 위한 메서드
	 * @param input 검색 조건을 담은 FavorPlan 객체
	 * @return 조회개수
	 * @throws Exception
	 */
	public int getFavoriteCount(FavorPlan input) throws Exception;
	
	/**
	 * FavorPlan 데이터베이스에서 데이터 불러오기
	 * 
	 * @param input 검색 조건을 담은 FavorPlan 객체
	 * @return 조회 결과 리스트
	 * @throws Exception
	 */
	public List<FavorPlan> getFavoriteList(FavorPlan input) throws Exception;
	
	
	/**
	 * 즐겨찾기 데이터 삭제하기
	 * @param FavorPlan 삭제할 즐겨찾기 정보를 담고있는 Beans
	 * @return int : 삭제여부 (0=삭제실패)
	 * @throws Exception
	 */
	public int deleteFavorite (FavorPlan input) throws Exception;
}
