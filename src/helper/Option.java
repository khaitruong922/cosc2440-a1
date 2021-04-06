package helper;

public class Option {
    private final String label;
    private final String toggleKey;
    private final Command command;
    private static final String[] fields = new String[]{"Input", "Action"};

    public static String[] getFields() {
        return fields;
    }

    public String[] toStringArray() {
        return new String[]{toggleKey, label};
    }

    public Option(String label, String toggleKey, Command command) {
        this.label = label;
        this.toggleKey = toggleKey;
        this.command = command;
    }

    public void execute() {
        command.execute();
    }

    public String getLabel() {
        return label;
    }

    public String getToggleKey() {
        return toggleKey;
    }
}