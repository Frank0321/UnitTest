/**
 * @Description : 登入 業務邏輯
 * @ClassName : LoginService.java
 * @Copyright : Copyright (c) 2024 
 * @ModifyHistory : 
 *  v1.00, 2024/08/04, frankchang
 *   1) First Release.
 */

package tw.com.softleader.UnitTest.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tw.com.softleader.UnitTest.api.req.LoginRequest;
import tw.com.softleader.UnitTest.api.res.LoginResponse;
import tw.com.softleader.UnitTest.bean.Company;
import tw.com.softleader.UnitTest.bean.CompanyUser;
import tw.com.softleader.UnitTest.bean.service.CompanyService;
import tw.com.softleader.UnitTest.bean.service.UserService;

@Slf4j
@Service
public class LoginService {

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * 
	 * @param req
	 * @return
	 * @throws IllegalAccessException 
	 */
	public LoginResponse login(LoginRequest req) throws IllegalAccessException {
		
		LoginResponse response = new LoginResponse();
		
		Company company = companyService.findByCompanyUid(req.getCompanyUid()).orElseThrow(() -> new IllegalAccessException(String.format("公司統編不存在: %s", req.getCompanyUid())));
		
		List<CompanyUser> companyUsers = userService.findByUserName(req.getUserUid());
		if (companyUsers.isEmpty()) {
			log.info("登入使用者不存在");
			response.setReturnMsg("登入失敗");
			return response;
		}
		
		Optional<CompanyUser> companyUserOptional = companyUsers.stream()
																.filter(user -> user.getCompanyKey() == company.getCompanyKey())
																.findFirst();
		
		if (companyUserOptional.isEmpty()) {
			log.info("登入公司無該使用者");
			response.setReturnMsg("登入失敗");
			return response;
		}
		
		response.setReturnMsg("登入成功");
		return response;
		
	}

}
