package com.lalkalol.notesbackend.dto

data class RegisterDTO(
    val name: String,
    val surname: String?,
    val email: String,
    val password: String,
    val username: String?
)