package com.job.future.jobservice.utils;

import javax.persistence.Column;

public final class ConstantSQL {

    public static final String FIND_POST_CONTENT_BY_TITLE = "select post .content , post .title , post .created_at , post .created_by, post .views, r.rating, r.content, r.rating \n" +
            "from posts post  inner join ratings r on post .id = r.post_id inner join comments c on c.post_id  = post .id where post.title like :title";




}
