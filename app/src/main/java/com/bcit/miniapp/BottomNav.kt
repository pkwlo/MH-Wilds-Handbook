package com.bcit.miniapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

data class NavItem(
    val imageVector: ImageVector? = null,
    val painter: Painter? = null,
    val navRoute: String,
    val label: String
)

@Composable
fun BottomNav(navController: NavController){
    val navItems = listOf(
        NavItem(imageVector = Icons.Filled.Home, navRoute = "home", label = "Home"),
        NavItem(painter = painterResource(R.drawable.large_mon_icon), navRoute = "largeMonster", label = "Large Monster"),
        NavItem(painter = painterResource(R.drawable.small_mon_icon), navRoute = "smallMonster", label = "Small Monster"),
        NavItem(imageVector = Icons.Outlined.AddCircle, navRoute = "logCrown", label = "Log Crown")
    )

    NavigationBar(containerColor = Color(0xFFFFFFFF)) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach { navItem ->
            NavigationBarItem(
//                selected = currentRoute == navItem.navRoute,
                selected = false,
                onClick = { navController.navigate(navItem.navRoute) },
                icon = {
                    when {
                        navItem.imageVector != null -> Icon(
                            imageVector = navItem.imageVector,
                            contentDescription = navItem.label,
                            modifier = Modifier.size(30.dp)
                        )
                        navItem.painter != null -> Icon(
                            painter = navItem.painter,
                            contentDescription = navItem.label,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                },
                label = { Text(navItem.label) }
            )
        }
    }
}
