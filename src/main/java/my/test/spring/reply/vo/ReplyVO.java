package my.test.spring.reply.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO {

    private int replyId;
    private String userId;
    private int boardId;
    private String replyContent;
    private String replyDate;

}
