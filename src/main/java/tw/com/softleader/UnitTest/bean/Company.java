/**
 * @Description : 公司 物件
 * @ClassName : Company.java
 * @Copyright : Copyright (c) 2024 
 * @ModifyHistory : 
 *  v1.00, 2024/08/03, frankchang
 *   1) First Release.
 */

package tw.com.softleader.UnitTest.bean;

import lombok.Data;

@Data
public class Company {
	
	private Integer companyKey;
	
	private String companyUid;
	
	private String companyName;
	
	private Integer status;
	
	private String address;
	
	private String phone;

}
