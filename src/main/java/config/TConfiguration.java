package config;

import proxy.TMapperProxy;
import session.TSqlSession;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;
import java.lang.reflect.Proxy;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @program: tbatis
 * @description: 配置文件解析对象
 * @author: tangliang
 * @create: 2019-05-07 00:39
 **/
public class TConfiguration {

    public static Properties properties = new Properties();
    static{
        try{
            InputStream inputStream = new FileInputStream(new File("D:\\工作学习\\咕泡\\mybatis核心\\基本使用方式\\mybatis-课程源码\\tbatis\\target\\classes\\tsql.properties"));
            properties.load(inputStream);
            System.out.println(properties);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public <T> T getMapper(Class clazz,TSqlSession tSqlSession) {
        //通过代理
        TMapperProxy tMapperProxy = new TMapperProxy(tSqlSession);

        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz},
                tMapperProxy);
    }
}
