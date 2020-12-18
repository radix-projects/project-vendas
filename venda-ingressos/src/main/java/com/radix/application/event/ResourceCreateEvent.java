package com.radix.application.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

@Getter
public class ResourceCreateEvent extends ApplicationEvent {

    private HttpServletResponse response;
    private Long id;

    public ResourceCreateEvent(Object source, HttpServletResponse response, Long id) {
        super(source);
        this.response = response;
        this.id = id;
    }
}
