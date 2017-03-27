package edu.gatech.gtorg.gitmad.todolist.model;


import java.util.concurrent.atomic.AtomicInteger;

public class TodoItem {
    private static AtomicInteger nextId = new AtomicInteger();
    private int id;
    private String text;
    private boolean isCompleted;

    public TodoItem(String text, boolean isCompleted) {
        this.id = nextId.incrementAndGet();
        this.text = text;
        this.isCompleted = isCompleted;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getId() {
        return id;
    }
}
