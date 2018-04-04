package com.bookstore.controller.adminController;

import com.bookstore.domain.Book;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Rostyslav Kasprovych
 */

@Controller
@RequestMapping("/book")
public class AdminBookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value="/add", method= RequestMethod.GET)
    public String addBook(Model model ) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "addBook";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
        bookService.save(book);

        MultipartFile bookImage = book.getBookImage();

        try {
            byte[] bytes = bookImage.getBytes();
            String name = book.getId() + ".jpg";
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(new File("src/main/resources/static/image/book/" + name)));
            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:bookList";

    }

    @RequestMapping("/bookInfo")
    public String bookInfo(@RequestParam("id") Long id, Model model) {
        model.addAttribute("book", bookService.findOne(id));
        return "bookInfo";
    }

    @RequestMapping("/updateBook")
    public String updateBook(@RequestParam("id") Long id, Model model) {
        model.addAttribute("book", bookService.findOne(id));
        return "/updateBook";
    }

    @RequestMapping(value="/updateBook", method=RequestMethod.POST)
    public String updateBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
        bookService.save(book);

        MultipartFile bookImage = book.getBookImage();

        try {
            byte[] bytes = bookImage.getBytes();
            String name = book.getId() + ".jpg";

            Files.delete(Paths.get("src/main/resources/static/image/book/" + name));

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(new File("src/main/resources/static/image/book/" + name)));
            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/book/bookInfo?id="+book.getId();
    }




    @RequestMapping("/bookList")
    public String bookList(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "bookList";


    }

    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public String remove(
            @ModelAttribute("id") String id, Model model
    ) {
        bookService.removeOne(Long.parseLong(id.substring(8)));
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);

        return "redirect:/book/bookList";
    }
}
