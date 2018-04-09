package com.czx.mapper;

import com.czx.entity.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookMapper {

    @Insert("insert into book (name,price,publish_time) values(#{name},#{price},now())")
    void saveBook(Book book);

    @Select("select id,name,price,publish_time publishTime from book")
    List<Book> selectBookList();

    @Select("select id,name,price,publish_time publishTime from book where id = #{id}")
    Book selectBookDetail(Integer id);

    @Update("update book set name=#{name},price=#{price},publish_time=now() where id = #{id}")
    void updateBook(Book book);

    @Delete("delete from book where id = #{id}")
    void deleteBook(Integer id);

}
