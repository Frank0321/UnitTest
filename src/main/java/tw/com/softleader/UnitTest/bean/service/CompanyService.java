/**
 * @Description : 公司 Service
 * @ClassName : CompanyService.java
 * @Copyright : Copyright (c) 2024 
 * @ModifyHistory : 
 *  v1.00, 2024/08/03, frankchang
 *   1) First Release.
 */

package tw.com.softleader.UnitTest.bean.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.softleader.UnitTest.bean.Company;
import tw.com.softleader.UnitTest.db.dao.CompanyDao;
import tw.com.softleader.UnitTest.db.entity.CompanyEntity;

@Service
public class CompanyService {

	@Autowired
	private CompanyDao companyDao;
	
	/***
	 * 使用公司統編 找尋 目前的公司資料
	 * 
	 * @param companyUid
	 * @return
	 */
	public Optional<Company> findByCompanyUid(String companyUid) {
		
		Company company = new Company();
		
		List<CompanyEntity> entities = companyDao.findByCompanyUidAndStatus(companyUid, 1);
		
		if (entities.isEmpty()) {
			return null;
		}
		
		BeanUtils.copyProperties(company, entities.get(0));
		
		return Optional.of(company);
		
	}
	
}
