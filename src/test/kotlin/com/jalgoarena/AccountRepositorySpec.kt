package com.jalgoarena

import com.jalgoarena.data.UserDetailsRepository
import com.jalgoarena.domain.UserDetails
import com.winterbe.expekt.should
import jetbrains.exodus.entitystore.PersistentEntityStores
import org.junit.AfterClass
import org.junit.Test
import java.io.File

class AccountRepositorySpec {

    companion object {
        val dbName = "./UserDetailsStoreForTests"
        var repository: UserDetailsRepository

        init {
            val store = PersistentEntityStores.newInstance(dbName)
            store.close()
            repository = UserDetailsRepository(dbName)
        }

        @AfterClass
        @JvmStatic fun tearDown() {
            repository.destroy()
            File(dbName).deleteRecursively()
        }
    }

    @Test
    fun should_return_all_available_problems() {
        repository.addUser(sampleUser("Mikolaj", "mikolaj@mail.com"))
        repository.addUser(sampleUser("Julia", "julia@mail.com"))

        val users = repository.findAll()
        users.should.have.size.least(2)
    }

    @Test
    fun should_return_particular_problem() {
        repository.addUser(sampleUser("Madzia", "madzia@mail.com"))
        val user = repository.findByUsername("Madzia")!!
        user.email.should.equal("madzia@mail.com")
    }

    private val sampleUser =
            { username: String, email: String -> UserDetails(username, "blabla", email, "PL", "Team A") }
}
