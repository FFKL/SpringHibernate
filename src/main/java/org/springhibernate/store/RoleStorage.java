package org.springhibernate.store;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springhibernate.models.Base;
import org.springhibernate.models.Role;
import org.springhibernate.models.User;

import java.util.Collection;

public class RoleStorage {

    private final SessionFactory factory;

    public RoleStorage() {
        factory = new Configuration().configure().buildSessionFactory();
    }
    public Collection<User> values() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from Role").list();
        } finally {
            tx.commit();
            session.close();
        }
    }

    public int add(final Role role) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(role);
            return role.getId();
        } finally {
            tx.commit();
            session.close();
        }
    }

    public void edit(final Role role) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(role);
        } finally {
            tx.commit();
            session.close();
        }
    }

    public void delete(int id) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(get(id));
        } finally {
            tx.commit();
            session.close();
        }
    }

    public Role get(int id) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return (Role) session.get(Role.class, id);
        } finally {
            tx.commit();
            session.close();
        }
    }

    public Role findByName(String name) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            final Query query = session.createQuery("from Role as role where role.name=:name");
            query.setString("name", name);
            return (Role) query.iterate().next();
        } finally {
            tx.commit();
            session.close();
        }
    }

    public void close() {
        this.factory.close();
    }
}