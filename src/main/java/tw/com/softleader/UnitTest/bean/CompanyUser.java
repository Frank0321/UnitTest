/**
 * @Description : 使用者 物件
 * @ClassName : CompanyUser.java
 * @Copyright : Copyright (c) 2024 
 * @ModifyHistory : 
 *  v1.00, 2024/08/03, frankchang
 *   1) First Release.
 */

package tw.com.softleader.UnitTest.bean;

import lombok.Data;

@Data
public class CompanyUser {

	private Integer userKey;
	
	private Integer companyKey;
	
	private String userUid;
	
	private String userName;
	
	private Integer status;
}
