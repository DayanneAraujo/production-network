package org.example.sample.domain.linkedlist;

import org.example.sample.domain.Component;

import java.util.Optional;

public class LinkedListComponent extends Component {
    private final LinkedListComponent next;

    public LinkedListComponent(String name, LinkedListComponent next, double distance, double temperature) {
        super(name, distance, temperature);
        this.next = next;
    }

    public Optional<LinkedListComponent> getNext() {
        return Optional.ofNullable(next);
    }
}
