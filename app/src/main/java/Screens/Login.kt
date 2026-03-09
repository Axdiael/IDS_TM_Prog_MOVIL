package com.example.mainscreen.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mainscreen.R

@Composable
fun LoginScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val textFieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color(0xFF5C54B4),
        unfocusedBorderColor = Color(0xFFE0E0E0),
        focusedLabelColor = Color(0xFF5C54B4),
        cursorColor = Color(0xFF5C54B4)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4B44A6)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .background(Color.White, shape = RoundedCornerShape(32.dp))
                .padding(vertical = 48.dp, horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.top_image),
                contentDescription = "Login Illustration",
                modifier = Modifier
                    .size(180.dp)
                    .padding(bottom = 24.dp)
            )

            Text(
                text = "Login",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF2B2B2B),
                modifier = Modifier.padding(bottom = 32.dp)
            )

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = textFieldColors,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = textFieldColors,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                colors = textFieldColors,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Forgot password?",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botones cancelar y Aceptar
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // Cancelaregresa a welcome
                Button(
                    onClick = { navController.navigate("welcome") },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Cancelar")
                }

                // Aceptar
                Button(
                    onClick = {  },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF5C54B4),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Aceptar")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}