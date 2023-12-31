package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException ;
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    public String generateCustomer() throws SQLException, ClassNotFoundException;
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;
}
