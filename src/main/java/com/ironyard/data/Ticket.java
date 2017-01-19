package com.ironyard.data;

import java.util.Random;

/**
 * Created by osmanidris on 1/18/17.
 */
public class Ticket {
    private final int MAXNUM = 53;
    private final int MINNUM = 1;
    private int[] numbers = new int[6];

    public String getTicket() {
        return this.toString();
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    private String ticket;
    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public void generateTicket(){
        int randomNum;
        for (int i=0;i < 6; i++){
             randomNum = randInt(MINNUM, MAXNUM);
            while(contains(this.numbers,randomNum)) {
                randomNum = randInt(1, 53);
            }
            this.numbers[i] = randomNum;
        }
    }

    public boolean contains(int[] array, int key) {
        boolean flag = false;
        for(int j = 0; j < array.length; j++){
            if(array[j]==key) {
                flag = true;
            }
        }
        return flag;
    }

    public String toString(){
       String result = ""+this.numbers[0];
       for(int i = 1; i < this.numbers.length; i++){
           result = result+"-"+this.numbers[i];
       }
       return result;
    }
    private int randInt(int min, int max) {

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
