package com.example.hellokotlin

class Human{
    val name:String
    // String type 을 전달받는 생성자
    constructor(name:String){
        this.name=name
    }
}
// 위의 클래스를 아래와 같은 형태로도 정의할 수 있다.
class Human2 constructor(name: String){
    val name:String
    init {
        this.name=name
    }
}
// 위의 작업을 줄여서 표현하면 아래와 같다.
class Human3 constructor(val name:String){

}
// 위으 ㅣ작업을 조금 더 줄여서 쓰면 아래와 같다.
class Human4(val name:String)

// 참조값을 출력했을 때 필드 안에 들어있는 내용을 확인 가능하게 해서 개발을 용의하게 하려면
data class Human5(val name:String) // data 키워드를 이용해서 클래스를 정의하면 된다.

fun main(){
    // 필요한 객체를 생성해줘야 객체가 전달 된다.
    val h1=Human("나야나")
    val h2=Human2("원숭이")
    val h3=Human3("주뎅이")
    val h4=Human4("덩어리")
    val h5=Human5("김구라")

    println("h4 : $h4")
    println("h5 : $h5")
}

