//algortimul are ca parametrii instanta problema si o funcite solve ce returneaza solutia la problema
public abstract class Algorithm {
    private Problem problem;

    public Algorithm(Problem problem) {
        this.problem = problem;
    }

    public abstract Solution solve();

}

