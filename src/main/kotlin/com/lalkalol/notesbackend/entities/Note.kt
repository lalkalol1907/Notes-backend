package com.lalkalol.notesbackend.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name="notes")
class Note (
    @Id
    @GeneratedValue
    var id: Long? = null,

    val title: String?,
    val header: String,
    val content: String,
    @ManyToOne
    val author: User
) : Serializable