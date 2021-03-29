package hellocucumber.model;

import java.util.List;

public class Root {

    public Root() {}

    public Root(List<Data> data) {
        this.data = data;
    }

    private List<Data> data;

    public void setData(List<Data> data){
        this.data = data;
    }
    public List<Data> getData(){
        return this.data;
    }

}
