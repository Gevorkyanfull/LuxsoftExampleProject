package com.guzichenko.dao.impl;

import com.guzichenko.dao.Dao;
import com.guzichenko.dao.DaoException;
import com.guzichenko.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements Dao<Product> {
    private static ProductDaoImpl productDao;

    Map<Long,Product>mapProduct=new HashMap<>();
    private static long generator = 1;
    private ProductDaoImpl(){

    }


    @Override
    public Long save(Product entity) {
        if (!mapProduct.containsKey(entity.getId())){
            entity.setId(generator++);
        }

        mapProduct.put(entity.getId(), entity);
        return entity.getId();
    }

    @Override
    public Product get(Long id) {

        return mapProduct.get(id);
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(mapProduct.values());
    }

    @Override
    public void remove(Long id) throws DaoException {
        if(mapProduct.remove(id)==null){
            throw new DaoException(id,"There is no product with this id");
        }


    }public static Dao<Product> getInstance() {
        if(productDao == null){
            productDao=new ProductDaoImpl();
        }
        return productDao;
}}
