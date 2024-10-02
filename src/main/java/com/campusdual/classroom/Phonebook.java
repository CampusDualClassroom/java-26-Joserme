package com.campusdual.classroom;

import com.campusdual.util.Utils;
import com.campusdual.classroom.Contact;

import java.util.Map;
import java.util.TreeMap;

public class Phonebook implements ICallActions{

    static Map<String, Contact> lista = new TreeMap<>();

    public static void menuPrincipal(){
        int opcion = 0;
        int tope = 5;
        do {
            System.out.println("\n  ______ LISTIN ______");
            System.out.println("\n   << MENU PRINCIPAL >>\n");
            System.out.println("  1. Añadir Contacto.");
            System.out.println("  2. Listar Contactos.");
            System.out.println("  3. Seleccionar Contacto.");
            System.out.println("  4. Borrar Contacto.");
            System.out.println("  5. Salir.\n");

            String peticion =  "Escriba el numero de la opcion deseada y pulse intro: \n";
            opcion = Utils.integer(peticion);
            eleccionMenuPrincipal((opcion));
        }while (opcion>0 || opcion>tope);
    }
    public static void eleccionMenuPrincipal(int eleccion) {
        Contact c = new Contact();
        switch(eleccion){
            case 1:

                addContact(c);
                break;
            case 2:
                showPhonebook();
                break;
            case 3:
                Contact.menuContactos(seleccionarContacto());
                break;
            case 4:
                c = new Contact();
                deleteContact(c.getCode());
                break;
            case 5:

                break;
            default:
                System.out.println("Opcion no disponible. Intentelo otra vez");
                break;
        }
    }
    public static Contact seleccionarContacto(){

     return null;
    }

    public static void addContact(Contact c){
        lista.put(c.getCode(),c);

    }
    public static void deleteContact(String code){
        lista.remove(code);
    }

    public static void showPhonebook(){
        lista = new TreeMap<>();
        Contact c = new Contact();

        for (Contact i : lista.values()) {
            i.toString();
        }

    }
    @Override
    public void callMyNumber() {
        System.out.println("El numero marcado es el suyo");
        //Este método tendrá que indicar con un mensaje escrito por consola
        //que el propio contacto se está llamando a sí mismo, y especificar
        //cuál es su número de teléfono
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("Esta llamando al número "+ number);
        //Este método tendrá que indicar con un mensaje escrito por consola
        //que el propio contacto se está llamando a un número de teléfono
        //que se le facilita por parámetro
    }

    @Override
    public void showContactDetails() {
        //Muestra en un mensaje por consola con los detalles del contacto
    }

        public  Map<String, Contact> getData(){

                return lista;
        }

}
