package tutorial.core.services;

import tutorial.core.entities.Account;
import tutorial.core.entities.Blog;

/**
 * Created by Sidhavratha on 25/7/15.
 */
public interface AccountService {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    public Blog createBlog(Long accountId, Blog data);
}
