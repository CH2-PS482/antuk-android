package com.antukcapstone.antuk.core.recognitiondomain

import androidx.camera.core.ImageProxy
import java.nio.ByteBuffer

fun ConvertImageProxyToByteBuffer(imageProxy: ImageProxy): ByteBuffer {

    val planes = imageProxy.planes
    val yBuffer = planes[0].buffer
    val uBuffer = planes[1].buffer
    val vBuffer = planes[2].buffer


    val ySize = yBuffer.remaining()
    val uSize = uBuffer.remaining()
    val vSize = vBuffer.remaining()



    val nv21 = ByteArray(ySize + uSize + vSize)

    yBuffer.get(nv21, 0, ySize)
    vBuffer.get(nv21, ySize, vSize)
    uBuffer.get(nv21, ySize + vSize, uSize)

//     Convert nv21 byte array to ByteBuffer
    val byteBuffer = ByteBuffer.allocateDirect(nv21.size)
    byteBuffer.put(nv21)

//     Rewind the ByteBuffer for reading
    byteBuffer.rewind()

    return byteBuffer
}
