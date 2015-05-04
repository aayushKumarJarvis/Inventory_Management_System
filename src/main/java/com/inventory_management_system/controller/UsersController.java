package com.inventory_management_system.controller;

import java.util.List;

import com.inventory_management_system.model.AdminUsers;
import com.inventory_management_system.model.Users;
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
@RequestMapping("/users")
public class UsersController {

    @Autowired
    DataServices dataServices;

    static final Logger logger = Logger.getLogger(AdminUsers.class);

    @RequestMapping(value = "/addUser", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addUser(@RequestBody Users user) {

        try {
            dataServices.addUser(user);
            return new Status(1, "User added successfully");
        } catch(Exception e) {

            return new Status(0,e.toString());
        }
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Users getUserById(@PathVariable("id") long id) {

        Users user = null;

        try {
            user = dataServices.getUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
    public @ResponseBody
    List<Users> getUsersList() {

        List<Users> usersList = null;
        try {
            usersList = dataServices.getUsersList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usersList;
    }

    @RequestMapping(value = "deleteUser/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Status deleteUser(@PathVariable("id") long id) {

        try {
            dataServices.deleteUser(id);
            return new Status(1, "User deleted Successfully !");
        } catch (Exception e) {
            return new Status(0, e.toString());
        }
    }
}
