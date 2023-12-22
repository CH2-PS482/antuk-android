package com.antukcapstone.antuk.ui.screens.home

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antukcapstone.antuk.R
import com.antukcapstone.antuk.core.di.Injection
import com.antukcapstone.antuk.core.helper.ViewModelFactory
import com.antukcapstone.antuk.ui.screens.account.profile.ProfileViewModel
import com.antukcapstone.antuk.ui.screens.components.TitleHeadlines
import com.antukcapstone.antuk.ui.screens.components.CardButton
import com.antukcapstone.antuk.ui.screens.components.CardHeadlines
import com.antukcapstone.antuk.ui.screens.recognition.CameraActivity
import com.antukcapstone.antuk.ui.theme.AntukTheme

@Composable
fun HomeScreen(
    viewModel: ProfileViewModel = viewModel(factory = ViewModelFactory(
        Injection.provideAntukRepository(
        LocalContext.current))
    ),
    toGuide:() -> Unit
) {
    val context = LocalContext.current
    val sessionData by viewModel.getLoggedInUser().observeAsState()
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                sessionData?.let {
                    TitleHeadlines(
                        text = "Hi, ${it.fullName} 👋")
                }


                Spacer(modifier = Modifier.height(23.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(270.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(color = Color.Black)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),

                        ) {
                        Spacer(modifier = Modifier.height(15.dp))
                        Row (
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {

                            Image(
                                painter = painterResource(R.drawable.astronaut_sleep) ,
                                contentDescription = "",
                                modifier = Modifier
                                    .requiredWidth(207.dp)
                                    .requiredHeight(112.dp))
                        }

                        Column(modifier = Modifier.padding(horizontal = 17.dp)) {
                            CardHeadlines(bigHeadline = stringResource(R.string.start_driving), smallHeadline = stringResource( R.string.start_driving_desc ))

                            Spacer(modifier = Modifier.height(14.dp))

                            CardButton(textButton = stringResource(R.string.start_driving), iconButton = painterResource(
                                R.drawable.play_circle
                            ), onClick = {
                                val intent = Intent(context, CameraActivity::class.java)
                                context.startActivity(intent)
                            })
                        }
                    }
                }

                Spacer(modifier = Modifier.height(23.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(270.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(color = Color.Black)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),

                        ) {
                        Spacer(modifier = Modifier.height(15.dp))
                        Row (
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {

                            Image(
                                painter = painterResource(R.drawable.astronaut_confuse) ,
                                contentDescription = "",
                                modifier = Modifier
                                    .requiredWidth(87.dp)
                                    .requiredHeight(112.dp))
                        }

                        Column(modifier = Modifier.padding(horizontal = 17.dp)) {
                            CardHeadlines(bigHeadline = stringResource(R.string.guide), smallHeadline = stringResource( R.string.guide_desc ))

                            Spacer(modifier = Modifier.height(14.dp))

                            CardButton(textButton = stringResource(R.string.read_guide), iconButton = painterResource(
                                R.drawable.book_guide
                            ), onClick = {
                                toGuide()
                            })
                        }
                    }
                }


            }
        }
    }
}

 @Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun HomeScreenPreview() {
    AntukTheme {
//        HomeScreen(navController)
    }
}