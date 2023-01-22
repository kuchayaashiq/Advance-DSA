package Other;

import java.util.*;
import java.util.stream.Collectors;

public class BeatMonsterProblem {
   static class Monster {
        private final int power, bonus;
        public  Monster(int power, int bonus){
            this.power = power;
            this.bonus = bonus;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int exp = s.nextInt();

        int monst[] = new int[n];
        int bonus[] = new int[n];

        for (int i = 0; i < n; i++) {
            monst[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bonus[i] = s.nextInt();
        }
        System.out.println(maxBeat(monst, bonus, exp));
    }

    private static int maxBeat(int[] monst, int[] bonus, int exp) {
        Monster[] monsters = new Monster[monst.length];

        for(int i = 0; i < monst.length; i++)
            monsters[i] = new Monster(monst[i], bonus[i]);

        Arrays.sort(monsters, Comparator.comparingInt(m -> m.power));

        int count = 0;

        for(Monster m: monsters){
            if(exp < m.power) break;
            exp += m.bonus;
            ++count;
        }

        return count;
    }
}
