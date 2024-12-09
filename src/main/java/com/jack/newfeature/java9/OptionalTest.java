package com.jack.newfeature.java9;

import com.jack.common.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * the following methods are provided in java9
 * ifPresentOrElse
 * or
 * stream
 *
 * the following methods are provided in java10
 * orElseThrow(), not orElseThrow(Supplier<? extends X> exceptionSupplier)
 *
 * the following methods are provided in java11
 * isEmpty
 *
 * no new methods have been provided since java12
 */
public class OptionalTest {
    public static void main(String[] args) {
        System.out.println(Optional.empty().or(() -> Optional.of("or default")).get());
        Optional.of("hello").ifPresentOrElse(System.out::println, () -> System.out.println("empty"));
        Optional.empty().ifPresentOrElse(System.out::println, () -> System.out.println("empty"));


        // stream method can be used to convert Optional to Stream
        Optional.of("123").stream().forEach(System.out::println);
        Stream<String> stream = Stream.of(Optional.of("123"), Optional.of("456"), Optional.of("789")).flatMap(Optional::stream);
        System.out.println(stream.collect(Collectors.toList()));


        List<Optional<User>> optionalUserList = new ArrayList<>();
        optionalUserList.add(Optional.of(new User("jack", 18)));
        optionalUserList.add(Optional.empty());
        optionalUserList.add(Optional.of(new User("tom", 25)));

        List<Optional<User>> filteredUserList = optionalUserList.stream().flatMap(Optional::stream).filter(user -> user.age() > 20).map(Optional::of).collect(Collectors.toList());
        filteredUserList.forEach(user -> {if (user.isPresent()) {System.out.println("the eligible person is ：" + user.get().name() + ", he is " + user.get().age());}});
    }
}
