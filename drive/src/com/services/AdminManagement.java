package com.services;

import com.DAO.DAOAdminTable;

public class AdminManagement {
    public static boolean checkAdmin(String AdminID, String AdminPassword) {
        DAOAdminTable dao = new DAOAdminTable();
        return dao.checkAdmin(AdminID, AdminPassword);
    }
}
