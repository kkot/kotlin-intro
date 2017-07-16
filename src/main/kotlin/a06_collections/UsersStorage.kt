package a06_collections

import User
import SuperUser
import java.util.*

class UsersStorage {
    private val _users : MutableList<User> = ArrayList()

    // toList() does defensive copy because cast is still possible
    // even without cast underlying collection can change
    val users : List<User> get() = _users.toList()

    fun addUser(user : User) {
        _users.add(user)
    }

    fun addUsers(users : List<User>) {
        _users.addAll(users)
    }

    fun printUsers() {
        for (user in this.users) {
            println(user)
        }
        println("-")
    }
}

val usersStorage = UsersStorage()

private fun mutateTest() {
    usersStorage.addUser(User())
    usersStorage.addUser(User())

    usersStorage.printUsers()

    val readOnlyView = usersStorage.users
    val mutableView = usersStorage.users as MutableList
    mutableView.add(User())
    //readOnlyView.add(User()) // will not compile because List has no add method

    usersStorage.printUsers()

}

private fun covariantTest() {
    val superUsers : List<SuperUser> = listOf(SuperUser(), SuperUser())
    usersStorage.addUsers(superUsers) // we can use List<SuperUser> where List<User> is expected, in Java it would not compile
}

fun main(args: Array<String>) {
    mutateTest()
    covariantTest()

    // map
    val readWriteMap = hashMapOf("foo" to 1, "bar" to 2) // map syntax
}


