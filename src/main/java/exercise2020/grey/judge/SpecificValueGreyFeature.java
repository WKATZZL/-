package exercise2020.grey.judge;

/**
 * @author mtage
 * @since 2020/10/22 14:00
 */
public class SpecificValueGreyFeature extends GreyJudgeFeature {
    private final int number;

    public SpecificValueGreyFeature(int number) {
        this.number = number;
    }

    @Override
    public boolean grey(String greyTarget) {
        return greyTarget.startsWith("" + number);
    }
}
