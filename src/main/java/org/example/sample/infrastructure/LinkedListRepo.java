package org.example.sample.infrastructure;

import org.example.sample.domain.linkedlist.LinkedListComponent;
import org.example.sample.domain.ComponentsRepository;

import java.util.Optional;
import java.util.Set;

public class LinkedListRepo implements ComponentsRepository<LinkedListComponent> {
    private LinkedListComponent sink = new LinkedListComponent("Sink", null, 0, 65);
    private LinkedListComponent gathering = new LinkedListComponent("Gathering-Center-1", sink, 200, 100);
    private LinkedListComponent compressor1 = new LinkedListComponent("Compressor-1", gathering, 400, 95);
    private LinkedListComponent valve1 = new LinkedListComponent("Valve-1", compressor1, 300, 130);
    private LinkedListComponent source1 = new LinkedListComponent("Source-1", valve1, 100, 100);
    private LinkedListComponent compressor2 = new LinkedListComponent("Compressor-2", gathering, 100, 85);
    private LinkedListComponent valve3 = new LinkedListComponent("Valve-3", compressor2, 50, 115);
    private LinkedListComponent valve2 = new LinkedListComponent("Valve-2", valve3, 50, 125);
    private LinkedListComponent source2 = new LinkedListComponent("Source-2", valve2, 50, 110);
    private LinkedListComponent compressor3 = new LinkedListComponent("Compressor-3", gathering, 250, 75);
    private LinkedListComponent valve4 = new LinkedListComponent("Valve-4", compressor3, 150, 105);
    private LinkedListComponent source3 = new LinkedListComponent("Source-3", valve4, 50, 120);

    public LinkedListRepo() {}

    public LinkedListRepo(final LinkedListComponent sink,
                          final LinkedListComponent gathering,
                          final LinkedListComponent compressor1,
                          final LinkedListComponent valve1,
                          final LinkedListComponent source1,
                          final LinkedListComponent compressor2,
                          final LinkedListComponent valve3,
                          final LinkedListComponent valve2,
                          final LinkedListComponent source2,
                          final LinkedListComponent compressor3,
                          final LinkedListComponent valve4,
                          final LinkedListComponent source3) {
        this.sink = sink;
        this.gathering = gathering;
        this.compressor1 = compressor1;
        this.valve1 = valve1;
        this.source1 = source1;
        this.compressor2 = compressor2;
        this.valve3 = valve3;
        this.valve2 = valve2;
        this.source2 = source2;
        this.compressor3 = compressor3;
        this.valve4 = valve4;
        this.source3 = source3;
    }

    @Override
    public Set<LinkedListComponent> fetchSources() {
        return Set.of(
                this.source1,
                this.source2,
                this.source3
        );
    }

    @Override
    public Optional<LinkedListComponent> fetchSource(final String sourceName) {
        for (LinkedListComponent source : this.fetchSources()) {
            if (source.getName().equals(sourceName)) {
                return Optional.of(source);
            }
        }
        return Optional.empty();
    }

    public LinkedListComponent getSink() {
        return sink;
    }

    public LinkedListComponent getGathering() {
        return gathering;
    }

    public LinkedListComponent getCompressor1() {
        return compressor1;
    }

    public LinkedListComponent getValve1() {
        return valve1;
    }

    public LinkedListComponent getSource1() {
        return source1;
    }

    public LinkedListComponent getCompressor2() {
        return compressor2;
    }

    public LinkedListComponent getValve3() {
        return valve3;
    }

    public LinkedListComponent getValve2() {
        return valve2;
    }

    public LinkedListComponent getSource2() {
        return source2;
    }

    public LinkedListComponent getCompressor3() {
        return compressor3;
    }

    public LinkedListComponent getValve4() {
        return valve4;
    }

    public LinkedListComponent getSource3() {
        return source3;
    }
}
