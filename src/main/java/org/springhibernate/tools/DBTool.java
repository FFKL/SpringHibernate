package org.springhibernate.tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springhibernate.models.Message;
import org.springhibernate.models.Role;
import org.springhibernate.models.User;
import org.springhibernate.store.Storages;

import java.util.HashSet;

public class DBTool {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Storages storage = context.getBean(Storages.class);
        System.out.println(storage.userStorage.values());
        Role role = new Role();
        role.setName("admin");
        User user = new User();
        user.setLogin("test");
        user.setEmail("test@test");
        user.setRole(role);
        final int id = storage.userStorage.add(user);
        user = storage.userStorage.get(id);
        Message message = new Message();
        message.setUser(user);
        message.setText("text");
        HashSet<Message> messages = new HashSet<Message>();
        messages.add(message);
        user.setMessages(messages);
        storage.userStorage.edit(user);
    }
}