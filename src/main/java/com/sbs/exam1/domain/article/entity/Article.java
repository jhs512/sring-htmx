package com.sbs.exam1.domain.article.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Article {
    private Long id;
    @EqualsAndHashCode.Exclude
    private String title;
}
