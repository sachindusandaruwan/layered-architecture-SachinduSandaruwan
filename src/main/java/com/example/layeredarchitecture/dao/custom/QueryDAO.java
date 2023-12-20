package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.CustomerOrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO {
    public ArrayList<CustomerOrderDTO> CustomerOrder(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
}
