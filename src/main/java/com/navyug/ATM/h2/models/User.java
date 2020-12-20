package com.navyug.ATM.h2.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="navyug_users")
public class User {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="account_id")
 private Long accountId;
 
 @Column
 private String name;
 
 @Column
 private String city;
 
 @Column
 private Long phone;
 
 @Column
 private Double balance;
 
 @Column(name="account_type")
 private String accountType;


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public Long getPhone() {
	return phone;
}

public void setPhone(Long phone) {
	this.phone = phone;
}

public Double getBalance() {
	return balance;
}

public void setBalance(Double balance) {
	this.balance = balance;
}

public Long getAccountId() {
	return accountId;
}

public void setAccountId(Long accountId) {
	this.accountId = accountId;
}

public String getAccountType() {
	return accountType;
}

public void setAccountType(String accountType) {
	this.accountType = accountType;
}

@Override
public String toString() {
	return "User [accountId=" + accountId + ", name=" + name + ", city=" + city + ", phone=" + phone + ", balance="
			+ balance + ", accountType=" + accountType + "]";
}



}
