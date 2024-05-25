package com.lalkalol.notesbackend.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Index
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import org.springframework.boot.context.properties.bind.DefaultValue
import java.io.Serializable

@Entity
@Table(name = "users",
    indexes = [Index(name = "email_index", columnList = "email")]
)
class User(
    @Id
    @GeneratedValue
    var id: Long? = null,

    val name: String,

    val surname: String? = null,
    val username: String? = null,

    @Column(unique = true)
    val email: String,

    val password: String,
) : Serializable