package Issue;

import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class OpenIssue extends OneShotBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Issue issue;
	
	public OpenIssue() {
		this.setIssue(null);
	}
	
	public OpenIssue(Issue issue) {
		this.setIssue(issue);
	}
	
	@Override
	public void action() {
		if (this.getIssue() != null) {
			System.out.println("Issue " + this.getIssue().getName() + " are open!");
			
			ACLMessage acl = myAgent.receive();
			
			if (acl != null) {
				if (acl.getPerformative() == ACLMessage.ACCEPT_PROPOSAL) {
					System.out.println("Changed to in progress...");
				} else {
					// Stay openned
					block();
				}
			} else {
				block();
			}
		} else {
			System.out.println("Open Issue...");
		}
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

}
