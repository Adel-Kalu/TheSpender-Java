package com.ga.thespender.model;

import java.sql.Date;
import java.time.LocalDateTime;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;
	private Date dateofBirth;
	private String image;
//	private String userRole;
//	
//	@OneToMany(mappedBy="user")
//	private Set<Spend> spends;
//	
//	@OneToMany(mappedBy="user")
//	private Set<LastSpend> lastSpends;
	
	@Column(name="createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;
	
	@Column(name="updatedat", nullable = false, updatable = true)
	@UpdateTimestamp
	private LocalDateTime updateAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
//	public String getUserRole() {
//		return userRole;
//	}
//	
//	public void setUserRole(String userRole) {
//		this.userRole = userRole;
//	}
	
//	public Set<Spend> getSpends() {
//		return spends;
//	}
//
//	public void setSpends(Set<Spend> spends) {
//		this.spends = spends;
//	}
//	
//	public Set<LastSpend> getLastSpends() {
//		return lastSpends;
//	}
//
//	public void setLastSpends(Set<LastSpend> lastSpends) {
//		this.lastSpends = lastSpends;
//	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

}
