/**
 * @Description : 使用者 Service
 * @ClassName : UserService.java
 * @Copyright : Copyright (c) 2024 
 * @ModifyHistory : 
 *  v1.00, 2024/08/03, frankchang
 *   1) First Release.
 */

package tw.com.softleader.UnitTest.bean.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.softleader.UnitTest.bean.CompanyUser;
import tw.com.softleader.UnitTest.db.dao.CompanyUserDao;
import tw.com.softleader.UnitTest.db.entity.CompanyUserEntity;

@Service
public class UserService {

	@Autowired
	private CompanyUserDao companyUserDao;
	
	/***
	 * 使用使用者 uid 找尋使用者資料
	 * 
	 * @param userName
	 * @return
	 */
	public List<CompanyUser> findByUserName(String userUid){
		
		List<CompanyUser> list = new ArrayList<>();
	
		List<CompanyUserEntity> companyUserEntities = companyUserDao.findByUserUid(userUid);
		
		for (CompanyUserEntity entity : companyUserEntities) {
			
			CompanyUser user = new CompanyUser();
			
			BeanUtils.copyProperties(user, entity);
			
			list.add(user);
		}
		
		return list;
	}
}
