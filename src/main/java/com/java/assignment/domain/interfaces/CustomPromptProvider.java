package com.java.assignment.domain.interfaces;



import org.jline.utils.AttributedString;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;
@Component
public class CustomPromptProvider implements PromptProvider {
    public AttributedString getPrompt() {
        return new AttributedString("enter command: ");
    }
}
