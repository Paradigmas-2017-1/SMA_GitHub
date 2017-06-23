package Issue;

import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class ProgressIssue extends OneShotBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Issue issue;
	
	public ProgressIssue() {
		this.setIssue(null);
	}
	
	public ProgressIssue(Issue issue) {
		this.setIssue(issue);
	}
	
	@Override
	public void action() {
		if (this.getIssue() != null) {
			System.out.println("Issue " + this.getIssue().getName() + " are in Progress");	

			ACLMessage acl = myAgent.receive();
			
			if (acl != null) {
				if (acl.getPerformative() == ACLMessage.CONFIRM) {
					System.out.println("Finish this Issue, change to Closed...");
				} else {
					// Stay in progress...
					block();
				}
			} else {
				block();
			}
		} else {
			System.out.println("In progress issue...");
		}
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

}
