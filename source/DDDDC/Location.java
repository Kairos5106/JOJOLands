/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSTeam3.source.DDDDC;
import java.util.*;
/**
 *
 * @EXTRA FEATURES NO.4 DIRTY DEEDS DONE CHEAP
 */
public class Location {
    private String name;
    private List<Neighbour> neighbours;

    public Location(String name) {
        this.name = name;
        this.neighbours = new ArrayList<>();
    }

//    public void addNeighbour(Location location, int distance) {
//        neighbours.add(new Neighbour(location, distance));
//    }

    public String getName() {
        return name;
    }

    public List<Neighbour> getNeighbours() {
        return neighbours;
    }    

    void addNeighbour(Location location, int distance) {
       neighbours.add(new Neighbour(location, distance));
    }
}
