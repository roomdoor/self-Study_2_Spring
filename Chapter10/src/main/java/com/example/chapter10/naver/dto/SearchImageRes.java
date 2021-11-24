package com.example.chapter10.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.plaf.BorderUIResource;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchImageRes {

    private String lastBuildDate;

    private Integer total;

    private Integer start;

    private Integer display;

    private List<SearchLocalItem> items;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchLocalItem {
        private String title;
        private String link;
        private String thumbnail;
        private String sizeheight;
        private String sizewidth;
    }

}

