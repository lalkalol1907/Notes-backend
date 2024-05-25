package com.lalkalol.notesbackend.config

import com.lalkalol.notesbackend.exceptions.HttpException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {
    data class ErrorResponse(
        val message: String? = "",
        val httpCode: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR
    )

    @ExceptionHandler
    fun handleException(ex: Exception) : ResponseEntity<ErrorResponse> {
        if (ex is HttpException) {
            return ResponseEntity(
                ErrorResponse(ex.message, ex.httpCode),
                ex.httpCode
            )
        }
        return ResponseEntity(
            ErrorResponse(ex.message),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }
}