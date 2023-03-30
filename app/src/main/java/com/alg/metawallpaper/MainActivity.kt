package com.alg.metawallpaper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alg.metawallpaper.ui.theme.MetaWallpaperTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MetaWallpaperTheme {
                Content()
            }
        }
    }
}

@Composable
fun Content() {
    WelcomePage()
//    LoginPage()
//    HomePage()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MetaWallpaperTheme {
        Content()
    }
}