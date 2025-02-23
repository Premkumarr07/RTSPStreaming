package com.example.livestreaming.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Help & FAQ", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // App Instructions
            Text(
                text = "How to Use the App",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text("1. Open the app and navigate to the **Home Screen**.")
            Text("2. Tap **Watch Live Stream** to start streaming.")
            Text("3. Go to **Profile** to update your details.")
            Text("4. Check **Help & Instructions** for FAQs.")
            Text("5. Use the **Settings** to adjust preferences.")

            Spacer(modifier = Modifier.height(20.dp))

            // FAQ Section
            Text(
                text = "Frequently Asked Questions",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(10.dp))

            FAQItem(question = "What is RTSP?", answer = "RTSP (Real-Time Streaming Protocol) is a network protocol designed for controlling streaming media servers.")
            FAQItem(question = "How do I start a live stream?", answer = "Go to the Home Screen and click on 'Watch Live Stream' to join an active session.")
            FAQItem(question = "Can I record live streams?", answer = "Currently, recording is not supported, but future updates may include this feature.")
            FAQItem(question = "Why is my stream buffering?", answer = "Check your internet connection or try lowering the stream quality in settings.")
        }
    }
}

@Composable
fun FAQItem(question: String, answer: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD)), // Light blue background
        shape = RoundedCornerShape(12.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = question, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = answer, fontSize = 16.sp, color = Color.DarkGray)
        }
    }
}
