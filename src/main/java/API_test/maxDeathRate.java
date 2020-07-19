package API_test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.ListIterator;

public class maxDeathRate {
    private int total_cases = 0;
    private int total_deaths = 0;
    private double death_rate;

    public maxDeathRate() { }

    public int getTotal_cases() {
        return total_cases;
    }

    public int getTotal_deaths() {
        return total_deaths;
    }

    public double getDeath_rate(String body) throws IOException {
        /*
        request res = new request(loc_id);
        HttpResponse<String> resJSON = res.getJSON();
        System.out.println(resJSON.statusCode());
        */
        //parse JSON
        ObjectMapper mapper = new ObjectMapper();
        List<covid19_entry> entries = mapper.readValue(body, new TypeReference<List<covid19_entry>>() {
        });
        ListIterator<covid19_entry> entryIterator = entries.listIterator();
        while(entryIterator.hasNext())
        {
            covid19_entry forward = entryIterator.next();
            if((forward.getTotal_cases() >= total_cases) &&
                    (forward.getTotal_deaths() >= total_deaths)) {
                total_deaths = forward.getTotal_deaths();
                total_cases = forward.getTotal_cases();
            }
        }
        death_rate = ((double)total_deaths / (double)total_cases);

        return death_rate;
    }
}
