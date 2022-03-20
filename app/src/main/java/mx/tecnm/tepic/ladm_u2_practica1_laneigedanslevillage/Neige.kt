package mx.tecnm.tepic.ladm_u2_practica1_laneigedanslevillage

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Neige(l:Lienzo) {
    val l = l
    var x = 0f
    var y = 0f
    var desX = 0f
    var desY = 0f
    var rad = 0f
    var color = Color.WHITE

    init {
        rad = rand(2,20)
        x = rand(0,1000)
        y = rand(0,1900)
        if (rad < 5) desY = rand(1,2)+1
        if (rad >=5 && rad <10) desY = rand(2,3)+1
        if(rad >= 10 && rad <15) desY = rand(3,4)+2
        if(rad >=15) desY = rand(4,6)+2
        color = Color.WHITE
    }

    private fun rand(desde:Int,hasta:Int) : Float{
        return Random.nextInt(desde,hasta).toFloat()
    }

    fun decendre(){
        if(y>l.height){
            y = 0f
        }
        y += desY
    }

    fun pintar(canvas: Canvas){
        var p = Paint()
        p.color = color
        canvas.drawCircle(x,y,rad,p)
    }
}