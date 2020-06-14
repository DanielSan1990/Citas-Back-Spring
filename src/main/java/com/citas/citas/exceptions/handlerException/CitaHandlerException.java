package com.citas.citas.exceptions.handlerException;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.citas.citas.dto.ErrorResponse;
import com.citas.citas.exceptions.generics.BadRequestException;
import com.citas.citas.exceptions.generics.ImUsedException;
import com.citas.citas.exceptions.generics.NoContentException;
import com.citas.citas.exceptions.generics.NotFoundException;



@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CitaHandlerException extends ResponseEntityExceptionHandler{
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({NotFoundException.class})
	@ResponseBody
	public ErrorResponse notFoundException(HttpServletRequest request, Exception exception) {
		return new ErrorResponse(exception, request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler({NoContentException.class})
	@ResponseBody
	public ErrorResponse noContentException(HttpServletRequest request, Exception exception) {
		return new ErrorResponse(exception, request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.IM_USED)
	@ExceptionHandler({ImUsedException.class})
	@ResponseBody
	public ErrorResponse imUsedException(HttpServletRequest request, Exception exception) {
		return new ErrorResponse(exception, request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({
		BadRequestException.class,
		org.springframework.dao.DuplicateKeyException.class,
		javax.validation.ConstraintViolationException.class		
		})
	@ResponseBody
	public ErrorResponse badRequestException(HttpServletRequest request, Exception exception) {
		return new ErrorResponse(exception, request.getRequestURI());
	}
	
	@Override //si salta error en una anotacion valid
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream().map (e -> e.getDefaultMessage()).collect(Collectors.toList());
		//return new ResponseEntity<>(new ErrorResponse(ex, errorMessages.toString()), HttpStatus.BAD_REQUEST);

		return new ResponseEntity<Object>(new ErrorResponse(ex, errorMessages.toString(), ((ServletWebRequest)request).getRequest().getRequestURI()), status); 
	} 
	
	
}
