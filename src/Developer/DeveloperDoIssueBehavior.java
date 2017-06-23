package Developer;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class DeveloperDoIssueBehavior extends CyclicBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeveloperDoIssueBehavior(Agent agent) {
		super(agent);
	}
	
	@Override
	public void action() {
		System.out.println("Action of Development Issue");
		
		if (((DeveloperAgent) myAgent).getPercentual() == 100) {
			DeveloperDoMergeRequestBehavior behavior = new DeveloperDoMergeRequestBehavior(myAgent);
			myAgent.addBehaviour(behavior);
		} else {
			((DeveloperAgent) myAgent).setPercentual(((DeveloperAgent) myAgent).getPercentual() + 1);
			block();
		}
		
	}

}
