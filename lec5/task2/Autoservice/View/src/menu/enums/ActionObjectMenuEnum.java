package menu.enums;

public enum ActionObjectMenuEnum {
    Add_ORDER(1, "Add Order"),
    ADD_PLACE(2, "Add Place"),
    ADD_MASTER(3, "Add Master"),
    DELETE_ORDER(4, "Delete Order"),
    DELETE_PLACE(5, "Delete Place"),
    DELETE_MASTER(6, "Delete Master"),
    BACK(7, "Back");

    private final String message;
    private final int code;

    public static ActionObjectMenuEnum get(int code) {
        for (ActionObjectMenuEnum c : ActionObjectMenuEnum.values()) {
            if (code == c.code) {
                return c;
            }
        }
        return null;
    }

    ActionObjectMenuEnum(int code, String message) {
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
