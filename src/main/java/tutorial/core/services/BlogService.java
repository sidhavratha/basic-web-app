package tutorial.core.services;

import tutorial.core.entities.Blog;
import tutorial.core.entities.BlogEntry;
import tutorial.core.services.util.BlogEntryList;
import tutorial.core.services.util.BlogList;

/**
 * Created by Sidhavratha on 25/7/15.
 */
public interface BlogService {
    public Blog findBlog(long id);
    public BlogList findAllBlogs();
    public BlogEntry createBlogEntry(Long blogId, BlogEntry data);
    public BlogEntryList findAllBlogEntries(Long blogId);
}
