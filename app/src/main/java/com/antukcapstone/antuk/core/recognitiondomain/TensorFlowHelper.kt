package com.antukcapstone.antuk.core.recognitiondomain

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.antukcapstone.antuk.ml.AntukModel
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer
import java.nio.ByteOrder

object TensorFlowHelper {

    val BATCH_SIZE = 1
    val INPUT_SIZE = 256
    val PIXEL_SIZE = 3

    @Composable
    fun classifyImage(
        bitmap: Bitmap,
        callback: (
        @Composable (status: String) -> Unit)
    ) {
        val model: AntukModel = AntukModel.newInstance(LocalContext.current)

        // Create inputs for reference
        val inputFeature0 =
            TensorBuffer.createFixedSize(intArrayOf(1, 1), DataType.FLOAT32)

        val byteBuffer: ByteBuffer = ByteBuffer.allocateDirect(INPUT_SIZE * INPUT_SIZE * PIXEL_SIZE)

        byteBuffer.order(ByteOrder.nativeOrder())

        val intValues = IntArray(INPUT_SIZE * INPUT_SIZE)

        bitmap.getPixels(intValues, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)

        var pixel = 0

        for (i in 0 until INPUT_SIZE) {
            for (j in 0 until INPUT_SIZE) {
                val `val` = intValues[pixel++] // RGB
                byteBuffer.putFloat((`val` shr 16 and 0xFF) * (1f / 1))
                byteBuffer.putFloat((`val` shr 8 and 0xFF) * (1f / 1))
                byteBuffer.putFloat((`val` and 0xFF) * (1f / 1))
            }
        }

        inputFeature0.loadBuffer(byteBuffer)

        // Runs model and get results
        val outputs: AntukModel.Outputs = model.process(inputFeature0)
        val outputFeature0: TensorBuffer = outputs.getOutputFeature0AsTensorBuffer()
        val confidences = outputFeature0.floatArray

        var maxResult = 0
        var maxConfidence = 0.1f
        for (i in confidences.indices) {
            if (confidences[i] > maxConfidence) {
                maxConfidence = confidences[i]
                maxResult = i
            }
        }

        val classes = arrayOf("Drowsy", "Awake")
        callback.invoke(classes[maxResult])

        model.close()
    }
}