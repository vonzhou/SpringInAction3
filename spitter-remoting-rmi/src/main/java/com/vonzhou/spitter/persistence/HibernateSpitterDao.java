//<start id="java_contextualHibernateDao"/> 
package com.vonzhou.spitter.persistence;

import com.vonzhou.spitter.common.Spitter;
import com.vonzhou.spitter.common.Spittle;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class HibernateSpitterDao implements SpitterDao {
    private SessionFactory sessionFactory;

    @Autowired
    public HibernateSpitterDao(SessionFactory sessionFactory) {//<co id="co_injectSessionFactory"/>
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();//<co id="co_getCurrentSession"/>
    }

    public void addSpitter(Spitter spitter) {
        currentSession().save(spitter);//<co id="co_useSession"/>
    }

    public Spitter getSpitterById(long id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }

    public void saveSpitter(Spitter spitter) {
        currentSession().update(spitter);//<co id="co_useSession"/>
    }

    /**
     * 思考:createCriteria是如何执行的? 是否会成为性能瓶颈
     * @return
     */
    public List<Spittle> getRecentSpittle() {
        List<Spittle> list =  currentSession().createCriteria(Spittle.class).list();
        return list;
    }

    public void saveSpittle(Spittle spittle) {
        currentSession().save(spittle);
    }

    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        Query query = currentSession().createQuery("from Spittle where spitter_id=:id");
        query.setParameter("id", spitter.getId());
        List<Spittle> list = query.list();
        return list;
    }

    /**
     * 学习使用 Hibernate Query Language (HQL), 注意语法, from的是映射类,而不是数据库表
     * TODO 确保 username 的唯一性
     * @param username
     * @return
     */
    public Spitter getSpitterByUsername(String username) {
        Query query = currentSession().createQuery("from Spitter where username=:name");
        query.setParameter("name", username);
        List<Spitter> list = query.list();
        // 确保非空(包含的有元素而不是 list == null),否则 IndexOutOfBoundsException
        return list.size() == 0 ? null : list.get(0);
    }

    public void deleteSpittle(long id) {
        currentSession().delete(getSpittleById(id));
    }

    public Spittle getSpittleById(long id) {
        return (Spittle) currentSession().get(Spittle.class, id);
    }

    public List<Spitter> findAllSpitters() {
        // TODO Auto-generated method stub
        return null;
    }
}