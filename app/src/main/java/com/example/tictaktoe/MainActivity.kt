package com.example.tictaktoe

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictaktoe.ui.theme.TicTakToeTheme

var number = mutableStateOf("0")

var n = mutableStateListOf<String>("", "", "", "", "", "", "", "", "")

var winState = mutableStateOf("")
var j: Int = 0

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicTakToeTheme {
                Scaffold(topBar = {
                    CenterAlignedTopAppBar(
                        actions = {
                            Image(
                                painter = painterResource(R.drawable.restart),
                                contentDescription = null,
                                modifier = Modifier.clickable {
                                    Log.d("==-==", "onCreate: ")
                                    for (i in 0 until n.size) {
                                        n[i] = ""

                                    }

                                    winState.value = ""
                                }
                            )
                        },
                        title = {
                            Text(
                                text = "Tic Tak Toe",
                                color = Color(0xFFE46363),
                                fontFamily = FontFamily.Cursive,
                                fontSize = 40.sp,
                                textDecoration = TextDecoration.Underline
                            )
                        }

                    )
                }


                )
                { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues = innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues = innerPadding),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {


                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(1f)

                            ) {
                                B(scope = this, index = 0)
                                B(scope = this, index = 1)
                                B(scope = this, index = 2)
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(1f)

                            ) {
                                B(scope = this, index = 3)
                                B(scope = this, index = 4)
                                B(scope = this, index = 5)
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(1f)
                            ) {
                                B(scope = this, index = 6)
                                B(scope = this, index = 7)
                                B(scope = this, index = 8)
                            }




                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(1f)
                            ) {
                                C(scope = this)
                                C(scope = this)
                            }
                        }
                    }
                }
            }
        }
    }
    var i: Int = 0


    var num = true

    @Composable
    fun B(scope: RowScope, color: Color = Color.White, index: Int = 0) {

        scope.apply {

            Box(
                modifier = Modifier
                    .clickable {
                        try {

                            if (n[index].isEmpty() && winState.value.isEmpty()) {
                                if (num) {

                                    n[index] = "0"
                                    num = false
                                } else {
                                    n[index] = "x"

                                    num = true
                                }

                            }

                        } catch (e: IndexOutOfBoundsException) {
                            println(e.message)
                        }


                    }
                    .fillMaxSize()
                    .weight(1f)
                    .border(5.dp, Color.White),
                contentAlignment = Alignment.Center,


                ) {

                Text(text = n[index], fontSize = 100.sp, color = Color.Yellow)
            }
        }
    }
}

@Composable
fun C(scope: RowScope, a: Int = 0) {
    scope.apply {
        if (n[0] == n[1] && n[0] == n[2]) {
            if (n[0] == "0") {
                winState.value = "0 is win"
            } else if (n[0] == "x") {
                winState.value = "x is win"
            }
        }
        if (n[0] == n[3] && n[0] == n[6]) {
            if (n[0] == "0") {
                winState.value = "0 is win"
            } else if (n[0] == "x") {
                winState.value = "x is win"
            }
        }
        if (n[0] == n[4] && n[0] == n[8]) {
            if (n[0] == "0") {
                winState.value = "0 is win"
            } else if (n[0] == "x") {
                winState.value = "x is win"
            }
        }
        if (n[2] == n[5] && n[2] == n[8]) {
            if (n[2] == "0") {
                winState.value = "0 is win"
            } else if (n[2] == "x") {
                winState.value = "x is win"
            }
        }
        if (n[6] == n[7] && n[6] == n[8]) {
            if (n[6] == "0") {
                winState.value = "0 is win"
            } else if (n[6] == "x") {
                winState.value = "x is win"
            }
        }
        if (n[1] == n[4] && n[1] == n[7]) {
            if (n[1] == "0") {
                winState.value = "0 is win"
            } else if (n[1] == "x") {
                winState.value = "x is win"
            }
        }

        if (n[4] == n[5] && n[4] == n[3]) {
            if (n[4] == "0") {
                winState.value = "0 is win"
            } else if (n[4] == "x") {
                winState.value = "x is win"
            }
        }
        if (n[2] == n[4] && n[2] == n[6]) {
            if (n[2] == "0") {

                winState.value = "0 is win"
            } else if (n[2] == "x") {
                winState.value = "x is win"
            }
        }


        if (winState.value.isEmpty()) {
            for (i in 0 until n.size)
                if (n[i].isEmpty()) {
                    return
                }
            winState.value = "Game Tie!"
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(), contentAlignment = Alignment.Center

    ) {
        Text(
            text = winState.value, fontSize = 50.sp,
            fontFamily = FontFamily.Monospace, color = Color.Cyan
        )
    }
}
