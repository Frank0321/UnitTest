/**
 * @Description : 帳號 Entity
 * @ClassName : CompanyAccountEntity.java
 * @Copyright : Copyright (c) 2024 
 * @ModifyHistory : 
 *  v1.00, 2024/08/03, frankchang
 *   1) First Release.
 */

package tw.com.softleader.UnitTest.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CompanyAccountEntity implements Serializable{
	
	private static final long serialVersionUID = 1622797550826046750L;

	@Id
	private Integer companyAccountKey;
	
	@Basic
	private Integer companyKey;
	
	@Basic
	private String companyAccount;
	
}
