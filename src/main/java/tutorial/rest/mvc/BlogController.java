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
import tutorial.core.services.exceptions.AccountExistsException;
import tutorial.rest.exceptions.ConflictException;
import tutorial.rest.resources.AccountResource;
import tutorial.rest.resources.BlogResource;
import tutorial.rest.resources.asm.AccountResourceAsm;

import java.net.URI;

/**
 * Created by Sidhavratha on 26/7/15.
 */
@Controller
@RequestMapping("/rest/accounts")
public class BlogController {

}
