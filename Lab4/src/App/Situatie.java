package App;
public class Situatie {
    public enum situatie {achizitionat, expus, vandut, nespecificat}

    public static situatie toSituatie(String s){
        switch (s) {
            case "achizitionat":
                return situatie.achizitionat;
            case "expus" :
                return situatie.expus;
            case "vandut" :
                return situatie.vandut;
        }
        return situatie.nespecificat;
    }
}

