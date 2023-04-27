package ex1;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<Integer, Carte> Carti = citire();
        Carti.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println();

        Carti.remove(2);
        Carti.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println();

        Carti.putIfAbsent(
                11111,
                new Carte("Misha pazitorul cainelui", "Dumitru Ursu", 2023));
        Carti.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println();

        scriere(Carti);

        Set<Carte> SetCarti = Carti.entrySet().stream()
                .filter(e -> e.getValue())
    }

    public static Map<Integer, Carte> citire() {
        try {
            File file = new File("C:\\Users\\dimau\\Desktop" +
                    "\\ProgramareJava\\Programare-Java\\Lab8\\src" +
                    "\\main\\resources\\colectie.json");
            ObjectMapper mapper = new ObjectMapper();
            Map<Integer, Carte> CartiMapLocal = mapper
                    .readValue(file, new TypeReference<Map<Integer, Carte>>() {});
            return  CartiMapLocal;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void scriere(Map<Integer, Carte> mapa) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/colectie_out.json");
            mapper.writeValue(file, mapa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
