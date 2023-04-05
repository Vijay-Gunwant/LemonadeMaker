package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Lemonade()
                }
            }
        }
    }
}

@Composable
fun Lemonade() {
    var number by remember {
        mutableStateOf(1)
    }
    val str:String = when(number){
        1-> stringResource(id = R.string.tree)
        2-> stringResource(id = R.string.lemon)
        3-> stringResource(id = R.string.drink)
        4-> stringResource(id = R.string.empty)
        else -> stringResource(id = R.string.error)
    }
    val img:Painter = when(number){
        1-> painterResource(id = R.drawable.lemon_tree)
        2-> painterResource(id = R.drawable.lemon_squeeze)
        3-> painterResource(id = R.drawable.lemon_drink)
        4-> painterResource(id = R.drawable.lemon_restart)
        else -> painterResource(id = R.drawable.lemon_tree)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = str,
            modifier = Modifier.padding(10.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.W500
            )
        Image(
            painter = img,
            contentDescription = "Grow the lemon",
            Modifier
                .border(2.dp, Color.Cyan)
                .clickable {
                    if(number == 4){
                        number = 1
                    }
                    else{
                        number += 1
                    }
                }
        )
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        Lemonade()
    }
}