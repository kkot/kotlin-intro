package a02_data_class

class Person(val name : String, val age : Int)

data class PersonDTO(val name : String, val age : Int)

fun main(args: Array<String>) {

    val personDTO1 = PersonDTO("Alex", 31)
    val personDTO2 = PersonDTO("Alex", 31)

    println("equal ${personDTO1 == personDTO2}, same ${personDTO1 === personDTO2}") // true, false : equals defined automatically, == calls equals

    val person1 = Person("Antonio", 31)
    val person2 = Person("Antonio", 31)

    println("equal ${person1 == person2}, same ${person1 === person2}") // false, false : equals not defined

    // copy
    val person1butYounger = personDTO1.copy(age = 21)

    val (name, age) = person1butYounger // destructuring declarations
    println("person1butYounger: name $name, age $age")

    // predefined, better user your own for more meaning
    val pair = Pair(person1, true)
    val triple = Triple(person1, false, "too short name")
}
