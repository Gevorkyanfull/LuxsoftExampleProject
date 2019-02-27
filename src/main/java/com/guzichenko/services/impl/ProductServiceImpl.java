package com.guzichenko.services.impl;

import com.guzichenko.dao.Dao;
import com.guzichenko.dao.DaoException;
import com.guzichenko.domain.Product;
import com.guzichenko.services.ProductData;
import com.guzichenko.services.ProductService;
import com.guzichenko.validators.ValidationService;
import com.guzichenko.exceptions.BusinessException;

import java.io.BufferedReader;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ValidationService validationService;
    private Dao<Product> daoProduct;

    public ProductServiceImpl(ValidationService validationService, Dao<Product> daoProduct) {
        this.validationService = validationService;
        this.daoProduct=daoProduct;
    }

    @Override
    public void createProduct(ProductData productData) throws BusinessException {
        validationService.validatePrice(productData.price);
        Product product=new Product(productData.nameOfProduct,productData.price);
        daoProduct.save(product);



    }

    @Override
    public void modifyProduct(Long id, ProductData data) throws BusinessException {
        validationService.validatePrice(data.price);
        //1. Взять по Id
        //2. Изменить данные.
        //3. Сохранить.
         Product product = daoProduct.get(id);
        product.setName(data.nameOfProduct);
        product.setPrice(data.price);
        daoProduct.save(product);



    }

    @Override
    public void removeProduct(Long id) throws BusinessException, DaoException {
        daoProduct.remove(id);

    }

    @Override
    public List<Product> getAllProducts() {
        return daoProduct.getAll();
    }
}
