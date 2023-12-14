package eniso.ia2.tp3tasnim_la


import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class CameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        val btnphoto = findViewById<Button>(R.id.btnphoto)
        var thelauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val imageBitmap = it.data?.extras?.get("data") as Bitmap
                    val imageview = findViewById<ImageView>(R.id.capturedimage)
                    imageview.setImageBitmap(imageBitmap)
                }
            }
        btnphoto.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            thelauncher.launch(takePictureIntent)

        }
    }
}