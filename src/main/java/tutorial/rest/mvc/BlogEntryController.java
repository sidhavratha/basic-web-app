package tutorial.rest.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tutorial.core.entities.BlogEntry;
import tutorial.core.services.BlogEntryService;
import tutorial.rest.resources.BlogEntryResource;
import tutorial.rest.resources.asm.BlogEntryResourceAsm;

/**
 * Created by Sidhavratha on 25/7/15.
 */
@Controller
@RequestMapping(value="/rest/blog-entries")
public class BlogEntryController {

    /*@RequestMapping("/test")
    public ResponseEntity<Object> test()
    {
        BlogEntry entry = new BlogEntry();
        entry.setTitle("Hello world");
        return new ResponseEntity(entry, HttpStatus.OK);
    }

    @RequestMapping("/test2")
    public @ResponseBody BlogEntry test2()
    {
        BlogEntry entry = new BlogEntry();
        entry.setTitle("Hello world");
        return entry;
    }

    @RequestMapping("/test3")
    public @ResponseBody BlogEntry test3(@RequestBody BlogEntry entry)
    {
        entry.setTitle("Modified "+entry.getTitle());
        return entry;
    }*/

    private BlogEntryService service;

    public BlogEntryController(BlogEntryService service)
    {
        this.service = service;
    }

    @RequestMapping(value="/{blogEntryId}",
            method = RequestMethod.GET)
    public ResponseEntity<BlogEntryResource> getBlogEntry(
            @PathVariable Long blogEntryId){
        BlogEntry entry = service.findBlogEntry(blogEntryId);
        if(entry!=null)
        {
            BlogEntryResource res = new BlogEntryResourceAsm().toResource(entry);
            return new ResponseEntity<BlogEntryResource>(res, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
        }
    }


}
