package tutorial.rest.resources;

import org.springframework.hateoas.ResourceSupport;
import tutorial.core.entities.Blog;

/**
 * Created by Sidhavratha on 25/7/15.
 */
public class BlogResource extends ResourceSupport {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Blog toBlog()
    {
        Blog blog = new Blog();
        blog.setTitle(this.getTitle());
        return blog;
    }
}
