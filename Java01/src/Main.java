import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //stream / Lambda

        List<String> cities = new ArrayList<>();

        cities.add("cali");
        cities.add("bogota");
        cities.add("barcelona");
        cities.add("medellin");
        cities.add("bucaramanga");

//        //Lambda
//        cities.stream().forEach(city -> System.out.println(city));
//
//        cities.stream().forEach(System.out::println);
//
//        //Reference to method
//        cities.stream().forEach(Main::printCity);

        // Simple example of parallel - pipeline
//        cities.stream().parallel().forEach(Main::printCity);

        // Example of filter - pipeline
        cities.stream().filter(city -> city.startsWith("b"))
                .filter(city -> city.contains("c"))
                .forEach(System.out::println);

    }


    public static void printCity(String city){
        System.out.println(city);
    }

    public static boolean FilterCity(String city){
        return city.startsWith("b");
    }
}
