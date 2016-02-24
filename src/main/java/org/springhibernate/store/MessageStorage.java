package org.springhibernate.store;

import org.springframework.stereotype.Repository;
import org.springhibernate.models.Message;

import java.util.Collection;

@Repository
public class MessageStorage implements Storage<Message> {

    @Override
    public Collection<Message> values() {
        return null;
    }

    @Override
    public int add(Message user) {
        return 0;
    }

    @Override
    public void edit(Message user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Message get(int id) {
        return null;
    }

    @Override
    public Message findByLogin(String login) {
        return null;
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {

    }
}
