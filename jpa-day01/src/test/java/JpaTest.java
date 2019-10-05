import cn.itcast.pojo.Customer;
import cn.itcast.utlis.JpaUtlis;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

    @Test
    public void testSave(){
        EntityManager em = JpaUtlis.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();//开启事务
        Customer customer = new Customer();
        customer.setCustName("传智播客");
        customer.setCustIndustry("教育");
        em.persist(customer);
        tx.commit();
        em.close();
        ///factory.close();

    }

    @Test
    public void testfindById(){
        EntityManager entityManager = JpaUtlis.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = entityManager.find(Customer.class, 1L);
        System.out.println(customer);
        transaction.commit();
        entityManager.close();
    }
    @Test
    public void testReference(){
        EntityManager entityManager = JpaUtlis.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = entityManager.getReference(Customer.class, 1L);
        System.out.println(customer);
        transaction.commit();
        entityManager.close();
    }
    @Test
    public void testDelete(){
        EntityManager entityManager = JpaUtlis.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = entityManager.find(Customer.class, 1L);
        entityManager.remove(customer);
        //System.out.println(customer);
        transaction.commit();
        entityManager.close();
    }
    @Test
    public void testUpdate(){
        EntityManager entityManager = JpaUtlis.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = entityManager.find(Customer.class, 1L);
        customer.setCustIndustry("it教育");
        entityManager.merge(customer);
        //System.out.println(customer);
        transaction.commit();
        entityManager.close();
    }
}
