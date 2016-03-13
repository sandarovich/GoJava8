package com.sandarovich.kickstarter.dao.quota;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Quota file mode test
 */

public class QuotaDaoFileImplTest {

    @Test
    public void testFillQuotas() throws
            IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Quota> quotas = objectMapper.readValue(
                getClass().getClassLoader().getResourceAsStream("quotaDaoFile.json"),
                objectMapper.getTypeFactory().constructCollectionType(
                        List.class, Quota.class));
        assertEquals(3, quotas.size());
    }
}