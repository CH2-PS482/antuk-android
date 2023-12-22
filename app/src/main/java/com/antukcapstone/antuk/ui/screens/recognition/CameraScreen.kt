package com.antukcapstone.antuk.ui.screens.recognition

import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.util.Log
import android.view.Surface
import androidx.annotation.RequiresApi
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.antukcapstone.antuk.core.recognitiondomain.TensorFlowHelper
import com.antukcapstone.antuk.core.recognitiondomain.TensorFlowHelper.INPUT_SIZE
import com.antukcapstone.antuk.core.recognitiondomain.convertImageProxyToBitmap
import com.antukcapstone.antuk.ui.screens.components.RecognitionStatusCard
import com.antukcapstone.antuk.ui.screens.components.TitleHeadlines
import org.tensorflow.lite.task.core.vision.ImageProcessingOptions


@Composable
fun CameraScreen() {
    var statusResult by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current
    val scaledBitmapState = remember {
        mutableStateOf<Bitmap?>(null)
    }


    val imageAnalysisUseCase = ImageAnalysis.Builder()
        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
        .build()

    imageAnalysisUseCase.setAnalyzer(ContextCompat.getMainExecutor(LocalContext.current)) { imageProxy ->
        val bitmap = convertImageProxyToBitmap(imageProxy)
        val scaledBitmap = Bitmap.createScaledBitmap(bitmap, 256, 256, false)
//            recognitionCallback(scaledBitmap)

        scaledBitmapState.value = scaledBitmap
    }

    val scaledBitmap: Bitmap? = scaledBitmapState.value

    CameraPreview(modifier = Modifier.fillMaxSize())

//    scaledBitmap.let {bitmap ->
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
//                bitmap?.let {
//                    TensorFlowHelper.classifyImage(it) { result ->
//                        RecognitionStatusCard(
//                            status = result
//                        )
//                    }
                
                RecognitionStatusCard(status = "Awake")
                }
//            }
        }
//    }



}






