package API_test;

import java.util.Date;

public class covid19_entry {
    private String _id;
    private String iso_code;
    private String continent;
    private String location;
    private String location_id;
    private String date;
    private int total_cases;
    private int new_cases;
    private int total_deaths;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIso_code() {
        return iso_code;
    }

    public void setIso_code(String iso_code) {
        this.iso_code = iso_code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotal_cases() {
        return total_cases;
    }

    public void setTotal_cases(int total_cases) {
        this.total_cases = total_cases;
    }

    public int getNew_cases() {
        return new_cases;
    }

    public void setNew_cases(int new_cases) {
        this.new_cases = new_cases;
    }

    public int getTotal_deaths() {
        return total_deaths;
    }

    public void setTotal_deaths(int total_deaths) {
        this.total_deaths = total_deaths;
    }

    @Override
    public String toString() {
        return "covid19_entry{" +
                "_id='" + _id + '\'' +
                ", iso_code='" + iso_code + '\'' +
                ", continent='" + continent + '\'' +
                ", location='" + location + '\'' +
                ", location_id='" + location_id + '\'' +
                ", date='" + date + '\'' +
                ", total_cases=" + total_cases +
                ", new_cases=" + new_cases +
                ", total_deaths=" + total_deaths +
                '}';
    }
}
