package com.example.jetpackcompose.screens.task.one

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DetailsScreenViewModel @Inject constructor() : ViewModel() {
    val movie = Movie(
        "Fantastic Beasts: The\n" +
                "Secrets of Dumbledore",
        listOf("Fantasy","Adventure"),
        "\"https://images.ctfassets.net/usf1vwtuqyxm/77BW3OW4tz6AGODWQLjWev/f7a462471c8c2895854a0f57d5d5a906/fb3-posters-niffler.jpg?w=914&q=70&fm=jpg",
        "2h 23m",
        "Albus Dumbledore and Gellert Grindelwald briefly meet in a Muggle teashop where they acknowledge their mutual feelings. Grindelwald vows to destroy the Muggle world\""
        ,listOf(
            "data:image/jpeg;base64,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",
            "data:image/jpeg;base64,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",
            "data:image/jpeg;base64,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",
            "data:image/jpeg;base64,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",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_2cJ5NozjweFXsLM6wGsoKu5wldCfIn_C-tK4n-kY9eB4WzGzRZX-5qO3&s=10",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSQiEcELIcrwee7rtJHAF7OsC5IsOP2DsrpiO2GhRLlabiblEhUmCXeZBSd&s=10",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbKmbK8dfEAvZ-f1g-Ex0sAhW5IX6XwPg060CiZDcjg1-WJAODJpKyi6IX&s=10",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSe8EFVajZV5X6KJ_Ork4DxBuYPD_UW_oZE_olO1pndIuw2zgfH6ARlzljm&s=10",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1YJg18Qeazq4Gq6zr1GHda0H9Sx360qB3yrgqADTa5FiX9Ak0cjBEkTQC&s=10",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3uwajrqHQdP0dRjrSlm69qV7OgXOEdS2hla0_6KNi&s=10",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvRvKwVUr-BZ2HVQcc0WbYl5VZgBGspo0DXvfOJC2bRxuI92FQ1q7fmO4f&s=10",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTT9SRj6fd-3NdIyPbgyT63Tdm469D-AnIQ6QiolwSsGvN16c5fc6kpRIxU&s=10",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9DvPvi61CjiMRraxX95-svnM1ktM3llbEVi4pj7aPUWSNTxqQoX1ly-Xx&s=10",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQpTJF9uDYuXrSykvnx_UrXJ8GebPLKnhZmpa_LBkZD-1mcDpZ7ZzKYxN0&s=10"
        )
    )
}