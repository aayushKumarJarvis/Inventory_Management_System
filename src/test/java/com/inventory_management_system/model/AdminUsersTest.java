package com.inventory_management_system.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import com.inventory_management_system.dao.DataDaoImpl;
import com.sun.jndi.cosnaming.IiopUrl;
import junit.framework.Assert;

import org.junit.Test;


public class AdminUsersTest extends BaseTest {

    @Resource
    private DataDaoImpl dataDaoTest;

    @Test
    public void getAdminUsersListTest() throws Exception {
        Assert.assertFalse(dataDaoTest.getAdminUsersList().isEmpty());
    }

    @Test
    public void getAdminUserByIdTest() throws Exception {
        Assert.assertNotNull(dataDaoTest.getAdminUserById(1));
    }

    @Test
    public void addAdminUserTest() throws Exception {
        AdminUsers adminUser = new AdminUsers();

        adminUser.setId(1);
        adminUser.setUsername("Aayush");
        adminUser.setPassword("aayush");

        Assert.assertNotNull(dataDaoTest.getAdminUserById(1));
    }


    @Test
    public void deleteAdminUserTest() throws Exception {
        AdminUsers adminUser = dataDaoTest.getAdminUserById(1);

        long id = adminUser.getId();
        dataDaoTest.deleteAdminUser(id);
        Assert.assertNull(dataDaoTest.getAdminUserById(id));
    }
}
