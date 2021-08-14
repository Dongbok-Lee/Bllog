package com.bok.bllog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// 프로젝트에서 연결된 DB 넘버링 전략을 따라간
	private int id;
	
	@Column(nullable = false, length = 30, unique = true)
	private String username;
	
	@Column(nullable = false, length = 30)
	private String name;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 30, unique = true)
	private String email;
	
	@Column(nullable = false, length = 10)
	private int birth;
	
	@Enumerated(EnumType.STRING)
	private RoleType role ; // Enum을 쓰는게 좋다. //admin user manager
	
	@CreationTimestamp //시간이 자동입력
	private Timestamp createDate;
}
