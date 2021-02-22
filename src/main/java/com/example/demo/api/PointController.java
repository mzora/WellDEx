package com.example.demo.api;

import com.example.demo.model.Point;
import com.example.demo.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/point")
@RestController
public class PointController {
    /*Add a point to the space
        POST /point with body { "x": ..., "y": ... }

        Get all points in the space
        GET /space

        Get all line segments passing through at least N points. Note that a line segment should be a set of
        points.
       GET /lines/{n}

        Remove all points from the space
        DELETE /space*/

    private final PointService pointService;

    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @PostMapping
    public void addPoint(@RequestBody Point point){
        pointService.addPoint(point);
    }

    @GetMapping
    public List<Point> getAllPoints(){
        return pointService.getAllPoints();
    }

    @DeleteMapping
    public void deleteAllPoints(){
        pointService.deleteAllPoints();
    }
}
