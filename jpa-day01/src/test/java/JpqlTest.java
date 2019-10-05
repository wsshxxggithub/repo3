import cn.itcast.utlis.JpaUtlis;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpqlTest {
    @Test
    public void testFindAll(){
        EntityManager entityManager = JpaUtlis.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql ="from cn.itcast.pojo.Customer";
        Query query = entityManager.createQuery(jpql);
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);
        }
        transaction.commit();
        entityManager.close();
    }

    @Test
    public void testOrders(){
        EntityManager entityManager = JpaUtlis.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql ="from Customer order by custId desc";
        Query query = entityManager.createQuery(jpql);
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);
        }
        transaction.commit();
        entityManager.close();
    }
    @Test
    public void testCount(){
        EntityManager entityManager = JpaUtlis.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql ="select  count(custId) from Customer";
        Query query = entityManager.createQuery(jpql);
        Object result = query.getSingleResult();
        System.out.println(result);

        transaction.commit();
        entityManager.close();
    }
    @Test
    public void testPageQuery(){
        EntityManager entityManager = JpaUtlis.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql ="from Customer ";
        Query query = entityManager.createQuery(jpql);
        query.setFirstResult(0);
        query.setMaxResults(2);
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);
        }

        transaction.commit();
        entityManager.close();
    }
    @Test
    public void testCodition(){
        EntityManager entityManager = JpaUtlis.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql ="from Customer where custId = ?1";
        Query query = entityManager.createQuery(jpql);
        query.setParameter(1,1L);
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);
        }

        transaction.commit();
        entityManager.close();
    }
}
