package spring.struct2.actions;

import spring.struct2.services.PersonService;

public class PerrsonAction {
	private PersonService personService;

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public String execute() {
		System.out.println("execute....");
		personService.save();
		return "success";
	}
}
