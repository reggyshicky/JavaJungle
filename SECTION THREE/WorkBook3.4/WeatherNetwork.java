public class WeatherNetwork {
    public static void main(String[] args) {
        int temp = -1;
        String forecast;

        if (temp <= -1) {
            forecast = "The forecast is FREEZING Stay home";
        }  else if (temp <= 10) {
            forecast =  "The forecast is chilly.Weat a coat!";
        } else {
            forecast = "It's warm.Go outside";
        }
        System.out.println(forecast);
    

    }
}
