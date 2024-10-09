package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(1) }


    val (imageResource, textResource) = when (currentStep) {
        1 -> Pair(R.drawable.lemon_tree, R.string.lemon_select)
        2 -> Pair(R.drawable.lemon_squeeze, R.string.lemon_squeeze)
        3 -> Pair(R.drawable.lemon_drink, R.string.lemon_drink)
        4 -> Pair(R.drawable.lemon_restart, R.string.lemon_empty_glass)
        else -> Pair(R.drawable.lemon_tree, R.string.lemon_select)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            Text(
                text = stringResource(textResource),
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(16.dp))


            Image(
                painter = painterResource(id = imageResource),
                contentDescription = stringResource(textResource),
                modifier = Modifier
                    .size(150.dp)
                    .border(
                        width = 2.dp,
                        color = Color(105, 205, 216),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .clickable {
                        currentStep = when (currentStep) {
                            1 -> 2
                            2 -> 3
                            3 -> 4
                            4 -> 1
                            else -> 1
                        }
                    }
                    .padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}
