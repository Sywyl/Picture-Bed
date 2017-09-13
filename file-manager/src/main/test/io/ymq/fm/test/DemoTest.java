package io.ymq.fm.test;

import com.alibaba.fastjson.JSONObject;
import io.ymq.fm.dao.base.BaseUtils;
import io.ymq.fm.dao.base.YmqBaseDao;
import io.ymq.fm.model.base.BaseTestUtil;
import io.ymq.fm.model.base.QueryResult;
import io.ymq.fm.model.po.ImagesPo;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 描述:
 * author: yanpenglei
 * Date: 2017/9/8 18:17
 */

public class DemoTest extends BaseTestUtil {

    @Autowired
    private YmqBaseDao ymqBaseDao;


    @Test
    public void test() {

        for (int i = 1; i <=40; i++) {
            ImagesPo ImagesPo = new ImagesPo();

            ImagesPo.setName(i+":美女一张");
            ImagesPo.setRemark("没有描述");
            ImagesPo.setUrl("img/imgDemo.jpg");
            ImagesPo.setWidth(400);
            ImagesPo.setHeight(400);
            ImagesPo.setStatus(0);

            ImagesPo.setCreateUser(0);
            ImagesPo.setUpdateUser(0);

            ImagesPo.setScreateTime(new Date());
            ImagesPo.setSupdateTime(new Date());

            System.out.println(ymqBaseDao.insert(ImagesPo));

        }

    }

    @Test
    public void testPage() {
        ImagesPo ImagesPo = new ImagesPo();


        /**
         * 此方法返回数据结果集和count
         *
         * @param statementPostfix 自定义方法名(mybatis namespace)
         * @param entity           参数对象
         * @param pageNum          页码
         * @param pageSize         每页记录数
         * @param orderBy          排序字段(例：'id desc')
         * @param statementCount   自定义count查询语句
         * @return
         */
        Integer pageNum = 1, pageSize = 10;


        pageNum = ((pageNum * pageSize) / pageSize) + 1;

        QueryResult<ImagesPo> queryResult = ymqBaseDao.selectListAndCount(BaseUtils.makeClazzPath(ImagesPo.getClass(), "selectList"), ImagesPo, pageNum, pageSize, "images_id");

        for (int i = 0; i < queryResult.getlist().size(); i++) {
            System.out.println(queryResult.getTotal());
            System.out.println(JSONObject.toJSONString(queryResult.getlist().get(i)));
        }

    }


}
