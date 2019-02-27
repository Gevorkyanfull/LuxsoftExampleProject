package com.guzichenko.services;

import com.guzichenko.dao.DaoException;
import com.guzichenko.domain.Product;
import com.guzichenko.exceptions.BusinessException;

import java.util.List;

public interface ProductService {
    void createProduct(ProductData productData) throws BusinessException;
    void modifyProduct(Long id,ProductData data)throws BusinessException;
    void removeProduct(Long id) throws BusinessException, DaoException;
    List<Product> getAllProducts();
}
