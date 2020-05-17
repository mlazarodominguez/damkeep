package com.salesianostriana.dam.damkeep

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.salesianostriana.dam.damkeep.users.User
import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

//  (una nota de texto consiste al menos en el título, el contenido, la fecha de creación, la de última edición y el autor)

@Entity
data class Nota(var titulo: String,
                var contenido:String,
                var fechaCreacion: LocalDate,
                var ultimaEdicion: LocalDate,
                @JsonManagedReference @ManyToOne var autor: User,
                @Id @GeneratedValue val id : UUID? = null)