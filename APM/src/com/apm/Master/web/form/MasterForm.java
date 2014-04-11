package com.apm.Master.web.form;

import java.util.ArrayList;

import com.apm.Master.eu.entity.Master;

public class MasterForm {
	private int id;
	private String occupation;
	private String jobTitle;
	private String pagerecords;
	private int totalRecords;
	private String reference;
	ArrayList<Master>occupationList;
	ArrayList<Master>jobTitleList;
	ArrayList<Master>referenceList;

	
	public ArrayList<Master> getReferenceList() {
		return referenceList;
	}
	public void setReferenceList(ArrayList<Master> referenceList) {
		this.referenceList = referenceList;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getPagerecords() {
		return pagerecords;
	}
	public void setPagerecords(String pagerecords) {
		this.pagerecords = pagerecords;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public ArrayList<Master> getOccupationList() {
		return occupationList;
	}
	public void setOccupationList(ArrayList<Master> occupationList) {
		this.occupationList = occupationList;
	}
	public ArrayList<Master> getJobTitleList() {
		return jobTitleList;
	}
	public void setJobTitleList(ArrayList<Master> jobTitleList) {
		this.jobTitleList = jobTitleList;
	}
}
