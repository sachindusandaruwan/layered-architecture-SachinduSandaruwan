package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;

public interface OrderDAO extends CrudDAO<OrderDTO> {
    public String generateNewOrderId() throws SQLException, ClassNotFoundException;


    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException;

    public boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;


}
