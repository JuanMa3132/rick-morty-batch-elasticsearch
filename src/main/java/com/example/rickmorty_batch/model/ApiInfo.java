package com.example.rickmorty_batch.model;

import lombok.Data;

@Data
public class ApiInfo {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
