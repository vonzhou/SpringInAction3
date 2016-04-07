package com.vonzhou.spitter.service;

import static java.lang.Math.*;
import static java.util.Collections.*;

import java.util.List;

import com.vonzhou.spitter.persistence.Spitter;
import com.vonzhou.spitter.persistence.SpitterDao;
import com.vonzhou.spitter.persistence.Spittle;
import org.hibernate.HibernateException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 编码式事务:自己控制事务的边界-开始,提交,结束
 */
@Transactional(propagation = Propagation.REQUIRED)
public class SpitterServiceImpl implements SpitterService {

    public void saveSpitter(final Spitter spitter) {
        transactionTemplate.execute(new TransactionCallback<Void>() {
            public Void doInTransaction(TransactionStatus txStatus) {
                try {
                    spitterDao.addSpitter(spitter);

                    // 测试失败的情况,看是否会回滚(记录不会插入到数据库)
                    // 然而记录仍然插入到了数据库,为何??
//                    if(true)
//                        throw new HibernateException("Network exception oops");

                } catch (RuntimeException e) {
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
    }


    public void saveSpittle(final Spittle spittle) {
        transactionTemplate.execute(new TransactionCallback<Void>() {
            public Void doInTransaction(TransactionStatus txStatus) {
                try {
                    spitterDao.saveSpittle(spittle);
                } catch (RuntimeException e) {
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Spittle> getRecentSpittles(int count) {
        List<Spittle> recentSpittles =
                spitterDao.getRecentSpittle();

        reverse(recentSpittles);

        return recentSpittles.subList(0,
                min(49, recentSpittles.size()));
    }


    public Spitter getSpitter(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Spitter getSpitter(String username) {
        return spitterDao.getSpitterByUsername(username);
    }

    public void startFollowing(Spitter follower, Spitter followee) {
        // TODO Auto-generated method stub

    }

    public List<Spittle> getSpittlesForSpitter(
            Spitter spitter) {
        return spitterDao.getSpittlesForSpitter(spitter);
    }

    public void deleteSpittle(long id) {
        spitterDao.deleteSpittle(id);
    }

    public Spittle getSpittleById(long id) {
        return spitterDao.getSpittleById(id);
    }

    private SpitterDao spitterDao;

    public void setSpitterDao(SpitterDao spitterDao) {
        this.spitterDao = spitterDao;
    }

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public List<Spittle> getSpittlesForSpitter(
            String username) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Spitter> getAllSpitters() {
        return spitterDao.findAllSpitters();
    }
}
