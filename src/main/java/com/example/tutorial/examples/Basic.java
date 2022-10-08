package com.example.tutorial.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Basic {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        //new Basic().printList(Arrays.asList(3,6,5));

        new Basic().printUsers(Collections.singletonList(new Basic.User(Arrays.asList(3, 6, 5))));
    }


    static class User {

        User(List<Integer> numbers) {
            this.numbers = numbers;
        }

        List<Integer> numbers;

        public List<Integer> getNumbers() {
            return numbers;
        }
    }

    public void printUsers(List<User> users) {
        List<Integer> opt = users.stream()
                .map(user -> user.getNumbers().stream())
                .flatMap(number -> number.filter(value -> value > 3))
                .collect(Collectors.toList());

        Stream<Integer> opt2 = users.stream()
                .map(user -> user.getNumbers().stream())
                .flatMap(number -> number.filter(value -> value > 3)).parallel();

        opt2.forEach(System.out::println);
    }

    public void printList(List<Integer> numbers) {
        //List<Integer> numb = numbers.stream().filter(number -> number > 3).collect(Collectors.toList());

        Optional<Integer> num2 = numbers.stream().filter(number -> number > 3).findAny();
        //num2.ifPresent(System.err::println);
        //num2.ifPresent(Basic::print);

        numbers.stream().filter(number -> number > 3).forEach(System.out::println);
    }

    public static void print(Integer n) {
        System.out.println(n);
    }

    public int summation(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }

        return sum;
    }

    public boolean isTrue(String value) {
        return value.equals("Y");
    }
}
