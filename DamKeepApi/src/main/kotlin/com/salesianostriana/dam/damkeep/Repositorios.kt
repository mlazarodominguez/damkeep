package com.salesianostriana.dam.damkeep

import com.salesianostriana.dam.damkeep.users.User
import com.salesianostriana.dam.damkeep.users.UserRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.util.*
import javax.annotation.PostConstruct

interface NotasRepository:JpaRepository<Nota,UUID>{

    @Query("select distinct n from Nota n where n.autor.id = :id")
    fun findNotasLogeado(id:UUID) : List<Nota>



}
@Component
class InitDataComponent(
        val notasRepository: NotasRepository,
        val userRepository: UserRepository,
        val encoder : BCryptPasswordEncoder
) {

    @PostConstruct
    fun initData()  {
        val user1= User("Miguel",encoder.encode("12345"),"Miguel Lázaro Dominguez","Admin")
        userRepository.save(user1)
        val user2= User("Agapito",encoder.encode("12345"),"Agapito De Pota","User")
        userRepository.save(user2)
        val nota1 = Nota("Nota prueba 1 ", "Esta es la primera nota", LocalDate.now(), LocalDate.now(),user1)
        notasRepository.save(nota1)
        val nota2 = Nota("Nota prueba 2 ", "Esta es la segunda nota", LocalDate.now(), LocalDate.now(),user1)
        notasRepository.save(nota2)
        val nota3 = Nota("Nota prueba 3 ", "Esta es la tercera nota", LocalDate.now(), LocalDate.now(),user1)
        notasRepository.save(nota3)

        val nota4 = Nota("Nota prueba 4 ", "Esta es la cuarta nota", LocalDate.now(), LocalDate.now(),user2)
        notasRepository.save(nota4)

    }

}