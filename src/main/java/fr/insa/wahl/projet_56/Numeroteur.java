package fr.insa.wahl.projet_56;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


 // @param <Obj>

public class Numeroteur <Obj> {
    
    private List<Obj> objets;
    private HashMap<Obj,Integer> indexes;

    public Numeroteur() {
        this(new ArrayList<Obj>());
    }

    public Numeroteur(Collection<Obj> objets) {
        this.objets = new ArrayList<>();
        this.indexes = new HashMap<>(this.objets.size());
        for (int i = 0 ; i < this.objets.size() ; i ++) {
            this.indexes.put(this.objets.get(i), i);
        }
    }
    
    public int getOrAdd(Obj obj) {
        Integer res = this.indexes.get(obj);
        if (res == null) {
            res = this.objets.size();
            this.indexes.put(obj, res);
            this.objets.add(obj);
        }
        return res;
    }
     
     /**
     * retourne l'objet correspondant à un index.
     * @param index int
     * @return Object
     */
    public Obj getObject(int index) {
        Obj res = this.objets.get(index);
        if (res == null) {
            throw new IndexOutOfBoundsException();
        }
        return res;
    }

    /**
     * retourne tous les objets contenus dans le numéroteur.
     * @return Variable[] l'ensemble des variables du numéroteur
     */
    public Collection<Obj> getAllObjects() {
        return this.objets;
    }

    /**
     * retourne l'index correspondant à une variable.
     * @param var Variable var
     * @return int
     */
    public int getIndex(Obj var) {
        Integer res = this.indexes.get(var);
        if(res == null) {
            throw new IndexOutOfBoundsException();
        }
        return res;
    }

    @Override
    public String toString() {
        return "indexes=" + indexes;
    }

    public boolean add(Obj obj) {
        if (this.indexes.get(obj) == null) {
            this.indexes.put(obj, this.objets.size());
            this.objets.add(obj);
            return true;
        } else {
            return false;
        }
    }
    int size(){
       return objets.size();
    }
}
