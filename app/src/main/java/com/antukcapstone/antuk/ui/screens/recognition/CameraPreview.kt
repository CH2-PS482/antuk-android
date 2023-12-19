package com.antukcapstone.antuk.ui.screens.recognition

import android.content.Context
import android.view.ViewGroup
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.LifecycleCameraController
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine



@Composable
fun CameraPreview(
    controller: LifecycleCameraController,
    modifier: Modifier = Modifier,
    scaleType: PreviewView.ScaleType = PreviewView.ScaleType.FILL_CENTER,
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,

) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val coroutineScope = rememberCoroutineScope()


    AndroidView(factory = { context ->
        val previewView = PreviewView(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
            )
            this.controller = controller
            controller.bindToLifecycle(lifecycleOwner)

            this.scaleType = scaleType
        }
        val previewUseCase = Preview.Builder().build()
        previewUseCase.setSurfaceProvider(previewView.surfaceProvider)


        coroutineScope.launch {
            val cameraProvider = context.cameraProvider()
            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, previewUseCase)
        }

        previewView
    })




}


suspend fun Context.cameraProvider() : ProcessCameraProvider = suspendCoroutine {continuation ->
    val listenableFuture = ProcessCameraProvider.getInstance(this)

    listenableFuture.addListener({
        continuation.resume(listenableFuture.get())

    }, ContextCompat.getMainExecutor(this))
}


