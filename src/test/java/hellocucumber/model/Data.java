package hellocucumber.model;

public class Data {

    public Data() {}

    public Data(String id, Api api, Metadata metadata) {
        this.id = id;
        this.api = api;
        this.metadata = metadata;
    }

    private String id;

    private Api api;

    private Metadata metadata;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setApi(Api api){
        this.api = api;
    }
    public Api getApi(){
        return this.api;
    }
    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }
    public Metadata getMetadata(){
        return this.metadata;
    }
}
