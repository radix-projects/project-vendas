package com.radix.application.event.listener;

import com.radix.application.event.ResourceCreateEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class ResourceCreateListener {

    @EventListener(ResourceCreateEvent.class)
    public void onApplicationEvent(ResourceCreateEvent resourceCreateEvent) {
        HttpServletResponse response = resourceCreateEvent.getResponse();
        Long code = resourceCreateEvent.getId();

        addHeaderLocation(response, code);
    }

    private void addHeaderLocation(HttpServletResponse response, Long id) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                                             .buildAndExpand(id).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }

}
