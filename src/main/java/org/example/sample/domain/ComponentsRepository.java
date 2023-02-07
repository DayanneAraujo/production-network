package org.example.sample.domain;

import java.util.Optional;
import java.util.Set;

public interface ComponentsRepository<T> {
    Set<T> fetchInputComponents();
    Optional<T> fetchComponentInput(final String sourceName);
}

