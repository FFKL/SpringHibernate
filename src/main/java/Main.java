import org.springhibernate.models.Message;
import org.springhibernate.models.Role;
import org.springhibernate.models.User;
import org.springhibernate.store.HibernateStorage;
import org.springhibernate.store.MessageStorage;
import org.springhibernate.store.RoleStorage;
import org.springhibernate.store.Storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(final String[] args) throws Exception {
        /*final MessageStorage storage = new MessageStorage();
        Role role = new Role();
        role.setName("admin");
        User user = new User();
        user.setId(5);
        user.setLogin("test");
        user.setEmail("test@test");
        user.setRole(role);
        storage.add(new Message(user, "texttext"));*/
        final HibernateStorage storage = new HibernateStorage();
        System.out.println(storage.values());
        /*final HibernateStorage storage = new HibernateStorage();
        Role role = new Role();
        role.setName("admin");
        User user = new User();
        user.setLogin("test");
        user.setEmail("test@test");
        user.setRole(role);
        final int id = storage.add(user);
        user = storage.get(id);
        Message message = new Message();
        message.setUser(user);
        message.setText("text");
        HashSet<Message> messages = new HashSet<Message>();
        messages.add(message);
        user.setMessages(messages);
        storage.edit(user);
        System.out.println(storage.findByLogin("test"));*/

    }
}