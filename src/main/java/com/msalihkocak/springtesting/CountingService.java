package com.msalihkocak.springtesting;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CountingService {
    private DataSource dataSource;

    public int getCount() {
        return dataSource.getAll().size();
    }
}
