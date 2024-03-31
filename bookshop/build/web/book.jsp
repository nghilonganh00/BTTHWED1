<%-- 
    Document   : book
    Created on : Mar 31, 2024, 9:55:10 PM
    Author     : ASUS
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="a" class="data.BookList" scope="request"></jsp:useBean>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="styles/main.css">
            <title>Show Book Page</title>
            <script>
                function loadBookList() {
                    console.log('run')
                    var xhr = new XMLHttpRequest();
                    xhr.open("GET", "getBookList", true);
                    xhr.onreadystatechange = function () {
                        if (xhr.readyState == 4 && xhr.status == 200) {
                            var bookList = JSON.parse(xhr.responseText);
                            displayBookList(bookList);
                        }
                    };
                    xhr.send();
                }

                function displayBookList(bookList) {
                    var table = document.getElementById("bookTable");
                    table.innerHTML = ""; // Clear existing table
                    console.log(bookList);
                    bookList.forEach(function (book) {
                        var row = table.insertRow();
                        var titleCell = row.insertCell(0);
                        var authorCell = row.insertCell(1);
                        var isbnCell = row.insertCell(2);

                        titleCell.innerHTML = book.title;
                        authorCell.innerHTML = book.author;
                        isbnCell.innerHTML = book.isbn;
                    });
                }

                window.onload = function () {
                    loadBookList();
                };
            </script>
        </head>
        <body>
            <div class="container">
                <div class="content">
                    <h2>HTML Table</h2>
                    <div style="width: 120px">
                        <button>Thêm sách</button>
                    </div>
                    <table>
                        <tr>
                            <th>Company</th>
                            <th>Contact</th>
                            <th>Country</th>
                        </tr>
                       
                    </table>
                    <div id="bookTable"></div>
                </div>
            </div>

    </body>
</html>
