package org.example.model.dao;

import org.example.db.DB;
import org.example.model.dao.impl.SellerDaoJDBCImpl;

public class DaoFactory {
    public static SellerDao createSellerDao() {
        return new SellerDaoJDBCImpl(DB.getConnection());
    }
}
