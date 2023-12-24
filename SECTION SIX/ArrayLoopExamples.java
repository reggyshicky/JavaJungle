public class ArrayLoopExamples {

    public static void main(String[] args) {
        int[] numbers = {22, 24, 26, 29, 30};

        for (int number : numbers) {
            System.out.println(number);   // this is a foreach loop
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        String[] strArray = {"apple", "banana", "cherry"};

        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }

        // Example 3: Print every elements of an integer array while skipping one element
        System.out.println("Print every second element of an integer array");
        int[] grades = {95, 80, 85, 70, 90, 60, 88, 78};
        for (int i = 0; i < grades.length; i+=2) {
            System.out.println(grades[i]);
        }

        System.out.println("Double the elements of an integer array");
        int[] values = {3, 5, 7, 9, 11};
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i] * 2);
        }

        System.out.println("Write  the elements of a string array in caps");
        String[] colors = {"red", "green", "blue"};
        for (int i = 0; i < colors.length; i++) {
            System.out.println(colors[i].toUpperCase());
        }
        // Example 6: Find the index of a specific value in an integer array
        System.out.println("Find the index of a specific value in an integer array");
        int[] data = {4, 7, 4, 1, 4, 9, 4};
        int targetValue = 4;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == targetValue) {
                System.out.println(i);
            }
        }
    }
}
