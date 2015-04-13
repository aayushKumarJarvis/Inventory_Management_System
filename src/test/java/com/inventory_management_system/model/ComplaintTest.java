package com.inventory_management_system.model;

import javax.annotation.Resource;

import com.inventory_management_system.dao.DataDaoImplementation;
import junit.framework.Assert;

import org.junit.Test;

import java.util.List;


public class ComplaintTest extends BaseTest {

    @Resource
    private DataDaoImplementation dataDaoTestForComplaint;

    @Test
    public void getAllComplaintsListTest() throws Exception {
        Assert.assertNotNull(dataDaoTestForComplaint.getAllComplaints().isEmpty());

        List<Complaint> allComplaints = dataDaoTestForComplaint.getAllComplaints();

        for (int i = 0; i < allComplaints.size(); i++) {
            System.out.println("Name of the complaint filing person : " + allComplaints.get(i).getNameOfPerson());
            System.out.println("Subject of the Complaint : " + allComplaints.get(i).getSubject());
            System.out.println("Complaint Description : " + allComplaints.get(i).getComplaintDescription());
        }
    }

    @Test
    public void addComplaint() throws Exception {
        Complaint complaint = new Complaint();

        complaint.setNameOfPerson("AayushKumar");
        complaint.setSubject("Complaint for Pencils");
        complaint.setComplaintDescription("Pencils were not that great!!. Lead broke out very easily.");

        dataDaoTestForComplaint.addComplaint(complaint);

        Assert.assertNotNull(dataDaoTestForComplaint.getAllComplaints());

        System.out.println("Filed Complaint is " + dataDaoTestForComplaint.getAllComplaints());
    }
}
