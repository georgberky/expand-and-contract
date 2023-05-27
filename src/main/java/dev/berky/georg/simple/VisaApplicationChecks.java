package dev.berky.georg.simple;

public class VisaApplicationChecks {
    public void checkVisaApplication(String visaApplicationId) {
        checkVisaApplication(new VisaApplicationId(visaApplicationId));
    }

    public void checkVisaApplication(VisaApplicationId visaApplicationId) {
        verify(visaApplicationId.raw());
        part1(visaApplicationId.raw());
        part2(visaApplicationId.raw());
        part3(visaApplicationId.raw());
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
