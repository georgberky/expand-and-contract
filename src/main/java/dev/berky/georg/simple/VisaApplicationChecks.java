package dev.berky.georg.simple;

public class VisaApplicationChecks {
    public void checkVisaApplication(String visaApplicationId) {
        verify(visaApplicationId);
        part1(visaApplicationId);
        part2(visaApplicationId);
        part3(visaApplicationId);
    }

    private void verify(String visaApplicationId) {
        // a lot of verification code
        // possibly duplicated all over the place
        // or hidden in helper functions with unguessable names
        // because we're working on Strings
    }

    private void part1(String visaApplicationId) {
        // part of actual logic
    }

    private void part2(String visaApplicationId) {
        // part of actual logic
    }

    private void part3(String visaApplicationId) {
        // part of actual logic
    }
}
