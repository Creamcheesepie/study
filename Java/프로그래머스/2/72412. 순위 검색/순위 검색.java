import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();
        
        for(String str : info){
            String[] bits = str.split(" ");
            int score = Integer.parseInt(bits[4]);
            makeComb(bits, "", 0, score, map);
        }
        
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }
        
        int[] answer = new int[query.length];
        
        for(int i = 0; i<query.length; i++){
            String q = query[i].replaceAll(" and ", " ");
            String[] bits = q.split(" ");
            String key = bits[0] + bits[1] + bits[2] + bits[3];
            int scoreLimit = Integer.parseInt(bits[4]);
            
            answer[i] = search(key,scoreLimit, map);
        }
        return answer;
    }
    
    private void makeComb(String[] bits, String str, int depth, int score, Map<String, List<Integer>> map){
        if(depth == 4 ){
            map.computeIfAbsent(str, k -> new ArrayList<>()).add(score);
            return;
        }
        
        makeComb(bits, str + bits[depth], depth + 1, score, map);
        makeComb(bits, str + "-", depth + 1, score, map);
    }
    
    private int search(String key, int scoreLimit, Map<String,List<Integer>> map){
        if(!map.containsKey((key))) return 0;
        
        List<Integer> list = map.get(key);
        
        int st = 0;
        int end = list.size();
        
        while(st<end){
            int mid = (st + end) / 2;
            if(list.get(mid)>= scoreLimit){
                end = mid;
            } else {
                st = mid + 1;
            }
        }
        return list.size() - st;
    }
    
    //시간 초과로 사용 X
    private int[] oldVer(String[] info, String[] query){
        Map<String, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> scoreMap = new HashMap<>();
        Set<Integer> allIndex = new HashSet<>();
        
        for(int i = 0; i<info.length; i++){
            String[] bits = info[i].split(" ");
            
            for(int j = 0 ; j<bits.length - 1; j++){
                String bit = bits[j];
                Set<Integer> indexes = map.getOrDefault(bit, new HashSet<Integer>());
                indexes.add(i);
                map.put(bit, indexes);
            }
            scoreMap.put(i, Integer.parseInt(bits[bits.length - 1]));
            allIndex.add(i);
        }
        
        int[] answer = new int[query.length];
        int idx = 0;
        for(String q : query){
            String[] bits = q.split(" ");
            
            Set<Integer> intersection = new HashSet<>(allIndex);
            for(int i = 0; i<bits.length -1; i++){
                String bit = bits[i];
                if(bit.equals("and") || bit.equals("-")) continue;
                Set<Integer> indexes = map.get(bit);
                intersection.retainAll(indexes);
            }
            
            int cnt = 0;
            int scoreLimit = Integer.parseInt(bits[bits.length -1]);
            for(int index : intersection){
                int score = scoreMap.get(index);
                if(score >= scoreLimit){
                    cnt++;
                } 
            }
            answer[idx++] = cnt;
        }
        
        return answer;
    }
}