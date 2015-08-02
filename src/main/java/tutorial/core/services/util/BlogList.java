package tutorial.core.services.util;

import tutorial.core.entities.Blog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sidhavratha on 26/7/15.
 */
public class BlogList {
    private List<Blog> blogs = new ArrayList<Blog>();

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
