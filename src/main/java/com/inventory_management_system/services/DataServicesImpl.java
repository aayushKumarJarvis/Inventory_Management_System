package com.inventory_management_system.services;

import java.util.List;

import com.inventory_management_system.model.AdminUsers;
import org.springframework.beans.factory.annotation.Autowired;

import com.inventory_management_system.dao.DataDao;
import com.inventory_management_system.model.InventoryItem;

public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;
	
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

    @Override
    public boolean addAdminUser(AdminUsers adminUser) throws Exception {
        return dataDao.addAdminUser(adminUser);
    }

    @Override
    public AdminUsers getAdminUserById(long id) {
        
    }
}
