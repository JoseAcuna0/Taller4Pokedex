import Node.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PokedexDataManager {

    private DoubleNexList pokemonData;
    private ArrayList<Pokemon> idsOrderList;
    private ArrayList<Pokemon> namesOrderList;

    /**
     * Listas donde guardan los datos
     */
    public PokedexDataManager(){
        this.pokemonData = loadPokedexData();
        this.idsOrderList = orderPokemonList(this.pokemonData);
        this.namesOrderList = alphabeticOrderPokemonList(this.pokemonData);
    }

    /**
     * Opcion 3 del menu
     */
    public void menuOptionThree(){
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingresa el tipo a buscar: ");
            String type = sc.nextLine();
            getPokemonListForType(type.toUpperCase());
            break;
        }
    }

    /**
     * Opcion 3 del menu
     */
    public void menuOptionOne(){
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el mínimo del rango: ");
            try {
                int min = sc.nextInt();
                if (min <= 0 || min > this.pokemonData.getDataAmount()){
                    System.out.println("Número o rango inválido!");
                    continue;
                }
                System.out.println("Ingrese el máximo del rango: ");
                int max = sc.nextInt();
                if (max > this.pokemonData.getDataAmount() || max < 0 || max < min){
                    System.out.println("Número o rango inválido!");
                    continue;
                }
                seePokedexRange(min, max);
                break;
            } catch (Exception e) {
                System.out.println("Número inválido!");
                continue;
            }
        }
    }

    /**
     * Metodo para ver la pokedex en el rango pedido por pantalla
     */
    public void seePokedexRange(int min, int max){
        for (int i = min; i <= max; i++){
            for (int j = 0; j < this.pokemonData.getDataAmount(); j++){
                if (this.idsOrderList.get(j).getId() == i){
                    System.out.println("ID: " + this.idsOrderList.get(j).getId());
                    System.out.println("Nombre: " + this.idsOrderList.get(j).getName());
                    System.out.println("--------------------------------");
                }
            }
        }
    }

    /**
     * Metodo para ver la pokedex alfabeticamente
     */
    public void seePokedexAlphabetic(){
        for (int i = 0; i < this.pokemonData.getDataAmount(); i++){
            System.out.println("Nombre: " + this.namesOrderList.get(i).getName());
            System.out.println("ID: " + this.namesOrderList.get(i).getId());
            System.out.println("--------------------------------");
        }
    }

    /**
     * Metodo para ver los pokemones por un filtro que es el tipo en comun
     */
    public void getPokemonListForType(String type){
        for (int i = 0; i < this.pokemonData.getDataAmount(); i++){
            if (this.namesOrderList.get(i).getPrincipalType().equalsIgnoreCase(type) || this.namesOrderList.get(i).getSecondType().equalsIgnoreCase(type)){
                System.out.println("Nombre: " + this.namesOrderList.get(i).getName());
                System.out.println("ID: " + this.namesOrderList.get(i).getId());
                System.out.println("Tipo Principal: " + this.namesOrderList.get(i).getPrincipalType());
                System.out.println("Tipo Secundario: " + this.namesOrderList.get(i).getSecondType());
                System.out.println("--------------------------------");
            }
        }
    }

    /**
     * Cargar los pokemones del txt
     */
    public DoubleNexList loadPokedexData () {
        BufferedReader br = null;
        DoubleNexList pokemonList = new DoubleNexList();

        String[] data;
        try {
            br = new BufferedReader(new FileReader("kanto (1).txt"));
            String line = br.readLine().strip();
            while (null != line) {
                if (!line.equals("")) {
                    data = line.split(",");
                    int id = Integer.parseInt(data[0].strip());
                    String name = data[1].strip();
                    String stage = data[2].strip();
                    if (name.equalsIgnoreCase("EEVEE")) {
                        String firstEvolutionName = data[3].strip();
                        String secondEvolutionName = data[4].strip();
                        String thirdEvolutionName = data[5].strip();
                        String principalType = data[6].strip();
                        String secondaryType = data[7].strip();
                        BasicStagePokemon p = new BasicStagePokemon(id,name,stage,principalType,secondaryType,firstEvolutionName,secondEvolutionName,thirdEvolutionName);
                        pokemonList.agregar(p);
                    } else if (stage.equalsIgnoreCase("BASICO")) {
                        if (data.length == 5) {
                            String principalType = data[3].strip();
                            String secondaryType = data[4].strip();
                            BasicStagePokemon p = new BasicStagePokemon(id,name,stage,principalType,secondaryType);
                            pokemonList.agregar(p);
                        } else if (data.length == 6) {
                            String firstEvolutionName = data[3].strip();
                            String principalType = data[4].strip();
                            String secondaryType = data[5].strip();
                            BasicStagePokemon p = new BasicStagePokemon(id,name,stage,principalType,secondaryType,firstEvolutionName);
                            pokemonList.agregar(p);
                        } else if (data.length == 7) {
                            String firstEvolutionName = data[3].strip();
                            String secondEvolutionName = data[4].strip();
                            String principalType = data[5].strip();
                            String secondaryType = data[6].strip();
                            BasicStagePokemon p = new BasicStagePokemon(id,name,stage,principalType,secondaryType,firstEvolutionName,secondEvolutionName);
                            pokemonList.agregar(p);
                        }
                    } else if (stage.equalsIgnoreCase("PRIMERA EVOLUCION")) {
                        if (data.length == 6) {
                            String prevEvolutionName = data[3].strip();
                            String principalType = data[4].strip();
                            String secondaryType = data[5].strip();
                            SecondStagePokemon p = new SecondStagePokemon(id,name,stage,principalType,secondaryType,prevEvolutionName);
                            pokemonList.agregar(p);
                        } else if (data.length == 7) {
                            String secondEvolutionName = data[3].strip();
                            String prevEvolutionName = data[4].strip();
                            String principalType = data[5].strip();
                            String secondaryType = data[6].strip();
                            SecondStagePokemon p = new SecondStagePokemon(id,name,stage,principalType,secondaryType,prevEvolutionName,secondEvolutionName);
                            pokemonList.agregar(p);
                        }
                    } else if (stage.equalsIgnoreCase("SEGUNDA EVOLUCION")) {
                        String prevEvolutionName = data[3].strip();
                        String prePrevEvolutionName = data[4].strip();
                        String principalType = data[5].strip();
                        String secondaryType = data[6].strip();
                        ThirdStagePokemon p = new ThirdStagePokemon(id,name,stage,principalType,secondaryType,prevEvolutionName,prePrevEvolutionName);
                        pokemonList.agregar(p);
                    }
                }
                try{
                    line = br.readLine().strip();
                } catch (Exception e){
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error cargando los datos.");
            return null;
        }
        System.out.println("Datos cargados correctamente!");
        return pokemonList;
    }

    public DoubleNexList getPokemonData(){
        return this.pokemonData;
    }

    /**
     * Metodo que ordena la lista de los pokemones
     * @param pokemonData
     * @return
     */
    public ArrayList<Pokemon> orderPokemonList(DoubleNexList pokemonData){
        DoubleNode aux = pokemonData.getFirstNodo();
        ArrayList<Pokemon> pokemonArray = new ArrayList<Pokemon>();
        ArrayList<Integer> idArray = new ArrayList<Integer>();
        for (int i = 0; i < pokemonData.getDataAmount(); i++){
            if(aux.getBasicPokemon() != null){
                pokemonArray.add(aux.getBasicPokemon());
                idArray.add(aux.getBasicPokemon().getId());
            } else if (aux.getSecondPokemon() != null){
                pokemonArray.add(aux.getSecondPokemon());
                idArray.add(aux.getSecondPokemon().getId());
            } else if (aux.getThirdPokemon() != null){
                pokemonArray.add(aux.getThirdPokemon());
                idArray.add(aux.getThirdPokemon().getId());
            }
            aux = aux.getNext();
        }
        ArrayList<Pokemon> orderPokemonArray = new ArrayList<Pokemon>();
        Collections.sort(idArray);
        for (int i = 0; i < pokemonData.getDataAmount(); i++){
            for (int j = 0; j < pokemonData.getDataAmount(); j++){
                if (idArray.get(i) == pokemonArray.get(j).getId()){
                    orderPokemonArray.add(pokemonArray.get(j));
                }
            }
        }
        return orderPokemonArray;
    }

    /**
     * Metodo para ver la primera evolucion del pokemon
     */
    public void seeFirstEvoPokemon(){
        ArrayList<Pokemon> pokemon = this.inversePokemonList(this.pokemonData);
        for (int i = 0; i < this.pokemonData.getDataAmount(); i++){
            if (pokemon.get(i).getStage().equalsIgnoreCase("PRIMERA EVOLUCION")){
                System.out.println("Nombre: " + pokemon.get(i).getName());
                System.out.println("ID: " + pokemon.get(i).getId());
                System.out.println("--------------------------------");
            }
        }
    }

    /**
     * Metodo para ver la lista de los pokemones invertida de mayor a menor id
     */
    public ArrayList<Pokemon> inversePokemonList(DoubleNexList pokemonData){
        DoubleNode aux = pokemonData.getFirstNodo();
        ArrayList<Pokemon> pokemonArray = new ArrayList<Pokemon>();
        ArrayList<Integer> idArray = new ArrayList<Integer>();
        for (int i = 0; i < pokemonData.getDataAmount(); i++){
            if(aux.getBasicPokemon() != null){
                pokemonArray.add(aux.getBasicPokemon());
                idArray.add(aux.getBasicPokemon().getId());
            } else if (aux.getSecondPokemon() != null){
                pokemonArray.add(aux.getSecondPokemon());
                idArray.add(aux.getSecondPokemon().getId());
            } else if (aux.getThirdPokemon() != null){
                pokemonArray.add(aux.getThirdPokemon());
                idArray.add(aux.getThirdPokemon().getId());
            }
            aux = aux.getNext();
        }
        ArrayList<Pokemon> orderPokemonArray = new ArrayList<Pokemon>();
        Collections.sort(idArray,Collections.reverseOrder());
        for (int i = 0; i < pokemonData.getDataAmount(); i++){
            for (int j = 0; j < pokemonData.getDataAmount(); j++){
                if (idArray.get(i) == pokemonArray.get(j).getId()){
                    orderPokemonArray.add(pokemonArray.get(j));
                }
            }
        }
        return orderPokemonArray;
    }



    /**
     * Metodo para ordenar la pokedex en orden alfabetico
     */
    public ArrayList<Pokemon> alphabeticOrderPokemonList(DoubleNexList pokemonData){
        DoubleNode aux = pokemonData.getFirstNodo();
        ArrayList<Pokemon> pokemonArray = new ArrayList<Pokemon>();
        ArrayList<String> namesArray = new ArrayList<String>();
        for (int i = 0; i < pokemonData.getDataAmount(); i++){
            if(aux.getBasicPokemon() != null){
                pokemonArray.add(aux.getBasicPokemon());
                namesArray.add(aux.getBasicPokemon().getName());
            } else if (aux.getSecondPokemon() != null){
                pokemonArray.add(aux.getSecondPokemon());
                namesArray.add(aux.getSecondPokemon().getName());
            } else if (aux.getThirdPokemon() != null){
                pokemonArray.add(aux.getThirdPokemon());
                namesArray.add(aux.getThirdPokemon().getName());
            }
            aux = aux.getNext();
        }
        ArrayList<Pokemon> orderPokemonArray = new ArrayList<Pokemon>();
        Collections.sort(namesArray);
        for (int i = 0; i < pokemonData.getDataAmount(); i++){
            for (int j = 0; j < pokemonData.getDataAmount(); j++){
                if (namesArray.get(i).equalsIgnoreCase(pokemonArray.get(j).getName())){
                    orderPokemonArray.add(pokemonArray.get(j));
                }
            }
        }
        return orderPokemonArray;
    }

    /**
     * Metodo para buscar un pokemon por su id o por su nombre
     */
    public void personalizedSearch(){
        System.out.println("Cual opcion desea que sea tu busqueda:");
        System.out.println("[1] Id ");
        System.out.println("[2] Nombre ");
        while(true) {
            Scanner sn = new Scanner(System.in);
            System.out.println("Ingrese la opcion: ");
            try {
                String opcion = sn.nextLine();
                if(opcion.equals("1")){
                    System.out.println("Ingrese la id del pokemon: ");
                    int idPokemon = sn.nextInt();
                    searchById(idPokemon);
                }

                if(opcion.equals("2")){
                    System.out.println("Ingrese el nombre del pokemon: ");
                    String nombrePokemon = sn.nextLine();
                    searchByName(nombrePokemon);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
        }






    }

    /**
     * Metodo que busca el pokemon por id
     */
    public void searchById(int idPokemon) {
        for (int i = 0; i < this.pokemonData.getDataAmount(); i++) {
            if (idPokemon == this.idsOrderList.get(i).getId()) {
                System.out.println("ID: " + this.idsOrderList.get(i).getId());
                System.out.println("Nombre: " + this.idsOrderList.get(i).getName());
                System.out.println("Etapa: " + this.idsOrderList.get(i).getStage());
                System.out.println("Tipo 1: " + this.idsOrderList.get(i).getPrincipalType());
                System.out.println("Tipo 2: " + this.idsOrderList.get(i).getSecondType());
                if (this.idsOrderList.get(i).getStage().equalsIgnoreCase("BASICO")){
                    BasicStagePokemon p = this.pokemonData.searchNode(this.idsOrderList.get(i).getId()).getBasicPokemon();
                    if(p.getFirstEvolutionName() == null){
                        System.out.println("Evoluciones: Ninguna");
                    } else if (p.getSecondEvolutionName() == null) {
                        System.out.println(("Evoluciones: " + "[1]" + p.getFirstEvolutionName()));
                    } else if (p.getThirdEvolutionName() == null){
                        System.out.println(("Evoluciones: " +  "[1]" + p.getFirstEvolutionName() +  "[2]" + p.getSecondEvolutionName()));
                    } else if (p.getThirdEvolutionName() != null){
                        System.out.println(("Evoluciones: " +  "[1]" + p.getFirstEvolutionName() +  "[2]" + p.getSecondEvolutionName() + "[3]" + p.getThirdEvolutionName()));
                    }
                }
            }
        }
    }
    /**
     * Metodo que busca el pokemon por nombre
     */
    public void searchByName(String nombrePokemon){
        for (int i = 0; i < this.pokemonData.getDataAmount(); i++) {
            if (nombrePokemon.equals(this.idsOrderList.get(i).getName())) {
                System.out.println("ID: " + this.idsOrderList.get(i).getId());
                System.out.println("Nombre: " + this.idsOrderList.get(i).getName());
                System.out.println("Etapa: " + this.idsOrderList.get(i).getStage());
                System.out.println("Tipo 1: " + this.idsOrderList.get(i).getPrincipalType());
                System.out.println("Tipo 2: " + this.idsOrderList.get(i).getSecondType());
            }

        }
    }
}




