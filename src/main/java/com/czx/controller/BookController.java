package com.czx.controller;

import com.czx.entity.Result;
import com.czx.Util.ResultUtil;
import com.czx.entity.Book;
import com.czx.service.BookService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("/hello")
    public Object hello(){
        return "Hello Spring Boot Mybatis";
    }

    @PostMapping("/saveBook")
    @ApiOperation(value = "保存图书信息")
    public Result<?> saveBook(@RequestBody @Valid Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.fail(1,bindingResult.getFieldError().getDefaultMessage());
        }
        bookService.saveBook(book);
        return ResultUtil.success();
    }

    @GetMapping("/selectBookList")
    @ApiOperation(value = "查询所有图书信息")
    public Result<List<Book>> selectBookList(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                             @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return ResultUtil.success(bookService.selectBookList());
    }

    @GetMapping("/selectBookDetail/{id}")
    @ApiOperation(value = "查询单个图书信息",notes = "根据id查询单个图书信息")
    public Result<Book> selectBookDetail(@PathVariable("id") Integer id){
        return ResultUtil.success(bookService.selectBookDetail(id));
    }

    @PutMapping("/updateBook")
    @ApiOperation(value = "修改图书信息",notes = "根据id修改图书信息")
    public Result<?> updateBook(@RequestBody Book book){
        bookService.updateBook(book);
        return ResultUtil.success();
    }

    @DeleteMapping("/deleteBook/{id}")
    @ApiOperation(value = "删除图书信息",notes = "根据id删除图书信息")
    public Result<?> deleteBook(@PathVariable("id") Integer id){
        bookService.deleteBook(id);
        return ResultUtil.success();
    }

}
