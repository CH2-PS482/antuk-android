package com.antukcapstone.antuk.ui.screens.recognition

import android.content.Context
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.antukcapstone.antuk.core.data.TfLiteDrowsyClassifier
import com.antukcapstone.antuk.core.domain.Classification
import com.antukcapstone.antuk.ui.screens.components.TitleHeadlines
import com.antukcapstone.antuk.ui.theme.AntukTheme



@Composable
fun CameraScreen(applicationContext: Context) {
    /*
    var classifications by remember {
        mutableStateOf(emptyList<Classification>())
    }

    val analyzer = remember {
        DrowsyAnalyzer(
            classifier = TfLiteDrowsyClassifier(
                context = applicationContext
            ),
            onResult = {
                classifications = it
            }
        )
    }
      */

    val controller = remember {
        LifecycleCameraController(applicationContext).apply {
            setEnabledUseCases(CameraController.IMAGE_ANALYSIS)
//            setImageAnalysisAnalyzer(
////                ContextCompat.getMainExecutor(applicationContext),
////                analyzer
////            )
        }
    }



    Box(modifier = Modifier
        .fillMaxSize()) {

        CameraPreview(controller, Modifier.fillMaxSize())

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            /*
            classifications.forEach {
                Text(
                    text = it.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Color.Red
                        )
                        .padding(10.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    color = Color.Black
                )
            }
             */
            TitleHeadlines(text = "CAMERA")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RecognitionScreenPreview() {
    AntukTheme {
//        CameraScreen(context)
    }
}
