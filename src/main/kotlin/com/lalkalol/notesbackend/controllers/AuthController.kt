package com.lalkalol.notesbackend.controllers

import com.lalkalol.notesbackend.dto.RegisterDTO
import com.lalkalol.notesbackend.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(
    @Autowired
    private val userService: UserService
) {
    @PostMapping("/register")
    fun register(@RequestBody registerDto: RegisterDTO) {
        println(registerDto.email)
        userService.registerUser(registerDto)
    }
}