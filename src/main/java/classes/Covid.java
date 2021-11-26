package classes;


import java.util.Date;
import java.util.List;



class General{
    public int infections;
    public int deaths;
    public int recovered;
}
class deathAgeRanges{
    public String ageRange;
    public int deaths;


}
class Today{
    public int newInfections;
    public int newDeaths;
    public List<deathAgeRanges>deathAgeRanges;
    public deathGender deathGender;
}
class deathGender{
    public int male;
    public int female;
}


public class Covid { //Wynik na calym swiecie | General

    public Date reportDate;
    public General general;
    public Today today;

}



