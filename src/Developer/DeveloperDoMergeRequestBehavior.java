package Developer;

import java.io.IOException;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class DeveloperDoMergeRequestBehavior extends OneShotBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeveloperDoMergeRequestBehavior(Agent agent) {
		super(agent);
	}
	
	@Override
	public void action() {
		System.out.println("Submit merge request when issue are 100%.");
		
		// Need to validate if issue are finished...
			
		ACLMessage sendMessage = new ACLMessage(ACLMessage.INFORM);
		try {
			sendMessage.setContentObject(((DeveloperAgent) myAgent).getIssue());
			sendMessage.addReceiver(((DeveloperAgent) myAgent).getGitAgent());
			sendMessage.setConversationId("issue-finished");
			
			myAgent.send(sendMessage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
