package com.lalkalol.notesbackend.config

import com.lalkalol.notesbackend.entities.User
import com.lalkalol.notesbackend.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(
    @Autowired
    private val userRepository: UserRepository
) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String): UserDetails { // На самом деле ByEmail, просто spring security так делать не дает
        val user: User =
            userRepository.getUserByEmail(email) ?: throw UsernameNotFoundException("Could not find user")
        return UserDetailsImpl(user)
    }
}