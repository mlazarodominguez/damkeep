package com.salesianostriana.dam.damkeep


import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/notas")
class NotaController (val notasRepository: NotasRepository){

    private fun getAllUser(id:UUID):List<Nota>{
        var result: List<Nota>
        with(notasRepository){
            result = findNotasLogeado(id)
        }
        if (result.isEmpty())
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "No hay notas almacenadas")
        return result
    }

    private fun getNotaById(id:UUID):Nota{

        var result: Optional<Nota>
        with(notasRepository){
            result =  findById(id)
        }
        return result.orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "No existe la nota con el identificador $id")}
    }

    @GetMapping("/")
    private  fun getAll(): List<Nota>{
        var result: List<Nota>
        with(notasRepository){
            result =  findAll()
        }
        if (result.isEmpty())
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "No hay notas almacenadas")
        return result
    }
    @GetMapping("/user/{id}")

    fun getTodasUsuario(@PathVariable id:UUID) = getAllUser(id).map { it.toNotaDto() }

    @GetMapping("/{id}")

    fun getById(@PathVariable id: UUID) =  getNotaById(id).toNotaDto()

    @PostMapping("/")

    fun nuevaSerie(@RequestBody nuevaNota: NotaDto) = ResponseEntity.status(HttpStatus.CREATED).body(notasRepository.save(nuevaNota.toNota()).toNotaDto())

    @PutMapping("/{id}")
    fun editarNota(@RequestBody editarNota: NotaDto, @PathVariable id : UUID): NotaDto {
        return notasRepository.findById(id)
                .map { notaEncontrada  ->
                    val notaActualizada : Nota =
                            notaEncontrada.copy(titulo = editarNota.titulo,
                                    ultimaEdicion = editarNota.ultimaEdicion,
                                    contenido = editarNota.contenido)
                    notasRepository.save(notaActualizada).toNotaDto()
                }.orElseThrow {
                    ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado la nota con el identificador $id")
                }
    }

    @DeleteMapping("/{id}")
    fun eliminarNota(@PathVariable id : UUID) : ResponseEntity<Void> {
        notasRepository.deleteById(id)
        return ResponseEntity.noContent().build()
    }


}