package com.liang.spring.boot.child.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 文件路径 实体
 * Created by: elvis(李亮)
 * 2019-04-18 10:14
 * Version: 1.0
 */
@Entity
public class FilePath {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer id;

    public String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
