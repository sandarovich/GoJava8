package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.project.QuotaGenerator;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class QuotaGeneratorTest {
    @Test
    public void tetsQuoteGenerate() {
        QuotaGenerator qr = new QuotaGenerator();
        assertThat("Quota test", qr.getQuota(), is("\"Every big journey begins with a small step\""));
    }
}
