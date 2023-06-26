package com.scw.resservice.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="s_faculty_detail")
public class FacultyDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Slno;
	@Column(name = "author_name")
	private String authorName;
	private String Department;
	private String Institute;
	private String Location;
	private String Link;
	private String Scopus;
	private Long Scopusid;
	private String Researcherid;
	private String Researcherlink;
	private String Orchidid;
	private String Orchidlink;
	@Column(name = "scopush_index")
	private Integer scopushIndex;
	@Column(name= "wosh_index")
	private Integer woshIndex;
	@Column(name = "gssh_index")
	private Integer gsshIndex;
	private String Verification;
	private String Emailid;
	private String Empid;
	private String Designation;
	private String Researcharea;
	
	public FacultyDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacultyDetail(Integer slno, String authorName, String department, String institute, String location,
			String link, String scopus, Long scopusid, String researcherid, String researcherlink, String orchidid,
			String orchidlink, Integer scopushIndex, Integer woshIndex, Integer gsshIndex, String verification,
			String emailid, String empid, String designation, String researcharea) {
		super();
		Slno = slno;
		this.authorName = authorName;
		Department = department;
		Institute = institute;
		Location = location;
		Link = link;
		Scopus = scopus;
		Scopusid = scopusid;
		Researcherid = researcherid;
		Researcherlink = researcherlink;
		Orchidid = orchidid;
		Orchidlink = orchidlink;
		this.scopushIndex = scopushIndex;
		this.woshIndex = woshIndex;
		this.gsshIndex = gsshIndex;
		Verification = verification;
		Emailid = emailid;
		Empid = empid;
		Designation = designation;
		Researcharea = researcharea;
	}

	public Integer getSlno() {
		return Slno;
	}

	public void setSlno(Integer slno) {
		Slno = slno;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getInstitute() {
		return Institute;
	}

	public void setInstitute(String institute) {
		Institute = institute;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getLink() {
		return Link;
	}

	public void setLink(String link) {
		Link = link;
	}

	public String getScopus() {
		return Scopus;
	}

	public void setScopus(String scopus) {
		Scopus = scopus;
	}

	public Long getScopusid() {
		return Scopusid;
	}

	public void setScopusid(Long scopusid) {
		Scopusid = scopusid;
	}

	public String getResearcherid() {
		return Researcherid;
	}

	public void setResearcherid(String researcherid) {
		Researcherid = researcherid;
	}

	public String getReseacherlink() {
		return Researcherlink;
	}

	public void setReseacherlink(String reseacherlink) {
		Researcherlink = reseacherlink;
	}

	public String getOrchidid() {
		return Orchidid;
	}

	public void setOrchidid(String orchidid) {
		Orchidid = orchidid;
	}

	public String getOrchidlink() {
		return Orchidlink;
	}

	public void setOrchidlink(String orchidlink) {
		Orchidlink = orchidlink;
	}

	public Integer getScopushIndex() {
		return scopushIndex;
	}

	public void setScopushIndex(Integer scopushIndex) {
		this.scopushIndex = scopushIndex;
	}

	public Integer getWoshIndex() {
		return woshIndex;
	}

	public void setWoshIndex(Integer woshIndex) {
		this.woshIndex = woshIndex;
	}

	public Integer getGsshIndex() {
		return gsshIndex;
	}

	public void setGsshIndex(Integer gsshIndex) {
		this.gsshIndex = gsshIndex;
	}

	public String getVerification() {
		return Verification;
	}

	public void setVerification(String verification) {
		Verification = verification;
	}

	public String getEmailid() {
		return Emailid;
	}

	public void setEmailid(String emailid) {
		Emailid = emailid;
	}

	public String getEmpid() {
		return Empid;
	}

	public void setEmpid(String empid) {
		Empid = empid;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getResearcharea() {
		return Researcharea;
	}

	public void setResearcharea(String researcharea) {
		Researcharea = researcharea;
	}

	@Override
	public String toString() {
		return "FacultyDetail [Slno=" + Slno + ", authorName=" + authorName + ", Department=" + Department
				+ ", Institute=" + Institute + ", Location=" + Location + ", Link=" + Link + ", Scopus=" + Scopus
				+ ", Scopusid=" + Scopusid + ", Researcherid=" + Researcherid + ", Reseacherlink=" + Researcherlink
				+ ", Orchidid=" + Orchidid + ", Orchidlink=" + Orchidlink + ", scopushIndex=" + scopushIndex
				+ ", woshIndex=" + woshIndex + ", gsshIndex=" + gsshIndex + ", Verification=" + Verification
				+ ", Emailid=" + Emailid + ", Empid=" + Empid + ", Designation=" + Designation + ", Researcharea="
				+ Researcharea + "]";
	}
	
	
}
