package com.mac.first.macFirst.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "contact")
data class Contact(
    val firstName: String? = null,
    @Id
    @GeneratedValue
    val id: Long?= null ,
    val lastName: String? = null,
    val email: String?= null
) {

}