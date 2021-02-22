package com.example.demo.model;

import com.example.demo.dao.PointDao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Segment {
    private Point a;
    private Point b;
    private double pendenza;

    public Segment(Point a, Point b) {
        this.a = a;
        this.b = b;
        this.pendenza = (b.getY()-a.getY()) / (b.getX()-a.getX());
    }

}
