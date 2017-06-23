package Issue;

import jade.core.behaviours.OneShotBehaviour;

public class ClosedIssue extends OneShotBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		System.out.println("Issue closed!");
	}

}
