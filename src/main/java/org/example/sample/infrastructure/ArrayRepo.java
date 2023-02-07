package org.example.sample.infrastructure;

import org.example.sample.domain.Component;
import org.example.sample.domain.ComponentsRepository;

import java.util.Optional;
import java.util.Set;

public class ArrayRepo implements ComponentsRepository<Component[]> {
    private Component sink = new Component("Sink", 0, 65);
    private Component gathering = new Component( "Gathering-Center-1", 200, 100);
    private Component compressor1 = new Component("Compressor-1", 400, 95);
    private Component valve1 = new Component("Valve-1", 300, 130);
    private Component source1 = new Component("Source-1", 100, 100);
    private Component compressor2 = new Component("Compressor-2", 100, 85);
    private Component valve2 = new Component("Valve-2", 50, 125);
    private Component valve3 = new Component("Valve-3", 50, 115);
    private Component source2 = new Component("Source-2", 50, 110);
    private Component valve4 = new Component("Valve-4", 150, 105);
    private Component compressor3 = new Component( "Compressor-3", 250, 75);
    private Component source3 = new Component("Source-3", 50, 120);

    @Override
    public Set<Component[]> fetchInputComponents() {
        Component[] path1 = {source1, valve1, compressor1, gathering, sink};
        Component[] path2 = {source2, valve2, valve3, compressor2, gathering, sink};
        Component[] path3 = {source3, valve4, compressor3, gathering, sink};

        return Set.of(path1, path2, path3);
    }

    @Override
    public Optional<Component[]> fetchComponentInput(String sourceName) {
        return Optional.empty();
    }
}
