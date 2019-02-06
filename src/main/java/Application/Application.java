package Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }


    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository){
        return (args) ->{
            repository.save(new BuddyInfo("Darsh","911"));
            repository.save(new BuddyInfo("Daman","911"));
            repository.save(new BuddyInfo("John","911"));
            repository.save(new BuddyInfo("Arun","911"));

            log.info("Buddys found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddy:repository.findAll()){
                log.info(buddy.toString());
            }
            log.info("");

            repository.findById(1L).ifPresent(buddyInfo -> {
                log.info("Buddy found with findById(1):");
                log.info("--------------------------------");
                log.info(buddyInfo.toString());
                log.info("");
            });

            log.info("Buddy found with findByName('Darsh'):");
            log.info("--------------------------------------------");
            repository.findByName("Darsh").forEach(darsh ->{
                log.info(darsh.toString());
            });
            log.info("");

        };
    }



}
