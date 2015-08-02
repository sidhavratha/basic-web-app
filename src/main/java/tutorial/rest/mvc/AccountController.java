package tutorial.rest.mvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tutorial.core.entities.Account;
import tutorial.core.entities.Blog;
import tutorial.core.services.AccountService;
import tutorial.core.services.exceptions.AccountDoesNotExistsException;
import tutorial.core.services.exceptions.AccountExistsException;
import tutorial.core.services.exceptions.BlogExistsException;
import tutorial.rest.exceptions.BadRequestException;
import tutorial.rest.exceptions.ConflictException;
import tutorial.rest.resources.AccountResource;
import tutorial.rest.resources.BlogEntryResource;
import tutorial.rest.resources.BlogResource;
import tutorial.rest.resources.asm.AccountResourceAsm;
import tutorial.rest.resources.asm.BlogResourceAsm;

import javax.security.auth.login.AccountNotFoundException;
import java.net.URI;

/**
 * Created by Sidhavratha on 26/7/15.
 */
@Controller
@RequestMapping("/rest/accounts")
public class AccountController {
    private AccountService accountService;
    public AccountController(AccountService accountService)
    {
        this.accountService = accountService;
    }

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<AccountResource> createAccount(
            @RequestBody AccountResource sentAccount
    ){
        try{
            Account createdAccount = accountService.createAccount(sentAccount.toAccount());
            AccountResource res = new AccountResourceAsm().toResource(createdAccount);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<AccountResource>(res, headers, HttpStatus.CREATED);
        }
        catch(AccountExistsException exception)
        {
            throw new ConflictException(exception);
        }
        catch(BlogExistsException exception)
        {
            throw new ConflictException(exception);
        }
    }

    @RequestMapping(value="/{accountId}",
            method= RequestMethod.GET)
    public ResponseEntity<AccountResource> getAccount(
            @PathVariable Long accountId
    ){
        Account account = accountService.findAccount(accountId);
        AccountResource res = new AccountResourceAsm().toResource(account);
        return new ResponseEntity<AccountResource>(res, HttpStatus.OK);
    }

    @RequestMapping(value="/{accountId}/blogs",
            method= RequestMethod.POST)
    public ResponseEntity<BlogResource> createBlog(
            @PathVariable Long accountId,
            @RequestBody BlogResource res
    ){
        try{
            Blog createdBlog = accountService.createBlog(accountId, res.toBlog());
            BlogResource createdBlogRes = new BlogResourceAsm().toResource(createdBlog);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(URI.create(createdBlogRes.getLink("self").getHref()));
            return new ResponseEntity<BlogResource>(createdBlogRes, httpHeaders, HttpStatus.OK);
        }
        catch(AccountDoesNotExistsException exception)
        {
            throw new BadRequestException(exception);
        }
        catch(BlogExistsException exception)
        {
            throw new ConflictException(exception);
        }
    }
}
