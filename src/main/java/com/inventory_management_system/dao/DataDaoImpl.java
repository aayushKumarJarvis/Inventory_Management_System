package com.inventory_management_system.dao;

import java.util.List;

import com.inventory_management_system.model.AdminUsers;
import com.inventory_management_system.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.inventory_management_system.model.InventoryItem;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

    // Hibernate Query handling of Inventory Users
	@Override
	public boolean addInventoryItem(InventoryItem inventoryItem) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(inventoryItem);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public InventoryItem getInventoryById(long id) throws Exception {

		session = sessionFactory.openSession();
		InventoryItem inventoryItem = (InventoryItem)session.load(InventoryItem.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return inventoryItem;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InventoryItem> getInventoryList() throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<InventoryItem> inventoryItemList = session.createCriteria(InventoryItem.class)
				.list();
		tx.commit();
		session.close();
		return inventoryItemList;
	}
	
	@Override
	public boolean deleteInventory(long id) throws Exception {

		session = sessionFactory.openSession();
		Object o = session.load(InventoryItem.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

    //Hibernate Query handling of the AdminUsers
    @Override
    public boolean addAdminUser(AdminUsers adminUser) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(adminUser);
        tx.commit();
        session.close();

        return false;
    }

    @Override
    public AdminUsers getAdminUserById(long id) throws Exception {

        session = sessionFactory.openSession();
        AdminUsers adminUser = (AdminUsers)session.load(AdminUsers.class,
                new Long(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return adminUser;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AdminUsers> getAdminUsersList() throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<AdminUsers> adminUsersList = session.createCriteria(AdminUsers.class)
                .list();
        tx.commit();
        session.close();
        return adminUsersList;
    }

    @Override
    public  boolean deleteAdminUser(long id) throws Exception {

        session = sessionFactory.openSession();
        Object o = session.load(InventoryItem.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }


    // Hibernate Query handling of Users
    @Override
    public boolean addUser(Users user) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();

        return false;
    }

    public Users getUserById(long id) throws Exception {

        session = sessionFactory.openSession();
        Users user = (Users)session.load(Users.class,
                new Long(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return user;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Users> getUsersList() throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Users> usersList = session.createCriteria(Users.class)
                .list();
        tx.commit();
        session.close();
        return usersList;
    }

    @Override
    public  boolean deleteUser(long id) throws Exception {

        session = sessionFactory.openSession();
        Object o = session.load(InventoryItem.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

}
