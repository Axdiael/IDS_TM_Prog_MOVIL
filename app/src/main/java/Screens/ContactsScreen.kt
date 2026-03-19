package com.example.mainscreen.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

// Clase de datos para un contacto
data class Contact(val name: String, val phone: String)

// Colores de fondo
val avatarColors = listOf(
    Color(0xFFD0E8FF),
    Color(0xFFD0F0E0),
    Color(0xFFFFE0D0)
)
val avatarIconColors = listOf(
    Color(0xFF2979FF),
    Color(0xFF2E7D32),
    Color(0xFFE64A19)
)

@Composable
fun ContactsScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var contacts by remember {
        mutableStateOf(
            listOf(
                Contact("Ana García", "+34 612 345 678"),
                Contact("Carlos Rodríguez", "+34 699 888 777"),
                Contact("Elena Martínez", "+34 655 443 322")
            )
        )
    }

    // Agrega contacto si ambos campos están llenos
    fun addContact() {
        if (name.isNotBlank() && phone.isNotBlank()) {
            contacts = contacts + Contact(name.trim(), phone.trim())
            name = ""
            phone = ""
        }
    }

    // Limpia ambos campos de texto
    fun clearFields() {
        name = ""
        phone = ""
    }

    Scaffold(
        containerColor = Color(0xFFF5F6FA)
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            // Campo de nombre
            ContactInputField(
                value = name,
                onValueChange = { name = it },
                label = "Nombre",
                placeholder = "Ej: Juan Pérez",
                icon = Icons.Default.Person,
                keyboardType = KeyboardType.Text
            )

            // Campo de teléfono
            ContactInputField(
                value = phone,
                onValueChange = { if (it.length <= 15) phone = it },
                label = "Teléfono",
                placeholder = "+34 600 000 000",
                icon = Icons.Default.Phone,
                keyboardType = KeyboardType.Phone
            )

            // Botón para agregar contacto
            Button(
                onClick = { addContact() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A56DB))
            ) {
                Icon(
                    Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text("Agregar Contacto", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }

            // Botón para limpiar los campos
            OutlinedButton(
                onClick = { clearFields() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF555E6C))
            ) {
                Text("Limpiar Campos", fontWeight = FontWeight.Medium, fontSize = 15.sp)
            }

            // Encabezado de la sección
            Text(
                text = "LISTA DE CONTACTOS",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF9AA3B0),
                letterSpacing = 1.5.sp,
                modifier = Modifier.padding(top = 4.dp)
            )

            // Lista de contactos
            LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                items(contacts) { contact ->
                    ContactListItem(contact = contact, index = contacts.indexOf(contact))
                }
            }
        }
    }
}

// Campo de texto reutilizable con ícono al inicio
@Composable
fun ContactInputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    keyboardType: KeyboardType
) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(label, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF2B2B2B))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(placeholder, color = Color(0xFFB0B8C4)) },
            leadingIcon = { Icon(icon, contentDescription = null, tint = Color(0xFFB0B8C4)) },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF1A56DB),
                unfocusedBorderColor = Color(0xFFE2E8F0),
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

// Fila individual para cada contacto en la lista
@Composable
fun ContactListItem(contact: Contact, index: Int) {
    val colorIndex = index % avatarColors.size
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(14.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Círculo de avatar con color
        Box(
            modifier = Modifier
                .size(44.dp)
                .background(avatarColors[colorIndex], CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Default.Person,
                contentDescription = null,
                tint = avatarIconColors[colorIndex],
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(Modifier.width(14.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(contact.name, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color(0xFF1A1A2E))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Phone, contentDescription = null, tint = Color(0xFF9AA3B0), modifier = Modifier.size(12.dp))
                Spacer(Modifier.width(4.dp))
                Text(contact.phone, fontSize = 13.sp, color = Color(0xFF9AA3B0))
            }
        }
        Text(">", fontSize = 18.sp, color = Color(0xFFCDD1D9))
    }
}

@Preview(showBackground = true)
@Composable
fun ContactsScreenPreview() {
    ContactsScreen(navController = rememberNavController())
}