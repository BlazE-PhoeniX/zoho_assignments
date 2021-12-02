public abstract class Row implements Comparable<Row> {
    protected int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public abstract int compareTo(Row row);
}
