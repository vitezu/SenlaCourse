package menu;

public enum Command {
    SORT_NAME_MASTER(0,"Sorted by name of master"),
    SORT_STATE_MASTER(1,"Sorted by state free of master"),
    GET_ALL(2,"Get all masters"),
    DELETE(3,"Delete master"),
    ADD(4,"Add master"),
    EXIT(5,"Exit");

    private final String message;
    private final int code;

    public static Command get(int code) {
        for(Command c : Command.values()) {
            if(code==c.code) {
                return c;
            }
        }
        return null;
    }

    Command(int code, String message) {
        this.code= code;
        this.message = message;
    }
    public int getCode() { return this.code; }
    public String message() { return this.message; }
}