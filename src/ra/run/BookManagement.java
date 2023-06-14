package ra.run;

import ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    private static Book book = new Book();
    private static Book[] bookList = new Book[100];
    private static int size;
    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            System.out.println("*****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1: // add with quantity
                    add();
                    break;
                case 2: // display all
                    displayList();
                    break;
                case 3: // sort by interest

                    break;
                case 4: // delete by id
                    delete();
                    break;
                case 5: // search by bookName || des

                    break;
                case 6: // edit by id
                    edit();
                    break;
                case 7:
                    System.out.println("Cảm ơn và hẹn gặp lại!");
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập số từ 1 đến 7!");
            }
        }
    }

    public static void add() {
        Book newBook = new Book();
        System.out.println("Nhập số lượng sách thêm mới ");
        int quantity = new Scanner(System.in).nextInt();
        newBook.inputData();
        if (checkList(newBook)) {
            System.out.println("Thêm mới sách thành công!");
        }
    }

    public static boolean checkList(Book book) {
        if (size > 100) {
            System.err.println("Thư viện đã đầy! Không thể thêm sách");
            return false;
        }
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i] == null) {
                bookList[i] = book;
                size++;
                break;
            }
        }
        return true;
    }

    public static void displayList() {
        if (size == 0) {
            System.out.println("Thư viện trống");
        }
        for (Book b : bookList) {
            if (b != null) {
                System.out.println(b.displayData());
            }
        }
    }

    public static Book findbyId(int id) {
        for (Book b : bookList) {
            if (b != null) {
                if (b.getBookId() == id) {
                    return b;
                }
            }
        }
        return null;
    }
    public static void edit() {
        System.out.println("Nhập mã sách bạn muốn sửa: ");
        int editedId = new Scanner(System.in).nextInt();
        Book editedBook = findbyId(editedId);
        if (editedBook != null) {
            System.out.println("New name: " + "(Old: " + book.getBookName() + ")");
            editedBook.setBookName(new Scanner(System.in).nextLine());
            System.out.println("New author: " + "(Old: " + book.getAuthor() + ")");
            editedBook.setAuthor(new Scanner(System.in).nextLine());
            System.out.println("New descriptions: " + "(Old: " + book.getDescriptions() + ")");
            editedBook.setDescriptions(new Scanner(System.in).nextLine());
            System.out.println("New imtport price: " + "(Old: " + book.getImportPrice() + ")");
            editedBook.setImportPrice(new Scanner(System.in).nextDouble());
            System.out.println("New export price: " + "(Old: " + book.getImportPrice() + ")");
            editedBook.setImportPrice(new Scanner(System.in).nextDouble());
            System.out.println("New status: " + "(Old: " + book.isBookStatus() + ")");
            editedBook.setBookStatus(new Scanner(System.in).nextBoolean());
            for (int i = 0; i < bookList.length; i++) {
                if (bookList[i].getBookId() == editedBook.getBookId()) {
                    bookList[i] = editedBook;
                    break;
                }
                System.out.println("Thay đổi thông tin sách thành công!");
            }
        } else {
            System.out.println("Không tìm thấy mã sách này");
        }

    }
    public static void delete() {
        System.out.println("Nhập mã sách bạn muốn xóa: ");
        int deleteId = new Scanner(System.in).nextInt();
        Book deleteBook = findbyId(deleteId);
        if (deleteBook != null) {
            System.out.println(deleteBook);
            System.out.println("Bạn có chắc chắn muốn xóa cuốn sách này?");
            System.out.println("1.Có");
            System.out.println("2.Không");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < bookList.length; i++) {
                        if (bookList[i] != null) {
                            if (bookList[i].getBookId() == deleteId) {
                                bookList[i] = null;
                                size--;
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    break;
                default:
                    System.err.println("Vui lòng nhập số 1 hoặc 2");
            }
        }
    }


}
