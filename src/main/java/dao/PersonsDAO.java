package dao;
import model.Persons;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;
import model.Stuff;

public class PersonsDAO implements DAO<Persons, Integer> {

    private final SessionFactory factory;

    public PersonsDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Persons persons) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(persons);
            session.getTransaction().commit();
        }
    }

    @Override
    public Persons read(@NotNull final Integer id_person) {
        try (final Session session = factory.openSession()) {
            return session.get(Persons.class, id_person);
        }
    }

    @Override
    public void update(@NotNull final Persons persons)
    {
        try (Session session = factory.openSession())
        {
            session.beginTransaction();
            session.update(persons);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final Persons persons)
    {
        try (Session session = factory.openSession())
        {
            session.beginTransaction();
            session.delete(persons);
            session.getTransaction().commit();
        }
    }
}