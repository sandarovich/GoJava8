package com.sandarovich.kickstarter.dao.quota;

import com.sandarovich.kickstarter.KickStarter;
import com.sandarovich.kickstarter.dao.DaoMode;
import com.sandarovich.kickstarter.io.ConsoleIO;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class QuotaDaoMemoryTest {

    @Test
    public void testGetQuotaInListByIndex() {
        QuotaDaoMemoryImpl qr = new QuotaDaoMemoryImpl();
        qr.fillQuotas();
        Quota quota = new Quota("Mr Y", "No pain, no gain");
        assertThat("Quota test", qr.getQuotaById(1), is(quota));
    }

    @Test
    public void testWrongQuotaIndex() {
        QuotaDaoMemoryImpl qr = new QuotaDaoMemoryImpl();
        qr.fillQuotas();
        Quota quota = new Quota("Mr X", "Every big journey begins with a small step");
        assertThat("Wrong Quota index test", qr.getQuotaById(7), is(quota));
    }

    @Test
    public void testRandomQuota() {
        //given
        QuotaDaoMemoryImpl qr = mock(QuotaDaoMemoryImpl.class);
        qr.fillQuotas();
        when(qr.getRandomQuota()).thenReturn(new Quota("z", "z"));
        //when
        new KickStarter(new ConsoleIO(), DaoMode.MEMORY).run();

        //then
        assertThat("Quota test", qr.getRandomQuota(), is(new Quota("z", "z")));
    }

}
