package menu.enums;

public enum PlaceServiceEnum {
    GET_FREE_PLACES(1, "Get free places"),
    CALC_FREE_PLACES(2, "Calc free places"),
    BACK(3, "Back");

    private final String message;
    private final int code;

    public static PlaceServiceEnum get(int code) {
        for (PlaceServiceEnum c : PlaceServiceEnum.values()) {
            if (code == c.code) {
                return c;
            }
        }
        return null;
    }

    PlaceServiceEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

}
