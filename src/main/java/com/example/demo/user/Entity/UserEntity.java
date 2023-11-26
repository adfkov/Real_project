package com.example.demo.user.Entity;

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
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name="user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENRT
	private int id;
	@Column(name="loginId")
	private String loginId;
	private String password;
	private String name;
	private String email;
	@Column(name="nickName")
	private String nickName;
	private String grade;
	@Column(name="profileImageUrl")
	private String profileImageUrl;
	private String birth;
	@Column(name="userGender")
	private String userGender;
	
	private String interest;
	@UpdateTimestamp
	@Column(name="createdAt", updatable = false)
	private Date createdAt;
	@UpdateTimestamp
	@Column(name="updatedAt")
	private Date updatedAt;
}
