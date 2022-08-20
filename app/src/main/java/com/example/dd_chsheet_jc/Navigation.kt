package com.example.dd_chsheet_jc

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.launch
import java.util.jar.Attributes

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
//        composable(
//            route = Screen.SplashScreen.route + "/{name}",
//            arguments = listOf(
//                navArgument("name") {
//                    type = NavType.StringType
//                    defaultValue = "Aryan"
//                    nullable = true
//                }
//            )
//        ) { entry ->
//            SplashScreen(name = entry.arguments?.getString("name"))
//        }
    }
}


//include 100% progress bar
//include image
//include text
@Composable
fun SplashScreen(navController: NavController) {
}

//include login button
//include signup button
//include forget password
//include about button
//include app version
//include design
@Composable
fun MainScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    var textFieldStateUsername by remember {
        mutableStateOf("")
    }

    var textFieldStatePassword by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }


    val scope = rememberCoroutineScope()

    //create top bar - nav drawer - snack bar
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = { }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            TextField(
                value = textFieldStateUsername,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = {
                    Text("Enter Username")
                },
                onValueChange = {
                    textFieldStateUsername = it
                },
                singleLine = true,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
            )

            TextField(
                value = textFieldStatePassword,
                onValueChange = { textFieldStatePassword = it },
                label = { Text("Enter Password") },
                singleLine = true,
                maxLines = 1,
                placeholder = { Text("Password") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    // Please provide localized description for accessibility services
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, description)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        "Data: $textFieldStateUsername\n$textFieldStatePassword"
                    )
                }

            }) {
                Text(text = "Sign In")
            }
            Button(onClick = {
                //click
                navController.navigate(Screen.RegisterScreen.route)
            }) {
                Text(text = "Sign Up")
            }
            Button(onClick = {
                //click

            }) {
                Text(text = "Forget Password")
            }
        }
    }
}


//include background image
//include back button on top left
//include page title(font-size-color-style)
//include 4 text fields
//include register button
@Composable
fun RegisterScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    var textFieldStateFullName by remember {
        mutableStateOf("")
    }
    var textFieldStateUsername by remember {
        mutableStateOf("")
    }

    var textFieldStatePassword by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    var textFieldStateEmail by remember {
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()

    //create top bar - nav drawer - snack bar
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = { }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {

            TextField(
                value = textFieldStateFullName,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = {
                    Text("Enter Full Name")
                },
                onValueChange = {
                    textFieldStateFullName = it
                },
                singleLine = true,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
            )
            TextField(
                value = textFieldStateUsername,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = {
                    Text("Enter Username")
                },
                onValueChange = {
                    textFieldStateUsername = it
                },
                singleLine = true,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
            )

            TextField(
                value = textFieldStatePassword,
                onValueChange = { textFieldStatePassword = it },
                label = { Text("Enter Password") },
                singleLine = true,
                maxLines = 1,
                placeholder = { Text("Password") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    // Please provide localized description for accessibility services
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, description)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
            )

            TextField(
                value = textFieldStateEmail,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = {
                    Text("Enter Email")
                },
                onValueChange = {
                    textFieldStateEmail = it
                },
                singleLine = true,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        "Data: " +
                                "$textFieldStateFullName\n$textFieldStateUsername\n" +
                                "$textFieldStatePassword\n$textFieldStateEmail"
                    )
                }

            }) {
                Text(text = "Check Data")
            }
        }
    }
}

//text field for email
//button for sending password
@Composable
fun ResetPasswordScreen(navController: NavController) {
}
