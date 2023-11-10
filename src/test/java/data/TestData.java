package data;

import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData {


    private final Faker faker = new Faker(new Locale("ru"));
    private final Faker fakerEU = new Faker(new Locale("eu-US"));
    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = fakerEU.internet().emailAddress(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            gender = faker.options().option("Male", "Female", "Other"),
            yearBirth = String.valueOf(faker.number().numberBetween(1970, 1999)),
            monthBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
            dayBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
            subjects = faker.options().option("Arts", "Maths", "Hindi"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            address = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = setRandomCity(state),
            permanentAddress = faker.address().fullAddress();

    public static String setRandomCity(String state) {
        Faker faker = new Faker();
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return state;
        }

    }


}