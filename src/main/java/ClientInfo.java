public class ClientInfo {
    private String name;
    private String address;
    private String city;
    private String state;
    private int zipCode;

    public ClientInfo(String name, String address, String city, String state, String zipCode) {
        this.name = name;
        this.address = address;
        this.city = city;
        if(state.equals("")){
            if(city.toLowerCase().equals("portland")){
                this.state = "OR";
            }
            else  if(city.toLowerCase().equals("hillsboro")){
                this.state = "OR";
            }
            else if(city.toLowerCase().equals("salem")){
                this.state = "OR";
            }
            else if(city.toLowerCase().equals("beaverton")){
                this.state = "OR";
            }
            else if(city.toLowerCase().equals("oregon city")){
                this.state = "OR";
            }
            else if(city.toLowerCase().equals("milwaukie")){
                this.state = "OR";
            }
        }
        else{
            this.state = state;
        }

        this.zipCode = zipCode.equals("") ? 0 : Integer.valueOf(zipCode);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }
    
    public String toString(){
        return this.name + "\n" + this.address + "\n" + this.city + ", " + this.state + " " + Integer.valueOf(this.zipCode) + "\n";
    }
}
