package br.empresa.locadora;

public class NewRelease extends Movie {

    public NewRelease(String title) {
        super(title);
    }

    public int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1)
            return 2;
        return 1;
    }

    public double getAmount(int daysRented) {
        return daysRented * 3;
    }
}
