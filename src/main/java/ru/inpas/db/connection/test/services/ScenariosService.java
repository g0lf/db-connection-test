package ru.inpas.db.connection.test.services;

import ru.inpas.db.connection.test.dao.TestDao;
import ru.inpas.db.connection.test.entities.TestEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ScenariosService {

    @Inject
    private TestDao testDao;

    private TestEntity createNewTestEntity(Long someLongValue, String someStringValue) {
        TestEntity te = new TestEntity();
        te.setSomeLongValue(someLongValue);
        te.setSomeStringValue(someStringValue);
        return te;
    }

    public void scenario(long insertCount, long selectCount) {
        for (long i = 0; i < insertCount; i++) {
            testDao.insertTest(createNewTestEntity(i, Thread.currentThread().getName()));
        }

        List<TestEntity> testEntities = new ArrayList<>();
        for (long i = 0; i < selectCount; i++) {
            testEntities = testDao.getTestEntitiesBySomeStringValue(Thread.currentThread().getName());
        }

        int ind = 0;
        for (TestEntity te : testEntities) {
            te.setSomeStringValue(Thread.currentThread().getName() + "-updated" + ind++);
            testDao.updateTest(te);
        }

    }

    public void dbFilling(long insertCount) {
        for (long i = 0; i < insertCount; i++) {
            testDao.insertTest(createNewTestEntity(i, Thread.currentThread().getName()));
        }
    }
}
