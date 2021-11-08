package P06MilitaryElite;

public class Mission {
    private String codeName;
    private State state;

    public Mission(String codeName, State state) {
        this.setCodeName(codeName);
        this.state = state;
    }

    public String getCodeName() {
        return codeName;
    }

    private void setCodeName(String codeName) {
        if (codeName.trim().isEmpty()) throw new IllegalArgumentException("Invalid partName");
        this.codeName = codeName;
    }

    public void completeMission(){
        this.state = State.FINISHED;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state.getDisplayText());
    }
}
