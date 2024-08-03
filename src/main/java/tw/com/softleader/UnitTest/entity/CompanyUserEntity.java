/**
 * @Description : 使用者 Entity
 * @ClassName : CompanyUser.java
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
public class CompanyUserEntity implements Serializable{
	
	private static final long serialVersionUID = 4092320840720620698L;
	
	@Id
	private Integer userKey;
	
	@Basic
	private Integer companyKey;
	
	@Basic
	private String userUid;
	
	@Basic
	private String userName;
	

}
