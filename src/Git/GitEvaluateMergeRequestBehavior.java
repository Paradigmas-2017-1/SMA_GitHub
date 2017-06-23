package Git;

import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class GitEvaluateMergeRequestBehavior extends OneShotBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GitEvaluateMergeRequestBehavior(GitAgent agent) {
		super(agent);
	}
	
	@Override
	public void action() {
		System.out.println("Action of Git One Shot Behaviour");
		
		ACLMessage acl = myAgent.receive();
		
		if (acl != null) {
			if (acl.getPerformative() == ACLMessage.INFORM) {
				// Receive information that issue are submitted.
				
				ACLMessage sendMessage = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
				
				sendMessage.addReceiver(acl.getSender());
				sendMessage.setConversationId("accept-merge-request");
				
				myAgent.send(sendMessage);
			} else {
				// Any message are receiveid.
				System.out.println("Message received!");
			}
		} else {
			block();
		}
		
	}

}
