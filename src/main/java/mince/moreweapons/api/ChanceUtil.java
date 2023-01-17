package mince.moreweapons.api;

import java.util.Random;

public class ChanceUtil {
    public static boolean percentChance(int chance){
        return new Random().nextInt(100) < chance;
    }
}
