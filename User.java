public class User {

    private String name;
    private int workingHours;
    private int overHours;

    User(String name){
        this.name = name;
    }



    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getWorkingHours(){
        return workingHours;
    }

    public void setOverHours(int overHours){
        this.overHours = overHours;
    }

    public int getOverHours() {
        return overHours;
    }
}
