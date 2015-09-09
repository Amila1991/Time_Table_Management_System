package com.mycompany.time_table_management_system.db.model;

public class Batch {
	private String batchNo;
	private String batchName;
	private String dateofAdmission;
	private String dateofAcademicCompletion;
	private int nooftudent;
	
	
	public Batch() {
	}

	
	public Batch(String batchNo) {
		this.batchNo = batchNo;
	}


	public Batch(String batchNo, String batchName, String dateofAdmission, String dateofAcademicCompletion,int nooftudent) {
		this.batchNo = batchNo;
		this.batchName = batchName;
		this.dateofAdmission = dateofAdmission;
		this.dateofAcademicCompletion = dateofAcademicCompletion;
		this.nooftudent = nooftudent;
	}


	/**
	 * @return the batchNo
	 */
	public String getBatchNo() {
		return batchNo;
	}


	/**
	 * @param batchNo the batchNo to set
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}


	/**
	 * @return the batchName
	 */
	public String getBatchName() {
		return batchName;
	}


	/**
	 * @param batchName the batchName to set
	 */
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}


	/**
	 * @return the dateofAdmission
	 */
	public String getDateofAdmission() {
		return dateofAdmission;
	}


	/**
	 * @param dateofAdmission the dateofAdmission to set
	 */
	public void setDateofAdmission(String dateofAdmission) {
		this.dateofAdmission = dateofAdmission;
	}


	/**
	 * @return the dateofAcademicCompletion
	 */
	public String getDateofAcademicCompletion() {
		return dateofAcademicCompletion;
	}


	/**
	 * @param dateofAcademicCompletion the dateofAcademicCompletion to set
	 */
	public void setDateofAcademicCompletion(String dateofAcademicCompletion) {
		this.dateofAcademicCompletion = dateofAcademicCompletion;
	}


	/**
	 * @return the nooftudent
	 */
	public int getNooftudent() {
		return nooftudent;
	}


	/**
	 * @param nooftudent the nooftudent to set
	 */
	public void setNooftudent(int nooftudent) {
		this.nooftudent = nooftudent;
	}
	
	
	
}
