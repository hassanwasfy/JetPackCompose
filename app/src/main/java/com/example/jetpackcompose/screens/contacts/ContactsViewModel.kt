package com.example.jetpackcompose.screens.contacts

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor() : ViewModel() {
    val contactsList = listOf(
        ContactsUiState(
            alphabet = "A", names = listOf("Alice", "Andrew", "Amelia", "Alice", "Andrew", "Amelia")
        ),
        ContactsUiState(
            alphabet = "B", names = listOf(
                "Benjamin",
                "Bella",
                "Brandon",
                "Brooklyn",
                "Benjamin",
                "Bella",
                "Brandon",
                "Brooklyn"
            )
        ),
        ContactsUiState(
            alphabet = "C",
            names = listOf("Caleb", "Charlotte", "Christopher", "Caleb", "Charlotte", "Christopher")
        ),
        ContactsUiState(alphabet = "D", names = listOf("Daniel", "David", "Daniel", "David")),
        ContactsUiState(
            alphabet = "E", names = listOf("Emma", "Ethan", "Elijah", "Emma", "Ethan", "Elijah")
        ),
        ContactsUiState(
            alphabet = "F", names = listOf("Faith", "Finn", "Frank", "Faith", "Finn", "Frank")
        ),
        ContactsUiState(
            alphabet = "G",
            names = listOf("Grace", "Gabriel", "George", "Grace", "Gabriel", "George")
        ),
        ContactsUiState(alphabet = "H", names = listOf("Hannah", "Henry", "Hannah", "Henry")),
        ContactsUiState(
            alphabet = "I", names = listOf("Isabella", "Isaac", "Ian", "Isabella", "Isaac", "Ian")
        ),
        ContactsUiState(
            alphabet = "J",
            names = listOf("Jacob", "James", "John", "Julia", "Jacob", "James", "John", "Julia")
        ),
        ContactsUiState(alphabet = "K", names = listOf("Katherine", "Kevin", "Katherine", "Kevin")),
        ContactsUiState(alphabet = "L", names = listOf("Liam", "Lucy", "Liam", "Lucy")),
        ContactsUiState(
            alphabet = "M", names = listOf("Mia", "Matthew", "Michael", "Mia", "Matthew", "Michael")
        ),
        ContactsUiState(alphabet = "N", names = listOf("Noah", "Natalie", "Noah", "Natalie")),
        ContactsUiState(alphabet = "O", names = listOf("Oliver", "Olivia", "Oliver", "Olivia")),
        ContactsUiState(
            alphabet = "P", names = listOf("Penelope", "Patrick", "Penelope", "Patrick")
        ),
        ContactsUiState(alphabet = "Q", names = listOf("Quinn", "Quinn")),
        ContactsUiState(alphabet = "R", names = listOf("Ryan", "Ruby", "Ryan", "Ruby")),
        ContactsUiState(alphabet = "S", names = listOf("Sophia", "Samuel", "Sophia", "Samuel")),
        ContactsUiState(alphabet = "T", names = listOf("Thomas", "Taylor", "Thomas", "Taylor")),
        ContactsUiState(alphabet = "U", names = listOf("Uma", "Uma")),
        ContactsUiState(
            alphabet = "V", names = listOf("Victoria", "Vincent", "Victoria", "Vincent")
        ),
        ContactsUiState(alphabet = "W", names = listOf("William", "Wendy", "William", "Wendy")),
        ContactsUiState(alphabet = "X", names = listOf("Xavier", "Xavier")),
        ContactsUiState(
            alphabet = "Y", names = listOf("Yasmine", "Yara", "Yvonne", "Yasmine", "Yara", "Yvonne")
        ),
        ContactsUiState(alphabet = "Z", names = listOf("Zachary", "Zoe", "Zachary", "Zoe"))
    )

    val namesList = listOf(
        "Alice",
        "Andrew",
        "Amelia",
        "Alice",
        "Andrew",
        "Amelia",
        "Benjamin",
        "Bella",
        "Brandon",
        "Brooklyn",
        "Benjamin",
        "Bella",
        "Brandon",
        "Brooklyn",
        "Caleb",
        "Charlotte",
        "Christopher",
        "Caleb",
        "Charlotte",
        "Christopher",
        "Daniel",
        "David",
        "Daniel",
        "David",
        "Emma",
        "Ethan",
        "Elijah",
        "Emma",
        "Ethan",
        "Elijah",
        "Faith",
        "Finn",
        "Frank",
        "Faith",
        "Finn",
        "Frank",
        "Grace",
        "Gabriel",
        "George",
        "Grace",
        "Gabriel",
        "George",
        "Hannah",
        "Henry",
        "Hannah",
        "Henry",
        "Isabella",
        "Isaac",
        "Ian",
        "Isabella",
        "Isaac",
        "Ian",
        "Jacob",
        "James",
        "John",
        "Julia",
        "Jacob",
        "James",
        "John",
        "Julia",
        "Katherine",
        "Kevin",
        "Katherine",
        "Kevin",
        "Liam",
        "Lucy",
        "Liam",
        "Lucy",
        "Mia",
        "Matthew",
        "Michael",
        "Mia",
        "Matthew",
        "Michael",
        "Noah",
        "Natalie",
        "Noah",
        "Natalie",
        "Oliver",
        "Olivia",
        "Oliver",
        "Olivia",
        "Penelope",
        "Patrick",
        "Penelope",
        "Patrick",
        "Quinn",
        "Quinn",
        "Ryan",
        "Ruby",
        "Ryan",
        "Ruby",
        "Sophia",
        "Samuel",
        "Sophia",
        "Samuel",
        "Thomas",
        "Taylor",
        "Thomas",
        "Taylor",
        "Uma",
        "Uma",
        "Victoria",
        "Vincent",
        "Victoria",
        "Vincent",
        "William",
        "Wendy",
        "William",
        "Wendy",
        "Xavier",
        "Xavier",
        "Yasmine",
        "Yara",
        "Yvonne",
        "Yasmine",
        "Yara",
        "Yvonne",
        "Zachary",
        "Zoe",
        "Zachary",
        "Zoe"
    )
}