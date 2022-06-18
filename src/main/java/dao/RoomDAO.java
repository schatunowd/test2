package dao;
import model.Room;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;

public class RoomDAO implements DAO<Room, Integer> {

    private final SessionFactory factory;

    public RoomDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Room room) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(room);
            session.getTransaction().commit();
        }
    }

    @Override
    public Room read(@NotNull final Integer id_room) {
        try (final Session session = factory.openSession()) {
            return session.get(Room.class, id_room);
        }
    }

    @Override
    public void update(@NotNull final Room room)
    {
        try (Session session = factory.openSession())
        {
            session.beginTransaction();
            session.update(room);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final Room room)
    {
        try (Session session = factory.openSession())
        {
            session.beginTransaction();
            session.delete(room);
            session.getTransaction().commit();
        }
    }
}