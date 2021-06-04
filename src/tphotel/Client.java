package tphotel;


import java.io.*;
import java.io.Serializable;

public class Client extends User implements Serializable {

    public Client(String tipousuario, String usuario, String contraseña, String name, String lastname, int dni, String country, String city) {
        super(tipousuario, usuario, contraseña, name, lastname, dni, country, city);
    }





    ///Listar clientes

    public void listClients() throws IOException, ClassNotFoundException {
        File file = new File( "clientes.txt");
        ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(file));

        Object aux = objInputStream.readObject();
        while (aux!=null) {
            if (aux instanceof Client)
                System.out.println(aux);
            aux = objInputStream.readObject();
        }

        objInputStream.close();

    }

    public void checkin(){

        Client p1= new Client("client","carlos","perez","pepito","alvarez",42245175,"argentina","rosario");
        Client p2= new Client();
        Client p3= new Client();
        Client p4= new Client();

//String path="C:\\Users\\Elian olivera\\Desktop\\Password\\clientes.txt";
        File myFile= new File( "clientes.txt");
        if(!myFile.exists()){
            try {
                myFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(myFile.exists()){
            try{
                FileOutputStream fileOutputStream=new FileOutputStream(myFile);
                ObjectOutputStream  objOutputstream= new ObjectOutputStream(fileOutputStream);
                objOutputstream .writeObject(p1);objOutputstream .writeObject(p2);
                objOutputstream .writeObject(p3);objOutputstream .writeObject(p4);

                objOutputstream.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        } }

    public Client() {

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





    /// FUNCION QUE INGRESA CLIENTES AL ARCHIVO



    @Override


    public String toString() {
        return "User:  " +
                "tipe='" + tipousuario + '\'' +
                ", User='" + usuario + '\'' +
                ", Password='" + contraseña + '\'' +
                ", Name='" + name + '\'' +
                ", Lastname='" + lastname + '\'' +
                ", Dni=" + dni +
                ", Country='" + country + '\'' +
                ", City='" + city + '\'' +
                '.';
    }
}