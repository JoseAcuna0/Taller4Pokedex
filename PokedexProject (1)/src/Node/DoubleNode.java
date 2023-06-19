package Node;

/**
 * The double node class
 */
public class DoubleNode {

    /**
     * The pokemon
     */
    private Pokemon pokemon;

    /**
     *  The basicPokemon
     */
    private BasicStagePokemon basicPokemon;
    /**
     *  The secondPokemon
     */
    private SecondStagePokemon secondPokemon;

    /**
     *  The thirdPokemon
     */
    private ThirdStagePokemon thirdPokemon;

    /**
     * The previous
     */
    private DoubleNode previous;
    /**
     * The next
     */
    private DoubleNode next;


    /**
     * The constructor
     * @param pokemon uses
     */

    public DoubleNode(Pokemon pokemon){
        if (pokemon == null){
            throw new IllegalArgumentException("Elemento tiene que ser no nulo! ");
        }
        this.pokemon = pokemon;
        this.previous = null;
        this.next = null;
    }
    public DoubleNode(BasicStagePokemon pokemon){
        if (pokemon == null){
            throw new IllegalArgumentException("Elemento tiene que ser no nulo! ");
        }
        this.basicPokemon = pokemon;
        this.previous = null;
        this.next = null;
    }
    public DoubleNode(SecondStagePokemon pokemon){
        if (pokemon == null){
            throw new IllegalArgumentException("Elemento tiene que ser no nulo! ");
        }
        this.secondPokemon = pokemon;
        this.previous = null;
        this.next = null;
    }

    public DoubleNode(ThirdStagePokemon pokemon){
        if (pokemon == null){
            throw new IllegalArgumentException("Elemento tiene que ser no nulo! ");
        }
        this.thirdPokemon = pokemon;
        this.previous = null;
        this.next = null;
    }

    public Pokemon getPokemon() {
        return this.pokemon;
    }

    public BasicStagePokemon getBasicPokemon() {
        return basicPokemon;
    }

    public SecondStagePokemon getSecondPokemon() {
        return secondPokemon;
    }

    public ThirdStagePokemon getThirdPokemon() {
        return thirdPokemon;
    }

    public DoubleNode getNext() {
        return this.next;
    }

    public void setNext(DoubleNode next){
        this.next = next;
    }

    public DoubleNode getPrevious() {
        return this.previous;
    }

    public void setPrevious(DoubleNode previous){
        this.previous = previous;
    }
}
