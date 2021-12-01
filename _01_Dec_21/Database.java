package assignments.zoho._01_Dec_21;

import java.util.ArrayList;

public class Database<T extends Row> {
    protected String name;
    protected int noOfRows;
    protected ArrayList<T> rows;

    public Database(String name) {
        this.name = name;
        this.noOfRows = 0;
        rows = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return noOfRows;
    }

    public boolean addRow(T row) {
        for(T r: rows) {
            if(r.getId() == row.getId()) {
                return false;
            }
        }
        rows.add(row);
        return true;
    }

    public T getRow(int id) {
        for(T r: rows) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public T getRow(String name) {
        for(T r: rows) {
            if(((Student) r).getName().equals(name)) {
                return r;
            }
        }
        return null;
    }

    public boolean deleteRow(int id) {
        for(T r: rows) {
            if(r.getId() == id) {
                rows.remove(r);
                return true;
            }
        }
        return false;
    }

    public boolean deleteRow(String name) {
        for(T r: rows) {
            if(((Student) r).getName().equals(name)) {
                rows.remove(r);
                return true;
            }
        }
        return false;
    }
}
