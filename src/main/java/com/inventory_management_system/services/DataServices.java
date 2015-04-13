package com.inventory_management_system.services;

import java.util.List;

import com.inventory_management_system.model.AdminUsers;
import com.inventory_management_system.model.Complaint;
import com.inventory_management_system.model.InventoryItem;
import com.inventory_management_system.model.Users;

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
    public boolean addUser(Users user) throws Exception;

    public Users getUserById(long id) throws Exception;

    public List<Users> getUsersList() throws Exception;

    public boolean deleteUser(long id) throws Exception;


    //Web Services for the Complaint CRUD operations
    public boolean addComplaint(Complaint complaint) throws Exception;

    public List<Complaint> getAllComplaints() throws Exception;

}
