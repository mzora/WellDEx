package com.example.demo.dao;

import com.example.demo.model.Point;

import java.util.List;
public interface PointDao {
    int insertPoint(Point point);

    List<Point> selectAllPoints();

    int getLines(int nPoints);

    int deleteAllPoints();
}
