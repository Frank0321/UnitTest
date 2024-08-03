/**
 * @Description : 使用者 Service
 * @ClassName : UserService.java
 * @Copyright : Copyright (c) 2024 
 * @ModifyHistory : 
 *  v1.00, 2024/08/03, frankchang
 *   1) First Release.
 */

package tw.com.softleader.UnitTest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.softleader.UnitTest.bean.CompanyUser;
import tw.com.softleader.UnitTest.dao.CompanyUserDao;
import tw.com.softleader.UnitTest.entity.CompanyUserEntity;

@Service
public class UserService {

	@Autowired
	private CompanyUserDao companyUserDao;
	
	/***
	 * 使用使用者名稱找尋使用者資料
	 * 
	 * @param userName
	 * @return
	 */
	public List<CompanyUser> findByUserName(String userName){
		
		List<CompanyUser> list = new ArrayList<>();
	
		List<CompanyUserEntity> companyUserEntities = companyUserDao.findByUserName(userName);
		
		for (CompanyUserEntity entity : companyUserEntities) {
			
			CompanyUser user = new CompanyUser();
			
			BeanUtils.copyProperties(user, entity);
			
			list.add(user);
		}
		
		return list;
	}
}
