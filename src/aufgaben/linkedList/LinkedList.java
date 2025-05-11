package aufgaben.linkedList;

public class LinkedList {
    public static void main(String[] args) {
        ListElement l1 = new ListElement('H');
        ListElement l2 = new ListElement('i');
        ListElement l3 = new ListElement('!');
        ListElement l4 = new ListElement('W');
        l1.insertBefore(l2);
        l2.insertBefore(l3);
        l3.insertBefore(l4);

        ListElement currentEl = l1;
        while (currentEl.hasSuccessor) {
            System.out.println(currentEl);
            System.out.print(currentEl.value);
            currentEl = currentEl.successor;
        }
    }
}
