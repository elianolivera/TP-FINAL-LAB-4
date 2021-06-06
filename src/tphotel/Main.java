package tphotel;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {



        /// INGRESA PASAJEROS AL SISTEMA
        Client p1= new Client("client","carlos","carli","pepito","alvarez",42245175,"argentina","rosario");
        p1.checkin();


        /// VALIDA USUARIOS Y ADMIN DEL SISTEMA
        validateuser();

    }


    //// SE ENCARGA DE VALIDAR EL INGRESO EN EL SISTEMA DE LOS USUARIOS

    static void validateuser() {
        File file = new File("clientes.txt");

        String pass = null;
        String usuario = null;
        try (ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(file))) {

            Object aux = objInputStream.readObject();
            while (aux != null) {

                if (aux instanceof Client)
                    pass = ((Client) aux).getContraseña();
                usuario = ((Client) aux).getUsuario();
                aux = objInputStream.readObject();

                String confirm = "si";
                String negative= "no";
                int cont = 0, bandera = 0;
                String ingreso;
                String usuarios;
                String admi;
                Scanner teclado = new Scanner(System.in);
                System.out.print("\n ======== BIENVENIDOS AL HOTEL : ======== ");
                System.out.print("\n ¿Es usted un administrador?: si/no ");
                admi = teclado.nextLine();

                if (admi.equals( confirm)) {

                    Admin a= new Admin();
                    a.loginAdmin();

                }else if(admi.equals(negative)) {
                    System.out.print("\n ¿Es usted un Recepcionista?: si/no ");
                    admi = teclado.nextLine();
                    if (admi.equals( confirm)) {

  Recepcionist r= new Recepcionist();
  r.loginReteptionist();

                    }else if(admi.equals(negative)){
                        System.out.print("\n ==Usted no es administrador ni recepcionista ingrese como usuario== ");
                        System.out.print("\n======== INGRESA COMO USUARIO: ======== ");
                        System.out.print("\n Ejemplo : Cliente en el archivo, Usuario: carlos , Pass: perez ");
                        while ((cont != 3) && (bandera == 0)) {
                            System.out.print("\n Ingrese el usuario: ");
                            usuarios = teclado.nextLine();
                            System.out.print("Ingrese la contraseña: ");
                            ingreso = teclado.nextLine();

                            if (pass.equals(ingreso) && usuario.equals(usuarios)) {
                                System.out.print("Acceso correcto!");
                                System.out.print("Bienvenido\n ");
                                System.exit(1);
                                bandera = 1;
                            } else {
                                System.out.print("Usuario o contraseña incorrectos, intente nuevamente !");
                                cont++;
                                if (cont == 3) {
                                    System.out.print("\n !Acceso restringido!");
                                    System.out.print("\n Bloqueando el sistema");
                                    System.exit(1);


                                }
                            }
                        }
                    }
                }
            }
            objInputStream.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace(); }
    }

}
