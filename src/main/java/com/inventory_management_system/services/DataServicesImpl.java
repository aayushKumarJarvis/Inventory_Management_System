package com.inventory_management_system.services;

import java.util.List;

import com.inventory_management_system.model.AdminUsers;
import com.inventory_management_system.model.Users;
import org.springframework.beans.factory.annotation.Autowired;

import com.inventory_management_system.dao.DataDao;
import com.inventory_management_system.model.InventoryItem;

public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;

    // Method Implementations for Inventory Items
	@Override
	public boolean addInventoryItem(InventoryItem inventoryItem) throws Exception {
		return dataDao.addInventoryItem(inventoryItem);
	}

	@Override
	public InventoryItem getInventoryById(long id) throws Exception {
		return dataDao.getInventoryById(id);
	}

	@Override
	public List<InventoryItem> getInventoryList() throws Exception {
		return dataDao.getInventoryList();
	}

	@Override
	public boolean deleteInventory(long id) throws Exception {
		return dataDao.deleteInventory(id);
	}

    // Method Implementations for Admin Users
    @Override
    public boolean addAdminUser(AdminUsers adminUser) throws Exception {
        return dataDao.addAdminUser(adminUser);
    }

    @Override
    public AdminUsers getAdminUserById(long id) throws Exception{
        return dataDao.getAdminUserById(id);
    }

    @Override
    public List<AdminUsers> getAdminUsersList() throws Exception {
        return dataDao.getAdminUsersList();
    }

    @Override
    public boolean deleteAdminUser(long id) throws Exception {
        return dataDao.deleteAdminUser(id);
    }

    // Method Implementations for Users
    @Override
    public boolean addUser(Users user) throws Exception {
        return dataDao.addUser(user);
    }

    @Override
    public Users getUserById(long id) throws Exception{
        return dataDao.getUserById(id);
    }

    @Override
    public List<Users> getUsersList() throws Exception {
        return dataDao.getUsersList();
    }

    @Override
    public boolean deleteUser(long id) throws Exception {
        return dataDao.deleteUser(id);
    }
}
