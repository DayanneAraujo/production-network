package org.example.sample.domain.array;

import org.example.sample.domain.Component;

public class ArrayComponent extends Component {
    private final double distance;

    public ArrayComponent(String name, double distance, double temperature) {
        super(name, temperature);
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }
}
