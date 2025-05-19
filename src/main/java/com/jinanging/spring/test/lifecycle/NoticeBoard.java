package com.jinanging.spring.test.lifecycle;

public class NoticeBoard {
    private String title;
    private String user;
    private String content;

    public NoticeBoard(String title, String user, String content) {
        this.title = title;
        this.user = user;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }
}
