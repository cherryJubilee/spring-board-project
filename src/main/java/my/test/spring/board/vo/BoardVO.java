package my.test.spring.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class BoardVO {
    private int boardId;
    private String userId;
    private String boardTitle;
    private String boardContent;
    private String boardDate;
    private String boardImg;
    private int boardLike;
    private int boardHate;
}