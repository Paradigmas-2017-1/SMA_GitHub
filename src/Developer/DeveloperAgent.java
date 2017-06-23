package Developer;
import jade.core.Agent;

public class DeveloperAgent extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Method for initial configurations about Developer Agent
	protected void setup() {
		System.out.println("Setup of Developer Agent - "+ this.getLocalName());
	    
		// Setting behavior for Developer Agent
		addBehaviour(new DeveloperControlIssueBehavior(this));
	}
}
