package com.jlyon.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {
	@UniqueConstraint(name = "user_unique_username_idx", columnNames = "username"),
	@UniqueConstraint(name = "user_unique_email_idx", columnNames = "email")
})
public class User {

	@Id
	@GeneratedValue
	private UUID id;
	@Column(nullable = false, updatable = false, length = 30)
	private String username;
	@Column(nullable = false, length = 50)
	private String email;
}
