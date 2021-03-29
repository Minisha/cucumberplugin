package hellocucumber.model;

public class Api {

    public Api() {}

    private String url;

    public Api(String url) {
        this.url = url;
    }

    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }

}
