/*
 * (c) 2024 Mobile TeleSystems PJSC, Russia
 * All Rights Reserved.
 * <p>
 * NOTICE: All information contained herein is, and remains
 * the property of Mobile TeleSystems PJSC ("MTS" - NYSE:MBT; MOEX:MTSS)
 * and its suppliers, if any. The intellectual and technical concepts
 * contained herein are proprietary to Mobile TeleSystems PJSC
 * and its suppliers, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Mobile TeleSystems PJSC.
 */
package example;

import org.apache.camel.*;
import org.apache.camel.builder.NotifyBuilder;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * @author Alex
 * @since 12.06.2024
 */
@CamelSpringBootTest
public class JokeIT {

    @Autowired
    CamelContext camelContext;

    @Test
    void  test_positive() throws InterruptedException {
        NotifyBuilder notification = new NotifyBuilder(camelContext)
                .from("timer:timer?repeatCount=1").whenDone(1)
                .create();
        camelContext.start();
        notification.matches(10, TimeUnit.SECONDS) ;
        camelContext.stop();
    }

}
