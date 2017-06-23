package Developer;
import Issue.Issue;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class DeveloperAgent extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AID gitAgent;
	private Integer percentual;
	private Issue issue;

	// Method for initial configurations about Developer Agent
	protected void setup() {
		System.out.println("Setup of Developer Agent - "+ this.getLocalName());
	    
		DFAgentDescription df = new DFAgentDescription();
		df.setName(getAID());
		
		ServiceDescription sd = new ServiceDescription();
		sd.setName(getName());
		sd.setType("DeveloperAgent");
		df.addServices(sd);
		
		try {
			DFService.register(this, df);
			
			DFAgentDescription adGitAgent = new DFAgentDescription();
			ServiceDescription sdGitAgent = new ServiceDescription();
			sdGitAgent.setType("book-selling");
			adGitAgent.addServices(sd);
			try {
				DFAgentDescription[] result = DFService.search(this, adGitAgent); 
				this.setGitAgent(result[0].getName());
			} catch (FIPAException e) {
				e.printStackTrace();
			}
			
			// Setting behavior for Developer Agent
			
			DeveloperControlIssueBehavior behavior1 = new DeveloperControlIssueBehavior(this);
			addBehaviour(behavior1);
			
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

	public Integer getPercentual() {
		return percentual;
	}

	public void setPercentual(Integer percentual) {
		this.percentual = percentual;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public AID getGitAgent() {
		return gitAgent;
	}

	public void setGitAgent(AID gitAgent) {
		this.gitAgent = gitAgent;
	}
}
