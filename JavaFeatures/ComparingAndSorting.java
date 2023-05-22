/**
 * This Package will contain code and exercises on java advance features.
 * */
package JavaFeatures;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * W.A.P to adds 5 student obj defined in 'MAP-Collection -Exercise' to a TresSet.
 *  a -> Sort students obj by name using comparable interface.
 *  b -> Sort students by totalMarks using comparator interface.
 * */

class Student implements Comparable<Student>{  // using comparable interface
    int id;
    String name;
    Double totalMarks;

    Student(int id, String name, double totalMarks){
        this.id = id;
        this.name = name;
        this.totalMarks = totalMarks;
    }

    @Override
    public String toString(){
        return "[ id:"+id+" name:"+name+" totalMarks:"+totalMarks+" ]";
    }

    @Override
    public int compareTo(Student o) {  // comparing using comparable by names
        return this.name.compareTo(o.name);
    }
}

// Using Comparator Interface
class compareTotalMarks implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return (int) (o1.totalMarks - o2.totalMarks);
    }
}
public class ComparingAndSorting {
    public static void main(String[] args){
        Student s1 = new Student(101,"abdul",85);
        Set<Student> set = new TreeSet<>(new compareTotalMarks()); // need to add our sorting method's obj here, bcos we are using TreeSet.
        set.add(s1);
        set.add(new Student(103,"salman", 80));
        set.add(new Student(102,"imran", 90));
        set.add(new Student(104,"nunnu", 50));

        System.out.println(set);
    }
}