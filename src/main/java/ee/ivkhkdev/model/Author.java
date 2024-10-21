package ee.ivkhkdev.model;

import java.io.Serializable;
import java.util.Objects;

public class Author implements Serializable {
    private static long count;
    private Long id;
    private String firstname;
    private String lastname;

    public Author() {
        id = count++;
    }

    public Author(String firstname, String lastname) {
        id = count++;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public static long getCount() {
        return count;
    }

    public static void setCount(long count) {
        Author.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;
        return Objects.equals(firstname, author.firstname) && Objects.equals(lastname, author.lastname);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(firstname);
        result = 31 * result + Objects.hashCode(lastname);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Author{");
        sb.append("id=").append(id);
        sb.append(", firstname='").append(firstname).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}