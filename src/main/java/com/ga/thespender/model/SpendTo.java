package com.ga.thespender.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="SpendTo")
public class SpendTo {
	@Id
	@GeneratedValue
	private int id;
	
	private String spendTo1;
	private String spendTo2;
	private String spendTo3;
	private String spendTo4;
	private String spendTo5;
	private String spendTo6;
	private String spendTo7;
	private String spendTo8;
	private String spendTo9;
	private String spendTo10;
	private String spendAmount;

//	@ManyToOne
//	@JoinColumn(name = "FK_SpendId")
//	private Spend spend;
	
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
	
	public String getSpendTo1() {
		return spendTo1;
	}

	public void setSpendTo1(String spendTo1) {
		this.spendTo1 = spendTo1;
	}

	public String getSpendTo2() {
		return spendTo2;
	}

	public void setSpendTo2(String spendTo2) {
		this.spendTo2 = spendTo2;
	}

	public String getSpendTo3() {
		return spendTo3;
	}

	public void setSpendTo3(String spendTo3) {
		this.spendTo3 = spendTo3;
	}

	public String getSpendTo4() {
		return spendTo4;
	}

	public void setSpendTo4(String spendTo4) {
		this.spendTo4 = spendTo4;
	}

	public String getSpendTo5() {
		return spendTo5;
	}

	public void setSpendTo5(String spendTo5) {
		this.spendTo5 = spendTo5;
	}

	public String getSpendTo6() {
		return spendTo6;
	}

	public void setSpendTo6(String spendTo6) {
		this.spendTo6 = spendTo6;
	}

	public String getSpendTo7() {
		return spendTo7;
	}

	public void setSpendTo7(String spendTo7) {
		this.spendTo7 = spendTo7;
	}

	public String getSpendTo8() {
		return spendTo8;
	}

	public void setSpendTo8(String spendTo8) {
		this.spendTo8 = spendTo8;
	}

	public String getSpendTo9() {
		return spendTo9;
	}

	public void setSpendTo9(String spendTo9) {
		this.spendTo9 = spendTo9;
	}
	
	public String getSpendTo10() {
		return spendTo10;
	}

	public void setSpendTo10(String spendTo10) {
		this.spendTo10 = spendTo10;
	}

//	public Spend getSpend() {
//		return spend;
//	}
//
//	public void setSpend(Spend spend) {
//		this.spend = spend;
//	}
	
	public String getSpendAmount() {
		return spendAmount;
	}

	public void setSpendAmount(String spendAmount) {
		this.spendAmount = spendAmount;
	}

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
