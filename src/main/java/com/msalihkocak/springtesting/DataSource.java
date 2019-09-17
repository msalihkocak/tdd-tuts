package com.msalihkocak.springtesting;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataSource {
    private List<String> data = new LinkedList<>();

    public List<String> getAll() {
        return Collections.unmodifiableList(data);
    }

    public void add(String item) {
        data.add(item);
    }
}
