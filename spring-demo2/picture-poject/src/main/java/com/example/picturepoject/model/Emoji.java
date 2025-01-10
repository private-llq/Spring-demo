package com.example.picturepoject.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Emoji {
    private Long id;
    
    private String name;
    private String url;
    private String category;
    private LocalDateTime createTime;
}