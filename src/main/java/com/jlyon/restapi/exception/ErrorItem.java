package com.jlyon.restapi.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorItem {
	private Instant timestamp;
	private String message;

	public ErrorItem(Exception exc) {
		this.timestamp = Instant.now();
		this.message = exc.getMessage();
	}
}
