package Developer;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class DeveloperDoMergeRequestBehavior extends OneShotBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeveloperDoMergeRequestBehavior(Agent agent) {
		super(agent);
	}
	
	@Override
	public void action() {
		System.out.println("Submit merge request after issue closed.");
		
	}

}
