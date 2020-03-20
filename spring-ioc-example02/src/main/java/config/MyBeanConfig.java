package config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import repository.IRepository;
import service.MessageService;
import service.impl.MessageServiceImpl;


@ComponentScan(basePackages =  {
		"main",
		"repository",
		
})
public class MyBeanConfig {
	
	
	@Bean (name = "messageServiceTxt")
	public MessageService getmessageServiceTxt (@Qualifier("txtRepository")IRepository iRepository) {
		return new MessageServiceImpl(iRepository);
	}
	
	@Bean (name = "messageServiceXml")
	public MessageService getmessageServiceXml (@Qualifier("xmlRepository")IRepository iRepository) {
		return new MessageServiceImpl(iRepository);
	}
	
	
	
	/*@Bean (name = "txtRepository")
	public IRepository getTxtRepository() {
		return new TxtRepository();
	}
	
	@Bean (name = "xmlRepository")
	public IRepository getXMLRepository() {
		return new XMLRepository();
	}
	
//	@Bean (name = "messageService")
//	public MessageService getMessageService() {
//		return new MessageServiceImpl(getXMLRepository());
//	}
	
	@Bean (name = "messageService")
	public MessageService getMessageService() {
		return new MessageServiceImpl();
	*/
	
}
