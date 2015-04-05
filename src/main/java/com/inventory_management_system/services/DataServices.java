package com.inventory_management_system.services;

import java.util.List;

import com.inventory_management_system.model.AdminUsers;
import com.inventory_management_system.model.InventoryItem;

public interface DataServices {

    // Web Services for the inventory CRUD operations
	public boolean addInventoryItem(InventoryItem inventoryItem) throws Exception;

	public InventoryItem getInventoryById(long id) throws Exception;

    public List<InventoryItem> getInventoryList() throws Exception;

    public boolean deleteInventory(long id) throws Exception;


    //Web Services for the Admin_Users CRUD operations
    public boolean addAdminUser(AdminUsers adminUser) throws Exception;

    public AdminUsers getAdminUserById(long id) throws Exception;

    public List<AdminUsers> getAdminUsersList() throws Exception;

    public boolean deleteAdminUser(long id) throws Exception;


    //Web Services for the Users CURD operations
}
