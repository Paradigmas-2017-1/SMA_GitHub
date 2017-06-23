package Git;

import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;

public class GitIssueStatesBehavior extends FSMBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GitIssueStatesBehavior(Agent agent) {
		super(agent);
	}
	
	@Override
	public void onStart() {
		System.out.println("Iniciando estado de issue - " + getExecutionState());
		
		super.onStart();
	}
	
	@Override
	public int onEnd() {
		System.out.println("Finalizando estado de issue - " + getExecutionState());
		
		return super.onEnd();
	}
	
}
