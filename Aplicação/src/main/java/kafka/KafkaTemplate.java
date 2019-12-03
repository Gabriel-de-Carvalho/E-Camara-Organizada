package kafka;

import org.springframework.beans.factory.annotation.Autowired;

public class KafkaTemplate<T, T1> {
		
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	 
	public void sendMessage(String msg) {
	    kafkaTemplate.send(topicName, msg);
	}
}
