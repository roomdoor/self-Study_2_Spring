package com.example.chapter0602.dto;

import com.example.chapter0602.Annotation.YearMonth;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class User {

    @Valid  // Car 변수에 모두 @Validation 을 붙였어도 그 변수를 사용하는 곳에 @Valid 를 붙여주지 안으면 동작하지 않음
    private List<Car> cars;

    @NotBlank
    private String name;

    @Max(value = 90)
    private int age;

//    @Email
//    private String email;
//
//    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호 양식과 맞지 않습니다. 01x-xxx(x)-xxxx")
//    private String phoneNumber;
//
//    @YearMonth(message = "yyyyMM 으로 넣으세요.")
//    private String reqYearMonth; // yyyyMM


    @Override
    public String toString() {
        return "User{" +
                "cars=" + cars +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
