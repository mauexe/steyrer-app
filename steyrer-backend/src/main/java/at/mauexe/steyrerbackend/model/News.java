package at.mauexe.steyrerbackend.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="NEWS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class News implements Serializable {

    public News(String title, String description, Date postedAt, String imageLink) {
        this.description = description;
        this.title = title;
        this.postedAt = postedAt;
        this.imageLink = imageLink;
    }

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Size(max=50)
    private String title;

    @NonNull
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name="POSTED_AT")
    private Date postedAt;

    @Size(max=2000)
    private String imageLink;
}
