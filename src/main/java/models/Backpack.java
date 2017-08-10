package models;

/**
 * Created by Guest on 8/10/17.
 */
public class Backpack {
    private boolean map;
    private String things;
    private int wallet;
    private String userInput;
    private int money;

 //   public Backpack = new Backpack(boolean map, String things, int money);

    public Backpack(boolean map, String things, int wallet) {
        this.map = map;
        this.things = things;
        this.wallet = wallet;
    }

    public void flipTheBool(){
        this.map = false;
    }

    public void addSomthingYouForgot(){
        this.things += userInput; //"Also dont forget to bring extra socks!"
    }

    public void addMoneyToYourWallet(){
        this.wallet += money;
    }




    public boolean getMap() {
        return map;
    }

    public String getThings() {
        return things;
    }
    public int getMoney() {
        return money;
    }

    public String getUserInput() {
        return userInput;
    }

    public int getWallet() {
        return wallet;
    }
    public void setWallet(int wallet) {
        this.wallet = wallet;
    }


}