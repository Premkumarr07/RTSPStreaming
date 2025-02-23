package com.example.livestreaming.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.livestreaming.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // User Profile Info
            ProfileInfoSection()

            Spacer(modifier = Modifier.height(20.dp))

            // Settings Options
            SettingsOption(icon = Icons.Default.Edit, title = "Edit Profile") { /* Navigate to Edit Profile */ }
            SettingsOption(icon = Icons.Default.Notifications, title = "Notifications") { /* Toggle Notifications */ }
            SettingsOption(icon = Icons.Default.LightMode, title = "Theme Mode") { /* Toggle Theme (Dark/Light Mode) */ }  // ✅ Fixed: Using LightMode icon
            SettingsOption(icon = Icons.Default.Lock, title = "Privacy & Security") { /* Privacy Settings */ }
            SettingsOption(icon = Icons.AutoMirrored.Filled.ExitToApp, title = "Logout", isDanger = true) { /* Logout Action */ }
        }
    }
}

@Composable
fun ProfileInfoSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Profile Picture
        Image(
            painter = painterResource(id = R.drawable.profile_pic), // Ensure this image is in res/drawable
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // User Name & Email
        Text("Prem Kumar", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text("premkumar@example.com", fontSize = 16.sp, color = Color.Gray)
    }
}

@Composable
fun SettingsOption(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, isDanger: Boolean = false, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp, horizontal = 16.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(if (isDanger) Color(0xFFFFE0E0) else Color(0xFFEFEFEF))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = title, tint = if (isDanger) Color.Red else Color.Black, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Text(title, fontSize = 18.sp, fontWeight = FontWeight.Medium, color = if (isDanger) Color.Red else Color.Black)
    }
}
