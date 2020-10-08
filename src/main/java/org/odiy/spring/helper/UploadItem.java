package org.odiy.spring.helper;

import lombok.Data;

/** @filename	: UploadItem.java
 * @description	: 
 * @author		: 박 통 영 (zawookmist@gmail.com)
 */
@Data
public class UploadItem {
	
	private String fieldName;
	private String orginName;
	private String contentType;
	private long fileSize;
	private String filePath;
	private String thumbnailPath;
	private String fileUrl;
	private String thumbnailUrl;
	
}
