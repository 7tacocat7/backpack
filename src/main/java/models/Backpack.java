package models;

import java.util.ArrayList;

/**
 * Created by Guest on 8/10/17.
 */
public class Backpack {
    private boolean map;
    private String things;
    private int wallet;
    private String userInput;
    private static ArrayList<Backpack> instances = new ArrayList<>();
    private int id;


    public Backpack(boolean map, String things, int wallet) {
        this.map = map;
        this.things = things;
        instances.add(this);
        this.id=instances.size();
    }
    public static ArrayList<Backpack> getAll() {
        return instances;
    }

    public boolean getMap() {
        return map;
    }

    public String getThings() {
        return things;
    }

    public int getId() {
        return id;
    }

    public int getWallet() {
        return wallet;
    }
    public void setWallet(int wallet) {
        this.wallet = wallet;
    }
    public static Backpack findById(int id){
        return instances.get(id-1); //why minus 1? See if you can figure it out.
    }


}