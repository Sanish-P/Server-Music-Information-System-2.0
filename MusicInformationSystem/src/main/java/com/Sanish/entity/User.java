package com.Sanish.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.Sanish.json.view.View;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "tbl_User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	@JsonView(View.Summary.class)
	private int userId;
	
    @Column(name = "username")
    @JsonView(View.Summary.class)
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "first_name")
    @JsonView(View.Summary.class)
    private String firstName;
    
    @Column(name = "last_name")
    @JsonView(View.Summary.class)
    private String lastName;
    
    @Column(name="user_role")
    @JsonView(View.Summary.class)
    private String userRole;
    
    @Column(name="email")
    @JsonView(View.Summary.class)
    private String email;

	public User(int userId,String username, String password, String firstName, String lastName) {
		
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public User(int userId,String username, String password, String firstName, String lastName,String userRole) {
		
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRole = userRole;
	}
	
	
	
	public User(String username, String password, String firstName, String lastName, String userRole) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRole = userRole;
	}
	
	

	public User(String username, String password, String firstName, String lastName, String userRole, String email) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRole = userRole;
		this.email = email;
	}

	public User(){
		
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", userRole=" + userRole + ", email=" + email + "]";
	}
	
	
	
	

}
