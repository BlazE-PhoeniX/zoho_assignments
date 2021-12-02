import java.util.ArrayList;

public interface Sortable<T> {
    void sort();
    ArrayList<T> cloneSort();
}
