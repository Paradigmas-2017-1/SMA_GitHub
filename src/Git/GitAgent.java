package Git;
import java.util.ArrayList;

import Issue.Issue;
import jade.core.Agent;

public class GitAgent extends Agent {
	
	private ArrayList<Issue> issues = new ArrayList<Issue>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Method for initial configurations about Git Agent
	protected void setup() {
		System.out.println("Setup of Git Agent - "+ this.getLocalName());
	    
		// Setting behavior for Git Agent
	    addBehaviour(new GitControlIssuesBehavior(this));
	}
	
	
	
	
	
	
	// Methods to Issues control
	
	public void addIssue(Issue issue) {
		this.getIssues().add(issue);
	}

	public boolean removeIssue(String issueName) {
		for (Issue issue : issues) {
			if (issue.getName().equals(issueName)) {
				this.getIssues().remove(issue);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Issue> getIssues() {
		return issues;
	}

	public void setIssues(ArrayList<Issue> issues) {
		this.issues = issues;
	}
}
