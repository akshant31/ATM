package com.navyug.ATM.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.navyug.ATM.h2.models.User;

public interface NavyugAtmService {

	String getBalance(Long id) throws Exception;

	String withdrawMoney(Map<String,Object> request) throws Exception;

	String depositMoney(Map<String,Object> request) throws Exception;

	String addNewUser(User newUser) throws Exception;

}
