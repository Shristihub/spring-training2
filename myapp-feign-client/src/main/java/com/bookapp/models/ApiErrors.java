package com.bookapp.models;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrors {
	private String message;
	private LocalDateTime timestamp;
	private List<String> details;
	private HttpStatus status;
	
}
