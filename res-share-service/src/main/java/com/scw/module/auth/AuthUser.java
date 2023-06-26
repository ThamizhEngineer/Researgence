package com.scw.module.auth;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import lombok.Data;

import org.hibernate.annotations.Fetch;


@Entity
@Table(name = "auth_user")
@Component
@Data
public class AuthUser implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "app_client_id")
	private String appClientId;
	@Column(name = "employee_id")
	private String employeeId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "mobile_number")
	private String mobileNumber;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "emp_code")
	private String empCode;
	@Column(name = "emp_designation")
	private String empDesignation;
	@Column(name = "user_type")
	private String userType;
	@Column(name = "user_status")
	private String userStatus;
	@Column(name = "duration")
	private String duration;
	@Column(name = "is_checked_in")
	private String isCheckedIn;
	@Column(name = "last_check_in_dt")
	private LocalDateTime lastCheckInDt;
	@Column(name = "last_check_out_dt")
	private LocalDateTime lastCheckOutDt;
	@Column(name = "latitude")
	private String latitude;
	@Column(name = "location_status")
	private String locationStatus;
	@Column(name = "longitude")
	private String longitude;
	@Column(name = "user_access_dt")
	private LocalDateTime userAccessDt;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_dt")
	private LocalDateTime createdDt;
	@Column(name = "modified_by")
	private String modifiedBy;
	@Column(name = "modified_dt")
	private LocalDateTime modifiedDt;
	@Column(name = "is_enabled")
	private String isEnabled="Y";
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "auth_user_id")
	private List<AuthToken> authToken;
	@Transient
	private String currentToken;

	
}
