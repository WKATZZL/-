package exercise2020.grey.judge;

/**
 * single judge feature
 * @author mtage
 * @since 2020/10/22 13:58
 */
public abstract class GreyJudgeFeature {
    public abstract boolean grey(String greyTarget);

    /**
     * factory method for creating judge feature
     * @param featureDesc
     * @return
     */
    public static GreyJudgeFeature createInstance(String featureDesc) {
        if (featureDesc.startsWith("%")) {
            return new PercentGreyFeature(Double.parseDouble(featureDesc.substring(1)));
        }
        if (featureDesc.contains("-")) {
            String[] rangeBounds = featureDesc.split("-");
            return new RangeGreyFeature(Integer.parseInt(rangeBounds[0]), Integer.parseInt(rangeBounds[1]));
        }
        return new SpecificValueGreyFeature(Integer.parseInt(featureDesc));
    }
}
