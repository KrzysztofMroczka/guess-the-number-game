package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        //create context
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // get NumberGenerator bean from context
        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class); //name (String) needs to match name or ID in XML file

        //call method next() to get random number
        int number = numberGenerator.next();

        //log generator number
        log.info("number = {}", number);

        // get Game bean from context
        Game game = context.getBean(Game.class);

        game.reset();

        //close context
        context.close();

    }

}
