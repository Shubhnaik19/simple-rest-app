package com.mac.first.macFirst.Resource

import com.mac.first.macFirst.model.Contact
import com.mac.first.macFirst.model.ContactRepo
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.net.URISyntaxException

//@CrossOrigin(origins = ["http://localhost:3000/"])
@RestController
@RequestMapping("/clients")
class ContactController(val contactRepo: ContactRepo) {

    @GetMapping("/{id}")
    fun getClient(@PathVariable id: Long): Contact {
        return contactRepo.findById(id).orElseThrow { RuntimeException() }
    }

    @GetMapping("/getAllContacts")
    fun getAllContact(): ResponseEntity<MutableList<Contact>> {
        return  ResponseEntity.status(HttpStatus.OK)
            .body(contactRepo.findAll())
    }


    @PostMapping
    @Throws(URISyntaxException::class)
    fun createClient(@RequestBody contact: Contact?): ResponseEntity<*> {
        val savedClient: Contact = contactRepo.save(Contact(contact?.firstName,contact!!.id, contact.lastName,contact.email))
        return ResponseEntity.created(URI("/clients/" + savedClient.id)).body<Any>(savedClient)
    }

    @PutMapping("/{id}")
    fun updateClient(@PathVariable id: Long?, @RequestBody contact: Contact?): ResponseEntity<*> {
        var currentClient:Contact = contactRepo.save(Contact(contact?.firstName,contact!!.id, contact.lastName, contact.email))
        return ResponseEntity.ok<Any>(currentClient)
    }

    @DeleteMapping("/{id}")
    fun deleteClient(@PathVariable id: Long?): ResponseEntity<*> {
        contactRepo.deleteById(id!!)
        return ResponseEntity.ok().build<Any>()
    }
}