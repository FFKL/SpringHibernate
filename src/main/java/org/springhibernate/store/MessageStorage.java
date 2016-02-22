package org.springhibernate.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springhibernate.models.Message;
import org.springhibernate.models.Role;
import org.springhibernate.models.User;

import java.util.Collection;

public class MessageStorage {
    private final SessionFactory factory;

    public MessageStorage() {
        factory = new Configuration().configure().buildSessionFactory();
    }
    public Collection<User> values() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from Message").list();
        } finally {
            tx.commit();
            session.close();
        }
    }

    public void add(final Message message) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(message);
        } finally {
            tx.commit();
            session.close();
        }
    }
}
