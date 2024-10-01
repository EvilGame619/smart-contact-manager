package com.scm20.demo.forms;

import com.scm20.demo.entities.enums.MessageType;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Message {
    private String message;
    private MessageType type = MessageType.blue;
}
