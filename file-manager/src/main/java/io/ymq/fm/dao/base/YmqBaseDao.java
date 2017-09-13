package io.ymq.fm.dao.base;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 描述: base Dao
 * author: yanpenglei
 * Date: 2017/9/8 19:50
 */
@Repository
public class YmqBaseDao extends BaseDao {

    @Resource
    public void setSqlSessionFactorFileManager(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
