package org.odiy.spring.service;

import java.util.List;

import org.odiy.spring.model.ApiItem;
import org.odiy.spring.model.TourApi.Response.Body.Items.Item;

/**
 * @filename : TourApiService.java
 * @description :
 * @author : 박 통 영 (zawookmist@gmail.com)
 */
public interface TourApiService {
	/**
	 * TourApi response item을 데이터베이스에 저장
	 * 
	 * @param input TourApi response를 List화한 데이터
	 * @throws Exception
	 */
	public void collectTourApiList(List<Item> input) throws Exception;

	/**
	 * TourApi 데이터베이스에서 기본 데이터 검색결과 불러오기
	 * 
	 * @param input 검색 조건을 담은 TourApi 객체
	 * @return 조회 결과 리스트
	 * @throws Exception
	 */
	public List<ApiItem> getTourApiList(ApiItem input) throws Exception;

	/**
	 * TourApi 데이터베이스에서 단일 데이터 검색결과 불러오기
	 * 
	 * @param input 검색 조건을 담은 TourApi 객체
	 * @return 조회 결과 아이템
	 * @throws Exception
	 */
	public ApiItem getTourApiItem(ApiItem input) throws Exception;
	
	
	/**
	 * TourApi 데이터베이스의 검색조건을 충족하는 데이터 개수 불러오기
	 * -> 결과목록 페이지를 위한 메서드
	 * @param input 검색 조건을 담은 TourApi 객체
	 * @return 조회개수
	 * @throws Exception
	 */
	public int getTourApiCount(ApiItem input) throws Exception;
	
	/**
	 * TourApi 데이터베이스의 이미지가 있는 데이터 불러오기
	 * @param 데이터를 담은 TourApi 객체
	 * @return 조회결과 아이템리스트
	 * @throws Exception
	 */
	public List<ApiItem> getTourApiImage(ApiItem input) throws Exception;
	
	/**
	 * TourApi 데이터베이스의 readcount가 높은 데이터 랜덤으로 불러오기
	 * @param 데이터를 담은 TourApi 객체
	 * @return 조회결과 아이템리스트
	 * @throws Exception
	 */
	public List<ApiItem> getTourApiRecommend(ApiItem input) throws Exception;
	
	/**
	 * TourApi 데이터베이스에서 위경도를 활용하여 지역추천
	 * @param 데이터를 담은 TourApi 객체
	 * @return 조회결과 아이템리스트
	 * @throws Exception
	 */
	public List<ApiItem> getDetailRecommend(ApiItem input) throws Exception;

	/**
	 * TourApi 데이터베이스에서 contenttypeid를 활용하여 축제추천
	 * @param 데이터를 담은 TourApi 객체
	 * @return 조회결과 아이템리스트
	 * @throws Exception
	 */
	public List<ApiItem> getDetailFestival(ApiItem input) throws Exception;
	/**
	 * TourApi 데이터베이스의 테이블 삭제
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public int deleteTourApiAll(ApiItem input) throws Exception;
}
