/**
 * @Description : 登入 req
 * @ClassName : LoginRequest.java
 * @Copyright : Copyright (c) 2024 
 * @ModifyHistory : 
 *  v1.00, 2024/08/04, frankchang
 *   1) First Release.
 */

package tw.com.softleader.UnitTest.api.req;

import lombok.Data;

@Data
public class LoginRequest {

	private String userUid;
	
	private String companyUid;
	
}
