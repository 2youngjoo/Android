package com.example.hellokotlin

import com.example.hellokotlin.java.MemberDto
import com.example.hellokotlin.java.Sender
import java.util.Scanner

fun main(){
    // java 패키지의 Sender 클래스를 이용해서 객체를 생성
    val s = Sender()
    s.send("hello! java")

    // java 에서는 .in 하면 예약어로 인식되지만
    // kotlin 에서는 키워드로 해석되기 때문에 ``으로 인식하지 않게 한다.
    // 키보드로 부터 입력 받을 수 있는 객체 생성
    val scan = Scanner(System.`in`)
    print("입력:")
    val msg = scan.nextLine()
    println("입력 받은 내용:$msg")

    // MemberDto 객체를 생성해서
    val mem1 = MemberDto()
    mem1.num = 1
    mem1.name = "김구라"
    mem1.addr = "노량진"
    // getter 메소드가 호출된다.
    val a = mem1.num
    val b = mem1.name
    val c = mem1.addr
}

