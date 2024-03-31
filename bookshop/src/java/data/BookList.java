/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class BookList {

    public List<Book> getListBook() {
        List<Book> list = new ArrayList<>();

        list.add(new Book("Sách a", "Tác giả a", "2024"));
        list.add(new Book("Sách b", "Tác giả b", "2024"));
        list.add(new Book("Sách c", "Tác giả c", "2024"));
        list.add(new Book("Sách d", "Tác giả d", "2024"));
        list.add(new Book("Sách e", "Tác giả e", "2024"));
        System.out.println("list: " + list);
        return list;

    }
}
