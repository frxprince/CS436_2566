fun main(args:Array<String>){
/*for(i in args){
    println(i)
}*/
 val score=80
 var result=""
 //if(score>50){result="pass"}else{result="fail"}
 /*if(score>=80){result="A"
 }else if(score>=70) {
  result = "B"
 }else if(score>=60){result="C"
 }else{result="F"}
 */
/*
 result=if(score>=80){
 println("Good")
 "A"
}else if(score>=70) {
"B"
}else if(score>=60){"C"
}else{"F"}
 println("score=$score result=$result")
var status=if(score>50){"pass"}else{"fail"}
 println("status=$status")

 */
 var lang="en"
 /*var lang_name=""
 when(lang){
  "th"->{lang_name="thai"}
  "en"->{lang_name="english"}
  "jp"->{lang_name="japan"}
 }*/
 var lang_name=when(lang){
  "th"->"thai"
  "en"->"english"
  "jp"->"japan"
  else->"i don't know"
 }
 println(lang_name)
 //printName("Dr Paween")
 println("The area is  ${circle_area(1.0)} ")
}
fun printName( name: String){
 println("My name is $name")
}
fun circle_area(r:Double):Double=Math.PI *r*r
