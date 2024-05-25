package com.lalkalol.notesbackend.services

import com.lalkalol.notesbackend.dto.RegisterDTO
import com.lalkalol.notesbackend.entities.User
import com.lalkalol.notesbackend.exceptions.HttpException
import com.lalkalol.notesbackend.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException.BadRequest
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(
    @Autowired
    private val userRepository: UserRepository,
) {
    private val passwordEncoder = BCryptPasswordEncoder()

    private fun validatePassword(password: String) : Boolean {
        return true
    }

    fun registerUser(registerDTO: RegisterDTO) {

        val userExists = userRepository.getUserByEmail(registerDTO.email)
        if (userExists != null) {
            throw HttpException("User already exists", HttpStatus.BAD_REQUEST)
        }

        if (!validatePassword(registerDTO.password)) {
            throw HttpException("Invalid password", HttpStatus.BAD_REQUEST)
        }

        val encodedPassword = passwordEncoder.encode(registerDTO.password)

        val user = User(
            name = registerDTO.name,
            surname = registerDTO.surname,
            email = registerDTO.email,
            password = encodedPassword,
            username = registerDTO.username
        )

        try {
            userRepository.save(user)
        } catch (e: Exception) {
            throw HttpException("DB update error", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}