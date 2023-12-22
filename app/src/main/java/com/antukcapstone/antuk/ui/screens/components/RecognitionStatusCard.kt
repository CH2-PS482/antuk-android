package com.antukcapstone.antuk.ui.screens.components

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.antukcapstone.antuk.MainActivity
import com.antukcapstone.antuk.R
import com.antukcapstone.antuk.ui.navigation.Screens
import com.antukcapstone.antuk.ui.navigation.graphs.navigateToSingleTop
import com.antukcapstone.antuk.ui.screens.account.components.AlarmPlayer
import com.antukcapstone.antuk.ui.theme.AntukTheme
import kotlinx.coroutines.delay


@Composable
fun RecognitionStatusCard(
    status: String,
) {
    var timerRunning by remember { mutableStateOf(false) }
    var timeElapsed by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val alarmPlayer = remember { AlarmPlayer(context) }

    LaunchedEffect(timerRunning) {
        while (timerRunning) {

            timeElapsed++
        }
    }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(10.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(color = Color.White)
    ) {
        Column {
        Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = formatTime(timeElapsed),
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    )
                )

                Spacer(modifier = Modifier.width(22.dp))

                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .width(130.dp)
                        .height(36.dp) ,
                    colors = ButtonDefaults.buttonColors(Color(0xFFDF3939)),
                    shape = RoundedCornerShape(size = 10.dp),

                    ) {
                    Text(
                        text = "Stop",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                            color = Color.White,
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(5.dp))
            
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(12.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(color = Color(0xFFF3F5F8)),
                contentAlignment = Alignment.Center
            ) {
                // Alarm
                if(status == "Drowsy") {
                    alarmPlayer.playAlarmForDuration(5000)
                } else {
                    alarmPlayer.stopAlarm()
                }



                val textColor =
                    if(status == "Drowsy") {
                        Color(0xFFCE7E7E)
                    } else if(status == "Awake") {
                        Color(0xFF5CAB6D)
                    } else {
                        Color.Gray
                    }

                Text(
                    text = status,
                    color = textColor,
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    )
                )
            }
        }
    }
}

fun formatTime(seconds: Int): String {
    val hours = seconds / 3600
    val minutes = (seconds % 3600) / 60
    val secs = seconds % 60
    return "%02d:%02d:%02d".format(hours, minutes, secs)
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun RecognitionStatusCardPreview() {
    AntukTheme {
        RecognitionStatusCard("Unknown")
    }
}