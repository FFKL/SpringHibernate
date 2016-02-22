package org.springhibernate.store;

import org.springhibernate.models.Base;
import org.springhibernate.models.User;

import java.util.Collection;

public interface Storage {

    public Collection<?> values();

    public int add(final Base base);

    public void edit(final Base base);

    public void delete(final int id);

    public Base get(final int id);

    public Base findByLogin(final String login) ;

    public int generateId();

    public void close();
}