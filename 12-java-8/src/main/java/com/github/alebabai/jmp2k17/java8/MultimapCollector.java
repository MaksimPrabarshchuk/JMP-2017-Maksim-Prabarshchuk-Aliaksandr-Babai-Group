package com.github.alebabai.jmp2k17.java8;


import com.google.common.collect.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

@Value
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MultimapCollector<T, A> implements Collector<T, A, A> {

    private static final Set<Characteristics> characteristics = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));

    private final Supplier<A> supplier;
    private final BiConsumer<A, T> accumulator;
    private final BinaryOperator<A> combiner;
    private final Function<A, A> finisher;

    MultimapCollector(Supplier<A> supplier,
                      BiConsumer<A, T> accumulator,
                      BinaryOperator<A> combiner) {
        this(supplier, accumulator, combiner, Function.identity());
    }

    public static <T, K, V, M extends Multimap<K, V>>
    MultimapCollector<T, M> toMultiMap(Function<? super T, ? extends K> keyMapper,
                                       Function<? super T, ? extends V> valueMapper,
                                       Supplier<M> mapSupplier) {
        final BiConsumer<M, T> accumulator = (map, element) -> map.put(keyMapper.apply(element), valueMapper.apply(element));
        return new MultimapCollector<>(
                mapSupplier,
                accumulator,
                (map1, map2) -> {
                    map1.putAll(map2);
                    return map1;
                });
    }

    public static <T, K, U>
    MultimapCollector<T, Multimap<K, U>> toHashMultiMap(Function<? super T, ? extends K> keyMapper,
                                                        Function<? super T, ? extends U> valueMapper) {
        return toMultiMap(keyMapper, valueMapper, HashMultimap::create);
    }

    public static <T, K, U>
    MultimapCollector<T, Multimap<K, U>> toLinkedHashMultiMap(Function<? super T, ? extends K> keyMapper,
                                                              Function<? super T, ? extends U> valueMapper) {
        return toMultiMap(keyMapper, valueMapper, LinkedHashMultimap::create);
    }

    public static <T, K, U>
    MultimapCollector<T, Multimap<K, U>> toArrayListMultimap(Function<? super T, ? extends K> keyMapper,
                                                             Function<? super T, ? extends U> valueMapper) {
        return toMultiMap(keyMapper, valueMapper, ArrayListMultimap::create);
    }

    public static <T, K extends Comparable<K>, U extends Comparable<U>>
    MultimapCollector<T, Multimap<K, U>> toTreeMultiMap(Function<? super T, ? extends K> keyMapper,
                                                        Function<? super T, ? extends U> valueMapper) {
        return toMultiMap(keyMapper, valueMapper, TreeMultimap::create);
    }

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }
}
