/**
 * @Description : 例外攔截器
 * @ClassName : UnitTestExceptionHnadler.java
 * @Copyright : Copyright (c) 2024 
 * @ModifyHistory : 
 *  v1.00, 2024/08/11, frankchang
 *   1) First Release.
 */

package tw.com.softleader.UnitTest.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import tw.com.softleader.UnitTest.api.res.LoginResponse;

@ControllerAdvice
public class UnitTestExceptionHnadler {

	@ExceptionHandler(value = {IllegalAccessException.class})
	public ResponseEntity<LoginResponse> exceptionHandler(Exception e){
		
		LoginResponse response = new LoginResponse();
		
		String message = e.getMessage();
		response.setReturnMsg(message);
		
		return ResponseEntity.ok(response);
	}
	
}
