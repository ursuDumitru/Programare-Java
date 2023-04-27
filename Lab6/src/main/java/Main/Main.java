package Main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Angajat> angajati = citire();

        //<<----------- 1 ------------->>
        System.out.println("1");
        angajati.stream().forEach(System.out::println);
        //------------- 1 ---------------


        angajati.add(new Angajat("Zara", "sef", LocalDate.of(2021,8,31), 1.2f));
        angajati.add(new Angajat("Smara", "Manager", LocalDate.of(2020,7,23), 12555.566f));
        angajati.add(new Angajat("Maximilian", "director", LocalDate.of(2023,11,21), 10000000.222222222f));
        angajati.add(new Angajat("Andrei", "sef", LocalDate.of(2010,1,4), 2323.23232f));

        scriere(angajati);

        angajati.stream().forEach(System.out::println);

        //<<----------- 2 ------------->>
        System.out.println("\n\n\n2");
        angajati.stream()
                .filter(a -> a.getSalariu() >= 2500)
                .forEach(System.out::println);
        //------------- 2 ---------------

        //<<----------- 3 ------------->>
        System.out.println("\n\n\n3");
        String[] posturi = {"sef", "director"};

        angajati.stream()
                .filter(a -> a.getData_angajarii()
                    .isAfter(LocalDate.of(2022, 05, 01))
                    && (a.getPostul().contains(posturi[0])
                     || a.getPostul().contains(posturi[1])))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //------------- 3 ---------------

        //<<----------- 4 ------------->>
        System.out.println("\n\n\n4");

        angajati.stream()
                .filter(a -> !(a.getPostul().contains(posturi[0])
                         || a.getPostul().contains(posturi[1])))
                .sorted(Comparator.comparingDouble(Angajat::getSalariu).reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //------------- 4 ---------------





    }

    public static void scriere(List<Angajat> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.registerModule(new JavaTimeModule());
            File file = new File("src/main/resources/angajati_out.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Angajat> citire() {
        try {
            File file = new File("src/main/resources/angajati.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            return mapper
                    .readValue(file, new TypeReference<List<Angajat>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
