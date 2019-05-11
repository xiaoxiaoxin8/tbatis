package mapper;

import pojo.Blog;
import session.TSqlSession;

/**
 * @program: tbatis
 * @description:
 * @author: tangliang
 * @create: 2019-05-11 14:22
 **/
public interface BlogMapper {

    public Blog selectBlogById(int id);
}
