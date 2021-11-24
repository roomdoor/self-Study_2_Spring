package com.example.chapter09.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRes {

    @ApiModelProperty(value = "사용자의 이름", example = "이시화", required = true)
    private String name;

    @ApiModelProperty(value = "사용자의 나이", example = "30", required = true)
    private int age;
}
