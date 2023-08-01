package com.example.step07sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    private DBHelper dbHelper;
    // 생성자
    public TodoDao(DBHelper dbHelper){
        this.dbHelper=dbHelper;
    }
    // 할 일 저장
    public void insert(Todo todo){
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        // datetime = sql 문에서 sysdate 와 비슷한 것이다.
        String sql="insert into todo" +
                " (content, regdate)" +
                " values(?, datetime('now','localtime'))";
        // ? 에 순서대로 바인딩할 인자를 Object[] 에 준비한다.
        Object[] args={todo.getContent()};
        // sql 문 실행하기
        db.execSQL(sql, args);
        db.close(); // close() 를 호출해야 실제로 반영된다.
    }
    // 할 일 정보를 수정하는 메소드
    public void update(Todo todo){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        String sql="update todo" +
                " set content=?" +
                " where num=?";
        // ? 에 바인딩할 데이터를 Object[] 배열에 순서대로 담아서
        Object[] args={todo.getContent(), todo.getNum()};
        // execSQL() 메소드의 인자로 Object[] 배열을 전달하면 ?에 순서대로 바인딩 된다.
        db.execSQL(sql, args);
        db.close();
    }
    // 할 일 정보를 삭제하는 메소드
    public void delete(int num){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        String sql="delete from todo where num=?";
        Object[] args={num};
        db.execSQL(sql, args);
        db.close();
    }
    // 할 일 1개의 정보를 리턴하는 메소드
    public Todo getData(int num){
        // 필드
        Todo todo=null;

        // 읽기전용 SQLiteDatabase 객체의 참조값 가져오기
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String sql="select content, regdate" +
                " from todo" +
                " where num=?";
        // query 문에는 String[] 배열에 selection 인자를 준비해야 한다.
        String[] args={Integer.toString(num)};
        Cursor result =db.rawQuery(sql, args);
        // 만일 select 된 값이 있다면
        if(result.moveToNext()){
            todo=new Todo();
            todo.setNum(num);
            // 0번째 칼럼에 select 된 문자열을 Todo 객체에 담는다.
            todo.setContent(result.getString(0));
            // 1번째 칼럼에 select 된 문자열을 Todo 객체에 담는다.
            todo.setRegdate(result.getString(1));
        };
        return todo;
    }
    // 모든 할 일 목록을 리턴하는 메소드
    public List<Todo> getList(){
        List<Todo> list=new ArrayList<>();
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String sql="select num, content, regdate" +
                " from todo" +
                " order by num asc";
        Cursor cursor=db.rawQuery(sql, null);
        // 반복문 돌면서 Cursor 에 저장된 값을
        while(cursor.moveToNext()){
            // 추출해서 Todo 객체에 담아서
            Todo tmp=new Todo();
            tmp.setNum(cursor.getInt(0));
            tmp.setContent(cursor.getString(1));
            tmp.setRegdate(cursor.getString(2));
            // List 에 누적 시킨다.
            list.add(tmp);
        }
        return list;
    }
}
