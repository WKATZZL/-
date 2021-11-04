package exercise2020.grey.judge;

/**
 * for range feature like 189-190
 * @author mtage
 * @since 2020/10/22 14:01
 */
public class RangeGreyFeature extends GreyJudgeFeature {
    private final int lower;
    private final int upper;

    public RangeGreyFeature(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    @Override
    public boolean grey(String greyTarget) {
        int startNumber = Integer.parseInt(greyTarget.substring(0, 3));
        return startNumber >= lower && startNumber <= upper;
    }
}
