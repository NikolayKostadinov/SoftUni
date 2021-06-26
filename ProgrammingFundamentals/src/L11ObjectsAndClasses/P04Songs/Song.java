package L11ObjectsAndClasses.P04Songs;

public class Song {
    String typeList;
    String name;
    String time;

    public Song(String typeList, String name, String time) {
        this.typeList = typeList;
        this.name = name;
        this.time = time;
    }

    public String getTypeList() {
        return this.typeList;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
