import java.util.*;

public class Person {
    //Random class for generating pseudo random numbers
    private static final Random random = new Random();
    //Attributes for Person class
    private final String name;
    private final String surname;
    private int yearOfBirth;
    //Calendar instance and getting current year
    private static final Calendar calendar = Calendar.getInstance();
    private static final int currentYear = calendar.get(Calendar.YEAR);
    //Creating bounds for random number generation
    private static final int origin = Person.getCurrentYear() - 100;
    private static final int bound = Person.getCurrentYear() + 1;
    /**
     * Constructor for object of class Person
     * @param name name of the person
     * @param surname surname of the person
     * @param yearOfBirth year of birth of the person
     */
    private Person(String name, String surname, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
    }
    //Getters and setters
    public String getName() {
        return name;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    public static int getOrigin() {
        return origin;
    }
    public static int getBound() {
        return bound;
    }
    private static int getCurrentYear() {
        return currentYear;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
    /**
     * Method for creating new random object of Person class
     * @return new random object of Person, temporarily name and surname as UUID
     */
    private static Person randomPersonGenerator() {
        String name = UUID.randomUUID().toString();
        String surname = UUID.randomUUID().toString();
        int yearOfBirth = random.nextInt(Person.getOrigin(), Person.getBound());
        return new Person(name, surname, yearOfBirth);
    }
    /**
     * Fills an array with Person objects
     * @param arrayOfPerson array which we want to get filled by objects
     */
    public static void fillArray(Person[] arrayOfPerson) {
        for(int i = 0; i < arrayOfPerson.length; i++) {
            arrayOfPerson[i] = Person.randomPersonGenerator();
        }
    }
    /**
     * Finds the oldest person in an array
     * @param arrayOfPerson array where we want to search
     * @return the oldest person as a Person object, if more have the same year of birth, returns the last one in an array
     */
    private static Person findOldest(Person[] arrayOfPerson) {
        Person oldest = Person.randomPersonGenerator();
        oldest.setYearOfBirth(Person.getBound() + 1);
        for (Person person : arrayOfPerson) {
            if(person.getYearOfBirth() < oldest.getYearOfBirth()) {
                oldest = person;
            }
        }
        return oldest;
    }
    /**
     * Finds the oldest Person and returns all of them in an array
     * @param arrayOfPerson array where we want to search
     * @return an array of all people with the lowest year of birth
     */
    public static Person[] findAllOldest(Person[] arrayOfPerson) {
        Person[] oldestArrayTemporary = new Person[arrayOfPerson.length];
        for(int i = 0, numberOfOldest = 0; i < arrayOfPerson.length; i++) {
            if(arrayOfPerson[i].getYearOfBirth() == Person.findOldest(arrayOfPerson).getYearOfBirth()) {
                oldestArrayTemporary[numberOfOldest] = arrayOfPerson[i];
                numberOfOldest++;
            }
        }
        return Arrays.stream(oldestArrayTemporary).filter(Objects::nonNull).toArray(Person[]::new);
    }
    /**
     * Finds all objects of class Person with the same name and returns an array of them
     * @param arrayOfPerson array where we want to search
     * @param name name of Person which we are searching for
     * @return an array of objects Person with the same name
     */
    public static Person[] findAllByName(Person[] arrayOfPerson, String name) {
        Person[] nameArrayTemporary = new Person[arrayOfPerson.length];
        for(int i = 0, numberWithSameName = 0; i < arrayOfPerson.length; i++) {
            if(arrayOfPerson[i].getName().equals(name)) {
                nameArrayTemporary[numberWithSameName] = arrayOfPerson[i];
                numberWithSameName++;
            }
        }
        return Arrays.stream(nameArrayTemporary).filter(Objects::nonNull).toArray(Person[]::new);
    }
}
