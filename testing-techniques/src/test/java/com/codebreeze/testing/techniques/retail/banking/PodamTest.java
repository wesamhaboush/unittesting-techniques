package com.codebreeze.testing.techniques.retail.banking;

import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;

public class PodamTest {


    @Test
    public void testClassIsBeingRandomized(){
        //uses spring internally, but no body notices, I do not like it
        final Car car = new PodamFactoryImpl().manufacturePojo(Car.class);

        assertThat(car.registeredTo, notNullValue());
        assertThat(car.year, not(equalTo(0)));
        assertThat(car.wheels, notNullValue());
        assertThat(car.wheels.length, not(equalTo(0)));
        assertThat(car.wheels[0], notNullValue());
        assertThat(car.wheels[0].brand, notNullValue());
        assertThat(car.wheels[0].materialType, notNullValue());
        assertThat(car.wheels[0].age, not(equalTo(0)));
    }

    @Test
    public void testWithinTheBiggerContext(){
        //given
        final Car car = new PodamFactoryImpl().manufacturePojo(Car.class);

        //when
        final MyCar result = new CarToMyCarMapper().apply(car);

        //then
        assertThat(result.owner, equalTo(car.registeredTo));
        assertThat(result.registrationYear, equalTo(String.valueOf(car.year)));
    }

    private static class Car {
        private final String registeredTo;
        private final int year;
        private final Wheel[] wheels;


        private Car(final String registeredTo, final int year, final Wheel[] wheels) {
            this.registeredTo = registeredTo;
            this.year = year;
            this.wheels = wheels;
        }
    }

    private static class Wheel {

        enum MaterialType { Platic, Metal, Chrome, Aluminium;}

        private final String brand;
        private final long age;
        private final MaterialType materialType;

        private Wheel(final String brand, final long age, final MaterialType materialType) {
            this.brand = brand;
            this.age = age;
            this.materialType = materialType;
        }
    }

    private static class MyCar {
        private final String owner;
        private final String registrationYear;

        private MyCar(final String owner, final String registrationYear) {
            this.owner = owner;
            this.registrationYear = registrationYear;
        }
    }

    private static class CarToMyCarMapper implements Function<Car, MyCar>{

        @Override
        public MyCar apply(final Car car) {
            return new MyCar(car.registeredTo, String.valueOf(car.year));
        }
    }
}
