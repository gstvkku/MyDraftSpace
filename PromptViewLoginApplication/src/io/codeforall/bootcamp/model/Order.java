package io.codeforall.bootcamp.model;

public class Order {

    private String clientName;
    private String selectedBurguer;
    private String selectedBeverage;
    private String selectedDesert;
    private double finalPrice;

    public Order(String clientName) {
        this.clientName = clientName;
        this.selectedBurguer = null;
        this.selectedBeverage = null;
        this.selectedDesert = null;
        this.finalPrice = 0;
    }

    public String getSelectedBurguer() {
        return selectedBurguer;
    }

    public void setSelectedBurguer(String selectedBurguer) {
        this.selectedBurguer = selectedBurguer;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getSelectedDesert() {
        return selectedDesert;
    }

    public void setSelectedDesert(String selectedDesert) {
        this.selectedDesert = selectedDesert;
    }

    public String getSelectedBeverage() {
        return selectedBeverage;
    }

    public void setSelectedBeverage(String selectedBeverage) {
        this.selectedBeverage = selectedBeverage;
    }

    public String getClientName() {
        return clientName;
    }
}
