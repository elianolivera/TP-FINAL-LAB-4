package tphotel;

import java.io.*;
import java.io.Serializable;
import java.util.Scanner;


public class Recepcionist extends User implements Serializable {

    public Recepcionist() {
        super();



    }
    public Recepcionist(String tipousuario, String usuario, String contraseña, String name, String lastname, int dni, String country, String city) {
        super(tipousuario, usuario, contraseña, name, lastname, dni, country, city);
    }
    public void loginReteptionist() {


        Recepcionist r4= new Recepcionist("Reteptionist","carlos","garcia","Carlos",".",13545257,"Argentina","Tandil");
                File mFile= new File("reteption.txt");
        if(!mFile.exists()){
            try {
                mFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(mFile.exists()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(mFile);
                ObjectOutputStream objOutputstream = new ObjectOutputStream(fileOutputStream);
                objOutputstream.writeObject(r4);

                Scanner tecladoss = new Scanner(System.in);
                String ingreso,users;
                int cont  = 0, bandera = 0;


                String pass = null; String usuarios = null;
                FileInputStream fileInputStream = new FileInputStream(mFile);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Object aux = objectInputStream.readObject();pass = ((Recepcionist) aux).getContraseña();  usuarios = ((Recepcionist) aux).getUsuario();
                System.out.println("=========LISTA DE RECEPCIONISTAS EN EL ARCHIVO===========: ");
                while (aux != null) {
                    if (aux instanceof Recepcionist) {
                        System.out.println(aux);
                        do {
                            System.out.print("\n======== INGRESE COMO RECEPCIONISTA: ======== ");
                            System.out.print("\n Ingrese el usuario: ");
                            users = tecladoss.nextLine();
                            System.out.print("Ingrese la contraseña: ");
                            ingreso = tecladoss.nextLine();
                            if (ingreso.equals(pass) && usuarios.equals(users)) {
                                System.out.print("Acceso correcto!");
                                System.out.print("Bienvenido\n ");
                                menuReceptionist();
                                System.exit(1);
                                bandera = 1;
                            } else {
                                System.out.print("Usuario o contraseña incorrectos, intente nuevamente !");
                                cont++;

                                if (cont == 3) {
                                    System.out.print("!Accesp restringido!");
                                    System.out.print("Bloqueando el sistema");
                                    System.exit(1);
                                }
                            }
                        }while ((cont != 3) && (bandera== 0));
                        aux = objectInputStream.readObject();
                    }
                }
                objectInputStream.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public void menuReceptionist() {
        int Opcion=0;
        System.out.print("\n ======== BIENVENIDO RECEPCIONISTA : ======== ");
        System.out.print("\n ======== RECEPCIONIST MENÚ : ======== ");
        String afirm="si"; String Scan=null;
        int Opcion2=0;
        System.out.println("\n1. Rooms");
        System.out.println(" 2. Check In");
        System.out.println(" 3. Check out");
        System.out.println(" 4. Room Booking");
        System.out.println(" 5. Cancel Booking");
        System.out.println(" 6. Guests");
        System.out.println(" 7. Settings ");
        System.out.println(" 8. Management Client ");
        System.out.println(" 0. Exit");

        System.out.print("\n ==== Seleccione opción que desee  ===: \n");
        Scanner teclado = new Scanner(System.in);
        Opcion = teclado.nextInt();
        switch (Opcion) {
            case 1:
                System.out.print("Room:\n");
                Room a = new Room(5,"En mantenimiento","Si", false);
                a.stateRoom();
                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuReceptionist();
                }
                break;

            case 2:
                System.out.print(" Check- in \n");
                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuReceptionist();
                }
                break;
            case 3:
                System.out.print("  Check- out \n");

                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuReceptionist();
                }
                break;
            case 4:
                System.out.print("Room Booking:\n");
                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuReceptionist();
                }
                break;
            case 5:
                System.out.print("Cancel Booking\n");
                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuReceptionist();
                }
                break;
            case 6:
                System.out.print("Guests \n");

                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuReceptionist();
                }
                break;
            case 7:
                System.out.print("Settings:\n");


                switch (Opcion2){
                    case 0:
                        menuReceptionist();
                }
                break;
            case 8:
                System.out.print("Management Client:\n");
                System.out.print("\n 1. Add Client ");
                System.out.print("\n 2. Modify Client");
                System.out.print("\n 3. Delete Client");
                System.out.print("\n 4. Sreach Client ");
                System.out.print("\n 5. Client List ");
                System.out.print("\n 0. Volver ");
                System.out.print("\n ==== Seleccione opción que desee  ===: \n");
                Scanner teclados2 = new Scanner(System.in);
                Opcion2 = teclado.nextInt();

                switch (Opcion2){
                    case 1:
                        System.out.print("Add Client \n");

                        System.out.print("Presione 0 para volver al menú \n");
                        Opcion2=teclado.nextInt();
                        switch (Opcion2){
                            case 0:
                                menuReceptionist();
                        }
                        break;

                    case 2:
                        System.out.print("Modify Client \n");

                        System.out.print("Presione 0 para volver al menú \n");
                        Opcion2=teclado.nextInt();
                        switch (Opcion2){
                            case 0:
                                menuReceptionist();
                        }
                        break;
                    case 3:
                        System.out.print("Delete Client\n");

                        System.out.print("Presione 0 para volver al menú \n");
                        Opcion2=teclado.nextInt();
                        switch (Opcion2){
                            case 0:
                                menuReceptionist();
                        }

                        break;
                    case 4:
                        System.out.print("Sreach Client\n");

                        System.out.print("Presione 0 para volver al menú \n");
                        Opcion2=teclado.nextInt();
                        switch (Opcion2){
                            case 0:
                                menuReceptionist();
                        }
                        break;

                    case 5:
                        System.out.print("List Clients \n");
                        System.out.print("Presione 0 para volver al menú \n");
                        Opcion2=teclado.nextInt();
                        switch (Opcion2){
                            case 0:
                                menuReceptionist();
                        }
                        break;
                    case 0:
                        System.out.print("Volver \n");
                        System.out.print("Presione 0 para volver al menú \n");
                        Opcion2=teclado.nextInt();
                        switch (Opcion2){
                            case 0:
                                menuReceptionist();
                        }
                        break;
                }
                break;

            case 0:
                System.out.print("Salir");

                System.exit(0);
                break;
        }
    }




    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Reteptionist{" +

                ", tipousuario='" + tipousuario + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dni=" + dni +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}