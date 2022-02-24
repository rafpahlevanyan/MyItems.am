package myItems.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private int id;
    private String title;
    private int price;
    private int categoryId;
    private String picUrl;
    private int userId;


}
