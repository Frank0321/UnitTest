/**
 * @Description : 登入 入口點
 * @ClassName : LoginController.java
 * @Copyright : Copyright (c) 2024 
 * @ModifyHistory : 
 *  v1.00, 2024/08/04, frankchang
 *   1) First Release.
 */

package tw.com.softleader.UnitTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.com.softleader.UnitTest.api.req.LoginRequest;
import tw.com.softleader.UnitTest.api.res.LoginResponse;
import tw.com.softleader.UnitTest.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService service;
	
	@PostMapping(value = "login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest req) throws IllegalAccessException{
		
		LoginResponse res = service.login(req);
		
		return ResponseEntity.ok(res);
	}
	
}
