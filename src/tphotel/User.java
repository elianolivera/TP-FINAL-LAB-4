package tphotel;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class User implements Serializable  {
    protected String tipousuario;
    protected String usuario;
    protected String contraseña;
    protected String name;
    protected String lastname;
    protected int dni;
    protected String country;
    protected String city;

    public User (String tipousuario, String usuario, String contraseña, String name, String lastname, int dni, String country, String city) {
        this.tipousuario = tipousuario;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.country = country;
        this.city = city;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "Userimplements{" +
                "tipousuario='" + tipousuario + '\'' +
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