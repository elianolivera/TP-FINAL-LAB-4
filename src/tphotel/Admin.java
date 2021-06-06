package tphotel;

import java.io.*;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Admin extends User implements Serializable {


    public Admin(String tipousuario, String usuario, String contraseña, String name, String lastname, int dni, String country, String city) {
        super(tipousuario, usuario, contraseña, name, lastname, dni, country, city);
    }
    public Admin() {
        super();
    }



    ///MENU ADMINISTRADOR

    public void menuAdmin() {
        int Opcion=0;
        System.out.print("\n ======== BIENVENIDO ADMINISTRADOR : ======== ");
        System.out.print("\n ======== ADMIN MENÚ : ======== ");
String afirm="si"; String Scan=null;
              int Opcion2=0;
        System.out.print("\n 1. Add Client ");
        System.out.print("\n 2. Modify Client");
        System.out.print("\n 3. Delete Client");
        System.out.print("\n 4. Sreach Client ");
        System.out.print("\n 5. Client List ");
        System.out.print("\n 6. Add Reteptionist");
        System.out.print("\n 7. Modify Reteptionist");
        System.out.print("\n 8. Sreach Reteptionist");
        System.out.print("\n 9. Reteptionist List ");
        System.out.print("\n 0. Salir");
        System.out.print("\n ==== Seleccione opción que desee  ===: \n");
        Scanner teclado = new Scanner(System.in);
        Opcion = teclado.nextInt();
        switch (Opcion) {
            case 1:
                System.out.print("Realizando alta de usuarios\n");

                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
               switch (Opcion2){
                    case 0:
                    menuAdmin();
                }
                break;

            case 2:
                System.out.print("Realizando baja  de usuarios:\n");
                switch (Opcion2){
                    case 1:
                        System.out.print("Baja de usuarioss:\n");

                        menuAdmin();
                    case 2:

                }
                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuAdmin();
                }

                break;
            case 3:
                System.out.print("Modificar el usuario\n");

                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuAdmin();
                }
                break;

            case 4:
                System.out.print("Lista de usuarios registrados\n");
                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuAdmin();
                }
                break;
            case 5:
                System.out.print("Realizando alta de usuarios\n");

                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuAdmin();
                }
                break;

            case 6:
                System.out.print("Realizando baja  de usuarios:\n");
                switch (Opcion2){
                    case 1:
                        System.out.print("Baja de usuarioss:\n");

                        menuAdmin();
                    case 2:

                }
                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuAdmin();
                }

                break;
            case 7:
                System.out.print("Modificar el usuario\n");

                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuAdmin();
                }
                break;

            case 8:
                System.out.print("Lista de usuarios registrados\n");
                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuAdmin();
                }
                break;
            case 9:
                System.out.print("Modificar el usuario\n");

                System.out.print("Presione 0 para volver al menú \n");
                Opcion2=teclado.nextInt();
                switch (Opcion2){
                    case 0:
                        menuAdmin();
                }
                break;
            case 0:
                System.out.print("Salir");

                System.exit(0);
                break;
        }
    }

    ///VALIDACION DE ADMINISTRADOR

    public void loginAdmin() {

        Admin r4= new Admin("Admin","elian","olivera","Elian","Olivera",13545257,"Argentina","Tandil");
        File mFile= new File("admin.txt");
        if(!mFile.exists()){ try { mFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace(); }
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
                Object aux = objectInputStream.readObject();
                pass = ((Admin) aux).getContraseña();  usuarios = ((Admin) aux).getUsuario();
                System.out.println("=========LISTA DE ADMIN EN EL ARCHIVO===========: ");
                while (aux != null) { if (aux instanceof Admin) {
                    System.out.println(aux);do {
                        System.out.print("\n======== INGRESE COMO ADMINISTRADOR: ======== ");
                        System.out.print("\n Ingrese el usuario: ");
                        users = tecladoss.nextLine();
                        System.out.print("Ingrese la contraseña: ");
                        ingreso = tecladoss.nextLine();
                        if (ingreso.equals(pass) && usuarios.equals(users)) {
                            System.out.print("Acceso correcto!");
                            System.out.print("Bienvenido\n ");
                           menuAdmin();
                            System.exit(1);
                            bandera = 1;
                        } else {
                            System.out.print("Usuario o contraseña incorrectos, intente nuevamente !");
                            cont++;

                            if (cont == 3) {
                                System.out.print("!Acceso restringido!");
                                System.out.print("Bloqueando el sistema");
                                System.exit(1); }
                        }
                    }while ((cont != 3) && (bandera== 0));

                } }
                objectInputStream.close(); } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace(); } }
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
        return "Admin:" +

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