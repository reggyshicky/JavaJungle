package com.ecommerce.JavaCollectionFramework;

public class Generics {
    public static void main(String[] args) {

        Integer[] intArray = {1,2,3,4,5};
        Double[] doubleArray = {1.4, 2.5, 4.9, 5.1};
        Character[] charArray = {'a', 'c', 'd', 'e'};
        String[] stringArray = {"g", "z", "op", "kite"};

        displayArray(intArray);
        displayArray(doubleArray);
        displayArray(charArray);
        displayArray(stringArray);

    }
    
    //T is just representation of generic ite, could be h, y, Thing anything i;e
    //pubic static <Thing> void display([Thing[] array)

    public static <Thing> void displayArray(Thing[] array) {
        for (Thing t: array) {
            System.out.println(t);
        }
        System.out.println();
    }
}