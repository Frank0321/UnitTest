/**
 * @Description : 帳號 service
 * @ClassName : AccountService.java
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

import tw.com.softleader.UnitTest.bean.CompanyAccount;
import tw.com.softleader.UnitTest.dao.CompanyAccountDao;
import tw.com.softleader.UnitTest.entity.CompanyAccountEntity;

@Service
public class AccountService {

	@Autowired
	private CompanyAccountDao companyAccountDao;
	
	/***
	 * 找尋單一筆帳號資料
	 * 
	 * @param accountKey
	 * @return
	 */
	public CompanyAccount getAccount(Integer accountKey) {
		
		CompanyAccount companyAccount = new CompanyAccount();
		
		CompanyAccountEntity accountEntity = companyAccountDao.findById(accountKey).orElse(null);
		
		if (accountEntity == null) {
			return null;
		}
		
		BeanUtils.copyProperties(companyAccount, accountEntity);
		
		return companyAccount;
		
	}
	
	/***
	 * 使用公司鍵值 找尋帳號資料
	 * 
	 * @param companyKey
	 * @return
	 */
	public List<CompanyAccount> findByCompanyKey(Integer companyKey){
		
		List<CompanyAccount> list = new ArrayList<>();
		
		List<CompanyAccountEntity> companyAccountEntities = companyAccountDao.findByCompanyKey(companyKey);
		
		for (CompanyAccountEntity entity : companyAccountEntities) {
			
			CompanyAccount account = new CompanyAccount();
			
			BeanUtils.copyProperties(account, entity);
			
			list.add(account);
		}
		
		return list;
	}
	
}
