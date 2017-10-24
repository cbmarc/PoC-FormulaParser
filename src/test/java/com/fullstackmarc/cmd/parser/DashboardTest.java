package com.fullstackmarc.cmd.parser;

import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.*;

public class DashboardTest {

    private static final Logger LOG = Logger.getLogger(DashboardTest.class.toString());
    public static final int WAIT_TIME = 3000;

    private int failOnTry;

    @Test
    public void shouldWaitForDashboard() throws Exception {
        failOnTry = 0;
        Assert.assertThat(waitForDashboard(), is(true));

        failOnTry = 1;
        Assert.assertThat(waitForDashboard(), is(true));

        failOnTry = 2;
        Assert.assertThat(waitForDashboard(), is(false));

        failOnTry = -1;
        Assert.assertThat(waitForDashboard(), is(true));
    }

    public boolean waitForDashboard() {
        LOG.info("WaitForDashboard called.");
        // Let's try to load the dashboard for 3 tries
        for (int i = 0; i < 3; i++) {
            try {
                waitUntilElementWillBeAvailable("DASHBOARD", WAIT_TIME);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                // If dashboard did not load, for each attempt do a different thing
                determineActionToReachDashboard(i);
            }
        }
        return false;
    }

    private void determineActionToReachDashboard(int attempt) {
        switch (attempt) {
            case 0: // first failed attempt
                clickContinue();
                break;
            case 1: // second failed attempt
                refresh();
                break;
            case 2: // Oh crap!
                LOG.severe("Dashboard could not be reached.");
                break;
        }
    }

    private void refresh() {
    }

    private void clickContinue() {
    }

    private void waitUntilElementWillBeAvailable(String elementId, int time) throws Exception {
        LOG.info("Waiting for element " + elementId + " to show in " + time + " millis");
        if (time <= failOnTry) {
            throw new Exception("You are lost!");
        }
    }
}
