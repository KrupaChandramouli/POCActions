package poc.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import poc.patient.model.FormattedWaveformModel;

@Controller
@CrossOrigin(origins = "*")
public class PatientLiveDataController {
	
	@Value("${stomp.topic}")
	private String stompTopic;
	

	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	@KafkaListener(topics = "${kafka.output.topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumeMessage(String msg) {
		System.out.println("Message received: " + msg);
		messagingTemplate.convertAndSend(stompTopic, msg);
	}

}
