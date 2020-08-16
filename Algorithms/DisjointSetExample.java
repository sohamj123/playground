import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.Map.Entry;

public class DisjointSetExample {
    public static void main (String[] args){
        DisjointSetExample d = new DisjointSetExample();
        DSet d1 = d.new DSet();
        String [] setval = {"a", "b", "c"};
        d1.makeSet(setval);
        setval = new String[]{"d", "e", "f"};
        d1.makeSet(setval);
        System.out.println(d1.findSet("c"));
        System.out.println(d1.findSet("e"));
        d1.union("a", "d");
    }

    public class DSet{
        
        public Hashtable<String,HashSet<String>> sets = new Hashtable<String,HashSet<String>>();
        
        public String makeSet(String[] elements){
            HashSet<String> s = new HashSet<String>();

            for (int i=0;i<elements.length; i++){
                s.add(elements[i]);
            }
            sets.put(elements[0], s);
            return elements[0];
        }

        public String findSet(String value){
            Set<Entry<String,HashSet<String>>> entries = sets.entrySet();

            for(Entry<String,HashSet<String>> entry:entries){
                String key = entry.getKey();
                HashSet<String> val = entry.getValue();
                if (val.contains(value)) {
                    return key;
                }
            }
            return null;
        }

        public String union(String aKey, String bKey){
            HashSet<String> aSet = sets.get(aKey);
            HashSet<String> bSet = sets.get(bKey);
            aSet.addAll(bSet);
            sets.put(aKey, aSet);
            sets.remove(bKey);
            return aKey;
        }

    }
    
}