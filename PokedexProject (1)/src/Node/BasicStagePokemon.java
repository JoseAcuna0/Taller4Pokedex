package Node;

import Node.Pokemon;

/**
 * BasicStagePokemon class
 */
public class BasicStagePokemon extends Pokemon {

    /**
     * The First evo name
     */
    private String firstEvolutionName;

    /**
     * The Second evo name
     */
    private String secondEvolutionName;

    /**
     * The Third evo name
     */
    private String thirdEvolutionName;

    /**
     * The constructor
     * @param id uses
     * @param name uses
     * @param stage uses
     * @param principalType uses
     * @param secondType uses
     */
    public BasicStagePokemon(int id, String name, String stage, String principalType, String secondType){
        super(id, name, stage, principalType, secondType);
        this.firstEvolutionName = null;
        this.secondEvolutionName = null;
        this.thirdEvolutionName = null;
    }
    public BasicStagePokemon(int id, String name, String stage, String principalType, String secondType, String firstEvolutionName){
        super(id, name, stage, principalType, secondType);
        this.firstEvolutionName = firstEvolutionName;
        this.secondEvolutionName = null;
        this.thirdEvolutionName = null;
    }
    public BasicStagePokemon(int id, String name, String stage, String principalType, String secondType, String firstEvolutionName, String secondEvolutionName){
        super(id, name, stage, principalType, secondType);
        this.firstEvolutionName = firstEvolutionName;
        this.secondEvolutionName = secondEvolutionName;
    }
    public BasicStagePokemon(int id, String name, String stage, String principalType, String secondType, String firstEvolutionName, String secondEvolutionName, String thirdEvolutionName){
        super(id, name, stage, principalType, secondType);
        this.firstEvolutionName = firstEvolutionName;
        this.secondEvolutionName = secondEvolutionName;
        this.thirdEvolutionName = thirdEvolutionName;
    }

    public String getFirstEvolutionName() {
        return firstEvolutionName;
    }

    public void setFirstEvolutionName(String firstEvolutionName) {
        this.firstEvolutionName = firstEvolutionName;
    }

    public String getSecondEvolutionName() {
        return secondEvolutionName;
    }

    public void setSecondEvolutionName(String secondEvolutionName) {
        this.secondEvolutionName = secondEvolutionName;
    }

    public String getThirdEvolutionName() {
        return thirdEvolutionName;
    }

    public void setThirdEvolutionName(String thirdEvolutionName) {
        this.thirdEvolutionName = thirdEvolutionName;
    }
}
