package com.lalkalol.notesbackend.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue
    var id: Long? = null,

    val name: String,
    val surname: String,
    val email: String,
    val password: String,
) : Serializable