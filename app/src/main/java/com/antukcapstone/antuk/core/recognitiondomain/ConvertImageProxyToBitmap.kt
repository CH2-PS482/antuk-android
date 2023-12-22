package com.antukcapstone.antuk.core.recognitiondomain

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageFormat
import android.graphics.Rect
import android.graphics.YuvImage
import androidx.camera.core.ImageProxy
import java.io.ByteArrayOutputStream

fun convertImageProxyToBitmap(imageProxy: ImageProxy): Bitmap {
    val buffer = imageProxy.planes[0].buffer
    val bytes = ByteArray(buffer.remaining())
    buffer.get(bytes)

    val width = imageProxy.width
    val height = imageProxy.height

    val yuvImage = YuvImage(bytes, ImageFormat.NV21, width, height, null)
    val outputStream = ByteArrayOutputStream()

    yuvImage.compressToJpeg(Rect(0, 0, width, height), 100, outputStream)
    val jpegBytes = outputStream.toByteArray()

    val bitmap = BitmapFactory.decodeByteArray(jpegBytes, 0, jpegBytes.size)

    // Create a new Bitmap with ARGB_8888 configuration
    return bitmap.copy(Bitmap.Config.ARGB_8888, true)
}
