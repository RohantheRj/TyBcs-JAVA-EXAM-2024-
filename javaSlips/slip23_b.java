import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class StudentNames {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java StudentNames <name1> <name2> <name3> ...");
            return;
        }

        ArrayList<String> studentNames = new ArrayList<>();


        for (String arg : args) {
            studentNames.add(arg);
        }


        System.out.println("Student Names (Using Iterator):");
        Iterator<String> iterator = studentNames.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        System.out.println("\nStudent Names (Using ListIterator in Reverse):");
        ListIterator<String> listIterator = studentNames.listIterator(studentNames.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}

