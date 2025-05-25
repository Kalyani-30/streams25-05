package com.neoteric.student.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo {
    public static void main(String[] args) {




        List<String> names =Arrays.asList("neo","tech","kallu");


        List<String>upperCaseName=names.stream()
                .filter(s->s.startsWith("k"))
                .map(b ->b.toUpperCase())
                .collect(Collectors.toList());

               System.out.println(upperCaseName);
    }
}
