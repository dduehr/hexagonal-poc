package com.example.adapter.input.rest

import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class RestExceptionHandler {
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(e: Exception): ResponseEntity<String> =
        ResponseEntity(e.localizedMessage, HttpStatus.BAD_REQUEST)

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(e: Exception): ResponseEntity<String> =
       ResponseEntity(e.localizedMessage, HttpStatus.BAD_REQUEST)
}