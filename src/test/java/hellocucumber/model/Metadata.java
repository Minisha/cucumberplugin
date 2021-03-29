package hellocucumber.model;

import java.util.List;

public class Metadata {

    public Metadata() {}

    public Metadata(String team, String microservice, List<String> jira) {
        this.team = team;
        this.microservice = microservice;
        this.jira = jira;
    }

    private String team;

    private String microservice;

    private List<String> jira;

    public void setTeam(String team){
        this.team = team;
    }
    public String getTeam(){
        return this.team;
    }
    public void setMicroservice(String microservice){
        this.microservice = microservice;
    }
    public String getMicroservice(){
        return this.microservice;
    }
    public void setJira(List<String> jira){
        this.jira = jira;
    }
    public List<String> getJira(){
        return this.jira;
    }
}
