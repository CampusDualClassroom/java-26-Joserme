package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.text.Normalizer;

public class Contact implements ICallActions{

    private String name;
    private String surnames;
    private String phone;


    public Contact(String name,String surnames,String phone) {
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
    }

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {

        String codigo = "";
        String nombre = name.substring(0, 1);
        String apellido = surnames;

        String[] separaciones = apellido.split(" ");
        String a = separaciones[0];
        String resto = "";

        for (int i = 1; i < separaciones.length; i++) {
             resto += separaciones[i];
        }
        if(resto.equals("")){
             codigo = nombre + a;
             codigo = limpiarAcentos(codigo);
                return (codigo).toLowerCase();
        }else {
            apellido = a.substring(0,1) + resto;
            codigo = nombre + apellido;
            codigo = limpiarAcentos(codigo);
                 return codigo.toLowerCase();
        }
    }

    public static String limpiarAcentos(String cadena) {
        String limpio =null;
        if (cadena !=null) {
            String valor = cadena;
            valor = valor.toUpperCase();
            limpio = Normalizer.normalize(valor, Normalizer.Form.NFD);
            limpio = limpio.replaceAll("[^\\p{ASCII}(N\u0303)(n\u0303)(\u00A1)(\u00BF)(\u00B0)(U\u0308)(u\u0308)]", "");
            limpio = Normalizer.normalize(limpio, Normalizer.Form.NFC);
        }
        return limpio.toLowerCase();
    }


    public static void menuContactos(Contact s){
        int opcion = 0;
        int tope = 4;
        do {
            System.out.println("\n  ______ LISTIN ______");
            System.out.println("\n   << MENU PRINCIPAL >>\n");
            System.out.println("  1. LLamarme.");
            System.out.println("  2. LLamar otro número.");
            System.out.println("  3. Mostrar detalles.");
            System.out.println("  4. Salir.\n");
            String peticion =  "Escriba el numero de la opcion deseada y pulse intro: \n";
            opcion = Utils.integer(peticion);
            eleccion((opcion));
        }while (opcion>0 || opcion>tope);
    }
    public static void eleccion(int eleccion) {
        Contact c = new Contact();
        switch(eleccion){
            case 1:
                c.callMyNumber();
                break;
            case 2:
               c.callOtherNumber("phone");
                break;
            case 3:
                c.showContactDetails();
                break;

            default:
                System.out.println("Opcion no disponible. Intentelo otra vez");
                break;
        }
    }


    @Override
    public void callMyNumber() {
        System.out.println("Calling "+name+" "+surnames+" at "+phone);
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("Calling "+name+" "+surnames+" at "+number);

    }

    @Override
    public void showContactDetails() {
        System.out.println("Name: " + name);
        System.out.println("Surnames: " + surnames);
        System.out.println("Phone: " + phone);
        System.out.println("Code: " +getCode());
    }


    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }


}
