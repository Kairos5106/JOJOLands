/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSTeam3.source.DDDDC;

/**
 *
 * @EXTRA FEATURES NO.4 DIRTY DEEDS DONE CHEAP
 */
public class Neighbour {
    private Location location;
    private int distance;

    public Neighbour(Location location, int distance) {
        this.location = location;
        this.distance = distance;
    }

    public Location getLocation() {
        return location;
    }

    public int getDistance() {
        return distance;
    }
}
