public class Person {
    private String givenName;

    private String familyName;

    private String IDNumber;

    private int birthYear = 1900;

    private static final int VOTE_AGE = 18;

    private static final int SENIOR_AGE = 65;

    //Getter
    public String getGivenName(){
        return givenName;
    }

    //Setter
    public void setGivenName(String givenName){
        this.givenName = givenName;
        // this keyword is used to specify that the class variable is changing
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Person(){

    }
    public Person(String givenName, String familyName){
        this.givenName = givenName;
        this.familyName = familyName;
    }

    public boolean canVote(int year){
        return (year-birthYear) >= VOTE_AGE;
    }

    public String toString(){
        return "Given name: "+givenName+"\n"
                + "Family name: "+familyName;
    }

    public boolean equals(Person p){
        if(p==null){
            return false;
        }
        else{
            return this.familyName.equals(p.getFamilyName());
        }
    }
}
