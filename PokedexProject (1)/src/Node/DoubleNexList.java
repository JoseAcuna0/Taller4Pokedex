package Node;

/**
 * The Double node nex list class
 */
public class DoubleNexList implements List {
    /**
     * The head
     */
    private DoubleNode head;

    /**
     * The head
     */
    private DoubleNode tail;

    /**
     * The constructor
     */
    public DoubleNexList(){
        this.head = null;
        this.tail = null;
    }
    @Override
    public boolean agregar(Pokemon p) {
        DoubleNode newNode = new DoubleNode(p);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return true;
        } else if (this.head.getNext() == null){
            this.tail = newNode;
            this.head.setNext(this.tail);
            this.tail.setPrevious(this.head);
            return true;
        } else {
            DoubleNode aux = this.tail;
            aux.setNext(newNode);
            this.tail = newNode;
            this.tail.setPrevious(aux);
            return true;
        }
    }
    public boolean agregar(BasicStagePokemon p) {
        DoubleNode newNode = new DoubleNode(p);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return true;
        } else if (this.head.getNext() == null){
            this.tail = newNode;
            this.head.setNext(this.tail);
            this.tail.setPrevious(this.head);
            return true;
        } else {
            DoubleNode aux = this.tail;
            aux.setNext(newNode);
            this.tail = newNode;
            this.tail.setPrevious(aux);
            return true;
        }
    }
    public boolean agregar(SecondStagePokemon p) {
        DoubleNode newNode = new DoubleNode(p);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return true;
        } else if (this.head.getNext() == null){
            this.tail = newNode;
            this.head.setNext(this.tail);
            this.tail.setPrevious(this.head);
            return true;
        } else {
            DoubleNode aux = this.tail;
            aux.setNext(newNode);
            this.tail = newNode;
            this.tail.setPrevious(aux);
            return true;
        }
    }
    public boolean agregar(ThirdStagePokemon p) {
        DoubleNode newNode = new DoubleNode(p);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return true;
        } else if (this.head.getNext() == null){
            this.tail = newNode;
            this.head.setNext(this.tail);
            this.tail.setPrevious(this.head);
            return true;
        } else {
            DoubleNode aux = this.tail;
            aux.setNext(newNode);
            this.tail = newNode;
            this.tail.setPrevious(aux);
            return true;
        }
    }
    public int getDataAmount(){
        if(this.head == null){
            return 0;
        }
        int dataAmount = 1;
        DoubleNode aux = this.head;
        while(aux.getNext() != null){
            dataAmount++;
            aux = aux.getNext();
        }
        return dataAmount;
    }

    @Override
    public boolean eliminar(Pokemon p) {
        return false;
    }

    @Override
    public int cantidad(Pokemon p) {
        return 0;
    }

    @Override
    public boolean isVacia(Pokemon p) {
        return false;
    }

    @Override
    public boolean isIgual(Pokemon p) {
        return false;
    }

    @Override
    public int compararCon(Pokemon p) {
        return 0;
    }
    public DoubleNode getFirstNodo(){
        return this.head;
    }

    public DoubleNode searchNode(int id){
        DoubleNode aux = this.head;
        while(aux.getNext() != null){
            if (aux.getPokemon().getId() == id){
                return aux;
            } else if (aux.getBasicPokemon().getId() == id){
                return aux;
            } else if (aux.getSecondPokemon().getId() == id){
                return aux;
            } else if (aux.getThirdPokemon().getId() == id){
                return aux;
            }
            aux = aux.getNext();
        }
        return null;
    }


}
