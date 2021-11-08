package P06MilitaryElite;

public enum State {
    INPROGRESS("inProgress"), FINISHED("finished");

   private String displayText;

    State(String displayName) {
        this.displayText = displayName;
    }

    public String getDisplayText() {
        return displayText;
    }
}

