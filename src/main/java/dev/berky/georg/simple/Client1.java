package dev.berky.georg.simple;

public class Client1 {
    private final VisaApplicationChecks visaApplicationChecks;

    public Client1(VisaApplicationChecks visaApplicationChecks) {
        this.visaApplicationChecks = visaApplicationChecks;
    }

    public void doSomething(String visaApplicationId) {
        visaApplicationChecks.checkVisaApplication(new VisaApplicationId(visaApplicationId));
    }
}
