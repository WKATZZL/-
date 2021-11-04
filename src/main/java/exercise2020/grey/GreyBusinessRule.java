package exercise2020.grey;

import exercise2020.grey.judge.GreyJudgeFeature;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mtage
 * @since 2020/10/22 14:12
 */
public class GreyBusinessRule {
    private String businessType;
    private boolean enabled;
    private List<GreyJudgeFeature> judgeRuleList;

    public GreyBusinessRule(String businessType, boolean enabled, String featureDescLine) {
        this.businessType = businessType;
        this.enabled = enabled;
        this.judgeRuleList = splitToFeatureList(featureDescLine);
    }

    public boolean grey(String greyTarget) {
        if (!enabled) {
            return false;
        }
        for (GreyJudgeFeature greyJudgeFeature : judgeRuleList) {
            if (greyJudgeFeature.grey(greyTarget)) {
                return true;
            }
        }
        return false;
    }

    private static List<GreyJudgeFeature> splitToFeatureList(String featureDescLine) {
        return Arrays.stream(featureDescLine.split("[{},]"))
                .filter(str -> !str.isBlank())
                .map(GreyJudgeFeature::createInstance)
                .collect(Collectors.toList());
    }
}
