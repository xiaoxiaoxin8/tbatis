package tBatisTest;

import config.TConfiguration;
import executor.TExecutor;
import mapper.BlogMapper;
import session.TSqlSession;

/**
 * @program: tbatis
 * @description: 查询测试类
 * @author: tangliang
 * @create: 2019-05-07 00:12
 **/
public class Test {

    public static void main(String[] args) {
        TSqlSession tSqlSession = new TSqlSession(new TConfiguration(),new TExecutor());
        BlogMapper blogMapper = tSqlSession.getMapper(BlogMapper.class);
        blogMapper.selectBlogById(1);
    }


}
