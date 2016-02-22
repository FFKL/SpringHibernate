package org.springhibernate.store;

import org.springhibernate.models.Base;
import org.springhibernate.models.Role;
import org.springhibernate.models.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Collection;
import java.util.List;

public class HibernateStorage /*implements Storage*/ {
    private final SessionFactory factory;

    public HibernateStorage() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public List<User> values() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from User").list();
        } finally {
            tx.commit();
            session.close();
        }
    }

    public int add(final Base user) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(user);
            return user.getId();
        } finally {
            tx.commit();
            session.close();
        }
    }

    public void edit(final Base user) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(user);
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

    public User get(int id) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return (User) session.get(User.class, id);
        } finally {
            tx.commit();
            session.close();
        }
    }

    public User findByLogin(String login) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            final Query query = session.createQuery("from User as user where user.login=:login");
            query.setString("login", login);
            return (User) query.iterate().next();
        } finally {
            tx.commit();
            session.close();
        }
    }

    public int generateId() {
        return 0;
    }

    public void close() {
        this.factory.close();
    }
}