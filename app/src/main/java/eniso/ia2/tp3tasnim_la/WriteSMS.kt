package eniso.ia2.tp3tasnim_la

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import eniso.ia2.tp3tasnim_la.databinding.ActivityWriteSmsBinding

class WriteSMS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_sms)
        val bind2 = ActivityWriteSmsBinding.inflate(layoutInflater)
        setContentView(bind2.root)
        bind2.confirmer.setOnClickListener {
            if(bind2.message.text.toString()==""){
                val toast = Toast.makeText(applicationContext, "Please enter a message!", Toast.LENGTH_LONG)
                toast.show()
            }else{

                val i= Intent(this,ConfirmSMS::class.java)
                i.putExtra("number",bind2.num.text.toString())
                i.putExtra("sms",bind2.message.text.toString())
                startActivity(i)

            }

        }
        val extra = intent.getStringExtra("toast")
        val toast = Toast.makeText(applicationContext, extra.toString(), Toast.LENGTH_LONG)
        toast.show()
    }
}
