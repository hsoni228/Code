package threading;

import java.util.concurrent.*;

public class Threadpool {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LinkedBlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(5);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 5, 10, TimeUnit.SECONDS, queue);
        Future<String> f = threadPoolExecutor.submit(() -> {
            System.out.println("heyy" + threadPoolExecutor.getActiveCount());
            return "hello";
        });

        System.out.println(f.get());
    }

    static String dedup(String inputStr, int chunkSize) {
        int len = inputStr.length();
        int steps = len / chunkSize;
        boolean visited[] = new boolean[steps + 1];
        String ans = "";
        for (int i = 0; i < steps; i++) {
            if (!visited[i]) {
                String s = inputStr.substring(i * chunkSize, (i + 1) * chunkSize);
                ans += s + " ";
                ans += (i + ",");
                visited[i] = true;
                for (int j = i + 1; j < steps; j++) {
                    if (!visited[j]) {
                        String copy = inputStr.substring(j * chunkSize, (j + 1) * chunkSize);
                        if (areEqual(s, copy)) {
                            ans += j + ",";
                            visited[j] = true;
                        }
                    }
                }
                ans += " ";
            }
        }
        return ans;
    }

    private static boolean areEqual(String s, String copy) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != copy.charAt(i))
                return false;
        }
        return true;
    }

    static String redup(String deduplicatedStr, int chunkSize) {
        String[] map = new String[10000];
        int maxIndex = 0;
        String chunks[] = deduplicatedStr.split(" ");
        for (int i = 0; i < chunks.length; i += 2) {
            String indexes[] = chunks[i + 1].split(",");
            String st = chunks[i];
            for (int j = 0; j < indexes.length; j++) {
                maxIndex = Integer.max(maxIndex, Integer.parseInt(indexes[j]));
                map[Integer.parseInt(indexes[j])] = st;
            }
        }
        String ans = "";

        for (int i = 0; i <= maxIndex; i++) {
            ans += map[i];
        }
        return ans;
    }
}
