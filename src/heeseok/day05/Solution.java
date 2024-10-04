/*

day05 : 방문 길이
https://school.programmers.co.kr/learn/courses/30/lessons/49994#

*/

import java.util.*;
class Edge {
    private Point start;
    private Point end;
    
    public Edge(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    
    public Point start() {
        return this.start;        
    }
    
    public Point end() {
        return this.end;
    }
    
    public static Edge of(Point start, Point end) {
       return new Edge(start, end);
    }
    
    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        Edge edge = (Edge) o;
        return (edge.start.equals(this.start) && edge.end.equals(this.end)) || (edge.start.equals(this.end) && edge.end.equals(this.start));
    }
     
    @Override
    public int hashCode() {
        return Objects.hash(this.start, this.end) + Objects.hash(this.end, this.start);
    }
    
    
}
class Point {
        private int x;
        private int y;        
     
        public Point(int x, int y) {
            this.x = x;
            this.y = y;           
        }
        
        public int x() {
            return this.x;
        }
        
        public int y() {
            return this.y;
        }        
        
        public static Point of(int x, int y) {
            return new Point(x,y);
        }
    
        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            
            Point point = (Point) o;
            return (point.x() == this.x && point.y() == this.y);            
        }
     
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    } 

class Solution {            
    /*
    U: ( 0, +1) 
    D: ( 0, -1)
    R: ( 1,  0)    
    L: (-1,  0)
    */
    private Point calculateDirectPoint(char direction) {
        
        switch(direction) {
            case 'U':
                return new Point(0,1);
            case 'D':
                return new Point(0,-1);
            case 'R':
                return new Point(1,0);
            case 'L':
                return new Point(-1,0);
        }
        
        return null;
    }
    
    private Point calculateCurrentPoint(Point current, Point direct) {
        return Point.of(current.x() + direct.x(), current.y() + direct.y());
    }
    
    private boolean isMove(Point current) {
        return (current.x() >= -5 && 5 >= current.x()) && (current.y() >= -5 && 5 >= current.y());
    }
    
    public int solution(String dirs) {
        int answer = 0;
        Set<Edge> visited = new HashSet<>();
        Point current = Point.of(0,0);                
        int dirsSize = dirs.length();
        int index = 0;
        while(dirsSize-- > 0) {
            Point move = calculateDirectPoint(dirs.charAt(index++));    
            Point movedPoint = calculateCurrentPoint(current, move); 
            
            if(!isMove(movedPoint)) {
                continue;
            }            
            visited.add(Edge.of(current, movedPoint));
            current = movedPoint;
        }        
        
        // edgeDisplay(visited);
        return visited.size();
    }
    
    private void edgeDisplay(Set<Edge> edges) {
    System.out.println("========Edge==========");
        for(Edge edge : edges) {
            System.out.println(edge.start().x() +","+ edge.start().y()+ " ==> " + edge.end().x() +"," + edge.end().y());
        }
    }
    
    private void pointDisplay(Set<Point> points) {
            System.out.println("========points==========");
        for(Point point : points) {
            System.out.println(point.x() +","+ point.y());
        }
    }
}
