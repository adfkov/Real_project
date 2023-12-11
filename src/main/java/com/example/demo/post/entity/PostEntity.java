package com.example.demo.post.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder(toBuilder = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="post")
public class PostEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // AUTO_INCREMENT
	private int id;
	@Column(name="userId")
	private int userId;
	private String subject;
	private String intro;
	@Column(name="foodTypeId")
	private String foodTypeId;
	@Column(name="ingredientId")
	private String ingredientId;
	private String portion;
	private String degree;
	@Column(name="mainImageUrl")
	private String mainImageUrl;
	private String ingredient;
	@Column(name="cookStepText")
	private String cookStepText;
	@Column(name="cookTip")
	private String cookTip;
	@UpdateTimestamp
	@Column(name="createdAt", updatable = false)
	private Date createdAt;
	@UpdateTimestamp
	@Column(name="updatedAt")
	private Date updatedAt;

	
}
