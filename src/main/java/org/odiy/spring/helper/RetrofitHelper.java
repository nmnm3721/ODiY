package org.odiy.spring.helper;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Slf4j
public class RetrofitHelper {
	
	public Retrofit getRetrofit(String baseUrl) {

		// 통신 객체를 생성하기 위한 Builder 객체 정의
		OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

		// 통신 객체에 Log 기록 객체를 연결한다
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new MyLogger());
		logging.level(Level.BODY);
		httpClientBuilder.addInterceptor(logging);
		
		// MyInterceptor 클래스의 객체를 통신객체에 연결한다
		// httpClientBuilder.addNetworkInterceptor(new MyInterceptor());
		
		// Builder를 통해 통신 객체 생성
		OkHttpClient httpClient = httpClientBuilder.build();
		
		// Retrofit을 생성하는 기능을 수행하는 객체 정의
		Retrofit.Builder builder = new Retrofit.Builder();
		
		// 기본 주소 지정
		builder.baseUrl(baseUrl);
		
		// 통신결과를 Gson객체를 통해 처리하도록 연결한다 (JSON 파싱 자동화)
		builder.addConverterFactory(GsonConverterFactory.create());
		
		// 통신 객체를 연결한다
		builder.client(httpClient);
		
		// 모든 설정이 반영된 Retrofit 객체 생성
		Retrofit retrofit = builder.build();
		
		return retrofit;
	}
	
	public class MyLogger implements HttpLoggingInterceptor.Logger {
		@Override
		public void log(String logMessage) {
			// 전달받은 문자열을 로그로 저장한다.
			log.debug(logMessage);	
		}
	}
/**	
	public class MyInterceptor implements Interceptor {

		@Override
		public Response intercept(Chain chain) throws IOException {
			Request originalRequest = chain.request();
			Request.Builder builder = originalRequest.newBuilder();
			builder.removeHeader("User-Agent");
			
			// 임의의 웹 브라우저 정보로 설정
			builder.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecho) Chrome/75.0.3770.142 Safari/537.36");
			
			Request newRequest = builder.build();
			Headers headers = newRequest.headers();
			
			for (int i=0; i<headers.size(); i++) {
				String name = headers.name(i);
				String values = headers.get(name);
				log.debug("(H); -> " + name + ": " + values);
			}
			return chain.proceed(newRequest);
		}	
	}
*/
}
