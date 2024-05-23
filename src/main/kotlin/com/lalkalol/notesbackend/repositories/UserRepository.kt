package com.lalkalol.notesbackend.repositories

import com.lalkalol.notesbackend.entities.User
import io.lettuce.core.dynamic.annotation.Param
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {
    fun getUserByEmail(@Param("email") email: String?): User?
}