package com.example.layeredarchitecture.dao;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)?daoFactory
                =new DAOFactory():daoFactory;
    }
    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL,QUERY
    }
    public void getDAO(DAOTypes daoTypes){
        switch (daoTypes) {
            case CUSTOMER:
        }
        }
    }
}
