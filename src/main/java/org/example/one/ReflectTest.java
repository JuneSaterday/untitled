package org.example.one;

import org.example.one.domain.User;

import java.lang.annotation.Annotation;

public class ReflectTest {


    public static void main(String[] args) {


        Class<User> userClass = User.class;

        Annotation[] annotations = userClass.getAnnotations();


    }
}
