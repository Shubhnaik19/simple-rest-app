package com.mac.first.macFirst.model

import org.springframework.data.jpa.repository.JpaRepository

interface ContactRepo : JpaRepository<Contact, Long> {
}