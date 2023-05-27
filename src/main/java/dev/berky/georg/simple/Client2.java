package dev.berky.georg.simple;

public class Client2 {
    private final VisaApplicationChecks visaApplicationChecks;

    public Client2(VisaApplicationChecks visaApplicationChecks) {
        this.visaApplicationChecks = visaApplicationChecks;
    }

    public void doSomething(String visaApplicationId) {
        visaApplicationChecks.checkVisaApplication(new VisaApplicationId(visaApplicationId));
    }
}
