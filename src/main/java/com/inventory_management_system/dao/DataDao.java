package com.inventory_management_system.dao;

import java.util.ArrayList;
import java.util.List;

import com.inventory_management_system.model.*;


/**
 * Interface of methods for Data Access Object CRUD Operations
 */
public interface DataDao {

    /**
     * DAO CRUD Operations on Inventory Items
     */

    /**
     * Adds a new Inventory Item to the Inventory Table in Database.
     * <p> URL : '/addItem'
     * @param inventoryItem Inventory Item to be added
     * @return boolean Transaction successful or not
     * @throws Exception
     */
    public boolean addInventoryItem(InventoryItem inventoryItem) throws Exception;

    /**
     * Gets InventoryItem using id
     * <p> URL : '/inventoryItem/{id}'
     * @param id Inventory Id
     * @return InventoryItem
     * @throws Exception
     */
    public InventoryItem getInventoryById(long id) throws Exception;


    /**
     * Gets the complete list of available inventory
     * <p>URL : '/listItems'</>
     * @return List<InventoryItem>
     * @throws Exception
     */
    public List<InventoryItem> getInventoryList() throws Exception;


    /**
     * Delete Inventory using Id
     * <p> URL : 'deleteInventory/{id}'</>
     * @param id Inventory Id
     * @return
     * @throws Exception
     */
    public boolean deleteInventory(long id) throws Exception;



    /**
     * DAO CRUD Operations for Admin Users
     */

    /**
     * Adds a new Admin
     * <p>URL : '/addAdminUser' </>
     * @param adminUser
     * @return boolean Successful transaction
     * @throws Exception
     */
    public boolean addAdminUser(AdminUsers adminUser) throws Exception;

    /**
     * Gets Admin User Details by Id
     * <p>URL : 'adminUser/{id}'</>
     * @param id Admin Id
     * @return AdminUsers
     * @throws Exception
     */
    public AdminUsers getAdminUserById(long id) throws Exception;

    /**
     * Gets List of Admin Users
     * <p>URL : '/listAdminUsers'</>
     * @return List of AdminUSers
     * @throws Exception
     */
    public List<AdminUsers> getAdminUsersList() throws Exception;

    /**
     * Delete an Admin User using Id
     * <p>URL : 'deleteAdminUser/{id}'</>
     * @param id
     * @return
     * @throws Exception
     */
    public boolean deleteAdminUser(long id) throws Exception;


    /**
     * DAO CRUD Operations for Users
     */

    /**
     * Add new User
     * <p>URL : '/addUser'</>
     * @param user
     * @return boolean Successful Transaction
     * @throws Exception
     */
    public boolean addUser(Users user) throws Exception;

    /**
     * Gets User by Id
     * <p>URL : 'user/{id}'</>
     * @param id
     * @return Users
     * @throws Exception
     */
    public Users getUserById(long id) throws Exception;

    /**
     * Gets List of available users
     * <p>URL : '/listUsers'</>
     * @return List<Users>
     * @throws Exception
     */
    public List<Users> getUsersList() throws Exception;

    /**
     * Delete and Existing User
     * <p>URL: 'deleteUser/{id}'</>
     * @param id
     * @return
     * @throws Exception
     */
    public boolean deleteUser(long id) throws Exception;

    /**
     * Add a new Complaint
     * <p>URL : '/addComplaint'</>
     * @param complaint
     * @return
     * @throws Exception
     */
    public boolean addComplaint(Complaint complaint) throws Exception;

    /**
     * Gets List of all complaints
     * <p>URL : '/listAllComplaint'</>
     * @return List of complaints
     * @throws Exception
     */
    public List<Complaint> getAllComplaints() throws Exception;

    /**
     * Gets details of Inventory Items associated with an Order
     * <p>URL : '/orderItems'</>
     * @param orderid
     * @return List of Inventory Items
     * @throws Exception
     */
}
