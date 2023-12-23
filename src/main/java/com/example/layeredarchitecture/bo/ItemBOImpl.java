package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO{
    ItemDAO itemDAO=new ItemDAOImpl();
    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException{
       return itemDAO.getAll();
    }

    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException{
        return itemDAO.delete(code);
    }

    @Override
    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException{
        return itemDAO.save(itemDTO);
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException{
        return itemDAO.update(itemDTO);
    }
    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException{
        return itemDAO.exist(code);
    }
    @Override
    public String generateItem() throws SQLException, ClassNotFoundException {
        return itemDAO.generate();
    }
    @Override
    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException{
        return itemDAO.search(newItemCode);
    }

    }
