package com.example.adventure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map <String, Integer> tempExit = new HashMap<String, Integer>();

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExit));


        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 5);
        tempExit.put("N", 2);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley besides stream", tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExit));




        int loc = 1;
        while(true){
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0){
                break;
            }

            Map <String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits are ");
            for(String exit: exits.keySet()){
                System.out.print(exit + ", ");
            }
            System.out.println();

            String east = "east";
            String west = "west";
            String south = "south";
            String north = "north";
            String quit = "quit";
            String direction = scan.nextLine().toUpperCase();

            if(direction.contains(east.toUpperCase())){
                direction = "E";
            }else if(direction.contains(west.toUpperCase())){
                direction = "W";
            }else if(direction.contains(south.toUpperCase())){
                direction = "S";
            }else if(direction.contains(north.toUpperCase())){
                direction = "N";
            }else if(direction.contains(quit.toUpperCase())){
                direction = "Q";
            }

            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            }else{
                System.out.println("You cannot go in that direction");
            }
        }

    }
}
