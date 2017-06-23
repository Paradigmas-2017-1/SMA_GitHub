package Git;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class GitEvaluateMergeRequestBehavior extends OneShotBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GitEvaluateMergeRequestBehavior(Agent agent) {
		super(agent);
	}
	
	@Override
	public void action() {
		System.out.println("Action of Git One Shot Behaviour");
		
		ACLMessage acl = myAgent.receive();
		
		if (acl != null) {
			System.out.println("Message received!");
		} else {
			block();
		}
		
	}

}
