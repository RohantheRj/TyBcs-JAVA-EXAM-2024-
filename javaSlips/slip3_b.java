import java.util.LinkedList;
import java.util.ListIterator;

public class StringLinkedListOperations {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");

        System.out.println("LinkedList after adding elements:");
        System.out.println(linkedList);

        if (!linkedList.isEmpty()) {
            linkedList.removeFirst();
            System.out.println("\nLinkedList after removing the first element:");
            System.out.println(linkedList);
        } else {
            System.out.println("\nLinkedList is empty. Cannot remove the first element.");
        }

        System.out.println("\nContents of the list in reverse order:");
        ListIterator<String> iterator = linkedList.listIterator(linkedList.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}

