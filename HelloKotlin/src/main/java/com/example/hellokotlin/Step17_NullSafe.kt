/*
    kotlin에서는 null이 가능한 type 과 null이 불가능한 type이 구분되어 있다.
    null이 가능한 type 데이터를 사용 (필드 참조 or 메소드 호출) 할때는 추가해야 하는 문법이 있다.

 */

//null 이 가능한 매개 변수가 선언된어 있는 함수
fun send(msg:String?){
    // msg 가 null 이 아니면 length 를 참조해라
    val result = msg?.length
    // msg 는 확실히 null 이 아니야 그냥 length 를 참조해!
    val result2 = msg!!.length
}

fun main(){
    var str:String = "abcde12345"
    var str2:String? = "abcde12345"

    // str = null // null 대입 불가
    str2 = null // null 대입 가능

    //문자열의 길이를 안전하게 참조 할 수 있다.
    val result:Int = str.length

    /*
         참조값 ?. 필드 참조 or 메소드 호출은
         참조값이 null이 아닌 경우에 우측의 필드 참조 or 메소드 호출을 수행 하라는 의미
         만일 참조값이 null이면 필드 참조나 메소드 호출을 하지 않고 null을 남긴다.
     */
     var result2:Int? = str2?.length

    println("result:$result")
    println("result:$result2")

    var str3:String? = null
    str3 = "안녕하세요"
    // 컴파일러가 null 이 아닌 것으 ㄹ확실히 인지 한다면 ? 생략 가능
    val result3 = str3.length

    send("hi")
    // 아래는 NullPointerException 발생
    send(null)
}