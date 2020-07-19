package API_test;

import org.cache2k.Cache;
import org.cache2k.Cache2kBuilder;

import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;

public class starter {
    public static void main(String[] args) throws InterruptedException {
        Cache<Integer, HttpResponse<String>> cache = new Cache2kBuilder<Integer, HttpResponse<String> >() {}
                .name("locationIdCache")
                .eternal(true)
                .entryCapacity(100)
                .build();

        for (int x=0; x < 50; x++)
        {
            ThreadRunner tmp = new ThreadRunner("T"+String.valueOf(x), cache);
            tmp.start();
            TimeUnit.SECONDS.sleep(2);
        }

    }
}

