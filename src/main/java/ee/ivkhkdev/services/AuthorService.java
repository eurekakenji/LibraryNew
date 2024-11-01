package ee.ivkhkdev.services;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.interfaces.Repository;

import java.util.List;

public class AuthorService implements Service {

    private Repository <Author> repository;
    private AppHelper <Author> appHelperAuthor;

    public AuthorService(AppHelper appHelperAuthor, Repository<Author> repository) {
        this.appHelperAuthor = appHelperAuthor;
        this.repository = repository;
    }

    public boolean add(){
        Author author = appHelperAuthor.create();
        if(author == null) return false;
        List<Author> authors = repository.load();
        try {
            repository.save(author);
            return true;
        }catch(Exception e){
            repository.save(author);
            return false;
        }
    }

    @Override
    public boolean print() {
        return false;
    }


    @Override
    public boolean printList() {
        List<Author> authors = repository.load();
        return appHelperAuthor.printList(authors);
    }

    public List<Author> list() {
        return repository.load();
    }
}
