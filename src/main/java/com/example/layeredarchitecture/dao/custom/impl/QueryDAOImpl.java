package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SqlUtil;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.CustomerOrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO  {

    @Override
    public ArrayList<CustomerOrderDTO> CustomerOrder(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        //join Query
        ResultSet rst =SqlUtil.execute("select c.id,c.name,o.oid,o,date from customer c join orders o on c.id=o.customerId;");
        ArrayList<CustomerOrderDTO> cusOrderList=new ArrayList<>();
        while (rst.next()){
            CustomerOrderDTO customerOrderDTO=new CustomerOrderDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
            cusOrderList.add(customerOrderDTO);

        }
        return cusOrderList;

    }
}
