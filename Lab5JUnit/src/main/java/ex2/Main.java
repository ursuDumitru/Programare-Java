package ex2;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        List<PerecheNumere> lista = new ArrayList<>();
        lista.add(new PerecheNumere(5, 2));
        lista.add(new PerecheNumere(100, 42));
        lista.add(new PerecheNumere(500, 1000));
        lista.add(new PerecheNumere(3, 5));
        lista.add(new PerecheNumere(34, 21 ));

        scriere(lista);

        List<PerecheNumere> l2 = citire();
        System.out.println(l2);

        for (var i : l2) {
            if(i.isConsecutiveFibbonaci())
                System.out.print(i.toString() + " sunt consecutive in fibonacci");
            else
                System.out.print(i.toString() + " nu sunt consecutive in fibonacci");

            System.out.println("\t||\t cmmmc : " + i.lcm());
        }
    }

    static void scriere(List<PerecheNumere> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/pereche_numere.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<PerecheNumere> citire() {
        try {
            File file=new File("src/main/resources/pereche_numere.json");
            ObjectMapper mapper=new ObjectMapper();
            List<PerecheNumere> lista = mapper
                    .readValue(file, new TypeReference<List<PerecheNumere>>(){});
            return lista;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
