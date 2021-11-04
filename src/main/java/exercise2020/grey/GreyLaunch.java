package exercise2020.grey;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author mtage
 * @since 2020/10/22 13:27
 */
public class GreyLaunch {
    private final static String GREY_CONFIG_FILE = "/exercise2020/grey-config.txt";
    private final static int LOAD_RATE = 1;
    private Map<String, GreyBusinessRule> businessRuleMap;
    private ScheduledExecutorService executor;

    public void start() {
        readConfig();
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            System.out.println("reload config file...");
            readConfig();
        }, LOAD_RATE, LOAD_RATE, TimeUnit.SECONDS);
    }

    public boolean grey(String businessType, String greyTarget) {
        if (!businessRuleMap.containsKey(businessType)) {
            throw new NoSuchBusinessException("no such business type " + businessType);
        }
        return businessRuleMap.get(businessType).grey(greyTarget);
    }


    private void readConfig() {
        // usually a configuration file is small, so we collect all lines at a time
        InputStream fileInputStream = GreyLaunch.class.getResourceAsStream(GREY_CONFIG_FILE);
        List<String> allConfigLines = new BufferedReader(new InputStreamReader(fileInputStream))
                .lines().collect(Collectors.toList());
        String businessType = "";
        boolean enabled = false;
        String featureDescLine = "";
        Map<String, GreyBusinessRule> newMap = new HashMap<>(allConfigLines.size() / 3);
        for (int i = 0; i < allConfigLines.size(); i++) {
            if (i % 3 == 0) {
                businessType = allConfigLines.get(i);
            }
            if (i % 3 == 1) {
                enabled = Boolean.parseBoolean(allConfigLines.get(i));
            }
            if (i % 3 == 2) {
                featureDescLine = allConfigLines.get(i);
                newMap.put(businessType, new GreyBusinessRule(businessType, enabled, featureDescLine));
            }
        }
        this.businessRuleMap = newMap;
    }
}
