package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;

public interface OrderDAO {
    public ResultSet generateNewOrderId() throws SQLException, ClassNotFoundException;


    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException;

    public boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;


}
