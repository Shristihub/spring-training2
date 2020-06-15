package com.bookapp.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bookapp.models.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(BookNotFoundException.class)
	protected ResponseEntity<Object> handleBookNotFoundException(Exception e){
		String message = e.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Author name not available");
		ApiErrors errors = new ApiErrors(message, LocalDateTime.now(), details, HttpStatus.BAD_REQUEST);
		return ResponseEntity.badRequest().body(errors);
	}
	@ExceptionHandler(IdNotFoundException.class)
	protected ResponseEntity<Object> handleIdNotFoundException(Exception e){
		String message = e.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Invalid id");
		ApiErrors errors = new ApiErrors(message, LocalDateTime.now(), details, HttpStatus.BAD_REQUEST);
		return ResponseEntity.badRequest().body(errors);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("Method not supported");
		ApiErrors errors = new ApiErrors(ex.getMessage(), LocalDateTime.now(), details, status);
		return new ResponseEntity<Object>(errors, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("Media not supported");
		ApiErrors errors = new ApiErrors(ex.getMessage(), LocalDateTime.now(), details, status);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("Missing path variable");
		details.add("Variable not added");
		ApiErrors errors = new ApiErrors(ex.getMessage(), LocalDateTime.now(), details, status);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("No request param");
		ApiErrors errors = new ApiErrors(ex.getMessage(), LocalDateTime.now(), details, status);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("Type not supported");
		ApiErrors errors = new ApiErrors(ex.getMessage(), LocalDateTime.now(), details, status);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAll(Exception ex) {
		List<String> details = new ArrayList<>();
		System.out.println(ex.getMessage());
		details.add(ex.getMessage());
		ApiErrors errors = new ApiErrors(ex.getMessage(), LocalDateTime.now(), details, HttpStatus.BAD_GATEWAY);
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(errors);
	}
}
