/**
 * @Description : 公司 Dao
 * @ClassName : CompanyDao.java
 * @Copyright : Copyright (c) 2024 
 * @ModifyHistory : 
 *  v1.00, 2024/08/03, frankchang
 *   1) First Release.
 */

package tw.com.softleader.UnitTest.db.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.softleader.UnitTest.db.entity.CompanyEntity;

@Repository
public interface CompanyDao extends JpaRepository<CompanyEntity, Integer>{
	
	List<CompanyEntity> findByCompanyUidAndStatus(String companyUid, Integer status);

}
