package exercise2020.grey.judge;

/**
 * @author mtage
 * @since 2020/10/22 14:01
 */
public class PercentGreyFeature extends GreyJudgeFeature {
    private double percentage;

    public PercentGreyFeature(double percentage) {
        this.percentage = percentage / 100;
    }

    @Override
    public boolean grey(String greyTarget) {
        return Math.random() < percentage;
    }
}
