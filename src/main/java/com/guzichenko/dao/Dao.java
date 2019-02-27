package com.guzichenko.dao;

import java.util.List;

public interface Dao<TDao> {
    Long save(TDao entity);

    TDao get(Long id);

    List<TDao> getAll();

    void remove(Long id) throws DaoException;

    //ArrayList<Integer> getAllPhones();


}
