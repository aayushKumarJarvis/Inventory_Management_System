package com.inventory_management_system.model;

import javax.annotation.Resource;

import com.inventory_management_system.dao.DataDaoImplementation;
import junit.framework.Assert;

import org.junit.Test;

import java.util.List;


public class AdminUsersTest extends BaseTest {

    @Resource
    private DataDaoImplementation dataDaoTestForAdminUsers;

    @Test
    public void getAdminUsersListTest() throws Exception {
        Assert.assertNotNull(dataDaoTestForAdminUsers.getAdminUsersList().isEmpty());

        List<AdminUsers> allAdminUsers = dataDaoTestForAdminUsers.getAdminUsersList();

        for(int i=0;i<allAdminUsers.size();i++)
            System.out.println(allAdminUsers.get(i).getUsername());
    }

    @Test
    public void getAdminUserByIdTest() throws Exception {
        Assert.assertNotNull(dataDaoTestForAdminUsers.getAdminUserById(1));

        System.out.println("Admin User By ID "+ dataDaoTestForAdminUsers.getAdminUserById(1).getUsername());
    }

    @Test
    public void addAdminUserTest() throws Exception {
        AdminUsers adminUser = new AdminUsers();

        adminUser.setUsername("AayushKumar");
        adminUser.setPassword("aayushKumar");

        dataDaoTestForAdminUsers.addAdminUser(adminUser);
        long newId = adminUser.getId();

        Assert.assertNotNull(dataDaoTestForAdminUsers.getAdminUserById(newId));

        System.out.println("Added Username is " + dataDaoTestForAdminUsers.getAdminUserById(newId).getUsername());
    }


    @Test
    public void deleteAdminUserTest() throws Exception {

        long delId = 19;

        dataDaoTestForAdminUsers.deleteAdminUser(delId);
        Assert.assertNotNull(dataDaoTestForAdminUsers.getAdminUserById(delId));
    }
}
