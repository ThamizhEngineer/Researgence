package com.scw.resservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="s_res_score")
public class ReseacherScore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer Pubcount;
	private Integer Pubcounthome;
	private Integer Patentcount;
	private Integer Projectcount;
	private Integer Academicguidancecount;
	public ReseacherScore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReseacherScore(Integer pubcount, Integer pubcounthome, Integer patentcount, Integer projectcount,
			Integer academicguidancecount) {
		super();
		Pubcount = pubcount;
		Pubcounthome = pubcounthome;
		Patentcount = patentcount;
		Projectcount = projectcount;
		Academicguidancecount = academicguidancecount;
	}
	public Integer getPubcount() {
		return Pubcount;
	}
	public void setPubcount(Integer pubcount) {
		Pubcount = pubcount;
	}
	public Integer getPubcounthome() {
		return Pubcounthome;
	}
	public void setPubcounthome(Integer pubcounthome) {
		Pubcounthome = pubcounthome;
	}
	public Integer getPatentcount() {
		return Patentcount;
	}
	public void setPatentcount(Integer patentcount) {
		Patentcount = patentcount;
	}
	public Integer getProjectcount() {
		return Projectcount;
	}
	public void setProjectcount(Integer projectcount) {
		Projectcount = projectcount;
	}
	public Integer getAcademicguidancecount() {
		return Academicguidancecount;
	}
	public void setAcademicguidancecount(Integer academicguidancecount) {
		Academicguidancecount = academicguidancecount;
	}
	@Override
	public String toString() {
		return "ReseacherScore [Pubcount=" + Pubcount + ", Pubcounthome=" + Pubcounthome + ", Patentcount="
				+ Patentcount + ", Projectcount=" + Projectcount + ", Academicguidancecount=" + Academicguidancecount
				+ "]";
	}
	
	
}
