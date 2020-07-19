package API_test;

import org.cache2k.Cache;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Random;

public class ThreadRunner extends Thread {
    private Thread t;
    private String threadName;
    private Cache<Integer, HttpResponse<String>> cache;

    ThreadRunner(String name, Cache<Integer, HttpResponse<String>> tmp) {
        threadName = name;
        cache = tmp;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        Random random = new Random();
        int loc_id = random.nextInt((212-1)) + 1;
        String body;
        HttpResponse<String> resJSON = null;
        //check cache
        if(cache.containsKey(loc_id))
        {
            resJSON = cache.peek(loc_id);
            System.out.println("Received from cache");
        }
        else {
            request res = new request(loc_id);
            try {
                resJSON = res.getJSON();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(resJSON.statusCode());
            cache.put(loc_id, resJSON);
        }
        maxDeathRate dr = new maxDeathRate();
        body = resJSON.body();

        threadLogger logger = threadLogger.getInstance();
        logger.logLocID(loc_id);
        try {
            System.out.println("Death rate for country " + String.valueOf(loc_id) + " : " + dr.getDeath_rate(body));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
