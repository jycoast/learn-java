package modules.FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/1/5 23:00
 * 4
 */
public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wangwu", 40);

        List<Person> persons = Arrays.asList(person1, person2, person3);
        PersonTest personTest = new PersonTest();
        List<Person> persons2 = personTest.getPersonByAge(25, persons);
        persons2.forEach(System.out::println);

    }

    public List<Person> getPersonByUsername(String username, List<Person> persons) {
        return persons.stream().filter(person -> person.getUsername().equals(username)).collect(Collectors.toList());
    }

    public List<Person> getPersonByAge(int age, List<Person> persons) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageOfPerson, personList) -> {
            return personList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());
        };
        return biFunction.apply(age, persons);
    }
}
