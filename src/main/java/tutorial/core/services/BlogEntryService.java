package tutorial.core.services;

import tutorial.core.entities.BlogEntry;

/**
 * Created by Sidhavratha on 25/7/15.
 */
public interface BlogEntryService {
    public BlogEntry findBlogEntry(Long id);
    public BlogEntry deleteBlogEntry(Long id);
    public BlogEntry updateBlogEntry(Long id, BlogEntry data);
}
