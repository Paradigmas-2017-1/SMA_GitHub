package Issue;

import jade.core.behaviours.OneShotBehaviour;

public class ClosedIssue extends OneShotBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Issue issue;
	
	public ClosedIssue() {
		this.setIssue(null);
	}
	
	public ClosedIssue(Issue issue) {
		this.setIssue(issue);
	}

	@Override
	public void action() {
		// Just closed, don`t have any action to do...
		if (this.getIssue() != null) {
			System.out.println("Issue " + this.getIssue().getName() + " are closed!");
		} else {
			System.out.println("Issue closed...");
		}
		
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

}
