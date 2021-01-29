/***
 Consider a grading scheme where your final grade is computed more generously
 if your grades show improvement over the term.  Scores show improvement
 if each grade is greater than or equal to the previous grade.

 A student has x scores indexed from 0 to x-1.  If the scores have shown improvement
 only those grades with indexes greater than to equal to x/2 are averaged.  If the
 scores have not improved, all of the scores are averaged.
 ***/

public class GradeAverage {

    private int[] scores;

    public GradeAverage(int[] s) {scores = s;}

    // returns the mean (average) of the values in the scores array
    // whose indexes are between first and last (including first and last).
    //You may assume that first and last are > 0 and < scores.length
    private double mean(int first, int last)
    {
        double sum = 0.0;

        for(int i = first; i <= last; i++)
        {
            sum+=scores[i];
        }
        return sum/(last-first+1);
    }

    // returns true if each successive value in scores is greater than
    // or equal to the previous value.  Otherwise returns false
    private boolean showsImprovement() {
        for(int i = 0; i < scores.length-1; i++)
        {
            if (scores[i] > scores[i+1]) {return false;}
        }
        return true;
    }

    // if the values in the scores array show improvement, returns the
    // average of the elements in scores with indexes greater than or
    // equal to scores.length()/2
    public double finalGrade() {

        if (this.showsImprovement())
        {
            return this.mean(scores.length/2, scores.length-1);
        }
        return this.mean(0,scores.length-1);
    }

    public static void main(String[] args) {
        int[] s1 = {50, 50, 20, 80, 53};   // not improved, finalGrade is 50.6
        int[] s2 = {20, 50, 50, 53, 80};   // improved, final grade is 61.0
        int[] s3 = {20, 50, 50, 85};
        int[] s4 = {1,2,3,6,3};// improved, final grade is 67.5

        GradeAverage sr1 = new GradeAverage(s1);
        System.out.println("\nMean of S1: " + sr1.mean(0,4));
        System.out.println("Did S1 Improve?: " + sr1.showsImprovement());
        System.out.println("S1 Final Grade: " + sr1.finalGrade());

        GradeAverage sr2 = new GradeAverage(s2);
        System.out.println("\nMean of S2: " + sr2.mean(0,4));
        System.out.println("Did S2 Improve?: " + sr2.showsImprovement());
        System.out.println("S1 Final Grade: " + sr2.finalGrade());

        GradeAverage sr3 = new GradeAverage(s3);
        System.out.println("\nMean of S3: " + sr3.mean(0,3));
        System.out.println("Did S3 Improve?: " + sr3.showsImprovement());
        System.out.println("S1 Final Grade: " + sr3.finalGrade());
    }
}