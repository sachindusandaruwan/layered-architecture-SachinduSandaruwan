package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {
     ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
     boolean save(T dto) throws SQLException, ClassNotFoundException ;

     boolean update(T customerDTO) throws SQLException, ClassNotFoundException;

     boolean exist(String id) throws SQLException, ClassNotFoundException ;

     boolean delete(String id) throws SQLException, ClassNotFoundException ;

     String generate() throws SQLException, ClassNotFoundException ;
     T search(String id) throws SQLException, ClassNotFoundException;


}
