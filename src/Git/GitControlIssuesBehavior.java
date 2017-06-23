package Git;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class GitControlIssuesBehavior extends CyclicBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GitControlIssuesBehavior(Agent agent) {
		super(agent);
	}

	@Override
	public void action() {
		System.out.println("Action of Git Cyclick Behaviour");
		
		ACLMessage acl = myAgent.receive();
		
		if (acl != null) {
			System.out.println("Message received!");
		} else {
			block();
		}
		
	}

}
