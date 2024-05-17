package com.tom.yang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.SequencedSet;
import java.util.stream.Collectors;

@Slf4j
@ExtendWith(MockitoExtension.class)
class TestSequenceCollection {

    @Test
    void test_sequenceSet() {
        SequencedSet<Integer> sequenceSet = new LinkedHashSet<>();

        sequenceSet.add(5);
        sequenceSet.add(3);
        sequenceSet.add(7);

        print(sequenceSet);

        // reverse order
        SequencedSet<Integer> reversedSet = sequenceSet.reversed();
        print(reversedSet);

        // add first, last
        reversedSet.addFirst(9);
        reversedSet.addLast(1);
        print(reversedSet);

        // get first, last
        log.info("First: {}", reversedSet.getFirst());
        log.info("Last: {}", reversedSet.getLast());
    }

    private <T> void print(Collection<T> collection) {
        String c = collection.stream().map(String::valueOf).collect(Collectors.joining(","));
        log.info("Collection: {}", c);
    }
}
