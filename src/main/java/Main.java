import org.springhibernate.models.Role;
import org.springhibernate.store.UserStorage;
import org.springhibernate.store.RoleStorage;

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
        /*final UserStorage storage = new UserStorage();
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