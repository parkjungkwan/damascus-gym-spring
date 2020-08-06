package com.chatbot.web.utils;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.function.Function;

@Component @Lazy
public class Inventory<T> {
    private ArrayList<T> inventory;

    public Inventory() {inventory = new ArrayList<>();}
    public void add(T t) {inventory.add(t);}
    public T get(int i){
        Function<Integer, T> f = inventory :: get;
        return f.apply(i);
    }
    public ArrayList<T> get() {return inventory;}
    public void clear() {inventory.clear();}
    public int size() {return inventory.size();}
    public void newInventory() {inventory = new ArrayList<T>();}
}