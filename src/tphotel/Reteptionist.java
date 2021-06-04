package tphotel;

import java.io.*;
import java.io.Serializable;
import java.util.Scanner;


public class Reteptionist extends User implements Serializable {
    private int id;
    public Reteptionist() {
        super();

    }
    public Reteptionist(String tipousuario, String usuario, String contraseña, String name, String lastname, int dni, String country, String city,int id) {
        super(tipousuario, usuario, contraseña, name, lastname, dni, country, city);
    }
    public void loginReteptionist() {

        Reteptionist r4= new Reteptionist("Admin","pablo","perez","carolina","pampita",13545257,"Argentina","Tandil",4);
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
                Object aux = objectInputStream.readObject();pass = ((Reteptionist) aux).getContraseña();  usuarios = ((Reteptionist) aux).getUsuario();
                System.out.println("=========LISTA DE RECEPCIONISTAS EN EL ARCHIVO===========: ");
                while (aux != null) {
                    if (aux instanceof Reteptionist) {
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
                                menuReteptionist();
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
    public void menuReteptionist() {
        int Opcion=0;
        System.out.print("\n ======== BIENVENIDO RECEPCIONISTA : ======== ");
        String afirm="si"; String Scan=null;
        int Opcion2=0;
        System.out.print("\n 1- Check-in ");
        System.out.print("\n 2- Check-out ");
        System.out.print("\n 3- Alta de Clientes ");
        System.out.print("\n 4- Baja de Clientes");
        System.out.print("\n 5- Modificación");
        System.out.print("\n 6- Listar Usuarios ");
        System.out.print("\n 7- Habitaciónes");
        System.out.print("\n 8- Salir");
        System.out.print("\n ==== Seleccione opción que desee  ===: \n");
        Scanner teclado = new Scanner(System.in);
        Opcion = teclado.nextInt();
        switch (Opcion) {
            case 1:
                System.out.print(" Realizar el Check - IN:\n");
                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                       menuReteptionist();
                }
                break;

            case 2:
                System.out.print("Realizar Check- out \n");
                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuReteptionist();
                }
                break;
            case 3:
                System.out.print("Realizar alta de clientes\n");

                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuReteptionist();
                }
                break;
            case 4:
                System.out.print("Realizando baja  de Clientes:\n");
                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuReteptionist();
                }
                break;
            case 5:
                System.out.print("Modificar el usuario\n");
                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuReteptionist();
                }
                break;
            case 6:
                System.out.print("Lista de usuarios registrados\n");

                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuReteptionist();
                }
                break;
            case 7:
                System.out.print("Estado de las habitaciones:\n");
                Room a = new Room(5,"En mantenimiento","Si", false);
                a.stateRoom();
                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuReteptionist();
                }
                break;
            case 8:
                System.out.print("Salir");

                System.exit(0);
                break;
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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