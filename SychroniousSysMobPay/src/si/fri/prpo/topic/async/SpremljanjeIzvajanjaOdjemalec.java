package si.fri.prpo.topic.async;

import java.util.Properties;
import java.util.Scanner;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SpremljanjeIzvajanjaOdjemalec {
	private static ConnectionFactory connectionFactory;
	private static Topic topic;
	private static JMSContext jmsContext;
	private static JMSConsumer jmsConsumer;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Properties properties = new Properties();
		properties.put(Context.PROVIDER_URL, "mq://localhost:7676");
		
		try {
			Context context = new InitialContext(properties);
			connectionFactory = (ConnectionFactory) context.lookup("jms/narocniska_razmerja_cf");
			topic = (Topic) context.lookup("jms/narocniska_razmerja_spremljanje_topic");
			jmsContext = connectionFactory.createContext();
			jmsConsumer = jmsContext.createConsumer(topic);
			
			System.out.print("Izberite nacin prejemanja (0 - sinhrono, 1 - asinhrono): ");
			int nacinPrejemanja = sc.nextInt();
			if(nacinPrejemanja == 1) {
				sprejemajAsinhrno();
				while(true) {
					Thread.sleep(10000);
				}
			} else if (nacinPrejemanja == 0){
				sprejemajSinhrono();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
			jmsConsumer.close();
			jmsContext.close();
		}
	}
	
	/**
	 * Metoda, ki implementira sinhrono poslusanje, v neskoncni zanki caka na
	 * sporocila.
	 */
	private static void sprejemajSinhrono() {
		System.out.println("Zacenjam SINHRONO prejemanje");
		while (true) {
			Message message = jmsConsumer.receive(1000);
			if (message != null && message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				try {
					System.out.println(textMessage.getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Metoda, ki implementira asinhrono prejemanje sporocil. Consumerju
	 * nastavimo message listener, ki implementira onMessage metodo.
	 */
	private static void sprejemajAsinhrno() {
		System.out.println("Zacenjam ASINHRONO prejemanje");
		jmsConsumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				if (message != null && message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage) message;
					try {
						System.out.println(textMessage.getText());
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			}
		});
		jmsContext.start();
	}
}
