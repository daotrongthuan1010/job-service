package com.job.future.jobservice.utils;

import javax.persistence.Column;

public final class ConstantSQL {

    public static final String FIND_POST_CONTENT_BY_TITLE =
            "SELECT p.code, p.title , p.content , p.views , p.created_at,  r.rating, c.content as comment_content, c.created_at as comment_created_at \n" +
                    "FROM posts p\n" +
                    "INNER JOIN ratings r ON r.post_id  = p.id \n" +
                    "INNER JOIN comments c ON c.post_id = p.id \n" +
                    "WHERE p.title LIKE :title%";


}
