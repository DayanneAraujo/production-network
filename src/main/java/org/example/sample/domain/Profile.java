package org.example.sample.domain;

import java.util.HashMap;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(path, profile.path) && Objects.equals(coordinates, profile.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, coordinates);
    }
}
