package org.odiy.spring.helper;

import java.io.File;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;
import net.coobird.thumbnailator.geometry.Positions;

@Slf4j
public class WebHelper {
	/** 기본 인코딩 타입 설정 */
	private String encType;

	/** JSP의 request 내장 객체 */
	// --> import javax.servlet.http.HttpServletRequest;
	private HttpServletRequest request;

	/** JSP의 response 내장 객체 */
	// --> import javax.servlet.http.HttpServletResponse;
	private HttpServletResponse response;
	
	
	private String uploadDir;
	
	private String uploadPath;
	

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	
	public UploadItem saveMultipartFile(MultipartFile multipartFile) throws NullPointerException,Exception{
		UploadItem item=null;
		/** 1> 업로드 파일 저장하기*/
		//파일의 원본이름 추출 
		String orginName=multipartFile.getOriginalFilename();
		
		//업로드 된 파일이 존재하는지 확인
		if(orginName.isEmpty()) {
			throw new NullPointerException("업로드 된 파일이 없음");
		}
		
		/** 2> 동일한 이름의 파일이 존재하는지 검사한다*/
		String ext = orginName.substring(orginName.lastIndexOf("."));
		String fileName= null;
		File targetFile=null;
		int count=0;
		
		while(true) {
			fileName=String.format("%d%d%s",System.currentTimeMillis(),count,ext);
			//업로드 파일이 저장될 폴더 + 파일이름으로 파일 객체를 생성한다
			targetFile= new File(this.uploadDir,fileName);
			//동일한 이름의 파일이없다면 반복중단
			if(!targetFile.exists()) {
				break;
			}
			
			count++;
		}//end while
		
		/** 3> 업로드된 파일을 결정된 파일 경로로 저장*/
		multipartFile.transferTo(targetFile);
		/** 4> 업로드 경로 정보 처리하기*/
		//복사된 파일의 절대경로를 추출한다
		//-->운영체제 호환을 위해 역슬래쉬를 슬래쉬로 변환
		String absPath=targetFile.getAbsolutePath().replace("\\", "/");
		//절대경로에서 이미 root-context에 지정되어 있는 업로드 폴더 경로를 삭제한다/
		String filePath=absPath.replace(this.uploadDir, "");
		item = new UploadItem();
		item.setContentType(multipartFile.getContentType());
		item.setFieldName(multipartFile.getName());
		item.setFileSize(multipartFile.getSize());
		item.setOrginName(orginName);
		item.setFilePath(filePath);
		
		//WepHelper에 의해 생성된 업로드 경로는 서버상의 위치일뿐 웹상에 노출될수있는 형태는 아니다
		//View를 통해 웹상에 노출하기 위해서는 업로드 위치의 URL PATH를 덧붙인 형태로 경로를 가공해야 한다
		String fileUrl=this.getUploadUrl(filePath);
		item.setFileUrl(fileUrl);
		
		return item;
		
	}
	public String createThumbnail(String path, int width, int height, boolean crop) throws Exception {
		/** 1>썸네일 생성 정보를 로그로 기록하기 */
		log.debug(String.format("Thumbnailpath: %s,size: %dx%d,crop:%s", path, width, height, String.valueOf(crop)));

		/** 2>저장될 썸네일 이미지의 경로 문자열 만들기 */
		File loadFile = new File(this.uploadDir, path);
		String dirPath = loadFile.getParent();
		String fileName = loadFile.getName();
		int p = fileName.lastIndexOf(".");
		String name = fileName.substring(0, p);
		String ext = fileName.substring(p + 1);
		String prefix = crop ? "_crop_" : "_resize_";

		// 최종 파일이름을 구성한다 --> 원본이름 + 크롭여부 +요청된 사이즈
		// ex> myphoto_resize_320x240.jpg
		String thumbName = name + prefix + width + "x" + height + "." + ext;

		File f = new File(dirPath, thumbName);
		String saveFile = f.getAbsolutePath();

		// 생성될 썸네일 이미지의 경로를 로그로 기록
		log.debug(String.format("[Thumbnail] saveFile: %s", saveFile));

		/** 3>썸네일 이미지 생성하고 최종 결로 리턴 */
		// 해당경로 이미지 없는경우에만 수행
		if (!f.exists()) {
			// 원본이미지 가져오기
			Builder<File> builder = Thumbnails.of(loadFile);

			if (crop == true) {
				builder.crop(Positions.CENTER);
			}

			builder.forceSize(width, height);
			builder.useExifOrientation(true);
			builder.outputFormat(ext);
			builder.toFile(saveFile);
		}
		//최종적으로 생성된 경로에서 업로드 폴더까지의 경로를 제거한다
		saveFile=saveFile.replace("\\","/").replace(this.uploadDir,"");

		return saveFile;

	}

	
	/**
	 * 싱글톤 객체가 생성될 때 호출되는 메서드로 JSP의 주요 내장객체를 멤버변수에 연결한다.
	 *
	 * @param request
	 * @param response
	 */
	public void init(HttpServletRequest request, HttpServletResponse response) {
		this.request = request; // JSP 내장객체 참조하기
		this.response = response; // JSP 내장객체 참조하기

		String methodName = request.getMethod(); // GET방식인지, POST방식인지 조회한다.
		String url = request.getRequestURL().toString(); // 현재 URL을 획득한다.
		String queryString = request.getQueryString(); // URL에서 "?"이후의 GET파라미터 문자열을 모두 가져온다.

		if (queryString != null) { // 가져온 값이 있다면 URL과 결합하여 완전한 URL을 구성한다.
			url = url + "?" + queryString;
		}

		log.debug(String.format("[%s] %s", methodName, url)); // 획득한 정보를 로그로 표시한다.

		/** 내장객체 초기화 -> utf-8 설정 */
		// --> import java.io.UnsupportedEncodingException;
		try {
			this.request.setCharacterEncoding(this.encType);
			this.response.setCharacterEncoding(this.encType);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/** Getter, Setter 메서드 */
	public String getEncType() {
		return encType;
	}

	public void setEncType(String encType) {
		this.encType = encType;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * 메시지 표시 후, 페이지를 지정된 곳으로 이동한다.
	 *
	 * @param url - 이동할 페이지의 URL, Null일 경우 이전페이지로 이동
	 * @param msg - 화면에 표시할 메시지. Null일 경우 표시 안함
	 * @return ModelAndView
	 */
	public ModelAndView redirect(String url, String msg) {

		// 획득한 정보를 로그로 표시한다.
		log.debug(String.format(" --> [redirect] %s >> %s", url, msg));

		// 가상의 View로 만들기 위한 HTML 태그 구성
		String html = "<!doctype html>";
		html += "<html>";
		html += "<head>";
		html += "<meta charset='" + this.encType + "'>";

		// 메시지 표시
		if (msg != null) {
			html += "<script type='text/javascript'>alert('" + msg + "');</script>";
		}

		// 페이지 이동
		if (url != null) {
			html += "<meta http-equiv='refresh' content='0; url=" + url + "' />";
		} else {
			html += "<script type='text/javascript'>history.back();</script>";
		}

		html += "</head>";
		html += "<body></body>";
		html += "</html>";

		return this.virtualView(html);
	}

	/**
	 * 파라미터로 받은 내용을 가상의 View로 생성후 리턴한다. 브라우저에게 전달할 HTML,CSS,JS 조합을 출력하기 위해 사용한다.
	 * 
	 * @param body - 브라우저에게 전달할 HTML,CSS,JS 조합 문자열
	 * @return ModelAndView
	 */
	public ModelAndView virtualView(final String body) {
		/** 가상의 View를 익명 클래스 방식으로 생성하여 리턴 */
		// --> import org.springframework.web.servlet.View;
		// --> import org.springframework.web.servlet.view.AbstractView;
		View view = new AbstractView() {
			@Override
			protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest request,
					HttpServletResponse response) throws Exception {
				PrintWriter out = response.getWriter();
				out.println(body);
				out.flush();
			}
		};

		// 가상의 뷰를 리턴한다.
		return new ModelAndView(view);
	}
	
	
	/**
	 * 전달받은 Map객체에 rt와 pubData 값을 추가한 후 리턴한다.
	 * @param statusCode	HTTP 결과코드 (200, 404, 500 등)
	 * @param rt			결과메시지 (성공일 경우 OK, 그 밖의 경우 에러 메시지)
	 * @param data			JSON으로 변환할 데이터 컬렉션
	 * @return Map<String, Object>
	 */
	public Map<String, Object> getJsonData(int statusCode, String rt, Map<String, Object> data) {
		
		/** 1) JSON 형식 출력을 위한 HTTP 헤더 설정 */
		response.setContentType("application");
		
		response.setStatus(statusCode);
		
		
		
		this.response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
		this.response.setHeader("Access-Control-Max-Age", "3600");
		this.response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		this.response.setHeader("Access-Control-Allow-Origin", "*");
		
		
		/** 2) 파라미터로 전달된 Map 객체에 rt와 pubDate 값을 추가한 새로운 Map 생성하기 */
		Calendar c = Calendar.getInstance();
		String pubData = String.format("%04d-%02d-%02d %02d:%02d:%02d",
							c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH),
							c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("rt", rt);
		
		map.put("pubData", pubData);
		
		if (data != null) {
			map.putAll(data);
		}
		
		return map;
	}
	
	
	/**
	 * 정성적인 결과를 위한 메서드 Overload
	 * 
	 * JSON 형식으로 결과메시지를 리턴하기 위한 메서드 오버로드
	 * HTTP 상태코드는 200으로 설정하고, 결과메시지는 "OK"라는 값을 설정하여
	 * getJsonData(int statusCode, String rt, Map<String, Object> data)
	 * 를 호출한다.
	 * 
	 * @param data		JSON으로 변환할 데이터 컬렉션
	 * 
	 * @return Map<String, Object>
	 */
	public Map<String, Object> getJsonData(Map<String, Object> data) {
		return this.getJsonData(200, "OK", data);
	}
	
	/**
	 * 정성적인 결과를 위한 메서드 Overload
	 * 
	 * JSON 형식으로 결과메시지를 리턴하기 위한 메서드 오버로드
	 * HTTP 상태코드는 200으로 설정하고, 결과메시지는 "OK"라는 값을 설정하여
	 * getJsonData(int statusCode, String rt, Map<String, Object> data)
	 * 를 호출한다.
	 * 
	 * JSON으로 표현하고자 하는 컬렉션이 없지만 처리 결과는 성공인 경우 사용
	 * ex) 데이터 입력, 수정, 삭제 등을 수행하고 특별히 조회 결과를 반환하지 않을 경우
	 * 
	 * @param data		JSON으로 변환할 데이터 컬렉션
	 * 
	 * @return Map<String, Object>
	 */
	public Map<String, Object> getJsonData() {
		return this.getJsonData(200, "OK", null);
	}
	
	/**
	 * JSON 형식으로 에러메시지를 리턴한다.
	 * HTTP 상태코드는 500으로 설정하고, 결과메시지는 파라미터로 전달되는 값을 설정하여
	 * JSON 문자열을 리턴한다.
	 * 
	 * Service 구현체에서 예외 발생시 전달하는 에러 메시지 등을 JSON으로 표현할 때 사용.
	 * 
	 * @param rt
	 * 
	 * @return Map<String, Object>
	 */
	public Map<String, Object> getJsonError(String rt) {
		return this.getJsonData(500, rt, null);
	}
	
	/**
	 * JSON 형식으로 잘못된 접근에 대한 경고메시지를 리턴한다.
	 * HTTP 상태코드는 400으로 설정하고, 결과메시지는 파라미터로 전달되는 값을 설정하여
	 * JSON 문자열을 리턴한다.
	 * 
	 * 파라미터 점검 과정에서 유효성 검증에 통과하지 못한 경우 사용.
	 * 
	 * @param rt
	 * 
	 * @return Map<String, Object>
	 */
	public Map<String, Object> getJsonWarning(String rt) {
		return this.getJsonData(400, rt, null);
	}
	
	
	
	/**업로드 폴더 하위에 저장되어있는 파일이름을 전달받아 web에서 접근가능한 경로로 리턴한다*/
	public String getUploadUrl(String filePath) {
		File f = new File(this.uploadPath,filePath);
		String path = f.getPath();
		return path.replace("\\","/");
	}
	
	
	
	
	
}






















