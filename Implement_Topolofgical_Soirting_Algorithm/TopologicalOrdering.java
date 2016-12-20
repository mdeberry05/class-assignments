import java.util.*;

/**
 * Created by Matthew DeBerry on 3/25/2015.
 * ITCS-2215 Topological Sort
 *
 * This code will read codes from a text file of adjacency lists for a directed graph
 * and will throw an exception if a cycle is detected.
 *
 */

public class TopologicalOrdering {
    public static void main(String[] args) throws Exception {
        TreeMap<String, ArrayList<String>> map = ReadOperations.readFile();
        System.out.println(TopologicalSort(map));
    }

    public static <T> ArrayList<T> TopologicalSort(Map<T, ArrayList<T>> dictionary) throws Exception {
        ArrayList<T> buffer;
        HashSet<T> X = new HashSet<T>();
        X.addAll(dictionary.keySet());
        for (T t : X)
            if (dictionary.get(t) != null || !dictionary.get(t).isEmpty()) {
                (buffer = dictionary.get(t)).remove(t);
                for (T m : buffer)
                    if (!X.contains(m))
                        dictionary.put(m, new ArrayList<T>(0));
            }

        ArrayList<T> answer = new ArrayList<T>(dictionary.size());
        Queue<T> nonVisitedVerts = new java.util.concurrent.LinkedBlockingDeque<T>();
        HashSet<T> visitedVerts = new HashSet<T>(),
                definedVerts = new HashSet<T>();
        definedVerts.addAll(dictionary.keySet());
        T currentElement;

        for (T t : definedVerts)
            if (dictionary.get(t) == null || dictionary.get(t).isEmpty())
                nonVisitedVerts.add(t);
        while (!nonVisitedVerts.isEmpty()) {
            if (visitedVerts.add(currentElement = nonVisitedVerts.poll()))
                answer.add(currentElement);
            for (T t : dictionary.keySet())
                if (dictionary.get(t) != null && !dictionary.get(t).isEmpty() && !visitedVerts.contains(t)
                        && visitedVerts.containsAll(dictionary.get(t)))
                    nonVisitedVerts.add(t);
        }

        // Return result.
        //Reverse answer from DFS

        if (answer.containsAll(definedVerts)) {
            ArrayList<T> reversedAnswer = new ArrayList<T>(answer.size());

            for(int i = answer.size() - 1; i > -1; i--) {
                reversedAnswer.add(answer.get(i));
            }

            return reversedAnswer;
        }

        // Throw exception if a Cycle is Detected
        
        StringBuilder sb = new StringBuilder("\nThere is not a topological ordering for this graph\nA cycle is a detected: ");
        for (T t : definedVerts)
            if (!answer.contains(t))
                sb.append(t).append(" ");
        throw new AreYouSerious(sb.append("\n").toString());
    }
}

//Custom Exception class

class AreYouSerious extends Exception {
    public AreYouSerious(String message) {
        System.out.println(message);
    }
}
