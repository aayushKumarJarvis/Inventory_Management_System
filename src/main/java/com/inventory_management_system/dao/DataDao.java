package com.inventory_management_system.dao;

import java.util.List;

import com.inventory_management_system.model.AdminUsers;
import com.inventory_management_system.model.InventoryItem;

public interface DataDao {

    // DAO methods for Inventory operations
    public boolean addInventoryItem(InventoryItem inventoryItem) throws Exception;

	public InventoryItem getInventoryById(long id) throws Exception;

    public List<InventoryItem> getInventoryList() throws Exception;

    public boolean deleteInventory(long id) throws Exception;

    // DAO methods for Admin Users operations
    public boolean addAdminUser(AdminUsers adminUser) throws Exception;

    public AdminUsers getAdminUserById(long id) throws Exception;

    public List<AdminUsers> getAdminUsersList() throws Exception;

    public boolean deleteAdminUser(long id) throws Exception;
}
