package guru.springframework.domain;

import lombok.Data;

@Data
public class Recepie {
    private String descryption;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private Byte[] image;

}
