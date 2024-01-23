package com.example.textracerapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.textracerapp.data.BottomNavigationItem
import com.example.textracerapp.data.loginClient
import com.example.textracerapp.ui.theme.TextracerAppTheme
import androidx.navigation.compose.rememberNavController
import com.example.textracerapp.Screens.LoginPage
import com.example.textracerapp.navigation.Screens
import com.example.textracerapp.R
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import com.example.textracerapp.Screens.GalleryPage
import com.example.textracerapp.Screens.OrderEvidencePage
import com.example.textracerapp.Screens.TasksPage
import com.example.textracerapp.Screens.UploadEvidencePage

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            TextracerAppTheme {

                val navController = rememberNavController()
                var selectedItemIndex by remember { mutableStateOf(0) }

                val items = listOf(
                    BottomNavigationItem(
                        title = stringResource(id = R.string.task),
                        selectedIcon = Icons.Filled.Home,
                        unselectedIcon = Icons.Outlined.Home
                    ),
                    BottomNavigationItem(
                        title = stringResource(id = R.string.account),
                        selectedIcon = Icons.Filled.AccountCircle,
                        unselectedIcon = Icons.Outlined.AccountCircle
                    )
                )

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            NavigationBar(
                                containerColor = MaterialTheme.colorScheme.background
                            ) {
                                items.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = selectedItemIndex == index || (selectedItemIndex == 2 && (index == 3 || index == 4)),
                                        onClick = {
                                            selectedItemIndex = index
                                            when (index) {
                                                0 -> navController.navigate(Screens.Task.route)
                                                1 -> navController.navigate(Screens.Login.route)
                                            }
                                        },
                                        label = {
                                            Text(text = item.title)
                                        },
                                        alwaysShowLabel = true,

                                        icon = {
                                            Icon(
                                                imageVector = if (index == selectedItemIndex) {
                                                    item.selectedIcon
                                                } else item.unselectedIcon,
                                                contentDescription = item.title,
                                                tint = if (index == selectedItemIndex) {
                                                    MaterialTheme.colorScheme.onSurfaceVariant
                                                } else {
                                                    MaterialTheme.colorScheme.onSurfaceVariant
                                                }
                                            )
                                        }
                                    )
                                }
                            }
                        }
                    ) {
                        // Content of your screen goes here
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

//                            // Declare variables to hold email and password values
//                            var email by remember { mutableStateOf("") }
//                            var password by remember { mutableStateOf("") }
//
//                            StyledEmailField(email) { updatedEmail ->
//                                email = updatedEmail
//                            }
//
//                            // StyledPasswordField with password value
//                            StyledPasswordField(password) { updatedPassword ->
//                                password = updatedPassword
//                            }
//
//                            LoginButton {
//                                // Pass email and password to the login function
//                                LoginBtnClicked(email, password)
//                            }

                            NavHost(
                                navController = navController,
                                startDestination = Screens.Task.route,
                            ) {
//                                composable(Screens.Home.route) {
//                                    selectedItemIndex = 0
//                                }

                                composable(Screens.Task.route) {
                                    TasksPage(navController, applicationContext)
                                    selectedItemIndex = 0
                                }


                                composable(Screens.Login.route) {
                                    LoginPage(navController, applicationContext)
                                    selectedItemIndex = 1
                                }


                                composable(Screens.OrderEvidence.route) {
                                    OrderEvidencePage(navController, applicationContext)
                                    selectedItemIndex = 0
                                }

                                composable(Screens.UploadEvidence.route) {
                                    UploadEvidencePage(navController, applicationContext)
                                    selectedItemIndex = 0
                                }

                                composable(Screens.Gallery.route) {
                                    GalleryPage(navController, applicationContext)
                                    selectedItemIndex = 0
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextracerAppTheme {
        Greeting("Android")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StyledEmailField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text("email")},
        maxLines = 1,
        textStyle = TextStyle(color = Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StyledPasswordField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = {Text("Password")},
        maxLines = 1,
        textStyle = TextStyle(color = Color.Black),
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}
fun LoginBtnClicked(email: String, password: String) {
    // Use email and password for login logic
    val tmp_InnoholandAPI = loginClient()
    tmp_InnoholandAPI.LoginWith(email, password)
}


@Composable
fun LoginButton(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text("login")
    }
}
