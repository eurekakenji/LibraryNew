package ee.ivkhkdev.services;

import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.model.LibraryCard;

import java.util.List;

public class LibraryCardService implements Service<LibraryCard> {

    @Override
    public boolean add() {
        LibraryCard libraryCard = libraryCardHelper.create();
        if (libraryCard == null) return false;
        try{
            repository.save(LibraryCard);
            return true;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return false;
        }

    }

    @Override
    public boolean print() {
        libraryCardAppHelper.printList(repository.load());
    }

    @Override
    public List<LibraryCard> list() {
        return List.of();
    }

    @Override
    public boolean printList() {
        return false;
    }

    public List<LibraryCard> returnBook(){
        return repository.load();
    }
}
