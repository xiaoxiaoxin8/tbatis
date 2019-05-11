package proxy;

import session.TSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: tbatis
 * @description: mapper代理对象
 * @author: tangliang
 * @create: 2019-05-11 13:52
 **/
public class TMapperProxy implements InvocationHandler {

    private TSqlSession tSqlSession;

    public TMapperProxy(TSqlSession tSqlSession){
        this.tSqlSession = tSqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String statementid = method.getDeclaringClass().getName()+"."+method.getName();
        return tSqlSession.selectOne(statementid,args[0]);
    }

}
