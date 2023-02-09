package org.example.sample.infrastructure;

import org.example.sample.domain.Component;
import org.example.sample.domain.ComponentsRepository;
import org.example.sample.domain.array.ArrayComponent;

import java.util.Optional;
import java.util.Set;

public class ArrayRepo implements ComponentsRepository<ArrayComponent[]> {
    private ArrayComponent sink = new ArrayComponent("Sink", 0, 65);
    private ArrayComponent gathering = new ArrayComponent( "Gathering-Center-1", 200, 100);
    private ArrayComponent compressor1 = new ArrayComponent("Compressor-1", 400, 95);
    private ArrayComponent valve1 = new ArrayComponent("Valve-1", 300, 130);
    private ArrayComponent source1 = new ArrayComponent("Source-1", 100, 100);
    private ArrayComponent compressor2 = new ArrayComponent("Compressor-2", 100, 85);
    private ArrayComponent valve2 = new ArrayComponent("Valve-2", 50, 125);
    private ArrayComponent valve3 = new ArrayComponent("Valve-3", 50, 115);
    private ArrayComponent source2 = new ArrayComponent("Source-2", 50, 110);
    private ArrayComponent valve4 = new ArrayComponent("Valve-4", 150, 105);
    private ArrayComponent compressor3 = new ArrayComponent( "Compressor-3", 250, 75);
    private ArrayComponent source3 = new ArrayComponent("Source-3", 50, 120);

    @Override
    public Set<ArrayComponent[]> fetchInputComponents() {
        ArrayComponent[] path1 = {source1, valve1, compressor1, gathering, sink};
        ArrayComponent[] path2 = {source2, valve2, valve3, compressor2, gathering, sink};
        ArrayComponent[] path3 = {source3, valve4, compressor3, gathering, sink};

        return Set.of(path1, path2, path3);
    }

    @Override
    public Optional<ArrayComponent[]> fetchComponentInput(String sourceName) {
        return Optional.empty();
    }
}
