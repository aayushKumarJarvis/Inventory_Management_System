package com.inventory_management_system.dao;

import java.util.List;

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
}
