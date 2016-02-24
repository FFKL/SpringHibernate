package org.springhibernate.store;

import org.springhibernate.models.Base;
import org.springhibernate.models.User;

import java.util.Collection;

public interface Storage<T> {

    public Collection<T> values();

    public int add(final T user);

    public void edit(final T user);

    public void delete(final int id);

    public T get(final int id);

    public T findByLogin(final String login) ;

    public int generateId();

    public void close();
}