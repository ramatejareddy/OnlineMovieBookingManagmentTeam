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
import com.cg.movie.entity.User;
@Entity
@Table(name="lpu_movie_customer")
public class Customer {
	
	
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
//  @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
	@Column(name="CUSTOMERID")
	private int customerId;
	@Column(name="customer_name",length=25)
	private String customerName;
	@Column(name="password",length=10)
	private String password;
	@Column(name="dateofBirth")
	private LocalDate dateOfBirth;
	@Column(name="customer_contact",length=10)
	private String customerContact;
//	 @OneToOne()
//	 @JoinColumn(name="user_id")// private User u = new User();
//	
	
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", password=" + password
				+ ", dateOfBirth=" + dateOfBirth + ", customerContact=" + customerContact + "]";
	}
	public Customer(int customerId, String customerName, String password, LocalDate dateOfBirth,
			String customerContact) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.customerContact = customerContact;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
