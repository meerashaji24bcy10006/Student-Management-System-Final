import java.util.ArrayList;

public class ResultManager {

    private ArrayList<Result> results;

    public ResultManager(ArrayList<Result> results) {
        this.results = results;
    }

    public void addResult(Result result) {
        results.add(result);
        FileManager.saveResult(result);
    }

    public Result searchResult(int studentId) {

        for (Result result : results) {
            if (result.getStudentId() == studentId) {
                return result;
            }
        }

        return null;
    }

    public ArrayList<Result> getResults() {
        return results;
    }
}