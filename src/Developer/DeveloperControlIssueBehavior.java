package Developer;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class DeveloperControlIssueBehavior extends CyclicBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeveloperControlIssueBehavior(Agent agent) {
		super(agent);
	}
	
	@Override
	public void action() {
		System.out.println("Action of Control Issue Development");
		
	}
	
}
