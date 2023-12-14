package eniso.ia2.tp3tasnim_la

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import eniso.ia2.tp3tasnim_la.databinding.ActivityCallBinding

class CallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCallBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if (binding.phone.text.toString() == "") {
                val toast = Toast.makeText(
                    applicationContext,
                    "Please enter a phone number !",
                    Toast.LENGTH_LONG
                )
                toast.show()
            } else {

                val appel =
                    Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + binding.phone.text.toString()))


                startActivity(appel)

            }

        }

    }
}