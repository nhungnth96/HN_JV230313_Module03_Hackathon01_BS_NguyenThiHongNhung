package ra.bussiness;

import java.util.Scanner;

public class Book {
    private static Book[] bookList = new Book[100];
    private static int size;
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus = true;

    public Book() {
    }

    public Book(int bookId, String bookName, String author, String descriptions, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String displayData() {
        return "Book ID: " + bookId +
                " | Book Name: " + bookName + " | Author: " + author +
                " | Descriptions: " + descriptions + " | Import Price: " + importPrice +
                " | Export Price: " + exportPrice + " | Interest: " + interest + " | Status: " + bookStatus;
    }

    public void inputData() {
        getNewId();
        System.out.println("Nhập vào tên sách: ");
        while (true) {
            bookName = new Scanner(System.in).nextLine();
            if (bookName.length() == 0) {
                System.err.println("Không được để trống");
            } else {
                setBookName(bookName);
                break;
            }
        }
        System.out.println("Nhập vào tên tác giả: ");
        while (true) {
            author = new Scanner(System.in).nextLine();
            if (author.length() == 0) {
                System.err.println("Không được để trống");
            } else {
                setAuthor(author);
                break;
            }
        }
        System.out.println("Nhập vào mô tả: ");
        while (true) {
            descriptions = new Scanner(System.in).nextLine();

            if (descriptions.length() == 0) {
                System.err.println("Không được để trống");
            } else if (descriptions.length() < 10) {
                System.err.println("Mô tả phải chứa ít nhất 10 kí tự");
            } else {
                setDescriptions(descriptions);
                break;
            }
        }
        System.out.println("Nhập vào giá tiền nhập: ");
        while (true) {
            importPrice = new Scanner(System.in).nextDouble();
            if (importPrice <= 0) {
                System.err.println("Giá tiền nhập phải lớn hơn 0");
            } else {
                setImportPrice(importPrice);
                break;
            }
        }
        System.out.println("Nhập vào giá tiền xuất: ");
        while (true) {
            exportPrice = new Scanner(System.in).nextDouble();
            if (exportPrice < importPrice * 1.2) {
                System.err.println("Giá tiền xuất phải gấp 1.2 lần giá tiền nhập");
            } else {
                setExportPrice(exportPrice);
                break;
            }
        }
        interest = (float) (importPrice - exportPrice);
        System.out.println("Nhập vào trạng thái của sách: (true or false)");
        bookStatus = new Scanner(System.in).nextBoolean();
    }

    public int getNewId() {
        int maxId = 0;
        for (Book b : bookList) {
            if (b != null) {
                if (maxId < b.getBookId()) {
                    maxId = b.getBookId();
                }
            }
        }
        return maxId + 1;
    }
}
