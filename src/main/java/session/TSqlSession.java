package session;

import config.TConfiguration;
import executor.TExecutor;

/**
 * @program: tbatis
 * @description:
 * @author: tangliang
 * @create: 2019-05-07 00:38
 **/
public class TSqlSession {

    private TConfiguration tConfiguration;
    private TExecutor tExecutor;

    public TSqlSession(TConfiguration tConfiguration,TExecutor tExecutor){
        this.tConfiguration = tConfiguration;
        this.tExecutor = tExecutor;
    }

    /**
     * 返回mapper的代理对象
     * @return
     */
    public <T> T getMapper(Class clazz){
        return tConfiguration.getMapper(clazz,this);
    }

    /**
     * 查询单个对象
     * @param statementId
     * @param paramter
     * @param <T>
     * @return
     */
    public <T> T selectOne(String statementId,Object paramter){
        String sql = TConfiguration.properties.getProperty(statementId);
        return tExecutor.query(sql,paramter);
    }
}
