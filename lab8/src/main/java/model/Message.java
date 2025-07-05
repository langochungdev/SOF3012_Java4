package model;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String text;
    private int type;
    private String sender;
    private Integer count;
}
