package com.scw.resservice.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="s_faculty")
public class Facultysummary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sl_no")
	private Integer slno;
	@Column(name = "faculty_name")
	private String facultyName;
	@Column(name = "emp_id")
	private Integer empId;
	@Column(name = "pubcount_total")
	private String pubcountTotal;
	@Column(name = "pubcount_hotel")
	private String pubcountHotel ;
	@Column(name = "pubcount_away")
	private String pubcountAway ;
	@Column(name = "patentCount")
	private String patentCount ;
	@Column(name = "projectCount")
	private String projectCount ;
	@Column(name = "academicguidancecount")
	private String academicguidancecount ;
	@Column(name = "department")
	private String department;
	@Column(name = "designation")
	private String designation;
	@Column(name = "location")
	private String location;
	@Column(name = "faculty")
	private String faculty;
	
	
	public Facultysummary() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Facultysummary(Integer slno, String facultyName, Integer empId, String pubcountTotal, String pubcountHotel,
			String pubcountAway, String patentCount, String projectCount, String academicguidancecount,
			String department, String designation, String location, String faculty) {
		super();
		this.slno = slno;
		this.facultyName = facultyName;
		this.empId = empId;
		this.pubcountTotal = pubcountTotal;
		this.pubcountHotel = pubcountHotel;
		this.pubcountAway = pubcountAway;
		this.patentCount = patentCount;
		this.projectCount = projectCount;
		this.academicguidancecount = academicguidancecount;
		this.department = department;
		this.designation = designation;
		this.location = location;
		this.faculty = faculty;
	}


	public Integer getSlno() {
		return slno;
	}


	public void setSlno(Integer slno) {
		this.slno = slno;
	}


	public String getFacultyName() {
		return facultyName;
	}


	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}


	public Integer getEmpId() {
		return empId;
	}


	public void setEmpId(Integer empId) {
		this.empId = empId;
	}


	public String getPubcountTotal() {
		return pubcountTotal;
	}


	public void setPubcountTotal(String pubcountTotal) {
		this.pubcountTotal = pubcountTotal;
	}


	public String getPubcountHotel() {
		return pubcountHotel;
	}


	public void setPubcountHotel(String pubcountHotel) {
		this.pubcountHotel = pubcountHotel;
	}


	public String getPubcountAway() {
		return pubcountAway;
	}


	public void setPubcountAway(String pubcountAway) {
		this.pubcountAway = pubcountAway;
	}


	public String getPatentCount() {
		return patentCount;
	}


	public void setPatentCount(String patentCount) {
		this.patentCount = patentCount;
	}


	public String getProjectCount() {
		return projectCount;
	}


	public void setProjectCount(String projectCount) {
		this.projectCount = projectCount;
	}


	public String getAcademicguidancecount() {
		return academicguidancecount;
	}


	public void setAcademicguidancecount(String academicguidancecount) {
		this.academicguidancecount = academicguidancecount;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getFaculty() {
		return faculty;
	}


	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}


	@Override
	public String toString() {
		return "Facultysummary [slno=" + slno + ", facultyName=" + facultyName + ", empId=" + empId + ", pubcountTotal="
				+ pubcountTotal + ", pubcountHotel=" + pubcountHotel + ", pubcountAway=" + pubcountAway
				+ ", patentCount=" + patentCount + ", projectCount=" + projectCount + ", academicguidancecount="
				+ academicguidancecount + ", department=" + department + ", designation=" + designation + ", location="
				+ location + ", faculty=" + faculty + "]";
	}


	

}
