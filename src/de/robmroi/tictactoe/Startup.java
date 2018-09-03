package de.robmroi.tictactoe;

public class Startup {
    static Service service;
    public static void main(String[] args){
        service = new Service();
        service.preStart();
    }
}
