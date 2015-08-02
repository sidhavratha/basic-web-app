package tutorial.mvc;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tutorial.core.entities.Account;
import tutorial.core.entities.Blog;
import tutorial.core.services.AccountService;
import tutorial.core.services.exceptions.BlogExistsException;
import tutorial.rest.exceptions.ConflictException;
import tutorial.rest.mvc.AccountController;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Sidhavratha on 26/7/15.
 */
public class AccountControllerTest {

    @InjectMocks
    AccountController accountController;

    @Mock
    AccountService service;

    MockMvc mockMvc;

    private ArgumentCaptor<Account> accountCaptor;
    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
        accountCaptor = ArgumentCaptor.forClass(Account.class);
    }

    @Test
    public void getExistingAccount() throws Exception {
        Account foundAccount = new Account();
        foundAccount.setId(1L);
        foundAccount.setName("test");
        foundAccount.setPassword("test");

        when(service.findAccount(1L)).thenReturn(foundAccount);

        mockMvc.perform(get("/rest/accounts/1"))
                .andDo(print())
                .andExpect(jsonPath("$.password", is(nullValue())))
                .andExpect(jsonPath("$.name", is(foundAccount.getName())))
                .andExpect(status().isOk());
    }

    @Test
    public void createAccountNonExistingUserName() throws Exception {
        Account createdAccount = new Account();
        createdAccount.setId(1L);
        createdAccount.setPassword("test");
        createdAccount.setName("test");

        when(service.createAccount(any(Account.class))).thenReturn(createdAccount);

        mockMvc.perform(post("/rest/accounts")
        .content("{\"name\":\"test\",\"password\":\"test\"}")
        .contentType(MediaType.APPLICATION_JSON))
                //.andExpect(header().string("Location"))
        .andExpect(jsonPath("$.name", is(createdAccount.getName())))
        .andExpect(jsonPath("$.password", is(nullValue())))
        .andExpect(status().isCreated());

        verify(service).createAccount(accountCaptor.capture());

        String password = accountCaptor.getValue().getPassword();

        assertEquals(createdAccount.getPassword(), password);
    }

    @Test
    public void createBlogExistingBlogName() throws Exception {
        when(service.createBlog(eq(1L), any(Blog.class))).thenThrow(new BlogExistsException());
        mockMvc.perform(post("/rest/accounts/1/blogs")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"title\":\"Test Title\"}"))
        .andExpect(status().isConflict());
    }

}
