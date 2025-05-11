package aufgaben.linkedList;

public class ListElement {
    char value;
    boolean hasPredecessor;
    boolean hasSuccessor;
    //einen Vorgänger
    ListElement predecessor;
    //einen Nachfolger
    ListElement successor;

    public ListElement(char value) {
        this.value = value;
        this.hasPredecessor = false;
        this.hasSuccessor = false;
    }

    public void insertBefore(ListElement element) {
        this.hasSuccessor = true;
        this.successor = element;
        element.hasPredecessor = true;
        element.predecessor = this;
    }
}
