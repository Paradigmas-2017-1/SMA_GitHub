package Developer;
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
			
			// Setting behavior for Developer Agent
			
			DeveloperControlIssueBehavior behavior1 = new DeveloperControlIssueBehavior(this);
			addBehaviour(behavior1);
	
			DeveloperDoIssueBehavior behavior2 = new DeveloperDoIssueBehavior(this);
			addBehaviour(behavior2);
			
			DeveloperDoMergeRequestBehavior behavior3 = new DeveloperDoMergeRequestBehavior(this);
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
}
