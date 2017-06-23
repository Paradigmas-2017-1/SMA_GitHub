package Developer;

import Issue.Issue;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

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
		
		ACLMessage acl = myAgent.receive();
		
		if (acl != null) {
			if (acl.getPerformative() == ACLMessage.INFORM) {
				// Have new issue assigned...
				
				try {
					((DeveloperAgent) myAgent).setIssue((Issue) acl.getContentObject());
					((DeveloperAgent) myAgent).setPercentual(0);
					
					DeveloperDoIssueBehavior behavior = new DeveloperDoIssueBehavior(myAgent);
					myAgent.addBehaviour(behavior);
				} catch (UnreadableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Developer received new issue.");
			} else if (acl.getPerformative() == ACLMessage.FAILURE) {
				// Issue submitted are refused...
				System.out.println("Issue merge request are refused, need to work more.");
			} else {
				System.out.println("Message received!");
			}
		} else {
			block();
		}
	}
}
