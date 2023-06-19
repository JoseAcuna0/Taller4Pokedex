package Node;

import Node.Pokemon;

/**
 * SecondStagePokemon class
 */
public class SecondStagePokemon extends Pokemon {

    /**
     * The previousEvo
     */
    private String prevEvolutionName;

    /**
     * The next
     */
    private String nextEvolutionName;

    /**
     * The constructor
     * @param id
     * @param name
     * @param stage
     * @param principalType
     * @param secondType
     * @param prevEvolutionName
     */
    public SecondStagePokemon(int id, String name, String stage, String principalType, String secondType, String prevEvolutionName) {
        super(id, name, stage, principalType, secondType);
        this.prevEvolutionName = prevEvolutionName;
        this.nextEvolutionName = null;
    }
    public SecondStagePokemon(int id, String name, String stage, String principalType, String secondType, String prevEvolutionName, String nextEvolutionName){
        super(id, name, stage, principalType, secondType);
        this.prevEvolutionName = prevEvolutionName;
        this.nextEvolutionName = nextEvolutionName;
    }

    public String getPrevEvolutionName() {
        return prevEvolutionName;
    }

    public String getNextEvolutionName() {
        return nextEvolutionName;
    }
}
