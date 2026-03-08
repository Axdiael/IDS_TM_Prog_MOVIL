package com.example.mainscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WelcomeScreen()
        }
    }

    @Composable
    fun WelcomeScreen() {
        // Fondo morado
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF4B44A6)),
            contentAlignment = Alignment.Center
        ) {
            // Tarjeta blanca principal
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .background(Color.White, shape = RoundedCornerShape(32.dp))
                    .padding(vertical = 120.dp, horizontal = 48.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Imagen superior
                Image(
                    painter = painterResource(id = R.drawable.top_image),
                    contentDescription = "Illustration Placeholder",
                    modifier = Modifier
                        .size(180.dp)
                        .padding(bottom = 24.dp)
                )

                // Texto del titulo
                Text(
                    text = "Hello",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF2B2B2B),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Texto del subtitulo
                Text(
                    text = "Welcome To Little Drop, where\nyou manage your daily tasks",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 40.dp)
                )

                // botón login
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF5C54B4), shape = RoundedCornerShape(50))
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Login",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }

                // Botón de Sign Up
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .border(1.dp, Color(0xFF5C54B4), shape = RoundedCornerShape(50))
                        .background(Color.White, shape = RoundedCornerShape(50))
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Sign Up",
                        color = Color(0xFF5C54B4),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }

                // texto de Sing up
                Text(
                    text = "Sign up using",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
                )

                // Registro de redes sociales
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Facebook
                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "Facebook",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(50))
                    )

                    // Google+
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .size(40.dp)
                            .background(Color(0xFFdb3236), shape = RoundedCornerShape(50)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("G+", color = Color.White, fontWeight = FontWeight.Bold)
                    }

                    // LinkedIn
                    Image(
                        painter = painterResource(id = R.drawable.linkedin),
                        contentDescription = "LinkedIn",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(50))
                    )
                }
            }
        }
    }

    // Ver android studio sin ejecutar app
    @Preview(showBackground = true)
    @Composable
    fun WelcomeScreenPreview() {
        WelcomeScreen()
    }
}
    // Login
    @Composable
    fun LoginScreen() {
        // Fondo morado
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF4B44A6)),
            contentAlignment = Alignment.Center
        ) {
            // Tarjeta blanca principal
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .background(Color.White, shape = RoundedCornerShape(32.dp))
                    .padding(vertical = 48.dp, horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Imagen superior
                Image(
                    painter = painterResource(id = R.drawable.top_image),
                    contentDescription = "Login Illustration",
                    modifier = Modifier
                        .size(180.dp)
                        .padding(bottom = 24.dp)
                )

                // Texto del titulo
                Text(
                    text = "Login",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF2B2B2B),
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                //label del name
                Text(
                    text = "Name",
                    fontSize = 14.sp,
                    color = Color(0xFF2B2B2B),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                // Campo Name
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color(0xFFE0E0E0), shape = RoundedCornerShape(12.dp))
                        .background(Color.White, shape = RoundedCornerShape(12.dp))
                        .padding(vertical = 16.dp, horizontal = 16.dp)
                ) {
                    Text(text = "", color = Color.Gray, fontSize = 14.sp)
                }

                // Label Email
                Text(
                    text = "Email",
                    fontSize = 14.sp,
                    color = Color(0xFF2B2B2B),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 8.dp)
                )

                // Cmpo Email
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color(0xFFE0E0E0), shape = RoundedCornerShape(12.dp))
                        .background(Color.White, shape = RoundedCornerShape(12.dp))
                        .padding(vertical = 16.dp, horizontal = 16.dp)
                ) {
                    Text(text = "", color = Color.Gray, fontSize = 14.sp)
                }

                // Labl Password
                Text(
                    text = "Password",
                    fontSize = 14.sp,
                    color = Color(0xFF2B2B2B),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 8.dp)
                )

                // Campo Password
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color(0xFFE0E0E0), shape = RoundedCornerShape(12.dp))
                        .background(Color.White, shape = RoundedCornerShape(12.dp))
                        .padding(vertical = 16.dp, horizontal = 16.dp)
                ) {
                    Text(text = "", color = Color.Gray, fontSize = 14.sp)
                }

                // Texto Forgot password
                Text(
                    text = "Forgot password?",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 24.dp),
                    textAlign = TextAlign.Start
                )

                // Botón Sign Up
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.55f)
                        .background(Color(0xFF5C54B4), shape = RoundedCornerShape(50))
                        .padding(vertical = 16.dp)
                        .align(Alignment.End),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Sign Up",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }

    // Preview de Login Screen
    @Preview(showBackground = true)
    @Composable
    fun LoginScreenPreview() {
        LoginScreen()
    }
