package com.inventory_management_system.controller;

import java.util.List;

import com.inventory_management_system.model.AdminUsers;
import com.inventory_management_system.model.Complaint;
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
@RequestMapping("/complaint")
public class ComplaintController {

    @Autowired
    DataServices dataServices;

    static final Logger logger = Logger.getLogger(Complaint.class);

    @RequestMapping(value = "/addComplaint", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addComplaint(@RequestBody Complaint complaint) {

        try {
            dataServices.addComplaint(complaint);
            return new Status(1, "Complaint added successfully");
        } catch(Exception e) {

            return new Status(0,e.toString());
        }
    }

    @RequestMapping(value = "/listAllComplaints/", method = RequestMethod.GET)
    public @ResponseBody
    List<Complaint> getAllComplaints() {

        List<Complaint> complaintList = null;

        try {
            complaintList = dataServices.getAllComplaints();
        } catch (Exception e) {
            e.printStackTrace();;
        }

        return complaintList;
    }
}
