package eniso.ia2.tp3tasnim_la

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import eniso.ia2.tp3tasnim_la.databinding.ActivityConfirmSmsBinding
import eniso.ia2.tp3tasnim_la.databinding.ActivityWriteSmsBinding

class ConfirmSMS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_sms)
        val bind3 = ActivityConfirmSmsBinding.inflate(layoutInflater)
        setContentView(bind3.root)
        val extra = intent.getStringExtra("number")
        val extra2 = intent.getStringExtra("sms")
        bind3.numero.setText(extra)
        bind3.msg.setText(extra2)
        bind3.envoyer.setOnClickListener {
            val appel = Intent(
                Intent.ACTION_SENDTO,
                Uri.parse("smsto:" + bind3.numero.text.toString() + "body:" + bind3.msg.text.toString())
            )
            startActivity(appel)


        }


        bind3.annuler.setOnClickListener {
            val u = Intent(this, WriteSMS::class.java)
            u.putExtra("toast", "Envoi du message annulé !")

            startActivity(u)


        }

    }

}











