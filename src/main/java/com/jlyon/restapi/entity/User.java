package com.jlyon.restapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.UUID;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "users", uniqueConstraints = {
	@UniqueConstraint(name = "user_unique_username_idx", columnNames = "username"),
	@UniqueConstraint(name = "user_unique_email_idx", columnNames = "email")
})
public class User {

	@Id
	@GeneratedValue
	@Column(updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
	private UUID id;
	@Column(nullable = false, updatable = false, length = 30)
	private String username;
	@Column(nullable = false, length = 50)
	private String email;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", username='" + username + '\'' +
			", email='" + email + '\'' +
			'}';
	}
}
