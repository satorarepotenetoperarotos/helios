package ifmo;

import org.primefaces.model.UploadedFile;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name = "Discipline.delete", query = "DELETE FROM Discipline discipline where discipline.id = :id"),
        @NamedQuery(name = "Discipline.findById", query = "SELECT discipline FROM Discipline discipline where discipline.id = :id"),
        @NamedQuery(name = "Discipline.findAll", query = "SELECT discipline FROM Discipline discipline order by discipline.id")
})
@Entity
public class Discipline implements Serializable {
    @SequenceGenerator(name = "SEQ", sequenceName = "seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @Id
    private Long id;

    @NotNull
    @Column
    @Size(min = 1, max = 40)
    private String discipline;

    @NotNull
    @Column
    @Size(min = 1, max = 10000)
    private String description;

    @NotNull
    @Column
    @Size(min = 1, max = 40)
    private String firstName;

    @Column
    @Size(max = 40)
    private String middleName;

    @NotNull
    @Column
    @Size(min = 1, max = 40)
    private String lastName;

    @NotNull
    @Column
    private byte[] image;

    @Column
    @NotNull
    private Integer courseNumber;

    public Integer getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(Integer courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void uploadImage() {
        image = FileUploadView.getFile().getContents();
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(UploadedFile file) {
        this.image = file.getContents();
    }

    public String toString() {
        return discipline + " " + lastName + " " + firstName + " " + middleName + " " + description;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}