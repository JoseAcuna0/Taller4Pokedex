package Node;

import Node.Pokemon;

/**
 * ThirdStagePokemon class
 */
public class ThirdStagePokemon extends Pokemon {

    /**
     * The second pre evolution name
     */
    private String secondPreEvolutionName;

    /**
     * The  pre evolution name
     */
    private String preEvolutionName;

    /**
     * The constructor
     * @param id
     * @param name
     * @param stage
     * @param principalType
     * @param secondType
     * @param preEvolutionName
     * @param secondPreEvolutionName
     */
    public ThirdStagePokemon(int id, String name, String stage, String principalType, String secondType, String preEvolutionName, String secondPreEvolutionName) {
        super(id, name, stage, principalType, secondType);
        this.preEvolutionName = preEvolutionName;
        this.secondPreEvolutionName = secondPreEvolutionName;
    }

    public String getSecondPreEvolutionName() {
        return secondPreEvolutionName;
    }

    public String getPreEvolutionName() {
        return preEvolutionName;
    }
}
