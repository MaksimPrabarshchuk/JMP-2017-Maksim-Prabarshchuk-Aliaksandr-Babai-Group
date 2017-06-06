package com.github.alebabai.jmp2k17.java8;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(JUnit4.class)
public class MultimapTest {

    @Test
    public void whatIsMultimapTest() {
        final Multimap<String, Integer> multimap = ArrayListMultimap.create();
        final String aKey = "a";
        multimap.put(aKey, 1);
        multimap.put(aKey, 2);
        multimap.put(aKey, 3);

        final String bKey = "b";
        multimap.put(bKey, 4);
        multimap.put(bKey, 5);
        multimap.put(bKey, 6);

        assertThat(multimap.get(aKey), contains(1, 2, 3));
        assertThat(multimap.get(bKey), contains(4, 5, 6));
    }

    @Test
    public void multimapArrayListCollectorTest() {
        final Multimap<String, Data> multimap = Stream.of(
                new Data("a", "123"),
                new Data("a", "54sadf"),
                new Data("b", "121323"),
                new Data("c", "1as23"),
                new Data("d", "123adsf"),
                new Data("d", "1dafs23123"),
                new Data("d", "11adsf23"),
                new Data("a", "123534")
        ).collect(MultimapCollector.toArrayListMultimap(Data::getName, Function.identity()));

        assertThat(multimap.get("a"), contains(
                hasProperty("data", is("123")),
                hasProperty("data", is("54sadf")),
                hasProperty("data", is("123534"))
        ));
        assertThat(multimap.get("b"), contains(
                hasProperty("data", is("121323"))
        ));
        assertThat(multimap.get("c"), contains(
                hasProperty("data", is("1as23"))
        ));
        assertThat(multimap.get("d"), contains(
                hasProperty("data", is("123adsf")),
                hasProperty("data", is("1dafs23123")),
                hasProperty("data", is("11adsf23"))
        ));
    }
}
