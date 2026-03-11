package com.example.mainscreen.Screens

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
fun SignUpScreen(navController: NavController) {

    // Estados de los campos
    var nombre by remember { mutableStateOf("") }
    var mail by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var confirmPass by remember { mutableStateOf("") }

    // Estados de error por campo
    var nombreError by remember { mutableStateOf(false) }
    var mailError by remember { mutableStateOf(false) }
    var telefonoError by remember { mutableStateOf(false) }
    var passError by remember { mutableStateOf(false) }
    var confirmPassError by remember { mutableStateOf(false) }

    // Valida el formato del correo
    fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Valida todos los campos y activa errores si algo falla
    fun validarFormulario() {
        nombreError = nombre.isBlank() || !nombre.all { it.isLetter() || it.isWhitespace() }
        mailError = !isValidEmail(mail)
        telefonoError = telefono.isBlank() || !telefono.all { it.isDigit() } || telefono.length != 10
        passError = pass.length < 6
        confirmPassError = confirmPass != pass
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4B44A6)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .verticalScroll(rememberScrollState())
                .background(Color.White, shape = RoundedCornerShape(32.dp))
                .padding(vertical = 48.dp, horizontal = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.top_image),
                contentDescription = "Illustration",
                modifier = Modifier
                    .size(150.dp)
                    .padding(bottom = 8.dp)
            )

            Text(
                text = "Crear Cuenta",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2B2B2B)
            )

            // Campo nombre
            TextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                isError = nombreError,
                supportingText = { if (nombreError) Text("Campo requerido", color = Color.Red) },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            // Campo correo
            TextField(
                value = mail,
                onValueChange = { mail = it },
                label = { Text("Correo") },
                isError = mailError,
                supportingText = { if (mailError) Text("Correo no válido", color = Color.Red) },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            // Campo teléfono
            TextField(
                value = telefono,
                onValueChange = { if (it.all { c -> c.isDigit() } && it.length <= 10) telefono = it },
                label = { Text("Teléfono") },
                isError = telefonoError,
                supportingText = { if (telefonoError) Text("Solo 10 dígitos numéricos", color = Color.Red) },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            // Campo contraseña
            TextField(
                value = pass,
                onValueChange = { pass = it },
                label = { Text("Contraseña") },
                isError = passError,
                supportingText = { if (passError) Text("Mínimo 6 caracteres", color = Color.Red) },
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            // Campo confirmar contraseña
            TextField(
                value = confirmPass,
                onValueChange = { confirmPass = it },
                label = { Text("Confirmar contraseña") },
                isError = confirmPassError,
                supportingText = { if (confirmPassError) Text("Las contraseñas no coinciden", color = Color.Red) },
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // Cancelar → regresa a login
                Button(
                    onClick = { navController.navigate("login") },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Cancelar")
                }

                // Aceptar valida el formulario al presionar
                Button(
                    onClick = { validarFormulario() },
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
fun SignUpScreenPreview() {
    SignUpScreen(navController = rememberNavController())
}