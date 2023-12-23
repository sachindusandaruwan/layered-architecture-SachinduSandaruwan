package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(dto);
    }
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }
    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException{
        return  customerDAO.update(customerDTO);
    }
    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException{
        return customerDAO.exist(id);
    }
    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException{
        return customerDAO.search(id);
    }
    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException{
        return customerDAO.delete(id);
    }
    @Override
    public String generateCustomer() throws SQLException, ClassNotFoundException{
        return customerDAO.generate();
    }
}
