import java.util.Arrays;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] mintable = new int[timetable.length];
        for(int i = 0; i<timetable.length; i++){
            mintable[i] = timeToMin(timetable[i]);
        }
        Arrays.sort(mintable);
        
        int busTime = 540; // 9:00 -> 560분
        int crewIdx = 0;
        int lastBusTime = 0;
        int lastCrewTime = 0;
        
        for(int i = 0; i<n; i++){
            int count = 0;
            while(count < m && crewIdx < mintable.length && mintable[crewIdx] <= busTime){
                lastCrewTime = mintable[crewIdx];
                crewIdx++;
                count++;
            }
            
            if(i == n - 1){
                if(count < m) return MinToString(busTime);
                else return MinToString(lastCrewTime - 1);
            }
            busTime += t;
        }
        return "";
    }
    
    private int timeToMin(String time){
        String[] bits = time.split(":");
        int hour = Integer.parseInt(bits[0]);
        int min = Integer.parseInt(bits[1]);
        return (hour * 60) + min;
    }
    
    private String MinToString(int min){
        return String.format("%02d:%02d", min/60 , min %60);
    }
}