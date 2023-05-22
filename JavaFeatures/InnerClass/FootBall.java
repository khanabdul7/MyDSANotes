package JavaFeatures.InnerClass;


public class FootBall { // Outer Class
    String leagueName ;
    String coachName ;
    public FootBall(String leagueName, String coachName){
        this.leagueName = leagueName;
        this.coachName = coachName;
    }

    Player p = new Player("Khan","123456789");
    public void printInnerClassMembers(){
        System.out.println("PlayerName: "+p.playerName+" PhoneNumber: "+ p.phoneNumber);
    }
    class Player{  // Inner Class
        String playerName;
        String phoneNumber;

        public Player(String name, String number){
            playerName = name;
            phoneNumber = number;
        }

        public void PrintOuterClassMembers(){
            System.out.println("LeagueName: "+leagueName+" CoachName: "+coachName);
        }

    }

    public static void main(String[] args){

        // Instance of OuterClass
        FootBall f = new FootBall("LeagueOfLegends","CoachOfLegends");

        //calling
        f.printInnerClassMembers();
        f.p.PrintOuterClassMembers();
    }
}
