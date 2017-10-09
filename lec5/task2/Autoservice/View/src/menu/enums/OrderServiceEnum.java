package menu.enums;

public enum OrderServiceEnum {
    SORT_BY_PRICE(1, "Sort by price of order"),
    SORT_BY_DATE_ORDER(2, "Sort by date of order"),
    SORT_BY_DATE_START(3, "sort By Date Of Start"),
    SORT_BY_DATE_EXECUTION(4, "sort By Date Of Execution"),
    SORT_BY_PRICE_OPERATION(5, "sort By Price Of Operation Order"),
    SORT_BY_DATE_OPERATION(6, "sort By Date Of Operation Order"),
    CANCEL_ORDER(7, "cancele Order"),
    CLOSE_ORDER(8, "close Order"),
    OPERATE_ORDER(9, "operate Order"),
    BACK(10, "Back");

    private final String message;
    private final int code;

    public static OrderServiceEnum get(int code) {
        for (OrderServiceEnum c : OrderServiceEnum.values()) {
            if (code == c.code) {
                return c;
            }
        }
        return null;
    }

    OrderServiceEnum(int code, String message) {
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
