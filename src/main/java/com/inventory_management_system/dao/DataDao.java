package com.inventory_management_system.dao;

import java.util.List;

import com.inventory_management_system.model.InventoryItem;

public interface DataDao {

	public boolean addInventoryItem(InventoryItem inventoryItem) throws Exception;

	public InventoryItem getInventoryById(long id) throws Exception;

    public List<InventoryItem> getInventoryList() throws Exception;

    public boolean deleteInventory(long id) throws Exception;
}
