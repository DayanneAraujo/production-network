package org.example.sample.infrastructure;

import org.example.sample.domain.ComponentsRepository;
import org.example.sample.domain.binarytree.BinaryTreeComponent;

import java.util.Optional;
import java.util.Set;

public class BinaryTreeRepo implements ComponentsRepository<BinaryTreeComponent> {
    private BinaryTreeComponent sink = new BinaryTreeComponent("Sink", 0, 65, null, null);
    private BinaryTreeComponent gathering = new BinaryTreeComponent( "Gathering-Center-1", 200, 100, null, null);
    private BinaryTreeComponent compressor1 = new BinaryTreeComponent("Compressor-1", 400, 95, null, null);
    private BinaryTreeComponent valve1 = new BinaryTreeComponent("Valve-1", 300, 130, gathering, sink);
    private BinaryTreeComponent source1 = new BinaryTreeComponent("Source-1", 100, 100, valve1, compressor1);
    private BinaryTreeComponent compressor2 = new BinaryTreeComponent("Compressor-2", 100, 85, null, null);
    private BinaryTreeComponent valve2 = new BinaryTreeComponent("Valve-2", 50, 125, compressor2, gathering);
    private BinaryTreeComponent valve3 = new BinaryTreeComponent("Valve-3", 50, 115, sink, null);
    private BinaryTreeComponent source2 = new BinaryTreeComponent("Source-2", 50, 110, valve2, valve3);
    private BinaryTreeComponent valve4 = new BinaryTreeComponent("Valve-4", 150, 105, gathering, sink);
    private BinaryTreeComponent compressor3 = new BinaryTreeComponent( "Compressor-3", 250, 75, null, null);
    private BinaryTreeComponent source3 = new BinaryTreeComponent("Source-3", 50, 120, valve4, compressor3);

    public Set<BinaryTreeComponent> fetchInputComponents() {
        return Set.of(source1, source2, source3);
    }

    public Optional<BinaryTreeComponent> fetchComponentInput(String sourceName) {
        for (BinaryTreeComponent component : fetchInputComponents()) {
            if (component.getName().equals(sourceName)){
                return Optional.of(component);
            }
        }

        return Optional.empty();
    }
}
