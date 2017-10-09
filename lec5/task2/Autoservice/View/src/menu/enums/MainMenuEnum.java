package menu.enums;

public enum MainMenuEnum {
    ACTIONS_OBJECT(1, "Actions Objects"),
    ORDER_SERVICE(2, "Order service"),
    PLACE_SERVICE(3, "Place service"),
    MASTER_SERVICE(4, "Master  service"),
    EXIT(5, "Exit");

    private final String message;
    private final int code;

    public static MainMenuEnum get(int code) {
        for (MainMenuEnum c : MainMenuEnum.values()) {
            if (code == c.code) {
                return c;
            }
        }
        return null;
    }

    MainMenuEnum(int code, String message) {
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
