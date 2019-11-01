import java.util.Scanner;

public class RaceData {

    private String team;
    private String name;
    private int age;
    private String raceTrack;
    private String lapTime;
    private int lap;

    public RaceData(String team, String name, int age, String raceTrack, String lapTime, int lap) {
        this.team = team;
        this.name = name;
        this.age = age;
        this.raceTrack = raceTrack;
        this.lapTime = lapTime;
        this.lap = lap;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRaceTrack() {
        return raceTrack;
    }

    public void setRaceTrack(String raceTrack) {
        this.raceTrack = raceTrack;
    }

    public String getLapTime() {
        return lapTime;
    }

    public void setLapTime(String lapTime) {
        this.lapTime = lapTime;
    }

    public int getLap() {
        return lap;
    }

    public void setLap(int lap) {
        this.lap = lap;
    }
    
    public int getSeconds() {
        Scanner scanner = new Scanner(lapTime);
        scanner.useDelimiter(":");
        int hour = scanner.nextInt();
        scanner.skip(scanner.delimiter());
        int min = scanner.nextInt();
        scanner.skip(scanner.delimiter());
        int sec = scanner.nextInt();
        
        return hour * 60 * 60 + min * 60 + sec;
    }
    
    @Override
    public String toString() {
        return team + " " + name + " " + age + " " + raceTrack + " " + lapTime + " " + lap;
    }
    
}
