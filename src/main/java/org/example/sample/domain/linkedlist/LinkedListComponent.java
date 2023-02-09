package org.example.sample.domain.linkedlist;

import org.example.sample.domain.Component;

import java.util.Optional;

public class LinkedListComponent extends Component {
    private final LinkedListComponent next;
    private final double distance;

    public LinkedListComponent(String name, LinkedListComponent next, double distance, double temperature) {
        super(name, temperature);
        this.next = next;
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public Optional<LinkedListComponent> getNext() {
        return Optional.ofNullable(next);
    }
}
