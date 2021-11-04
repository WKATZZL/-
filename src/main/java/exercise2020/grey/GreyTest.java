package exercise2020.grey;

/**
 * @author mtage
 * @since 2020/10/22 14:32
 */
public class GreyTest {
    public static void main(String[] args) {
        GreyLaunch greyLaunch = new GreyLaunch();
        greyLaunch.start();
        System.out.println(greyLaunch.grey("api_playMusic", "18289083467"));
        System.out.println(greyLaunch.grey("api_registerUser", "13489083467"));
    }
}
