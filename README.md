# PolynomialCalculator

This application is a basic calculator that performs operations on polynoms. The User Interface is done with the help of Java Swing package

## Requirements

Running the program requires an IDE for Java development.
I personally use IntelliJ IDEA Community 2021.2.3

```bash
java --version
java 11.0.12 2021-07-20 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.12+8-LTS-237)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.12+8-LTS-237, mixed mode)
```

## Usage

The the application starts this is the window that the user will see. User can either write the polynom using his keyboard or using the buttons deisgned on the window.
The switch button is to be used when writing either the 1st or the 2nd polynom in the designed box.
![image](https://user-images.githubusercontent.com/69772634/205080769-60bb3421-c90b-4b87-ae10-49b2e34b9321.png)

All of the implemented operations cand be done on the given polynoms. To be noted that the polynoms might meet a speical requirement to avoid any typos. If any typo is meet,
the user will the a warning window.
![image](https://user-images.githubusercontent.com/69772634/205081260-6324e4c6-2422-45da-96eb-8b2fe6c213a7.png)


## Testing

The testing of the application is done using JUNIT. I have written a number of 18 tests in order to highlight the most common mistakes or special cases that my application
could meet and how they would be handled. All 18 tests passed successfully.
![image](https://user-images.githubusercontent.com/69772634/205081883-06eccea1-921b-4fcb-9742-45da36717abf.png)


## Further development

The application can be extended by adding other operations that can be performed on the polynoms, doing operation on 3 polynoms instead of 2, even implementing an algorithm
that solves a given polynom.
