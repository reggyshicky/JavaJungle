import java.util.*;

public class StockPriceAnalysis {

    public static void main(String[] args) {
        // Initialize array with 10 stock prices
        float[] ArrStockPrices = {45.67f, 52.30f, 48.95f, 51.20f, 49.80f, 
                                   53.15f, 50.40f, 48.95f, 52.75f, 47.90f};
        
        // Initialize ArrayList with same prices
        ArrayList<Float> ArrListStockPrices = new ArrayList<>(Arrays.asList(
            45.67f, 52.30f, 48.95f, 51.20f, 49.80f, 53.15f, 50.40f, 48.95f, 52.75f, 47.90f
        ));
        
        System.out.println("========== STOCK PRICE ANALYSIS ==========\n");
        
        // Display the stock prices
        System.out.println("Stock Prices (Array): " + Arrays.toString(ArrStockPrices));
        System.out.println("Stock Prices (ArrayList): " + ArrListStockPrices);
        System.out.println();
        
        // Task 1: Calculate average price
        float avgArray = calculateAveragePrice(ArrStockPrices);
        float avgArrayList = calculateAveragePrice(ArrListStockPrices);
        System.out.println("1. AVERAGE STOCK PRICE:");
        System.out.println("   Array: " + avgArray);
        System.out.println("   ArrayList: " + avgArrayList);
        System.out.println();
        
        // Task 2: Find maximum price
        float maxArray = findMaximumPrice(ArrStockPrices);
        float maxArrayList = findMaximumPrice(ArrListStockPrices);
        System.out.println("2. MAXIMUM STOCK PRICE:");
        System.out.println("   Array: " + maxArray);
        System.out.println("   ArrayList: " + maxArrayList);
        System.out.println();
        
        // Task 3: Count occurrences of a specific price
        float targetPrice = 48.95f;
        int countArray = countOccurrences(ArrStockPrices, targetPrice);
        int countArrayList = countOccurrences(ArrListStockPrices, targetPrice);
        System.out.println("3. OCCURRENCE COUNT (Target Price: " + targetPrice + "):");
        System.out.println("   Array: " + countArray + " times");
        System.out.println("   ArrayList: " + countArrayList + " times");
        System.out.println();
        
        // Task 4: Compute cumulative sum
        ArrayList<Float> cumulativeSum = computeCumulativeSum(ArrListStockPrices);
        System.out.println("4. CUMULATIVE SUM (ArrayList):");
        System.out.println("   " + cumulativeSum);
        System.out.println();
        
        System.out.println("========== ANALYSIS COMPLETE ==========");
    }

    
    // Method 1: Calculate average price for ARRAY
    public static float calculateAveragePrice(float[] prices) {
        float sum = 0;
        for (float price: prices) {
            sum+=price;
        }
        return sum/prices.length;
    }

    // Method 1: Calculate average price for ARRAYLIST
    public static float calculateAveragePrice(ArrayList<Float> prices) {
        float sum = 0;
        for (float price: prices) {
            sum+=price;
        }
        return sum/prices.size();
    }

    // Method 2: Find maximum price for ARRAY
    public static float findMaximumPrice(float[] prices) {
        float max = prices[0];
        for (float price: prices) {
            if (price > max) {
                max = price;
            }
        }
        return max;
    }

    // Method 2: Find maximum price for ARRAYLIST
    public static float findMaximumPrice(ArrayList<Float> prices) {
        float max = prices.get(0);

        for (float price: prices) {
            if (price > max) {
                max = price;
            }
        }
        return max;
    }

    // Method 3: Count occurrences for ARRAY
    public static int countOccurrences(float[] prices, float targetPrice) {
        int count = 0;
        for (float price: prices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }

    // Method 3: Count occurrences for ARRAYLIST
    public static int countOccurrences(ArrayList<Float> prices, float targetPrice) {
        int count = 0;
        for (float price : prices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }

    // Method 4: Compute cumulative sum for ARRAYLIST
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;
        for (float price:prices) {
            sum+=price;
            cumulativeSum.add(sum);
        }
        return cumulativeSum;
     }
}




