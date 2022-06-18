package dao;
import model.Inventory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;

public class InventoryDAO implements DAO<Inventory, Integer> {

    private final SessionFactory factory;

    public InventoryDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Inventory inventory) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(inventory);
            session.getTransaction().commit();
        }
    }

    @Override
    public Inventory read(@NotNull final Integer id_inventory) {
        try (final Session session = factory.openSession()) {
            return session.get(Inventory.class, id_inventory);
        }
    }

    @Override
    public void update(@NotNull final Inventory inventory)
    {
        try (Session session = factory.openSession())
        {
            session.beginTransaction();
            session.update(inventory);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final Inventory inventory)
    {
        try (Session session = factory.openSession())
        {
            session.beginTransaction();
            session.delete(inventory);
            session.getTransaction().commit();
        }
    }
}