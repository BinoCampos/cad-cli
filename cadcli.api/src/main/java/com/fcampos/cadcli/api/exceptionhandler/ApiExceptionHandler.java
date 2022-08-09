package com.fcampos.cadcli.api.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
		protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
				String bodyOfResponse = "Ocorreu um erro ao chamar o serviço";
				return handleExceptionInternal(ex, bodyOfResponse, 
						new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
