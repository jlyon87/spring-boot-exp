package com.jlyon.restapi.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
	private Instant timestamp;
	private List<ErrorItem> errors;

	public ErrorResponse() {
		this.timestamp = Instant.now();
	}

	public ErrorResponse(Exception exc) {
		this();
		this.errors = Arrays.asList(new ErrorItem(exc));
	}

	public ErrorResponse(List<ErrorItem> errors) {
		this();
		this.errors = errors;
	}

	public void addError(ErrorItem error) {
		this.errors.add(error);
	}

	public void addErrors(List<ErrorItem> errors) {
		this.errors.addAll(errors);
	}
}
