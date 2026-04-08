package com.hawaso.javacampus.models.demos;

public class GreetingDemo {
    private final long id;
    private final String content;

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public GreetingDemo(long id, String content) {
        this.id = id;
        this.content = content;
    }
}
