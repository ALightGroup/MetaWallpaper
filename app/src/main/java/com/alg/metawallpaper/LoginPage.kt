package com.alg.metawallpaper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alg.metawallpaper.ui.theme.*


@Preview(showBackground = true)
@Composable
fun TopText() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        var keywordPre = "By Clicking below you agree to our".split(" ")
        var keywordPost = "and consent".split(" ")
        for (word in keywordPre) {
            Text(
                text = word,
                style = body2,
                color = gray,
            )
        }
        Text(
            text = "Terms of Use",
            style = body2,
            color = gray,
            textDecoration = TextDecoration.Underline
        )
        for (word in keywordPost) {
            Text(
                text = word,
                style = body2,
                color = gray,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomText() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = " to Our ",
            style = body2,
            color = gray
        )
        Text(
            text = "Privacy Policy.",
            style = body2,
            color = gray,
            textDecoration = TextDecoration.Underline
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HintWithUnderline() {
    Column(
        modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 16.dp)
    ) {
        TopText()
        BottomText()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun LoginInputBox() {
    Column {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(small),
            placeholder = {
                Text(
                    text = "Email address",
                    style = body1,
                    color = gray
                )
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(small),
            placeholder = {
                Text(
                    text = "Password(8+ Characters)",
                    style = body1,
                    color = gray
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginTitle() {
    Text(
        text = "Log in with email",
        modifier = Modifier
            .fillMaxWidth()
            .paddingFromBaseline(top = 184.dp, bottom = 16.dp),
        style = h1,
        color = gray,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun LoginButton() {
    Button(
        onClick = { },
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .clip(medium),
        colors = ButtonDefaults.buttonColors(containerColor = pink900)
    ) {
        Text(
            text = "Log in",
            style = button,
            color = white
        )
    }
}

@Composable
fun LoginPage() {
    Column(
        Modifier
            .fillMaxSize()
            .background(white)
            .padding(horizontal = 16.dp)
    ) {
        LoginTitle()
        LoginInputBox()
        HintWithUnderline()
        LoginButton()
    }
}

@Composable
@Preview
fun LoginPageLightPreview() {
    LoginPage()
}
