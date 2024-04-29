import java.util.LinkedList;import java.util.List;
public class Main {
    public static void main(String[] args) {
        System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
    }
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;         // 캐시크기가 0일 경우
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        List<String> caches = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase(); // 대소문자 구분이 없다.            // cache miss
            if (!caches.contains(city)) {
                answer += 5;
                if (caches.size() >= cacheSize) {                    // 가장 앞에 있는것이 오랫동안 사용하지 않은 캐시므로 0번째를 제거
                    caches.remove(0);                }
                caches.add(city);
                continue;            }             // cache hit
            if (caches.contains(city)) {
                caches.remove(city);
                caches.add(city);
                answer += 1;
            }
        }
        return answer;
    }
}