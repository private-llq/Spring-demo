package org.example.library;

public class DisplayOperation implements IOperation {

    @Override
    public void work(BookList bookList) throws OperationException {
        for (int i = 0; i < bookList.getBooks().size(); i++) {
            System.out.println(bookList.getBooks().get(i));

        }
    }

}
