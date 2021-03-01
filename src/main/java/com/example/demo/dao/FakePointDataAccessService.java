package com.example.demo.dao;

import com.example.demo.model.Point;
import com.example.demo.model.Segment;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository("testDao")
public class FakePointDataAccessService implements PointDao{
    private final static List<Point> DB = new ArrayList<>();
    //private final static Map<Double, List<Segment>> segmentiXPendenza = new HashMap<>();
    private final static List<Segment> DbSegments = new ArrayList<>();

    @Override
    public int insertPoint(Point point) {
        DB.add(new Point(point.getX(),point.getY()));
        /*if(DB.size()>1) {
            for (int i=0; i<DB.size()-1; i++) {
                Segment s = new Segment(point, DB.get(i));
                System.out.println(s.toString());
                if(segmentiXPendenza.containsKey(s.getPendenza())){
                    segmentiXPendenza.get(s.getPendenza()).add(s);
                }else{
                    List<Segment> newLista = new ArrayList<>();
                    newLista.add(s);
                    segmentiXPendenza.put(s.getPendenza(), newLista);
                }
            }*/
        if(DB.size()>1) {
            for (int i=0; i<DB.size()-1; i++) {
                Segment s = new Segment(point, DB.get(i));
                DbSegments.add(s);
                //TODO: se la pendenza==0 || pendenza==infinito,considerare solo val.assoluto
            }
        }
        return 1;
    }

    @Override
    public List<Point> selectAllPoints() {
        return DB;
    }

    //ottenere dalla mappa quell'indice che contiene n-1 segmenti per quella pendenza
    @Override
    public List<Point> getLines(int nPoints) {
        //raggruppamento per pendenza
        Map<Double, List<Segment>> lista = DbSegments.stream()
                .collect(Collectors
                        .groupingBy(Segment::getPendenza));

        //conteggio segmenti per pendenza
        Map<Double, Long> pendenzaCount = DbSegments.stream()
                .collect(Collectors
                        .groupingBy(Segment::getPendenza,Collectors.counting())
        );

        // - iterare la mappa pendenzaCount
        //      e trovare per quale pendenza ci sono almeno (nPoints-1) segmenti
        // - mettere il risultato in una lista di segmenti
        // - per ogni segmento prendere i punti e metterli un una lista
        // TODO: di questa lista prendere i punti una sola volta (distinct?)
        //  return questa lista di punti

        Double pendenzaOk = 0.0;
        for (Map.Entry<Double, Long> entry : pendenzaCount.entrySet()) {
            Double key=entry.getKey();
            Long value=entry.getValue();
            if(value >= nPoints-1){
                pendenzaOk += key;
            }
        }

        List<Segment> segments = lista.get(pendenzaOk);
        List<Point> result = new ArrayList<>();
        for (Segment segment :segments) {
            result.add(segment.getA());
            result.add(segment.getB());
        }
        return result;
    }

    @Override
    public int deleteAllPoints() {
        DB.clear();
        return 1;
    }
}
