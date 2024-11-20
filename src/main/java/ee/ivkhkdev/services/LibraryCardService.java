package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.LibraryCardAppHelper;
import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Repository;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.model.LibraryCard;

import java.util.List;

public class LibraryCardService implements Service<LibraryCard> {
    private final AppHelper<LibraryCard> libraryCardAppHelper;
    private final Repository<LibraryCard> repository;

    public LibraryCardService(AppHelper<LibraryCard> libraryCardAppHelper, Repository<LibraryCard> repository) {
        this.libraryCardAppHelper =libraryCardAppHelper;
        this.repository = repository;
    }

    @Override
    public boolean add() {
        LibraryCard libraryCart = libraryCardAppHelper.create();
        if(libraryCart == null) return false;
        try {
            repository.save(libraryCart);
            return true;
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
            return false;
        }

    }

    @Override
    public boolean edit() {
        return false;
    }

    @Override
    public boolean print() {
        return libraryCardAppHelper.printList(repository.load());
    }

    @Override
    public List<LibraryCard> list() {
        return repository.load();
    }

    public boolean returnBook(){
        List<LibraryCard> modifiedLibraryCarts = ((LibraryCardAppHelper) libraryCardAppHelper).returnBack(this.list());
        if(modifiedLibraryCarts != null) {
            repository.saveAll(modifiedLibraryCarts);
            return true;
        }else{
            return false;
        }
    };

}