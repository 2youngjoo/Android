package com.example.hellokotlin

// java = public class Person{
//           public Person(String name){
//           }
//       }

/*
class Person constructor(name:String){
    // 필드 선언
    var name:String
    // 초기화 블럭
    init {
        // 생성자의 인자로 전달 받은 값을 매개 변수에 저장
        this.name=name
    }
}
*/

// 위의 코드를 줄이면 아래와 같다
// var만 선언 해주면 생성자는 알아서 들어간다.
// var or val 을 생성자의 인자에 선언하면 전달받은 값이 자동으로 같은 이름의 필드가
// 만들어 지면서 값이 필드에 대입된다.
// var 은 수정이 가능한 필드가 만들어 지고, val 은 수정이 불가능한 필드가 만들어 진다.
class Person(var name:String)

data class Member(var num:Int, var name:String, var addr:String)

fun main(){
    var p1=Person("김구라")
    println("p1.name:"+p1.name)
    println(p1)

    // Memeber 객체 생성
    var m1=Member(1, "김구라", "노량진")
    println("번호:${m1.name} 이름:${m1.name} 주소:${m1.addr}")
    println(m1)

    // java에서 List<Member> members 와 같은 것
    // Kotlin에서 list 는 수정이 불가능 하다 ( java에서 상수화를 시킬 때 final을 붙여서 만드는 것을 생각하면 된다)
    var members:MutableList<Member> = mutableListOf<Member>();
    // type 추론이 가능하기 때문에 members2 의 type 생략 가능
    val member2 = mutableListOf<Member>()

    // list 의 add 메소드를 이용해서 Member 객체의 참족밧 저장하기
    members.add(m1)
    members.add(Member(2,"해골", "행신동"))

    // list 의 forEach() 함수를 호출 하면서 함수를 전달하면 전달한 함수의 매개 변수에
    // list 에 저장된 아이템이 순서대로 전달된다.
    members.forEach(fun(item){
        println(item)
    })
    println("--------------")
    members.forEach {
        println(it)
    }

}