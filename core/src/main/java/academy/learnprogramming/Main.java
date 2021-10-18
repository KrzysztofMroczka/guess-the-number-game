package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        //create context
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // get NumberGenerator bean from context
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class); //name (String) needs to match name or ID in XML file if we use XML

        //call method next() to get random number
        int number = numberGenerator.next();

        //log generator number
        log.info("number = {}", number);

        // get Game bean from context
        Game game = context.getBean(Game.class);

        //close context
        context.close();

    }

}
