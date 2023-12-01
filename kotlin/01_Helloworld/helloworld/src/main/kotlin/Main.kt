fun main(args: Array<String>){
    /*
println("Hello World!")
print("CS")
print("MJU")
val a:String="abcd"
val b="asdfghj"
val c=123456.0
var d="ZZZZZZZ"
d="Hello WorldXXXX"
println(a)
println(b)
println(c::class.simpleName)
println(d)
var e:Int
e=1234
e=e+1
println(e)
  */
//var r:String= readln()
//println(Math.PI*r.toDouble() *r.toDouble() )
/*var s="\"Hello\\World\""
var s2=""" "Hello\World" """
println(s2)
var s3="""
    JetBrains Privacy Policy
    Version 2.6, last updated: January 14, 2022
    In this Privacy Policy, we describe the types of data, including Personal Data (collectively, "data"), that we and our associated companies collect from you when you use JetBrains Websites and certain JetBrains Products and services as described in this Privacy Policy (collectively, our "services"), how we and our associated companies use and disclose that data, and your options to access or update your data.

    This Privacy Policy may be amended from time to time. The respective latest version of the Privacy Policy at the point of time of the purchase or registration of a JetBrains Software Product (whichever occurs later) shall apply. The data controllers are JetBrains s.r.o., Praha 4, Na Hřebenech II 1718/8, PSČ 140 00, Czech Republic, and the associated companies of JetBrains.

    JetBrains and its associated companies act as joint data controllers, who are jointly responsible for compliance with data protection legislation. JetBrains s.r.o. is primarily responsible for exercising the rights of data subjects and providing information about data processing.
""".trimIndent()
println(s3)
*/
 /*   var a=1234
    var b=5678
   println("a="+a.toString()+" b="+b.toString()+" , a+b="+(a+b).toString())
println("a=$a b=$b a+b=${a+b}")
*/
    /*
 val A= arrayOf("CS","MJU","MAEJO")
 val B= arrayOfNulls<Int>(3)
 val C=Array<String>(10,init={index->"CSMJU(${index+1})"})
 println("${A[0]}   ${A[1]}    ${A[2]}")
B[0]=1;B[1]=2;B[2]=3
    println("${B[0]}   ${B[1]}    ${B[2]}")
println("${C[0]} ${C[1]} ${C[2]} ${C[7]} ${C[8]} ${C[9]}   ")
for( (i,x) in C.withIndex()) {
    println("Data at $i is $x")
}
  //  println(C.get(8))
*/
 var L= listOf("item1","item2","item3")
    println(L)
 var L2= mutableListOf("item1","item2","item3","item3")
    L2.add(1,"XXX")
    println(L2)
var S1= setOf("a","b","c","d","a")
    println(S1)
var text="sdfsdlfdsfydsiufydsiuyfe8fxvgdiypofddfgsdfgd"
var S2= mutableSetOf<Char>()

var F1= mutableMapOf<Char,Int>()

for (c in text.toCharArray()) {
 S2.add(c)
 F1.set(c,(F1?.get(c)?:0)+1)
}
    println(S1.sortedDescending())
    println(F1)
var F= mapOf(Pair("a",1),Pair("b",2))
println(F["a"])
}

