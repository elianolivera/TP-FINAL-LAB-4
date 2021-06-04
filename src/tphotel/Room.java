package tphotel;

import java.util.Scanner;

public class Room extends User{

    private int numeroHab;
    private String state;
    private String mantenimiento;
    private boolean ocupacticion;

    public Room( String usuario,  String name, String lastname, int numeroHab, String state, String mantenimiento, boolean ocupacticion) {
        super( usuario, name, lastname);
        this.numeroHab = numeroHab;
        this.state = state;
        this.mantenimiento = mantenimiento;
        this.ocupacticion = ocupacticion;
    }

    public Room(int numeroHab, String state, String mantenimiento, boolean ocupacticion) {

        this.numeroHab = numeroHab;
        this.state = state;
        this.mantenimiento = mantenimiento;
        this.ocupacticion = ocupacticion;
    }

    public void stateRoom(){
  int Room=0;
        System.out.print("----------------------------------------------------\n");
        System.out.print("Ingrese el numero de habitacion para conocer su estado:\n");
        System.out.print("----------------------------------------------------\n");
        Scanner tecladoss = new Scanner(System.in);
        Room=tecladoss.nextInt();
        if (Room >15){
            System.out.print("----------------------------------------------------\n");
            System.out.print("LA HABITACIÓN ESTA LIBRE\n");
            System.out.print("----------------------------------------------------\n");

        }else if (Room<15){
            System.out.print("----------------------------------------------------\n");
            System.out.print("LA HABITACIÓN ESTA EN MANTENIMIENTO\n");
            System.out.print("----------------------------------------------------\n");
        }else if(Room<50 && Room>28){
            System.out.print("----------------------------------------------------\n");
            System.out.print("LA HABITACIÓN ESTA OCUPADA\n");
            System.out.print("----------------------------------------------------\n");
        }


    }

    @Override
    public String toString() {
        return "Room:" +
                "numeroHab=" + numeroHab +
                ", state='" + state + '\'' +
                ", mantenimiento='" + mantenimiento + '\'' +
                ", ocupacticion=" + ocupacticion +


                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}


