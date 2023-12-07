fun main(args: Array<String>) {
for (i in 1..10 step 2) println(i)
for(i in 10 downTo 1 step 1)println(i)
    repeat(10){i->println("Hello $i")}
l1@for(r in 0..5){
l2@    for(c in 0..5){
        if(r==3)break@l1
        print("($r,$c) ")
    }
    println()
}
 var text:String?=null
    //text="abcd"
 println(text?.length?:"no data")
var c= text?:"empty"
println("the value of text is $c")
println(text!!.length)
}