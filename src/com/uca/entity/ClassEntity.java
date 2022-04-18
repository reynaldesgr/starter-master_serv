package com.uca.entity;

import java.util.Collection;
import java.util.Iterator;

public class ClassEntity implements Collection<StudentEntity> {
    private Collection<StudentEntity> students;
    private String classname;

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    /** Re-usage of Collection<StudentEntity> to implement Collection<T> **/
    @Override
    public int size() { return students.size(); }

    @Override
    public boolean isEmpty() { return students.isEmpty(); }

    @Override
    public boolean contains(Object o) { return students.contains(o); }

    @Override
    public Iterator<StudentEntity> iterator() { return students.iterator(); }

    @Override
    public Object[] toArray() { return students.toArray(); }

    @Override
    public <T> T[] toArray(T[] a) { return students.toArray(a); }

    @Override
    public boolean add(StudentEntity studentEntity) { return students.add(studentEntity);
    }

    @Override
    public boolean remove(Object o) { return students.remove(o); }

    @Override
    public boolean containsAll(Collection<?> c) { return students.containsAll(c); }

    @Override
    public boolean addAll(Collection<? extends StudentEntity> c) { return students.addAll(c); }

    @Override
    public boolean removeAll(Collection<?> c) { return students.removeAll(c); }

    @Override
    public boolean retainAll(Collection<?> c) { return students.retainAll(c); }

    @Override
    public void clear() { students.clear(); }
}
