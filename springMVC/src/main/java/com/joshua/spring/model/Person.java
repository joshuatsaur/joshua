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
@Table(name="PERSON")
public class Person {
	@Id
	@Column(name="OID",length=12)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "accountSeq")
	@SequenceGenerator(name="accountSeq", sequenceName="ACCOUNT_SEQ", allocationSize=1)
    private Long oid;
	
	@NotNull
	@Column(name="NAME", columnDefinition="VARCHAR2(20)")
	private String name;
	
	@NotNull
	@Column(name="COUNTRY", columnDefinition="VARCHAR2(2)")
	private String country;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
