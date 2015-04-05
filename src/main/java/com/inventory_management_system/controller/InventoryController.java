package com.inventory_management_system.controller;

import java.util.List;

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

@Controller
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(InventoryController.class);

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addInventoryItem(@RequestBody InventoryItem inventoryItem) {
		try {
			dataServices.addInventoryItem(inventoryItem);
			return new Status(1, "Inventory added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
    InventoryItem getInventoryById(@PathVariable("id") long id) {
		InventoryItem inventoryItem = null;
		try {
			inventoryItem = dataServices.getInventoryById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return inventoryItem;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<InventoryItem> getInventoryList() {

		List<InventoryItem> inventoryItemList = null;
		try {
			inventoryItemList = dataServices.getInventoryList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return inventoryItemList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
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
