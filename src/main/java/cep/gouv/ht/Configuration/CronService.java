package cep.gouv.ht.Configuration;

import cep.gouv.ht.Models.Messagerie;
import cep.gouv.ht.Repository.ProcesVerbalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronService {

    @Autowired
    ProcesVerbalRepository procesVerbalRepository;

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    @Scheduled(cron="*/3 * * * * ?")
    public void demoServiceMethod()
    {
      Long countProcessverbal=procesVerbalRepository.getCountProcesVerbal();
       messagingTemplate.convertAndSend("/topic/messages", new Messagerie(countProcessverbal+""));
    }
}
