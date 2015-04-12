package com.inventory_management_system.model;

import javax.annotation.Resource;

import com.inventory_management_system.dao.DataDaoImplementation;
import junit.framework.Assert;

import org.junit.Test;

import java.util.List;


public class UsersTest extends BaseTest {

    @Resource
    private DataDaoImplementation dataDaoImplementationForUsers;

    @Test
    public void getUsersListTest() throws Exception {
        Assert.assertNotNull(dataDaoImplementationForUsers.getUsersList().isEmpty());

        List<Users> allUsers = dataDaoImplementationForUsers.getUsersList();

        for(int i=0;i<allUsers.size();i++)
            System.out.println(allUsers.get(i).getUsername());
    }

    @Test
    public void getUserByIdTest() throws Exception {
        Assert.assertNotNull(dataDaoImplementationForUsers.getUserById(1));

        System.out.println("User By ID "+ dataDaoImplementationForUsers.getUserById(1).getUsername());
    }

    @Test
    public void addUserTest() throws Exception {
        Users user = new Users();

        user.setUsername("AayushKumar");
        user.setPassword("aayushKumar");

        dataDaoImplementationForUsers.addUser(user);
        long newId = user.getId();

        Assert.assertNotNull(dataDaoImplementationForUsers.getAdminUserById(newId));

        System.out.println("Added Username is " + dataDaoImplementationForUsers.getUserById(newId).getUsername());
    }


    @Test
    public void deleteAdminUserTest() throws Exception {

        long delId = 2;

        dataDaoImplementationForUsers.deleteUser(delId);
        Assert.assertNotNull(dataDaoImplementationForUsers.getUserById(delId));
    }
}
