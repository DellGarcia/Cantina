package br.com.dellgarcia.cantina.models;

public class Item {

    private String name;
    private int quantity;
    private double value;
    private double finalValue;

    public Item(String name, double value, int quantity) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
        this.finalValue = value * quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(double finalValue) {
        this.finalValue = finalValue;
    }

    @Override
    public String toString() {
        return "Produto: " + name + " | R$ " + value + " | Qtd: " + quantity;
    }
}
