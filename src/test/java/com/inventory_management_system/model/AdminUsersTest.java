package com.inventory_management_system.model;

import javax.annotation.Resource;

import com.inventory_management_system.dao.DataDaoImplementation;
import junit.framework.Assert;

import org.junit.Test;


public class AdminUsersTest extends BaseTest {

    @Resource
    private DataDaoImplementation dataDaoTest;

    @Test
    public void getAdminUsersListTest() throws Exception {
        Assert.assertNotNull(dataDaoTest.getAdminUsersList().isEmpty());

        System.out.println("Admin Users List "+dataDaoTest.getAdminUsersList());
    }

    @Test
    public void getAdminUserByIdTest() throws Exception {
        Assert.assertNotNull(dataDaoTest.getAdminUserById(1));

        System.out.println("Admin User By ID "+dataDaoTest.getAdminUserById(1).getId());
    }

    @Test
    public void addAdminUserTest() throws Exception {
        AdminUsers adminUser = new AdminUsers();

        adminUser.setId(2);
        adminUser.setUsername("AayushKumar");
        adminUser.setPassword("aayushKumar");

        Assert.assertNull(dataDaoTest.getAdminUserById(2));
    }


    @Test
    public void deleteAdminUserTest() throws Exception {
        AdminUsers adminUser = dataDaoTest.getAdminUserById(2);

        long id = adminUser.getId();
        dataDaoTest.deleteAdminUser(id);
        Assert.assertNull(dataDaoTest.getAdminUserById(id));
    }
}
