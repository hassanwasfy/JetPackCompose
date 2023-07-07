package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.screens.contacts.ContactsScreen
import com.example.jetpackcompose.screens.login.LoginScreen
import com.example.jetpackcompose.screens.profile.ProfileScreen
import com.example.jetpackcompose.screens.task.three.HomeScreen
import com.example.jetpackcompose.screens.task.two.BuyScreen
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme {
                //MyApp()
                //DetailsScreen()
                //BuyScreen()
                HomeScreen()
            }
        }
    }
}

@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login"){
        composable("login"){ LoginScreen(navController) }
        composable("sign"){ ProfileScreen(navController) }
        composable("contacts"){ ContactsScreen() }
    }
}
