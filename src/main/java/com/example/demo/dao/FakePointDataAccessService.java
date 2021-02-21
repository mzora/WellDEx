package com.example.demo.dao;

import com.example.demo.model.Point;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository("fakeDao")
public class FakePointDataAccessService implements PointDao{
    private static List<Point> DB = new ArrayList<>();

    @Override
    public int insertPoint(Point point) {
        DB.add(new Point(point.getX(),point.getY()));
        return 1;
    }

    @Override
    public List<Point> selectAllPoints() {
        return DB;
    }

    @Override
    public int getLines(int nPoints) {
        //TODO:implemnteare l'algoritmo che individua le rette;
        return 0;
    }

    @Override
    public int deleteAllPoints() {
        DB.clear();
        return 1;
    }
}
