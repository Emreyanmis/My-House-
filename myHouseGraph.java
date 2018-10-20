package myHouse;


import java.util.*;
class myHouseGraph
{
    public static void main(String[] args)
    {
        int currentVertex, userChoice;
        Scanner input = new Scanner(System.in);
        final int KITCHEN = 0;
        final int ROOM_EMRE = 1;
        final int FRONT_FOYER = 2;
        final int BASEMENT = 3;
        final int DOWNSTAIRS = 4;
        final int UPSTAIRS = 5;
        final int LIVING_ROOM = 6;
        final int RESTROOM_DOWNSTAIRS  = 7;
        final int RESTROOM_UPSTAIRS_MAIN  = 8;
        final int RESTROOM_UPSTAIRS_SMALL  = 9;
        final int SITTING_ROOM = 10;
        final int ROOM_HALID_DIDAR = 11;
        final int ROOM_MUHAMMED_SAMI_BATUHAN = 12;
        

        // create graph using Author's Graph
        Graph myGraph = new Graph(13);

        // add labels
        myGraph.setLabel(KITCHEN,"Kitchen");
        myGraph.setLabel(BASEMENT, "Basement");
        myGraph.setLabel(ROOM_EMRE,"Room of Emre");
        myGraph.setLabel(FRONT_FOYER,"Front Foyer");
        myGraph.setLabel(UPSTAIRS,"Upstairs");
        myGraph.setLabel(SITTING_ROOM, "Sitting Room");
        myGraph.setLabel(DOWNSTAIRS,"Downstairs");
        myGraph.setLabel(LIVING_ROOM,"Living Room");
        myGraph.setLabel(RESTROOM_DOWNSTAIRS,"Restroom Downstairs");
        myGraph.setLabel(RESTROOM_UPSTAIRS_SMALL, "Restroom Upstairs -2");
        myGraph.setLabel(RESTROOM_UPSTAIRS_MAIN, "Resroom Upstairs - 1");
        myGraph.setLabel(ROOM_HALID_DIDAR, "ROOM of Adam and Jack");
        myGraph.setLabel(ROOM_MUHAMMED_SAMI_BATUHAN, "ROOM O MUHAMMED_SAMI_BATUHAN");

        // Add each edge (this undirected Graph has 7 edges,
        //                  so we add 14 edges)
        myGraph.addEdge(KITCHEN,SITTING_ROOM);
        myGraph.addEdge(SITTING_ROOM,KITCHEN);
        
        myGraph.addEdge(LIVING_ROOM,KITCHEN);
        myGraph.addEdge(KITCHEN,LIVING_ROOM);
        
        myGraph.addEdge(KITCHEN,DOWNSTAIRS);
        myGraph.addEdge(DOWNSTAIRS, KITCHEN);
        
        myGraph.addEdge(DOWNSTAIRS, BASEMENT);
        myGraph.addEdge(BASEMENT, DOWNSTAIRS);
        

        myGraph.addEdge(FRONT_FOYER,SITTING_ROOM);
        myGraph.addEdge(SITTING_ROOM,FRONT_FOYER);
        
   
        myGraph.addEdge(LIVING_ROOM,FRONT_FOYER);
        myGraph.addEdge(FRONT_FOYER, LIVING_ROOM);
        

        myGraph.addEdge(FRONT_FOYER, RESTROOM_DOWNSTAIRS);
        myGraph.addEdge(RESTROOM_DOWNSTAIRS, FRONT_FOYER);


        myGraph.addEdge(FRONT_FOYER, UPSTAIRS);
        myGraph.addEdge(UPSTAIRS, FRONT_FOYER);
       
        myGraph.addEdge(ROOM_HALID_DIDAR, RESTROOM_UPSTAIRS_MAIN);
        myGraph.addEdge(RESTROOM_UPSTAIRS_MAIN, ROOM_HALID_DIDAR);
        
        myGraph.addEdge(ROOM_HALID_DIDAR, UPSTAIRS);
        myGraph.addEdge(UPSTAIRS, ROOM_HALID_DIDAR);
               
        myGraph.addEdge(ROOM_EMRE,RESTROOM_UPSTAIRS_MAIN);
        myGraph.addEdge(RESTROOM_UPSTAIRS_MAIN, ROOM_EMRE);
        
        myGraph.addEdge(ROOM_EMRE,UPSTAIRS);
        myGraph.addEdge(UPSTAIRS, ROOM_EMRE);
        
        myGraph.addEdge(ROOM_EMRE,ROOM_HALID_DIDAR);
        myGraph.addEdge(ROOM_HALID_DIDAR, ROOM_EMRE);
        
        myGraph.addEdge(ROOM_MUHAMMED_SAMI_BATUHAN,UPSTAIRS);
        myGraph.addEdge(UPSTAIRS, ROOM_MUHAMMED_SAMI_BATUHAN);
        
        myGraph.addEdge(ROOM_MUHAMMED_SAMI_BATUHAN,ROOM_EMRE);
        myGraph.addEdge(ROOM_EMRE, ROOM_MUHAMMED_SAMI_BATUHAN);
        
        myGraph.addEdge(ROOM_MUHAMMED_SAMI_BATUHAN,ROOM_HALID_DIDAR);
        myGraph.addEdge(ROOM_HALID_DIDAR,ROOM_MUHAMMED_SAMI_BATUHAN);
        
        myGraph.addEdge(ROOM_MUHAMMED_SAMI_BATUHAN,RESTROOM_UPSTAIRS_MAIN);
        myGraph.addEdge(RESTROOM_UPSTAIRS_MAIN,ROOM_MUHAMMED_SAMI_BATUHAN);
        
        
        myGraph.addEdge(RESTROOM_UPSTAIRS_SMALL,ROOM_MUHAMMED_SAMI_BATUHAN);
        myGraph.addEdge(ROOM_MUHAMMED_SAMI_BATUHAN,RESTROOM_UPSTAIRS_SMALL);

        // let's pretend we are in FRONT_FOYER
        currentVertex = FRONT_FOYER;


        System.out.println("Welcome to my house!\n");

        do
        {
            // display the current vertex
            System.out.println("\nYou are currently in room "
                            + currentVertex + "-" + myGraph.getLabel(currentVertex));

            // display our neighbors
            System.out.println("neighbors of " + currentVertex + " are:");

            for (int neighbor : myGraph.neighbors(currentVertex))
                System.out.printf("%2d-%s\n",neighbor,myGraph.getLabel(neighbor));
            System.out.println();

            // suppose I was interacting with user, (hey, I am)
            // I will ask for their choice
            System.out.print("\nWhere would you like to go? (-1 to exit): ");
            userChoice = input.nextInt();

            // make sure not too small nor too big
            while (userChoice < -1 || userChoice >= myGraph.size())
            {
                System.out.println("\n" + userChoice + " is not a valid value");
                System.out.print("\nWhere would you like to go? (-1 to exit): ");
                userChoice = input.nextInt();
            }

            // if their choice is -1 then exit
            if (userChoice == -1)
                System.out.println("Good bye!");
            else
            {
                // if their choice is a valid neighbor
                if (myGraph.isEdge(currentVertex,userChoice))
                    currentVertex=userChoice; // then move to new vertex....
                else
                    // report the vertex they entered is unreachable
                    System.out.println("\nYou can't go to " + userChoice
                                        + "-" + myGraph.getLabel(userChoice)
                                        + " from " + currentVertex
                                        + "-" + myGraph.getLabel(currentVertex));
            }
        } while (userChoice != -1);
    }
 
}
	
	
	
