package main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import config.MyBeanConfig;
import repository.IRepository;
import service.MessageService;
@Component(value = "main")
public class Main {
	
	public static void main(String[] args) {
		//2.main ne kreiramo preko new operatora
		BeanFactory container = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		Main main = container.getBean("main", Main.class);
		main.saveMessage("GLADAN SAM", container);
	}

	private void annotationConfig() {
		BeanFactory container = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		IRepository txtRepository = (IRepository)container.getBean("txtRepository");
		txtRepository.save("My plain message!");
		
		IRepository xmlRepository = container.getBean("xmlRepository", IRepository.class);
		xmlRepository.save("My xml message!");
		
		((AnnotationConfigApplicationContext)container).close();
	}
	
	private void saveMessage(String message, BeanFactory container) {
		//1. u zavisnosti od nekog uslova cuvamo poruku u txt repository ili xml repository
		/*BeanFactory container = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		MessageService messageService = 
				container.getBean("messageService", MessageService.class);
		*/
		
		MessageService messageService = container.getBean("messageServiceTxt", MessageService.class);
		messageService.save(message);
		((AnnotationConfigApplicationContext)container).close();
	}
}
