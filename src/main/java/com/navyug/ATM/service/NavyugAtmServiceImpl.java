package com.navyug.ATM.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.navyug.ATM.h2.models.User;
import com.navyug.ATM.h2.repo.UserRepository;


@Service
public class NavyugAtmServiceImpl  implements NavyugAtmService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public String getBalance(Long account_id) throws Exception
	{
		User user = userRepository.findById(account_id).get();
		System.out.println(user.getBalance());
		String message = "Your current balace is Rs." + user.getBalance().toString();
		return  message;
	}
	
	@Override
	public String depositMoney(Map<String,Object> request) throws Exception
	{
		Long account_id;
		Integer amount;
		
		try {
		 account_id = ((Number)request.get("account_id")).longValue();
		
		}
		catch(Exception e)
		{
			
			return "Invalid Account Id";
		}
		try {
		 amount = (Integer)request.get("amount");
		}
		catch(Exception e)
		{
			return "Invalid Amount given, please provide Integer value";
		}
		User user = userRepository.findById(account_id).get();
		if (user == null)
		{
			return "No user found with given account Id";
		}
		Double balance = user.getBalance();
		balance = balance + amount;
		user.setBalance(balance);
		userRepository.save(user);
		String message = "Your account credited with amount Rs. "+ amount.toString()+". Available balance is Rs."+ balance.toString();
		return message;
	}
	
	@Override
	public String withdrawMoney(Map<String,Object> request) throws Exception
	{
		Long account_id;
		Integer amount;
//		System.out.println(request);
		try {
			account_id = ((Number)request.get("account_id")).longValue();
		}
		catch(Exception e)
		{
			return "Invalid Account Id";
		}
		try {
		 amount = (Integer)request.get("amount");
		}
		catch(Exception e)
		{
			return "Invalid Amount given, please provide Integer value";
		}
		User user = userRepository.findById(account_id).get();
		if (user == null)
		{
			return "No user found with given account Id";
		}
		Double balance = user.getBalance();
		if (balance < amount)
		{
			String message = "Insufficient Balance. Available balance is Rs. "+ balance.toString();
			return message;
		}
		balance = balance - amount;
		user.setBalance(balance);
		userRepository.save(user);
		String message = "Your Account debited with Amount Rs. "+amount.toString()+". Available balance is Rs."+balance.toString();
		return message;
	}
	
	
	@Override
	public String addNewUser( User newUser) throws Exception
	{
		
		newUser = userRepository.save(newUser);
		String message = "New User Account created with Account ID : " + newUser.getAccountId().toString();
		return message;
	}

}
