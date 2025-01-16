package org.utils;

import org.testng.*;

public class TestngListeners implements ISuiteListener, ITestListener {

    ////ISuiteListener
    @Override
    public void onStart(ISuite suite) {
        System.out.println("Starting Test Suite");
        System.out.println("**********************************************" + "\n");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Finished Test Suite");
        System.out.println("**********************************************" + "\n");
    }

    ////ITestListener
    @Override
    public void onStart(ITestContext context) {
        System.out.println("\n" + "**************************************************** " + "Test: ["
                + context.getName() + "] Started" + " ****************************************************" + "\n");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("\n" + "**************************************************** " + "Test: ["
                + context.getName() + "] Finished" + " ****************************************************" + "\n");
    }



}
