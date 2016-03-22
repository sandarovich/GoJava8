package com.sandarovich.kickstarter.dao.quote;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Quote file mode test
 */

public class QuoteDaoFileImplTest {

    @Test
    public void testFillQuotas() throws
            IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Quote> quotes = objectMapper.readValue(
                getClass().getClassLoader().getResourceAsStream("quotaDaoFile.json"),
                objectMapper.getTypeFactory().constructCollectionType(
                        List.class, Quote.class));
        assertEquals(3, quotes.size());
    }
}