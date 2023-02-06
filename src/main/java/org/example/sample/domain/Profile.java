package org.example.sample.domain;

import java.util.HashMap;

public class Profile {
    private final String path;
    private final HashMap<String, Coordinate> coordinates;

    public Profile(String path, HashMap<String, Coordinate> coordinates) {
        this.path = path;
        this.coordinates = coordinates;
    }

    public String getPath() {
        return path;
    }

    public HashMap<String, Coordinate> getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Profile { \n" +
                "path='" + path + "',\n\n" +
                "coordinates=\n" + coordinates + "\n" +
                "}\n\n";
    }
}
