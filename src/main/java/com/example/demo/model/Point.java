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
    private double x;
    private double y;

    public Point(@JsonProperty("x") double x,
                 @JsonProperty("y") double y) {
        this.x = x;
        this.y = y;
    }
}
