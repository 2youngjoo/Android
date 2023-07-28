package com.example.hellokotlin

class Cat constructor(){
    // init 블럭은 primary 생성자의 일부
    init{
        println("야옹이가 생겼어요!")
    }
    // 필드
    // 뒤늦은 초기화가 가능한 필드 latainit 예약어 붙여서 선언하기
    lateinit var name:String
    constructor(name:String) : this(){ // this() primary 생성자를 호출하는 표현식
        println("야옹이의 이름은:${name}")
        this.name=name
    }
}

class Dog constructor(){
    init{
        println("강아지가 생겼어요!")
    }
    var name:String? = null
    constructor(name:String):this(){
        println("강아지의 이름은:${name}")
        this.name=name
    }
}

fun main(){
    val c1=Cat("마리")
    val c2=Cat()
    println(c1.name)
    // lateinit 필드에 값을 넣어주고
    c2.name="키티"
    // 필드를 참해야 한다.
    println(c2.name)

    // null 값이 가능한 data type 은 type 뒤에 ? 를 넣어 붙여 주어야 한다.
    // String type 과 String ? type 은 다른 type 으로 간주 된다.
    var myName:String? = null
    myName="김구라"
    myName=null

    // Int(숫자) type 도 null 을 넣어 놓고 값을 나중에 대입할수 있다.
    var myNum:Int? = null
    myNum=999
    myNum=null

    var d1=Dog("행이")
    var d2=Dog()
    println(d1.name)
    println(d2.name)

}