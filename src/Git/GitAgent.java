package Git;
import jade.core.Agent;

public class GitAgent extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Method for initial configurations about Git Agent
	protected void setup() {
		System.out.println("Setup of Git Agent - "+ this.getLocalName());
	    
		// Setting behavior for Git Agent
	    addBehaviour(new GitBehaviors(this));
	}
}
