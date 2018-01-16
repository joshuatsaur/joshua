package com.joshua.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="PRODUCT")
public class Product {

	@Id
	@Column(name="OID", length=12)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "accountSeq")
	@SequenceGenerator(name="accountSeq", sequenceName="ACCOUNT_SEQ", allocationSize=1)
	private Long oid;
	
	@NotNull
	@Column(name="NAME", columnDefinition="VARCHAR2(20)")
	private String name;

	public Long getOid() {
		return oid;
	}

	public void setOid(final Long oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
	
}
