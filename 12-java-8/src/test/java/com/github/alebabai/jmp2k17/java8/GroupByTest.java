package com.github.alebabai.jmp2k17.java8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(JUnit4.class)
public class GroupByTest {

    @Test
    public void groupByCollectorTest() {
        final List<String> items = asList("a", "b", "c", "d", "a", "b", "b", "d");

        final Map<String, Long> result = items.stream()
                .collect(groupingBy(
                        Function.identity(),
                        Collectors.counting())
                );

        assertThat(result, hasEntry("a", 2L));
        assertThat(result, hasEntry("b", 3L));
        assertThat(result, hasEntry("c", 1L));
        assertThat(result, hasEntry("d", 2L));
    }
}
