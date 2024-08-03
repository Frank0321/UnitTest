/**
 * @Description : 帳號 物件
 * @ClassName : CompanyAccount.java
 * @Copyright : Copyright (c) 2024 
 * @ModifyHistory : 
 *  v1.00, 2024/08/03, frankchang
 *   1) First Release.
 */

package tw.com.softleader.UnitTest.bean;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CompanyAccount {

	private Integer companyAccountKey;
	
	private Integer companyKey;
	
	private String companyAccount;
	
	private String currencyId;
	
	private Integer permission;
	
	private BigDecimal companyAccountValue;
}
