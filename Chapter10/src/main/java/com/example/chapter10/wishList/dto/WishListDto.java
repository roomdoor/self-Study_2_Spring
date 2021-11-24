package com.example.chapter10.wishList.dto;

import com.example.chapter10.db.MemoryDbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishListDto {

    private int index;
    private String title;
    private String category;
    private String address;
    private String roadAddress;
    private String homepageLink;
    private String imageLink;
    private boolean isVisited;
    private int visitCount;
    private LocalDateTime lastVisitDate;

}
