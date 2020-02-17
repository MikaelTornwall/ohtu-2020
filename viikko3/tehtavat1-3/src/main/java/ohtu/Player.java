package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private int goals;
    private int assists;
    private int penalties;
    private String team;
    private String nationality;
    private String birthdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    
    public int getScore() {
        return goals + assists;
    }
    
    public int compareTo(Player other) {
        return other.getScore() - getScore();
    }

    @Override
    public String toString() {
        if (name.length() > 15) {
            return name + "\t" + team + "\t" + goals + " + " + assists + " = " + getScore();
        }
        return name + "\t\t" + team + "\t" + goals + " + " + assists + " = " + getScore();
    } 
}
