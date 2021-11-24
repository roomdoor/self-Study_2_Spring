package com.example.chapter0602.validator;

import com.example.chapter0602.Annotation.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// @YearMonth 를 사용하기위해 만드는 class
// 이거 만들면 User 에 06.01 에서 만들었던 AssertTrue 없어도 됨
public class YearMonthValidator implements ConstraintValidator<YearMonth, String> { // ConstraintValidator 상속받고 받을 원하는 annotation 넣고 거기에 들어가는 값 형 넣으면 됨

    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();  // 초기화 시킬때 this.pattern 은 annotation 의 pattern 을 가져오기로 함
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //yyyyMM
        // 패턴이 잘 지정되어있는 지검사하는 곳

        try {   // value 에 + 01 을 하는 이유는 LocalDate 가 yyyyMMdd 이기 때문에 01을 더해주지 안으면 오류남
            LocalDate localDate = LocalDate.parse(value + "01", DateTimeFormatter.ofPattern("yyyyMMdd"));
        } catch (Exception e) {
            return false;
        }

        return true;
    }


}
