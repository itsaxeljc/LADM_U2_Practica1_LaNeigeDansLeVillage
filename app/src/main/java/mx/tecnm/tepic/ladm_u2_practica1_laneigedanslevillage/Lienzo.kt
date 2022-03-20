package mx.tecnm.tepic.ladm_u2_practica1_laneigedanslevillage

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class Lienzo (ce:MainActivity) : View(ce) {
    var ce = ce
    var Neige = Array<Neige>(200,{ Neige(this) })
    var conta = 0
    var day = 0.1
    var jour = true
    var orange = true
    var nuit = true
    var mas = true

    val corutina = GlobalScope.launch {
        while (true){
            ce.runOnUiThread{
                invalidate()
            }
            day+=0.07
            if(day<4) {
                reset()
                orange = true
            }
            if(day>=4 && day<10){
                reset()
                jour=true
            }
            if(day>=10 && day<14){
                reset()
                orange = true
            }
            if(day>=14 && day<20){
                reset()
                nuit = true
            }
            if(day>=20)day=0.0
            if(mas)conta++
            else conta--
            if(conta<40){
                Neige = Array<Neige>(rand(1,20).toInt(),{ Neige(this@Lienzo) })
                delay(80L)
            }
            if (conta>=40 && conta<80){
                Neige = Array<Neige>(rand(20,40).toInt(),{ Neige(this@Lienzo) })
                delay(60L)
            }
            if (conta>=80 && conta<120){
                Neige = Array<Neige>(rand(40,80).toInt(),{ Neige(this@Lienzo) })
                delay(40L)
            }
            if (conta>=120 && conta<140){
                Neige = Array<Neige>(rand(50,100).toInt(),{ Neige(this@Lienzo) })
                delay(30L)
            }
            if (conta>=140 && conta<160){
                Neige = Array<Neige>(rand(80,150).toInt(),{ Neige(this@Lienzo) })
                delay(20L)
            }
            if (conta>=160 && conta<180){
                Neige = Array<Neige>(rand(120,200).toInt(),{ Neige(this@Lienzo) })
                delay(20L)
            }
            if (conta>=180)mas = false
            if(conta==0)mas = true
            delay(20L)

        }
    }
    override fun onDraw(c:Canvas){
        super.onDraw(c)
        val p = Paint()
        if(jour){
            c.drawColor(Color.rgb(153,217,234))
            p.color = Color.rgb(255,254,187)
            c.drawCircle(50f,100f,230f,p)
        }
        if(orange){
            c.drawColor(Color.rgb(255,197,183))
            p.color = Color.rgb(255,252,183)
            c.drawCircle(0f,1300f,250f,p)
        }
        if(nuit){
            c.drawColor(Color.rgb(72,104,163))
            p.color = Color.rgb(246,255,198)
            c.drawCircle((this.width-150).toFloat(),180f,220f,p)
        }
        p.color = Color.rgb(103,92,115)
        c.drawOval(100f,600f,(this.width+200).toFloat(),2100f,p)
        p.color = Color.rgb(144,129,161)
        c.drawOval(-100f,1200f,800f,2100f,p)

        p.color = Color.rgb(112,146,190)
        c.drawRect(0f,1650f,this.width.toFloat(),this.height.toFloat(),p)
        p.color = Color.rgb(185,122,87)
        c.drawRect(285f,1350f,315f,1800f,p)
        c.drawRect(375f,1200f,415f,1850f,p)
        c.drawRect(165f,1300f,235f,2080f,p)
        c.drawRect(475f,1650f,525f,1990f,p)

        p.color = Color.rgb(255,197,183)
        c.drawRoundRect(550f,1500f,(this.width-10).toFloat(),1900f,30f,30f,p)
        p.color = Color.rgb(205,231,240)
        c.drawRoundRect(600f,1600f,700f,1800f,30f,30f,p)
        c.drawRoundRect(920f,1600f,1020f,1800f,30f,30f,p)
        p.color = Color.rgb(240,135,132)
        c.drawRoundRect(745f,1650f,875f,1900f,30f,30f,p)
        c.drawRoundRect(745f,1650f,875f,1900f,30f,30f,p)
        c.drawRoundRect(500f,1400f,(this.width+10).toFloat(),1550f,30f,30f,p)

        p.color = Color.rgb(2,146,161)
        c.drawOval(250f,1250f,350f,1700f,p)
        c.drawOval(330f,1050f,460f,1750f,p)
        p.color = Color.rgb(5,161,132)
        c.drawOval(80f,1200f,320f,1900f,p)
        c.drawOval(400f,1450f,600f,1850f,p)



        for(neige in Neige){
            neige.decendre()
            neige.pintar(c)
        }
    }

    fun reset(){
        jour = false
        nuit = false
        orange = false
    }
    fun rand(desde:Int,hasta:Int) : Float{
        return Random.nextInt(desde,hasta).toFloat()
    }
}