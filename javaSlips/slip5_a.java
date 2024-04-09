import java.util.Hashtable;
import java.util.Enumeration;

public class StudentHashTable {
    public static void main(String[] args) {
        Hashtable<String, String> studentDetails = new Hashtable<>();


        studentDetails.put("1234567890", "Alice");
        studentDetails.put("9876543210", "Bob");
        studentDetails.put("5678901234", "Charlie");


        System.out.println("Details of Students:");
        System.out.println("====================");
        Enumeration<String> mobileNumbers = studentDetails.keys();
        while (mobileNumbers.hasMoreElements()) {
            String mobileNumber = mobileNumbers.nextElement();
            String studentName = studentDetails.get(mobileNumber);
            System.out.println("Mobile Number: " + mobileNumber + ", Student Name: " + studentName);
        }
    }
}

