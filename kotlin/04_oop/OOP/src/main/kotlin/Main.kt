import kotlin.Any

open class Line(var width:Double){
  init { println("Class line was created!")  }
  fun printwidth(){ println("the width of line is $width")}
}
open class Square(var sqwidth:Double):Line(sqwidth){
    init { println("Class square was created!")  }
open fun area(){println("the area of this square is ${width*width}")}
}
class Circle(var radius:Double):Square(radius){
    init { println("Class circle was created!")  }
 override  fun area(){println("the area of this circle is ${width*width*Math.PI}") }
}
open class Rectangle(var rwidth:Double,var height:Double):Square(rwidth){
    init { println("Class rectangle was created!")  }
    fun printheight(){println("The height of this rectangle is $height")}
override fun area(){println("the area of this rectangle is ${width*height}")}
}
class Any(var awidth:Double,var aheight:Double):Rectangle(awidth,aheight){
    init { println("Class Any was created!")  }
 fun anyarea(area:areaforany){
    area.area(width,height)
}
}
interface areaforany{
  fun area(w:Double,h:Double){}
}
class AnyLb(var awidth:Double,var aheight:Double):Rectangle(awidth,aheight){
  fun area(areax:(w:Double,h:Double)->Unit){ areax(width,height)}
}
fun main(args: Array<String>) {
val Anyobj2=AnyLb(20.0,30.0);Anyobj2.printwidth();Anyobj2.printheight()
Anyobj2.area { w, h -> println("The area of this diamond is ${w*h*0.5}")  }

/*val Anyobj=Any(20.0,10.0);Anyobj.printwidth();Anyobj.printheight()
    Anyobj.anyarea(object:areaforany{
        override fun area(w:Double,h:Double){
            println("The area of this dianond ${w*h*0.5}")
        }
    })*/
// val Rectangleobj=Rectangle(10.0,20.0);Rectangleobj.printwidth();Rectangleobj.printheight();Rectangleobj.area()
//val Lineobj=Line(50.0);Lineobj.printwidth()
//val Squareobj=Square(100.0);Squareobj.printwidth();Squareobj.area()
//val Circleobj=Circle(2.0);Circleobj.printwidth();Circleobj.area()
}
