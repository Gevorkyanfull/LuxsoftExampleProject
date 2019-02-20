package com.guzichenko.validators.impl;

import com.guzichenko.dao.ClientDao;
import com.guzichenko.dao.impl.ClientDaoImpl;
import com.guzichenko.exceptions.BusinessException;
import com.guzichenko.validators.ValidationService;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationServiceImpl implements ValidationService {
	@Override
	public void validateAge(int age) throws BusinessException {
		if (age < 0 || age > 200) {
			throw new BusinessException("Incorrect age!!!");
		}
	}

	@Override
	public void validateEmail(String email) throws BusinessException {
		String EMAIL_PATTERN =
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
						"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		if(matcher.matches()==false){
			throw new BusinessException("Incorrect email!!!");
		}
	}

	@Override
	public void validatePhone(String phone) throws BusinessException {
		//Pattern pattern = Pattern.compile("^((\\+?380)([0-9]{9}))$");
		Pattern pattern = Pattern.compile("^((\\+?38)(067|050|097)([0-9]{7}))$");
		Matcher matcher = pattern.matcher(phone);
		if(matcher.matches()==false){
			throw new BusinessException("Check the phone!!!");


		}
	}

	@Override
	public void validateByPhone(String phone) throws BusinessException {

	}


}


