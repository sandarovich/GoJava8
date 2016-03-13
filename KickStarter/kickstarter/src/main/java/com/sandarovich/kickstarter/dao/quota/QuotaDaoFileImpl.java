package com.sandarovich.kickstarter.dao.quota;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Quota Dao file mode
 */

public class QuotaDaoFileImpl extends QuotaDaoMemoryImpl {
    public QuotaDaoFileImpl() {
        fillQuotas();
    }
    @Override
    void fillQuotas() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.quotas = objectMapper.readValue(
                    getClass().getClassLoader().getResourceAsStream("quotaDaoFile.json"),
                    objectMapper.getTypeFactory().constructCollectionType(
                            List.class, Quota.class));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
