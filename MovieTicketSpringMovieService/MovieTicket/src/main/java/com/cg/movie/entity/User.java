package com.cg.movie.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="lpu_movie_user")
public class User {
	
	
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
//  @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
	@Column(name="user_id")
	private int userId;
	@Column(name="NAME",length=25)
	private String name;
	@Column(name="USERNAME",length=10,unique=true)
	private String userName;
	@Column(name="ISADMIN")
	private Boolean isAdmin;
	@Column(name="USERPASSWORD",length=16)
	private String password;
	@Column(name="dateofBirth")
	private LocalDate dateOfBirth;
	@Column(name="CONTACT",length=10,unique=true)
	private String contact;
//	 @OneToOne()
//	 @JoinColumn(name="user_id")// private User u = new User();
//	
	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", userName=" + userName
				+ ", isAdmin=" + isAdmin + ", password=" + password + ", dateOfBirth=" + dateOfBirth
				+ ", contact=" + contact + "]";
	}
	public User(int userId, String customerName, String userName, Boolean isAdmin, String password,
			LocalDate dateOfBirth, String contact) {
		super();
		this.userId = userId;
		this.name = customerName;
		this.userName = userName;
		this.isAdmin = isAdmin;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.contact = contact;
	}
		
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int customerId) {
		this.userId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String customerName) {
		this.name = customerName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    	

}
