package de.robmroi.ticktacktoe;

public class Startup {
    public static Service service;
    public static void main(String[] args){
        service = new Service();
        service.preStart();
    }
}