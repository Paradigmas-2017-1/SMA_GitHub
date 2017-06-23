package Git;
import java.util.ArrayList;

import Issue.ClosedIssue;
import Issue.Issue;
import Issue.IssueStates;
import Issue.OpenIssue;
import Issue.ProgressIssue;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class GitAgent extends Agent {
	
	private ArrayList<Issue> issues = new ArrayList<Issue>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Method for initial configurations about Git Agent
	protected void setup() {
		System.out.println("Setup of Git Agent - "+ this.getLocalName());
	    
		DFAgentDescription df = new DFAgentDescription();
		df.setName(getAID());
		
		ServiceDescription sd = new ServiceDescription();
		sd.setName(getName());
		sd.setType("GitAgent");
		df.addServices(sd);

		try {
			DFService.register(this, df);
			
			// Setting behaviors for Git Agent
			GitControlIssuesBehavior behavior1 = new GitControlIssuesBehavior(this);
			addBehaviour(behavior1);

			GitIssueStatesBehavior behavior2 = new GitIssueStatesBehavior(this);
			behavior2.registerFirstState(new OpenIssue(), IssueStates.open.name());
			behavior2.registerState(new ProgressIssue(), IssueStates.in_progress.name());
			behavior2.registerLastState(new ClosedIssue(), IssueStates.closed.name());

			behavior2.registerDefaultTransition(IssueStates.open.name(), IssueStates.in_progress.name());
			behavior2.registerDefaultTransition(IssueStates.in_progress.name(), IssueStates.closed.name());
			
			addBehaviour(behavior2);
			
			GitEvaluateMergeRequestBehavior behavior3 = new GitEvaluateMergeRequestBehavior(this);
			addBehaviour(behavior3);
			
		} catch (FIPAException e) {
			e.printStackTrace();
			doDelete();
		}
	}
	
	@Override
	protected void takeDown() {
		try {
			System.out.println("Unregistering of DF");
			DFService.deregister(this);
		} catch (FIPAException e) {
			e.printStackTrace();
		}
		super.takeDown();
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
