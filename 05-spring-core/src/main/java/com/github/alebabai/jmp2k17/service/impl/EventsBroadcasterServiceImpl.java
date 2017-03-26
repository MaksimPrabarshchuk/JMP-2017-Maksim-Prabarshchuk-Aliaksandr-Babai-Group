package com.github.alebabai.jmp2k17.service.impl;

import com.github.alebabai.jmp2k17.service.EventsBroadcasterService;
import com.github.alebabai.jmp2k17.service.EventsFactory;
import com.github.alebabai.jmp2k17.service.EventsInvokerService;
import org.springframework.scheduling.TaskScheduler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ScheduledFuture;

public class EventsBroadcasterServiceImpl implements EventsBroadcasterService {

    private final EventsFactory eventsFactory;
    private final EventsInvokerService invokerService;
    private final TaskScheduler scheduler;
    private ScheduledFuture<?> task;
    private long delay;

    public EventsBroadcasterServiceImpl(EventsFactory eventsFactory, EventsInvokerService invokerService, TaskScheduler scheduler) {
        this.eventsFactory = eventsFactory;
        this.invokerService = invokerService;
        this.scheduler = scheduler;
        this.delay = 1000;
    }

    @PostConstruct
    @Override
    public void start() {
        this.task = scheduler.scheduleWithFixedDelay(() -> invokerService.invoke(eventsFactory.createEvent()), delay);
    }

    @PreDestroy
    @Override
    public void stop() {
        this.task.cancel(true);
    }

    public long getDelay() {
        return delay;
    }

    public EventsBroadcasterServiceImpl setDelay(long delay) {
        this.delay = delay;
        return this;
    }
}
