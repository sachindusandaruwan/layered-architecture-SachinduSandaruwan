package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.OrderDetailsDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailsDAOImpl;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    CustomerDAO customerDAO=new CustomerDAOImpl();
    ItemDAO itemDAO=new ItemDAOImpl();
    OrderDAO orderDAO=new OrderDAOImpl();
    OrderDetailsDAO orderDetailsDAO=new OrderDetailsDAOImpl();

    @Override
    public boolean PlaceOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        /*Transaction*/

        Connection connection = null;


            connection= DBConnection.getDbConnection().getConnection();

            //OrderDAO orderDAO=new OrderDAOImpl();
            boolean s1=orderDAO.existOrder(orderId);
            if (s1){
                return false;
            }

            connection.setAutoCommit(false);

            //OrderDAO orderDAO1=new OrderDAOImpl();
            boolean s2=orderDAO.saveOrder(new OrderDTO(orderId,orderDate,customerId));

            if (!s2){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            //stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");

            for (OrderDetailDTO detail : orderDetails) {
                //OrderDetailsDAO orderDetailsDAO=new OrderDetailsDAOImpl();
                boolean s3=orderDetailsDAO.saveOrderDetails(detail);


                if ( !s3) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

//                //Search & Update Item
                ItemDTO item = findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                ItemDAOImpl itemDAO1=new ItemDAOImpl();
                boolean b4=itemDAO1.update(new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));

                if (!b4){
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;


    }
    public ItemDTO findItem(String code) {
        try {
            /*Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
            pstm.setString(1, code);
            ResultSet rst = pstm.executeQuery();
            rst.next();*/
            //ItemDAOImpl itemDAO=new ItemDAOImpl();
            ItemDTO dto=itemDAO.search(code);
            return new ItemDTO(code,
                    dto.getDescription(),
                    dto.getUnitPrice(),
                    dto.getQtyOnHand());


        } catch (SQLException e) {

            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
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
    public boolean existItem(String code)throws SQLException, ClassNotFoundException{
        return itemDAO.exist(code);
    }
    @Override
    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException{
        return itemDAO.search(newItemCode);
    }
    @Override
    public String generateNewOrderId()throws SQLException, ClassNotFoundException{
        return orderDAO.generateNewOrderId();
    }
    @Override
    public ArrayList<CustomerDTO> getAllCustomerIds() throws SQLException, ClassNotFoundException{
        return customerDAO.getAll();
    }
    @Override
    public ArrayList<ItemDTO> getAllItemCodes() throws SQLException, ClassNotFoundException{
        return itemDAO.getAll();
    }
}
