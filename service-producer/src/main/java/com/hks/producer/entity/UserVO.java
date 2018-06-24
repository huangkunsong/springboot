package com.hks.producer.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Huangkunsong
 */
@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class UserVO implements Serializable{
    private Integer id;
    private String userName;
    private String passWord;
    private Boolean salt;
    private Boolean locked;
    private Date date;
}
