public class TowerSolver {
    private TowerModel model;

    public TowerSolver() {
        // Nothing to do here
    }

    public void solve(TowerModel model) {
        this.model = model;
        // Call the recursive method to solve the puzzle
        solve(model.height(), 0, 2, 1);
    }

    // Recursive method to solve Tower of Hanoi
    private void solve(int n, int source, int destination, int auxiliary) {
        if (n == 1) {
            model.move(source, destination); // Base case: Move 1 disk
            return;
        }

        // Move n-1 disks from source to auxiliary
        solve(n - 1, source, auxiliary, destination);
        
        // Move the nth (largest) disk from source to destination
        model.move(source, destination);
        
        // Move n-1 disks from auxiliary to destination
        solve(n - 1, auxiliary, destination, source);
    }
}