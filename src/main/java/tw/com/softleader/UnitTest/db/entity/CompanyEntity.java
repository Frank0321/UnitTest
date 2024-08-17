/**
 * @Description : 公司 entity
 * @ClassName : CompanyEntity.java
 * @Copyright : Copyright (c) 2024 
 * @ModifyHistory : 
 *  v1.00, 2024/08/03, frankchang
 *   1) First Release.
 */

package tw.com.softleader.UnitTest.db.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CompanyEntity implements Serializable {
	
	private static final long serialVersionUID = -4875472268363365607L;

	@Id
	@GeneratedValue
	private Integer companyKey;
	
	@Basic
	private String companyUid;
	
	@Basic
	private String companyName;
	
	@Basic
	private Integer status;
	
	@Basic
	private String address;
	
	@Basic
	private String phone;
	
}
