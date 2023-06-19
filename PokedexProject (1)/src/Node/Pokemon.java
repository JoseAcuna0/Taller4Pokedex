package Node;

/**
 * Clase Pokemon
 */
public abstract class Pokemon {

    /**
     * The id
     */
    private int id;

    /**
     * The name
     */
    private String name;

    /**
     * The stage
     */
    private String stage;

    /**
     * The principalType
     */
    private String principalType;

    /**
     * The secondType
     */
    private String secondType;

    /**
     * The constructor
     * @param id uses
     * @param name uses
     * @param stage uses
     * @param principalType uses
     * @param secondType uses
     */
    public Pokemon(int id, String name, String stage, String principalType, String secondType){
        this.id = id;
        this.name = name;
        this.stage = stage;
        this.principalType = principalType;
        if(this.principalType.equals(secondType)){
            this.secondType = this.principalType;
        } else {
            this.secondType = secondType;
        }
    }

    /**
     *
     * @return the name
     */
    public String getName(){
        return this.name;
    }

    /**
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return the stage
     */
    public String getStage() {
        return stage;
    }


    /**
     *
     * @return the principalType
     */
    public String getPrincipalType() {
        return principalType;
    }

    /**
     *
     * @return the secondType
     */
    public String getSecondType() {
        return secondType;
    }
}
