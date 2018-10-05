package ru.inpas.db.connection.test.dao;

import ru.inpas.db.connection.test.entities.TestEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class TestDao {

    @PersistenceContext(unitName = "test")
    EntityManager em;

    public void insertTest(TestEntity te) {
        em.persist(te);
        em.flush();
        em.clear();
    }

    public void updateTest(TestEntity te) {
        em.merge(te);
        em.flush();
    }

    public void deleteTest(TestEntity te) {
        em.remove(te);
        em.flush();
    }

    public List<TestEntity> getTestEntities(Long someLongValue, String someStringValue) {
        TypedQuery<TestEntity> typedQuery = em.createQuery(
                "SELECT te FROM TestEntity te WHERE " +
                        "te.someLongValue=:someLongValue " +
                        "and te.someStringValue=:someStringValue",
                TestEntity.class);
        typedQuery.setParameter("someLongValue", someLongValue);
        typedQuery.setParameter("someStringValue", someStringValue);
        return typedQuery.getResultList();
    }

    public List<TestEntity> getTestEntitiesBySomeStringValue(String someStringValue) {
        TypedQuery<TestEntity> typedQuery = em.createQuery(
                "SELECT te FROM TestEntity te WHERE " +
                        "te.someStringValue=:someStringValue",
                TestEntity.class);
        typedQuery.setParameter("someStringValue", someStringValue);
        return typedQuery.getResultList();
    }

}
