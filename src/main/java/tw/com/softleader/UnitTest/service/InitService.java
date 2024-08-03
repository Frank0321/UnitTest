/**
 * @Description : 初始化 service
 * @ClassName : InitService.java
 * @Copyright : Copyright (c) 2024 
 * @ModifyHistory : 
 *  v1.00, 2024/08/03, frankchang
 *   1) First Release.
 */

package tw.com.softleader.UnitTest.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.softleader.UnitTest.dao.CompanyAccountDao;
import tw.com.softleader.UnitTest.dao.CompanyDao;
import tw.com.softleader.UnitTest.dao.CompanyUserDao;
import tw.com.softleader.UnitTest.entity.CompanyAccountEntity;
import tw.com.softleader.UnitTest.entity.CompanyEntity;
import tw.com.softleader.UnitTest.entity.CompanyUserEntity;

@Service
public class InitService {

	@Autowired
	private CompanyDao companyDao;

	@Autowired
	private CompanyAccountDao companyAccountDao;

	@Autowired
	private CompanyUserDao companyUserDao;

	/***
	 * 初始化資料
	 */
	@PostConstruct
	private void initData() {

		// 建立公司資料
		CompanyEntity kgibCompanyEntity = CompanyEntity.builder()
											.companyUid("23111915")
											.companyName("凱xxx卷")
											.status(1)
											.address("臺北市中山區成功里明水路oooooo")
											.phone("02-21818888")
											.build();

		CompanyEntity yuantaCompanyEntity = CompanyEntity.builder()
											.companyUid("84384477")
											.companyName("元xxx券")
											.status(1)
											.address("臺北市大安區敦化南路oooooo")
											.phone("02-27175555")
											.build();

		CompanyEntity hitrsutCompanyEntity = CompanyEntity.builder()
											.companyUid("16313302")
											.companyName("網xxx信")
											.status(1)
											.address("台北市內湖區港墘路oooooo")
											.phone("02-26586000")
											.build();

		List<CompanyEntity> companyEntities = List.of(kgibCompanyEntity, yuantaCompanyEntity, hitrsutCompanyEntity);
		companyDao.saveAll(companyEntities);
		
		// 建立使用者資料
		List<CompanyUserEntity> userList = new ArrayList<>();
		
		List<CompanyUserEntity> kgibUserEntities = List.of(CompanyUserEntity.builder()
																			.companyKey(kgibCompanyEntity.getCompanyKey())
																			.userUid("sansan")
																			.userName("sansan")
																			.status(1)
																			.build(), 
														   CompanyUserEntity.builder()
																			   .companyKey(kgibCompanyEntity.getCompanyKey())
																			   .userUid("martin")
																			   .userName("馬丁")
																			   .status(1)
																			   .build(),
														   CompanyUserEntity.builder()
																			   .companyKey(kgibCompanyEntity.getCompanyKey())
																			   .userUid("KgibKK")
																			   .userName("KK")
																			   .status(1)
																			   .build());
		
		userList.addAll(kgibUserEntities);
		
		companyUserDao.saveAll(userList);
		
		// 建立帳號資料
		List<CompanyAccountEntity> accountList = new ArrayList<>();
		List<CompanyAccountEntity> kgibAccountEntities = List.of(CompanyAccountEntity.builder()
																	.companyKey(kgibCompanyEntity.getCompanyKey())
																	.companyAccount("1234567890")
																	.currencyId("TWD")
																	.permission(2)
																	.companyAccountValue(new BigDecimal("1000000"))
																	.build(),
																CompanyAccountEntity.builder()
																	.companyKey(kgibCompanyEntity.getCompanyKey())
																	.companyAccount("U0246813579")
																	.currencyId("USD")
																	.permission(1)
																	.companyAccountValue(new BigDecimal("1234567"))
																	.build());
		
		accountList.addAll(kgibAccountEntities);
		
		companyAccountDao.saveAll(accountList);
		
	}

}
