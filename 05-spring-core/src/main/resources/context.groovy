import com.github.alebabai.jmp2k17.service.impl.EventsBroadcasterServiceImpl
import com.github.alebabai.jmp2k17.service.impl.EventsFactoryImpl
import com.github.alebabai.jmp2k17.service.impl.EventsInvokerServiceImpl
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler

beans {
    scheduler(ThreadPoolTaskScheduler) {
        poolSize = 10
        removeOnCancelPolicy = true
    }

    eventsFactory(EventsFactoryImpl, 'Some event', 'Event data: %s') {
        eventLabel = 'Event label'
    }

    eventsInvoker(EventsInvokerServiceImpl)

    eventsBroadcaster(EventsBroadcasterServiceImpl, ref('eventsFactory'), ref('eventsInvoker'), ref('scheduler'))
}