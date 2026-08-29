package com.fizan.jarvis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JarvisApp()
        }
    }
}

@Composable
fun JarvisApp() {
    var url by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("SYSTEM READY • ONLINE") }
    var analyzing by remember { mutableStateOf(false) }

    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF05080D))
        ) {

            // हल्का JARVIS watermark
            Text(
                text = "JARVIS",
                color = Color(0x1428A9FF),
                fontSize = 90.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "◉",
                    color = Color(0xFF35B8FF),
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "JARVIS",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "FIZAN URL ANALYZER",
                    color = Color(0xFF35B8FF),
                    fontSize = 14.sp,
                    letterSpacing = 2.sp
                )

                Spacer(modifier = Modifier.height(35.dp))

                Text(
                    text = "ENTER URL FOR ANALYSIS",
                    color = Color.LightGray,
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = url,
                    onValueChange = { url = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            1.dp,
                            Color(0xFF1687C9),
                            RoundedCornerShape(14.dp)
                        ),
                    singleLine = true,
                    placeholder = {
                        Text(
                            "https://example.com",
                            color = Color.Gray
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Uri
                    )
                )

                Spacer(modifier = Modifier.height(18.dp))

                Button(
                    onClick = {
                        if (url.isBlank()) {
                            status = "⚠ ENTER A URL FIRST"
                        } else {
                            analyzing = true
                            status = "JARVIS SCANNING..."
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF087DB8)
                    )
                ) {
                    Text(
                        text = if (analyzing) "ANALYZING..." else "ANALYZE URL",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    text = status,
                    color = if (analyzing)
                        Color(0xFFFFC107)
                    else
                        Color(0xFF36D98A),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(35.dp))

                Text(
                    text = "FIZAN • JARVIS SECURITY ENGINE",
                    color = Color.DarkGray,
                    fontSize = 11.sp
                )
            }
        }
    }
}
