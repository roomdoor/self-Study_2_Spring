package com.example.chapter0605.dto;

import lombok.*;

//lombok     getter setter 뿐만 아니라 생성자까지 annotation 으로 할 수 있음 build 가보면  annotationProcessor 'org.projectlombok:lombok' 가 들어가있고
//     compileOnly 'org.projectlombok:lombok' compileOnly 는 컴파일 할때 모든 getter setter 등을 코드로 넣어주기 위함
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private int age;
}
