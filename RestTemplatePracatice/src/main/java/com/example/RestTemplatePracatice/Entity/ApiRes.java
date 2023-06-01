package com.example.RestTemplatePracatice.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Comments;
import org.springframework.stereotype.Component;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ApiRes {
    private List<User> data;
    private Object status;
    private String Message;
}
