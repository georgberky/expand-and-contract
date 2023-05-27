package dev.berky.georg.simple;

public record VisaApplicationId(String raw) {
    public VisaApplicationId {
        verify(raw);
    }

    private void verify(String visaApplicationId) {
        // a lot of verification code
        // possibly duplicated all over the place
        // or hidden in helper functions with unguessable names
        // because we're working on Strings
    }
}
