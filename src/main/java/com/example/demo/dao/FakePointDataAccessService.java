package com.example.demo.dao;

import com.example.demo.model.Point;
import com.example.demo.model.Segment;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("testDao")
public class FakePointDataAccessService implements PointDao{
    private final static List<Point> DB = new ArrayList<>();

    private final static Map<Double, List<Segment>> segmentiXPendenza = new HashMap<>();

    @Override
    public int insertPoint(Point point) {
        DB.add(new Point(point.getX(),point.getY()));

        if(DB.size()>1) {
            for (int i=0;i<DB.size()-1;i++) {
                Segment s = new Segment(point, DB.get(i));
                System.out.println(s.toString());
                if(segmentiXPendenza.containsKey(s.getPendenza())){
                    segmentiXPendenza.get(s.getPendenza()).add(s);
                }else{
                    List<Segment> newLista = new ArrayList<>();
                    newLista.add(s);
                    segmentiXPendenza.put(s.getPendenza(), newLista);
                }
            }
        }

        return 1;
    }

    @Override
    public List<Point> selectAllPoints() {
        return DB;
    }


    /*Ottieni tutti i segmenti di linea che passano per almeno N punti*/
    @Override
    public List<Point> getLines(int nPoints) {

        return null;
    }

    @Override
    public int deleteAllPoints() {
        DB.clear();
        return 1;
    }
}
