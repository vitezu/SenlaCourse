

public class Array {

    public String[] split(String s) {
        String[] mas = s.split("[!,\\s]+");
        return mas;
    }

    public String selectUpWorlds(String[] mas) {
        String arrayToString = "";
        for (int i = 0; i < mas.length; i++){
            if ((mas[i].charAt(0) >= 'A') && (mas[i].charAt(0) <= 'Z')){
                arrayToString += mas[i];
            }
        }
        return arrayToString;
    }
}

