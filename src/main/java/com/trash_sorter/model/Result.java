package com.trash_sorter.model;

import java.util.Objects;

public class Result {


    String barcode;
    String name;
    boolean isvalidate;

    public Result(String barcode, String name, boolean isvalidate) {
        this.barcode = barcode;
        this.name = name;
        this.isvalidate = isvalidate;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsvalidate() {
        return isvalidate;
    }

    public void setIsvalidate(boolean isvalidate) {
        this.isvalidate = isvalidate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return isvalidate == result.isvalidate &&
                Objects.equals(barcode, result.barcode) &&
                Objects.equals(name, result.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode, name, isvalidate);
    }
}
