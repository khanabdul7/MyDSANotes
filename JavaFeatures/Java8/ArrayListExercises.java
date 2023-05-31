package JavaFeatures.Java8;

import java.util.*;

public class ArrayListExercises {
    public static void main(String[] args) {

        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("White");

        colors.add(0,"Black");

//        colors.remove(2);

        String blue = colors.contains("Blue") ? "Found" : "Not Found";
        System.out.println(blue);

        System.out.println("Before Sorting ");
        System.out.println(colors);

        System.out.println("After Sorting ");
        Collections.sort(colors);
        System.out.println(colors);

        //iterator
        System.out.println("Traversing using iterator ");
        Iterator<String> it = colors.iterator();
        while(it.hasNext()) System.out.println(it.next());

        //Coping
        ArrayList<String> copyColors = new ArrayList<>(Arrays.asList("color","color","color","color","color"));

        System.out.println("Before coping: copyColors -> "+copyColors);
        Collections.copy(copyColors, colors);
        System.out.println("After coping: copyColors -> "+copyColors);

        Collections.shuffle(copyColors);
        System.out.println("After Shuffling: copyColors -> "+copyColors);

        copyColors.set(1,"Pink");
        System.out.println("After Replacing: copyColors -> "+copyColors);

        //comparing two lists
        List<String> result = new ArrayList<>();
        for(String s: colors){
            result.add(copyColors.contains(s)? "Y" : "N");
        }
        System.out.println("After Comparing "+colors+" with "+copyColors+" result -> "+result);

        System.out.println("Before Swapping: copyColors -> "+copyColors);
        Collections.swap(copyColors,0 ,3);
        System.out.println("After Swapping 0th index with 3rd index: copyColors -> "+copyColors);

        //joining 2 lists
        System.out.println("Colors -> "+colors);
        System.out.println("copyColors -> "+copyColors);
        List<String> combinedColors = new ArrayList<>();
        combinedColors.addAll(colors);
        combinedColors.addAll(copyColors);
        System.out.println("After Joining combinedColors -> "+combinedColors);

        //cloning
        List<String> clonedColors;
        clonedColors = (List<String>) colors.clone();
        clonedColors.add("Purple");
        System.out.println("Colors -> "+colors);
        System.out.println("clonedColors -> "+clonedColors);

        //removing all elements
        System.out.println("Colors -> "+colors);
//        for(String s: colors){   // this will throw exception
//            colors.remove(s);
//        }
        colors.removeAll(colors);
        System.out.println("After removing all: Colors -> "+colors);

        //checking if list is empty
        String s = colors.isEmpty() ? "list is empty" : "List is not empty";
        System.out.println(s);

        ArrayList<String> newList = new ArrayList<>(10); // creating a list of initial size of 10
        newList.add("item1");
        newList.add("item2");
        newList.add("item3");
        newList.add("item4");
        System.out.println("New List -> "+newList);
        newList.trimToSize();  // trimming the list to current size of list
        System.out.println("After Trimming New List -> "+newList);
        newList.ensureCapacity(6); // increasing capacity to hold at least 6 elements
        newList.add("item5");
        newList.add("item6");
        System.out.println("After increasing capacity New List -> "+newList);

        //printing using index no's
        System.out.println("Printing using Index no's");
        int length = newList.size();
        for(int i=0; i<length; i++){
            System.out.println(newList.get(i));
        }
    }
     
}