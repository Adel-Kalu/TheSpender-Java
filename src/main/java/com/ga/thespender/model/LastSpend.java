package com.ga.thespender.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="LastSpend")
public class LastSpend {
	@Id
	@GeneratedValue
	private int id;
	
	private int salary;
	private String spend1;
	private String spend2;
	private String spend3;
	private String spend4;
	private String spend5;
	private String spend6;
	private String spend7;
	private String spend8;
	private String spend9;
	private String spend10;
	private String userEmail;

//	@ManyToOne
//	@JoinColumn(name = "FK_UserId")
//	private User user;
	
	@Column(name="createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getSpend1() {
		return spend1;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setSpend1(String spend1) {
		this.spend1 = spend1;
	}

	public String getSpend2() {
		return spend2;
	}

	public void setSpend2(String spend2) {
		this.spend2 = spend2;
	}

	public String getSpend3() {
		return spend3;
	}

	public void setSpend3(String spend3) {
		this.spend3 = spend3;
	}

	public String getSpend4() {
		return spend4;
	}

	public void setSpend4(String spend4) {
		this.spend4 = spend4;
	}

	public String getSpend5() {
		return spend5;
	}

	public void setSpend5(String spend5) {
		this.spend5 = spend5;
	}

	public String getSpend6() {
		return spend6;
	}

	public void setSpend6(String spend6) {
		this.spend6 = spend6;
	}

	public String getSpend7() {
		return spend7;
	}

	public void setSpend7(String spend7) {
		this.spend7 = spend7;
	}

	public String getSpend8() {
		return spend8;
	}

	public void setSpend8(String spend8) {
		this.spend8 = spend8;
	}

	public String getSpend9() {
		return spend9;
	}

	public void setSpend9(String spend9) {
		this.spend9 = spend9;
	}
	
	public String getSpend10() {
		return spend10;
	}

	public void setSpend10(String spend10) {
		this.spend10 = spend10;
	}
	
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	
	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	

}
