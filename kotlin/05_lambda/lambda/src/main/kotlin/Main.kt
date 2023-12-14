fun sum1(a:Int,b:Int):Int{
    return a+b
}
fun main(args: Array<String>) {

    println(sum1(5,4))
 val sum2:(Int,Int)->Int={i:Int,j:Int->i+j}
    println(sum2(5,4))
 var a= listOf<Int>(1,2,3,4,5,6,7,8,9,0,10,11)
 EachItem(a,{i->println("the item is $i")})
}

fun EachItem(x:List<Int>,myAction:(Int)->Unit){
    for (item in x){
      myAction(item)
    }
}