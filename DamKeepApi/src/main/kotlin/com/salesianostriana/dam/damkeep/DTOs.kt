package com.salesianostriana.dam.damkeep

import com.fasterxml.jackson.annotation.JsonFormat
import com.salesianostriana.dam.damkeep.users.User

import java.time.LocalDate
import java.util.*

data class NotaDto(
        val id: UUID?,
        val titulo: String,
        val contenido:String,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val fechaCreacion: LocalDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val ultimaEdicion: LocalDate,
        val autor : User
)


fun Nota.toNotaDto() = NotaDto(id, titulo, contenido, fechaCreacion, ultimaEdicion, autor)

fun NotaDto.toNota() = Nota(titulo, contenido, fechaCreacion, ultimaEdicion,autor, id)

data class NuevaNotaDto(
        val titulo: String,
        val contenido:String,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val fechaCreacion: LocalDate = LocalDate.now(),
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val ultimaEdicion: LocalDate =  LocalDate.now(),
        val autor : User
)

fun NuevaNotaDto.toNota() = Nota(titulo,contenido,fechaCreacion,ultimaEdicion,autor)