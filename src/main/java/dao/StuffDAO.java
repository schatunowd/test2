package dao;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;
import model.Stuff;

public class StuffDAO implements DAO<Stuff, Integer> {

    private final SessionFactory factory;

    public StuffDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Stuff stuff) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(stuff);
            session.getTransaction().commit();
        }
    }

    @Override
    public Stuff read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {
            return session.get(Stuff.class, id);
        }
    }

    @Override
    public void update(@NotNull final Stuff stuff)
    {
        try (Session session = factory.openSession())
        {
            session.beginTransaction();
            session.update(stuff);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final Stuff stuff)
    {
        try (Session session = factory.openSession())
        {
            session.beginTransaction();
            session.delete(stuff);
            session.getTransaction().commit();
        }
    }
}