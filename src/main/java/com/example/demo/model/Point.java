package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Point {
    private int x;
    private int y;

    public Point(@JsonProperty("x") int x,
                 @JsonProperty("y") int y) {
        this.x = x;
        this.y = y;
    }
}
