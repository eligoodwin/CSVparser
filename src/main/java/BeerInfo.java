public class BeerInfo {
    private String beerName;
    private String beerStyle;
    private String hopsUsed;
    private String abv;
    private String ibu;

    public BeerInfo(String beerName, String beerStyle, String hopsUsed, String abv, String ibu) {
        this.beerName = beerName;
        this.beerStyle = beerStyle;
        this.hopsUsed = hopsUsed;
        this.abv = abv;
        this.ibu = ibu;
    }

    public String getBeerName() {
        return beerName;
    }

    public String getBeerStyle() {
        return beerStyle;
    }

    public String getAbv() {
        return abv;
    }

    public String getIbu() {
        return ibu;
    }


    @Override
    public String toString(){
        return String.format("name: %s, style: %s, hops: %s, abv: %s, ibu: %s",
                beerName, beerStyle, hopsUsed, abv, ibu);
    }
}
