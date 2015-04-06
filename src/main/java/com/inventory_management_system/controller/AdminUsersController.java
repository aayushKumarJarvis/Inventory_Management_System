package com.inventory_management_system.controller;

import java.util.List;

import com.inventory_management_system.model.AdminUsers;
import org.apache.log4j.Logger;
import com.inventory_management_system.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inventory_management_system.model.InventoryItem;
import com.inventory_management_system.services.DataServices;

import javax.xml.crypto.Data;

@Controller
@RequestMapping("/adminUsers")
public class AdminUsersController {

    @Autowired
    DataServices dataServices;

    static final Logger logger = Logger.getLogger(AdminUsers.class);

    @RequestMapping(value = "/addAdminUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addAdminUser(@RequestBody AdminUsers adminUser) {

        try {
            dataServices.addAdminUser(adminUser);
            return new Status(1, "Admin User added successfully");
        } catch(Exception e) {

            return new Status(0,e.toString());
        }
    }

    @RequestMapping(value = "adminUser/{id}", method = RequestMethod.GET)
    public @ResponseBody
    AdminUsers getAdminUserById(@PathVariable("id") long id) {

        AdminUsers adminUser = null;

        try {
            adminUser = dataServices.getAdminUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminUser;
    }

    @RequestMapping(value = "/listAdminUsers", method = RequestMethod.GET)
    public @ResponseBody
    List<AdminUsers> getAdminUsersList() {

        List<AdminUsers> adminUsersList = null;
        try {
            adminUsersList = dataServices.getAdminUsersList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return adminUsersList;
    }

    @RequestMapping(value = "deleteInventory/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Status deleteInventory(@PathVariable("id") long id) {

        try {
            dataServices.deleteInventory(id);
            return new Status(1, "Inventory deleted Successfully !");
        } catch (Exception e) {
            return new Status(0, e.toString());
        }
    }
}
