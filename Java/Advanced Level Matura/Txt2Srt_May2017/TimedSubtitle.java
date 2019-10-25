import java.util.Scanner;

public class TimedSubtitle {
    
    private String timing;
    private String subtitle;

    public TimedSubtitle(String timing, String subtitle) {
        this.timing = timing;
        this.subtitle = subtitle;
    }

    public String getTiming() {
        return timing;
    }

    public String getSubtitle() {
        return subtitle;
    }
    
    public int numberOfWords() {
        String[] wordsArray = subtitle.split(" ");
        return wordsArray.length;
    }
    
    public String srtTiming() {
        String part1 = convertToHHMMSS(timing.substring(0, 5));
        String part2 = convertToHHMMSS(timing.substring(8, 13));
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(part1)
                .append(" --> ")
                .append(part2);
        
        return sb.toString();
    }
     
//    private String convertToHHMMSS(String time) {
//        int allMinutes = Integer.parseInt(time.substring(0, 2));
//        int hours = allMinutes / 60;
//        int minutes = allMinutes % 60;
//        int seconds = Integer.parseInt(time.substring(3, 5));
//        
//        StringBuilder sb = new StringBuilder();
//        sb.append(hours < 10 ? "0" + hours : hours)
//                .append(":")
//                .append(minutes < 10 ? "0" + minutes : minutes)
//                .append(":")
//                .append(seconds < 10 ? "0" + seconds : seconds);
//        
//        return sb.toString();
//    }
    
//    public String convertToHHMMSS(String time) {
//        String[] splittedTime = time.split(":");
//        
//        int allMinutes = Integer.parseInt(splittedTime[0]);
//        int hours = allMinutes / 60;
//        int minutes = allMinutes % 60;
//        int seconds = Integer.parseInt(splittedTime[1]);
//        
//        
//        StringBuilder sb = new StringBuilder();
//        sb.append(hours < 10 ? "0" + hours : hours)
//                .append(":")
//                .append(minutes < 10 ? "0" + minutes : minutes)
//                .append(":")
//                .append(seconds < 10 ? "0" + seconds : seconds);
//        
//        return sb.toString();
//    }
    
    public String convertToHHMMSS(String time) {
        Scanner scanner = new Scanner(time);
        scanner.useDelimiter(":");
        
        int allMinutes = scanner.nextInt();
        int hours = allMinutes / 60;
        int minutes = allMinutes % 60;
        
        scanner.skip(scanner.delimiter());
        int seconds = scanner.nextInt();
        
        StringBuilder sb = new StringBuilder();
        sb.append(hours < 10 ? "0" + hours : hours)
                .append(":")
                .append(minutes < 10 ? "0" + minutes : minutes)
                .append(":")
                .append(seconds < 10 ? "0" + seconds : seconds);
        
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return timing + " " + subtitle;
    }
    
}
