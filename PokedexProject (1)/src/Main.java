import java.util.ArrayList;
import Node.Pokemon;
import java.util.Scanner;

/**
 * The main
 */
public class Main {
    public static void main(String[] args) {

        PokedexDataManager listaNodoConLosPokemones = new PokedexDataManager();
        menu(listaNodoConLosPokemones);
    }
    public static void menu(PokedexDataManager pokedex){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a la Pokedex! ");
        System.out.println("[1] Entrar a las Opciones de la pokedex ");
        System.out.println("[5] Salir ");
        System.out.println("Que desea Realizar: ");
        String opcion = sc.nextLine();
        while (!opcion.equals("6")){
            System.out.println("Esto es lo que puedes hacer en la pokedex! ");
            System.out.println("[1] Desplegar pokemons por un rango que tu nos digas. ");
            System.out.println("[2] Desplegar todos los pokemons ordenados alfabeticamente. ");
            System.out.println("[3] Desplegar pokemons que tengan un tipo en particular ");
            System.out.println("[4] Desplegar todos los pokemons de primera evolucion ordenados decrecientemente. ");
            System.out.println("[5] Busqueda personalizada ");
            System.out.println("[6] Salir ");
            System.out.println("Que desea Realizar: ");
            opcion = sc.nextLine();
            if(opcion.equals("1")){
                pokedex.menuOptionOne();
            }
            else if(opcion.equals("2")){
                pokedex.seePokedexAlphabetic();
            }
            else if(opcion.equals("3")){
                pokedex.menuOptionThree();
            }
            else if(opcion.equals("4")){
                pokedex.seeFirstEvoPokemon();
            } else if(opcion.equals("5")){
                pokedex.personalizedSearch();
            }else if(opcion.equals("6")){
                break;
            }


        }
        System.out.println("Saliendo de la Pokedex... ");
    }
}
