/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author arturv
 */
public class Examenb {

    /**
     * @param args the command line arguments
     */
    //se define una arraylist para el garaje
    private static ArrayList<String> garaje = new ArrayList<String>();
    
    //añade un coche
    private static void anadircoche()
    {
        String matricula;
        System.out.println("Matrícula del coche:");
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            matricula=lector.readLine();
            if(matricula.length()>0)
            {
                if(garaje.contains(matricula))
                {
                    //Si el coche ya existía no se añade
                    System.out.println("Ya existía un coche con esta matrícula en el garaje.");
                }  
                else
                {
                    //Si el coche no existía se añade
                    garaje.add(matricula);
                    System.out.println("Coche añadido correctamente.");
                }        
            }
            else
            {
                System.out.println("No has introducido una matrícula.");
            }
        }
         catch(Exception e){
            System.out.println("Error."); 
        }
    }
    
    //Elimina un coche
    private static void eliminarcoche()
    {
        String matricula;
        System.out.println("Introduce la matrícula del coche ya reparado:");
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            matricula = lector.readLine();
            if(garaje.contains(matricula))
            {
                garaje.remove(matricula);
                //Si se encuentra el coche se elimina
                System.out.println("Coche fuera del taller.");
            }
            else
            {
                System.out.println("El coche no existe.");
            }
        }
        catch(Exception e){
            System.out.println("Error."); 
        }
    }
    
    //Busca un coche
    private static void buscarcoche()
    {
        String matricula;
        System.out.println("Introduce la matrícula del coche:");
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            matricula=lector.readLine();
            if(garaje.contains(matricula))
            {
                //Si el coche existe se informa
                System.out.println("El coche se encuentra todavía para reparar.");
            }
            else
            {
                System.out.println("El coche no se encuentra en el garaje.");
            }
        }
        catch(Exception e){
            System.out.println("Error."); 
        }
    }
    
    //se muestran todos los coches
    private static void mostrartodoscoches()
    {
        System.out.println("Coches pendientes de reparar:");
        for(String coche:garaje)
        {
            //se muestran todos los coches en un bucle for each
            System.out.println(coche);
        }
    }
    
    //Cuenta los coches
    private static void contarcoches()
    {
        System.out.println("Actualmente hay " + garaje.size() + " coches para reparar.");
    }
    
    //Elimina todos los coches
    private static void eliminartodoscoches()
    {
        garaje.clear();
        System.out.println("Todos los coches han sido reparados.");
        
    }
    
    //Calcula el presupuesto
    private static void calcularpresupuesto()
    {
        System.out.println("Introduce el numero de días que ha estado el coche.");
        Scanner entrada=new Scanner(System.in);
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int dias;
        double total, totald=0;
        String tipo;
        String descuento;
        try
        {
            dias=entrada.nextInt();
            System.out.println("Introduce el tipo de coche: SUV/DEP");
            tipo=lector.readLine();
            tipo=tipo.toLowerCase();
            if(tipo.equals("suv") || tipo.equals("dep"))
            {
                System.out.println("Jubilado o estudiante? (jub/est/no)");
                descuento=lector.readLine();
                descuento=descuento.toLowerCase();
                if(descuento.equals("jub") || descuento.equals("est") || descuento.equals("no"))
                {
                    total = 15 * dias;
                    //se multiplican los 15 euros diaros por los dias
                    //se añade el suplemento según el tipo de coche
                    if(tipo.equals("suv"))
                    {
                        total +=25;
                    }
                    else
                    {
                        total+=55;
                    }
                    //se aplica el descuento si es jubilado o estudiante
                    if(descuento.equals("jub"))
                    {
                        totald= total-(total/10);
                    }
                    else if(descuento.equals("est"))
                    {
                        totald = total - ((total/100)*22);        
                    }    
                    if(descuento.equals("jub") || descuento.equals("est"))
                    {
                        System.out.println("El precio total de su reparación es de " + total + " euros, pero aplicando el descuento le queda por " + totald + " euros.");
                    }
                    else
                    {
                        System.out.println("El precio total de su reparación es de " + total + " euros.");
                    }
                }
                else
                {
                    System.out.println("Respuesta incorrecta.");
                }        
            }
            else
            {
                System.out.println("Tipo incorrecto.");
            }
        }
        catch(Exception e){
            System.out.println("Error."); 
        }
    }
    
    public static void main(String[] args) {
        int opcion=0;
        Scanner entrada=new Scanner(System.in);
        try
        {
            do
            {
                //se muestra el menú
                System.out.println("1-Añadir coche al garaje.");
                System.out.println("2-Eliminar coche del garaje.");
                System.out.println("3-Buscar un coche por su matrícula.");
                System.out.println("4-Mostrar todos los coches del taller.");
                System.out.println("5-Contar los coches actuales del taller.");
                System.out.println("6-Eliminar todos los coches del taller.");
                System.out.println("7-Calcular presupuesto.");
                System.out.println("8-Salir.");
                opcion=entrada.nextInt();
                switch(opcion)
                {
                    case 1:
                        anadircoche();
                        break;
                    case 2:
                        eliminarcoche();
                        break;
                    case 3:
                        buscarcoche();
                        break;
                    case 4:
                        mostrartodoscoches();
                        break;
                    case 5:
                        contarcoches();
                        break;
                    case 6:
                        eliminartodoscoches();
                        break;
                    case 7:
                        calcularpresupuesto();
                        break;
                    case 8:
                        System.out.println("Adios.");
                        break;
                    default:
                        System.out.println("Opción incorrecta.");
                            
                }
            }while(opcion!=8);
        }
        catch(Exception e){
            System.out.println("Error."); 
        }
    }
    
}
