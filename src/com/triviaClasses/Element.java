package com.triviaClasses;

public class Element {
    public Element(int atomicNumber, String name, String elementalSymbol) {
        this.atomicNumber = atomicNumber;
        this.name = name;
        this.elementalSymbol = elementalSymbol;
    }

    int atomicNumber = this.atomicNumber;
    String name = this.name;
    String elementalSymbol = this.elementalSymbol;


    public String getElementalSymbol() {
        return elementalSymbol;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "[Number = " + this.atomicNumber + ", Name = " + this.name + ", Symbol = " + this.elementalSymbol + "]";
    }
}
