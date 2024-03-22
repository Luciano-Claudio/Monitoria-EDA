import java.util.TreeSet;

public class TabelaHash_TreeSet implements TabelaHash {

    private int m;
    private TreeSet<Integer>[] tabela;

    public TabelaHash_TreeSet(int m) {
        this.m = m;
        this.tabela = new TreeSet[m];

        for (int i = 0; i < m; i++) {
            tabela[i] = new TreeSet<Integer>();
        }
    }

    private int hash(Integer key) {
        return key % m;
    }

    public void insert(Integer element) {
        int hashValue = hash(element);
        tabela[hashValue].add(element);
    }

    public void remove(Integer element) throws Exception {
        int hashValue = hash(element);
        if(!tabela[hashValue].contains(element)){
            throw new Exception("Element not found");
        }
        tabela[hashValue].remove(element);
    }

    public Integer search(Integer element) throws Exception {
        int hashValue = hash(element);
            if (tabela[hashValue].contains(element)) {
                return element;
            }

        throw new Exception("Element not found");
    }

    public String print() {
        String result = "";
        for (int i = 0; i < m; i++) {
            result += i + ": ";
            if (!tabela[i].isEmpty()) {
                Object[] elements = tabela[i].toArray();
                for (int j = 0; j < elements.length; j++) {
                    result += elements[j];
                    if (j < elements.length - 1) {
                        result += ", ";
                    }
                }
            }
            result += "\n";
        }
        return result;
    }
    
}
