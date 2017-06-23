package Git;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class GitControlIssuesBehavior extends CyclicBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public GitControlIssuesBehavior(GitAgent agent) {
		super(agent);
	}

	@Override
	public void action() {
		System.out.println("Action of Git Cyclick Behaviour");
		
		ACLMessage acl = myAgent.receive();
		
		if (acl != null) {
			if (acl.getPerformative() == ACLMessage.INFORM) {
				// New issue...
				System.out.println("New issue are inserted, need to send for any developer!");
			} else if (acl.getPerformative() == ACLMessage.PROPOSE) {
				// Issue are finished...
				System.out.println("Issue are finished!");
			} else {
				// Any message are receiver!
				System.out.println("Message received!");
			}
		} else {
			block();
		}
		
	}

}
