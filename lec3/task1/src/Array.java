

public class Array {
    static String s = "Mama mila ramu v Paris";

    public String split() {
        String arrayString = "";
        String[] mas = s.split("[,;:.!?\\s]+");

        for (int i = 0; i < mas.length; i++){
            if ((mas[i].charAt(0) >= 'A') && (mas[i].charAt(0) <= 'Z')){
                arrayString += mas[i];
            }
        }
        return arrayString;
    }
}

