package com.hua.matchfriends.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用
 */
@Data
public class DeleteRequest implements Serializable {

    private static final long serialVersionUID = 3741441858923475577L;

    private long id;
}
