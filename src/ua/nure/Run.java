package ua.nure;

import ua.nure.entity.Country;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        List<Country> countries = initCountries();

        defineMaxAreaAndPrintResult(countries);
        defineMinYearAndPrintResult(countries);
        sortByNameAndDisplay(countries);
        sortByLongAndDisplay(countries);
        displayOddYearDigitsCountries(countries);
        awaitInputAndDisplayEvenAreaBiggerThanEntered(countries);
    }

    private static void awaitInputAndDisplayEvenAreaBiggerThanEntered(List<Country> countries) {
        System.out.println("Enter a number from which even countries area should be found: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println("Country with an even area greater than a certain value entered from the keyboard: ");
        countries.stream().filter(c -> c.getArea() > input && c.getArea() % 2 == 0).forEach(System.out::println);

    }

    private static void displayOddYearDigitsCountries(List<Country> countries) {
        System.out.println("Countries with an odd sum of digits in the year of foundation: ");
        countries.stream().filter(c -> calculateDigitsSum(c.getCreationYear()) % 2 != 0).forEach(c -> System.out.println(c + " Digits sum: " + calculateDigitsSum(c.getCreationYear())));
        System.out.print(System.lineSeparator());
    }

    private static int calculateDigitsSum(int creationYear) {
        char[] chars = String.valueOf(creationYear).toCharArray();
        int sum = 0;
        for (char ch : chars) {
            sum += Character.getNumericValue(ch);
        }
        return sum;
    }

    private static void sortByLongAndDisplay(List<Country> countries) {
        System.out.println("Descending duration of existence: ");
        countries.stream()
                .sorted(Comparator.comparing((Country c) -> 2021 - c.getCreationYear()).reversed())
                .forEach(c -> System.out.println(c + " Exists " + (2021 - c.getCreationYear()) + " years"));
        System.out.print(System.lineSeparator());
    }

    private static void sortByNameAndDisplay(List<Country> countries) {
        System.out.println("List of countries sorted alphabetically: ");
        countries.stream().sorted(Comparator.comparing(Country::getName)).forEach(System.out::println);
        System.out.print(System.lineSeparator());
    }

    private static void defineMaxAreaAndPrintResult(List<Country> countries) {
        Country maxArea = countries.stream().max(Comparator.comparingDouble(Country::getArea)).orElse(new Country());
        System.out.println("Country with max area: " + maxArea + System.lineSeparator());
    }

    private static void defineMinYearAndPrintResult(List<Country> countries) {
        Country minYear = countries.stream().min(Comparator.comparingInt(Country::getCreationYear)).orElse(new Country());
        System.out.println("Country with min creation year: " + minYear + System.lineSeparator());
    }

    private static List<Country> initCountries() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Uganda", 1962, 241037));
        countries.add(new Country("Guatemala", 1821, 108889));
        countries.add(new Country("Singapore", 1965, 728.6f));
        countries.add(new Country("USA", 1776, 9519431));
        countries.add(new Country("Canada", 1867, 9984670));
        return countries;
    }
}
