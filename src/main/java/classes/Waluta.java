package classes;

public class Waluta {
    public String table;
    public String currency;
    public String code;
    public Rate[] rates;
}

class Rate {
    public String no;
    public String effectiveDate;
    public double mid;
}

