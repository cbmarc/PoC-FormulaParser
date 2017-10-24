package com.fullstackmarc.cmd.parser;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class KeywordExtractor {

    public List<String> extract(String input) {
        if (input == null) {
            return Lists.newArrayList();
        }
         return Lists.newArrayList(input.split("\\+")).stream().map(s -> s.trim()).collect(Collectors.toList());
    }

}
