package com.example.RestTemplatePracatice.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class ApiRes1 {
    private Object data;
    private Object status;
    private String Message;
}
