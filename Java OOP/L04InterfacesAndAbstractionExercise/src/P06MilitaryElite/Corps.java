package P06MilitaryElite;

public enum Corps {
    AIRFORCES("Airforces"), MARINES("Marines");

    private String displayText;

    Corps(String displayText) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}
