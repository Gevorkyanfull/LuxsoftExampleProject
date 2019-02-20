package com.guzichenko.validators;

import com.guzichenko.exceptions.BusinessException;

public interface ValidationService {

	void validateAge(int age) throws BusinessException;

	void validateEmail(String email) throws BusinessException;

	void validatePhone(String phone) throws BusinessException;
    void validateByPhone(String phone) throws BusinessException;

}