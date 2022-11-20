package com.example.composeanimationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeanimationapp.animation.*
import com.example.composeanimationapp.ui.theme.DroidTheme
import com.example.mycomposeapplication.R

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DroidTheme {
                Surface(
                    // on below line we are specifying modifier and color for our app
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text(text = stringResource(id = R.string.title_activity_compose_animation)) },
                                elevation = 8.dp
                            )
                        },
                        floatingActionButton = {
                            ExplodingFabButton()
                        },
                        floatingActionButtonPosition = FabPosition.End,
                        content = {
                            LazyColumn {
                                item {
                                    Spacer(modifier = Modifier.height(20.dp))

                                    HeadingText(text = "animateContentSize()")
                                    AnimateContentSize()

                                    HeadingText(text = "AnimatedVisibility()")
                                    AnimatedVisibilty()
                                    AnimatedBottomNavigation()

                                    HeadingText(text = "animate()")
                                    ColorAnimation()
                                    ScaleAndColorAnimation()
                                    Spacer(modifier = Modifier.height(20.dp))
                                    GenderSelectAnimation()

                                    HeadingText(text = "animatedFloat")
                                    HeartBeatDemo()
                                    Spacer(modifier = Modifier.height(40.dp))
                                    MovingSquare()
                                    Spacer(modifier = Modifier.height(100.dp))

                                    HeadingText(text = "Transitions")
                                    RayWenderlichFavButton()
                                    FlipView(flipDurationMs = 1000,
                                        front = {
                                            Image(
                                                painter = painterResource(id = R.drawable.card_front),
                                                contentDescription = "",
                                                modifier = Modifier.size(width = 300.dp, height = 150.dp)
                                            )
                                        },
                                        back = {
                                            Image(
                                                painter = painterResource(id = R.drawable.card_back),
                                                contentDescription = "",
                                                modifier = Modifier.size(width = 300.dp, height = 150.dp)
                                            )
                                        })
                                }
                            }
                        }
                    )

                }
            }
        }
    }


    @Composable
    fun HeadingText(text: String) {
        Text(
            text = text,
            style = TextStyle(
                color = Color.Black,
                fontSize = 15.sp
            ),
            modifier = Modifier.padding(10.dp)
        )
    }
}
