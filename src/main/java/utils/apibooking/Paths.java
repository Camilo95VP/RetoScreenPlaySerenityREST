package utils.apibooking;

public enum Paths {
    REQUEST_JSON_FILE_BOOKING(System.getProperty("user.dir")+"\\src\\test\\resources\\files\\apibooking\\createbooking\\createbooking.json"),
    REQUEST_JSON_FILE_TOKEN(System.getProperty("user.dir")+"\\src\\test\\resources\\files\\apibooking\\createtoken\\createtoken.json");

    private final String value;

    public String getValue() {
        return value;
    }

    Paths(String value){
        this.value=value;
    }
}
