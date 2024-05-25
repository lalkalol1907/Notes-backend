package com.lalkalol.notesbackend.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode

class HttpException(message: String? = "", val httpCode: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR) : Exception(message)
