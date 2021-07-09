package com.example.demo.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Entity
public class todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id=new Long(1);
    private String name;
    private  Date date;
    private int priority;
    private boolean done;
    public todo(){

    }
    public todo(String name, Date date, int priority) {
        this.name = name;
        this.date = date;
        this.priority = priority;
        this.done =false;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public int getPriority() {
        return priority;
    }

    public Date getDate() {
        return date;
    }

    public boolean isDone() {
        return done;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", priority=" + priority +
                ", done=" + done +
                '}';
    }
}
