package com.example.demo.service;

import com.example.demo.dao.PointDao;
import com.example.demo.model.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {
    private final PointDao pointDao;

    @Autowired
    public PointService(@Qualifier("testDao") PointDao pointDao) {
        this.pointDao = pointDao;
    }

    public int addPoint(Point point){
        return pointDao.insertPoint(point);
    }

    public List<Point> getAllPoints(){
        return pointDao.selectAllPoints();
    }

    public int deleteAllPoints(){
        return pointDao.deleteAllPoints();
    }

}
