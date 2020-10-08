package org.odiy.spring.model;

import org.odiy.spring.helper.UploadItem;

import lombok.Data;

/** @filename	: User.java
 * @description	: 
 * @author		: 박 통 영 (zawookmist@gmail.com)
 */
@Data
public class User {
	
	private int userNum;
	private String userEmail;
	private String userPw;
	private String userName;
	private String userBirthday;
	private String userThumb;
	private String userMemo;
	private String isAdmin;
	private String isOut;
	private String regDate;
	private String editDate;
	
    public String getUserEmail() {
        return userEmail;
    }
	
}
