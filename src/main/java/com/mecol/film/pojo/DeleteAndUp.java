package com.mecol.film.pojo;

import java.io.Serializable;

public class DeleteAndUp implements Serializable {
    private Integer id;
    private String mode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "DeleteAndUp{" +
                "id=" + id +
                ", mode='" + mode + '\'' +
                '}';
    }
}
