package menu.enums;

public enum MasterServiceEnum {
    SORT_BY_NAME(1, "Sort by name"),
    SORT_BY_STATE_FREE(2, "Sort by state free"),
    GET_ALL_MASTERS(3, "get All Masters"),
    BACK(4, "Back");

    private final String message;
    private final int code;

    public static MasterServiceEnum get(int code) {
        for (MasterServiceEnum c : MasterServiceEnum.values()) {
            if (code == c.code) {
                return c;
            }
        }
        return null;
    }

    MasterServiceEnum(int code, String message) {
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
