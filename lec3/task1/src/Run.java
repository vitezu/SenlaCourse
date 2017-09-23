
class Run {
    private static final String OUT_SCREEN = "Words with a capital letter: ";
    public static void main(String[] args) {
       String s = "Mama mila ramu v Paris";
        Array array = new Array();
        System.out.println(OUT_SCREEN + array.selectUpWorlds(array.split(s)));
    }
}