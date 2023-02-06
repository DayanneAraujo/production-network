package org.example.sample;

import org.example.sample.domain.linkedlist.LinkedListComponent;
import org.example.sample.domain.linkedlist.ProductionNetworkSampleLL;
import org.example.sample.infrastructure.LinkedListRepo;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ProductionNetworkSampleLL productionNetworkSample = new ProductionNetworkSampleLL();
        LinkedListRepo repo = new LinkedListRepo();
        Set<LinkedListComponent> sources = repo.fetchSources();

        for (LinkedListComponent source : sources) {
            System.out.println(productionNetworkSample.getProfile(source));
        }
    }
}
