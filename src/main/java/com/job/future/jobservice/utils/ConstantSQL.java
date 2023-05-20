package com.job.future.jobservice.utils;

import javax.persistence.Column;

public final class ConstantSQL {
    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;
    public static final String FIND_POST_CONTENT_BY_TITLE = "SELECT p.code, p.title, p.content FROM Post p WHERE p.title = :title";




}
