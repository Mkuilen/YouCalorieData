package com.ymddevelopment.yourcaloriedata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.ymddevelopment.yourcaloriedata.ui.theme.YourCalorieDataTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YourCalorieDataTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var selectedItem by remember { mutableStateOf(0) }
                    val navItems = listOf("Item1", "Item2", "Item3")
                    NavigationBar() {
                        navItems.forEachIndexed { index, navItem ->
                            NavigationBarItem(icon = {
                                Icon(
                                    Icons.Filled.Build,
                                    contentDescription = navItem
                                )
                            }, selected = selectedItem == index, onClick = { selectedItem = index })
                        }
                    }
                    Greeting(android.os.Build.MODEL, android.os.Build.MANUFACTURER)
                }
            }
        }
    }
}

@Composable
fun Greeting(model: String, manu: String) {
    Text(text = "Hello $model by $manu!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    YourCalorieDataTheme {
        Greeting(android.os.Build.MODEL, android.os.Build.MANUFACTURER)
    }
}