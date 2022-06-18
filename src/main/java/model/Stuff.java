package model;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Stuff {
    private int id;
    private int inventNum;
    private String purchaseDate;
    private String resPerson;
    private String place;
    private String comment;
}
