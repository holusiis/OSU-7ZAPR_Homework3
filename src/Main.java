import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person[] arrayOfPerson = new Person[1000];
        Person.fillArray(arrayOfPerson);
        System.out.println(Arrays.toString(arrayOfPerson));
        Person person = arrayOfPerson[748];
        System.out.println(Arrays.toString(Person.findAllOldest(arrayOfPerson)));
        System.out.println(Arrays.toString(Person.findAllByName(arrayOfPerson, person.getName())));

    }
}