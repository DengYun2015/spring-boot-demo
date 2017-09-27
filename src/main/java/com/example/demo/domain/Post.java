package com.example.demo.domain;

import com.example.demo.util.Helper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,length = 65532)
    private String content;

    @Column(nullable = false)
    private Integer authorId = 0;

    @Column(nullable = false)
    private Long createTime;

    @Column(nullable = false)
    private Long updateTime;

    public Post() {
        super();
    }

    public Post(String title, String content, Integer authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        Long time = Helper.GetCurrentTimestamp();
        this.createTime = time;
        this.updateTime = time;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
