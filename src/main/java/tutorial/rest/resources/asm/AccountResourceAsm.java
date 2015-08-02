package tutorial.rest.resources.asm;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import tutorial.core.entities.Account;
import tutorial.core.entities.BlogEntry;
import tutorial.rest.mvc.AccountController;
import tutorial.rest.mvc.BlogEntryController;
import tutorial.rest.resources.AccountResource;
import tutorial.rest.resources.BlogEntryResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Sidhavratha on 26/7/15.
 */
public class AccountResourceAsm extends ResourceAssemblerSupport<Account, AccountResource> {
    public AccountResourceAsm()
    {
        super(AccountController.class, AccountResource.class);
    }

    @Override
    public AccountResource toResource(Account account) {
        AccountResource res = new AccountResource();
        res.setName(account.getName());
        res.setPassword(account.getPassword());
        Link link = linkTo(AccountController.class).slash(account.getId()).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }
}
