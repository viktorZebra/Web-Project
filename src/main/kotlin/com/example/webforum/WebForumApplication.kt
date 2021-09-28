package com.example.webforum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class WebForumApplication

fun main(args: Array<String>) {
    runApplication<WebForumApplication>(*args)
}

@RestController
@RequestMapping("/api/user")
class UserResource(val service: UserService){

    @GetMapping
    fun get(): List<User> = service.findUser()

    @PostMapping
    fun post(@RequestBody user: User) = service.post(user)
}

//@RestController
//@RequestMapping("/api/role")
//class RoleResource(val service: RoleService){
//
//    @GetMapping("/")
//    fun get(): List<Role> = service.findRole()
//
//    @PostMapping
//    fun post(@RequestBody role: Role) = service.post(role)
//}

@Service
class UserService(val db: UserRepository){

    fun findUser(): List<User>{
        return db.findUser()
    }

    fun post(user: User){
        db.save(user)
    }

}

//@Service
//class RoleService(val db: RoleRepository){
//
//    fun findRole(): List<Role>{
//        return db.findRole()
//    }
//
//    fun post(role: Role){
//        db.save(role)
//    }
//
//}

interface UserRepository: CrudRepository<User, Integer> {
    @Query("select * from users")
    fun findUser(): List<User>
}

//interface RoleRepository: CrudRepository<Role, Integer> {
//    @Query("select * from roles")
//    fun findRole(): List<Role>
//}

@Table("USERS")
data class User(val id: Integer, val username: String, val email: String, val password: String, val roleid: Integer)

@Table("ROLES")
data class Role(val id: Int, val name: String, val description: String)