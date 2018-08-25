
public class HelloWorld {
    public static void main(String[] args) {
        Person p = new Person("Matt", 29);
        p.greeting();
        p.celebrateBirthday();
        p.greeting();

        System.out.println(p.name);

        Person p1 = new AngryPerson("Mack", 29);
        p1.greeting();

        Person.test();

        Dog d = new Dog();
        example(d);
    }

    public static void example(Greeter g)
    {
        g.greeting();
    }
}

class Person implements Greeter
{
    protected int age;
    protected String name;

    public Person(String myName, int myAge)
    {
        name = myName;
        age = myAge;
    }

    public void greeting()
    {
        System.out.println("Hello, I'm " + name + " and " + age + " years old.");
    }

    public static void test()
    {
        System.out.println("hello from static");
    }

    public void celebrateBirthday()
    {
        age++;
    }
}

class AngryPerson extends Person
{
    public AngryPerson(String name, int age)
    {
        super(name, age);
    }

    public void greeting()
    {
        System.out.println("Blow me, asshole! " + name + " says fuck you!");
    }
}

class Dog implements Greeter
{
    public void greeting()
    {
        System.out.println("Fuck you, I'm a dog");
    }
}

interface Greeter
{
    public void greeting();
}
