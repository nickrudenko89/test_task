package Daos;

import Entities.RequestEntity;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RequestDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public RequestEntity getRequestById(int id) {
        String messageHql = "FROM RequestEntity WHERE id = :id";
        Query query = sessionFactory.getCurrentSession().createQuery(messageHql);
        query.setParameter("id", id);
        return (RequestEntity) query.uniqueResult();
    }

    public int getRequestCountByStatus(int status) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT COUNT(*) FROM RequestEntity WHERE isCompleted=:status");
        query.setParameter("status", status);
        return ((Long) query.uniqueResult()).intValue();
    }

    public List<RequestEntity> getAll() {
        String messageHql = "FROM RequestEntity";
        Query query = sessionFactory.getCurrentSession().createQuery(messageHql);
        return query.list();
    }

    public void update(RequestEntity request) {
        sessionFactory.getCurrentSession().update(request);
    }

    public void save(RequestEntity request) {
        sessionFactory.getCurrentSession().save(request);
    }
}
