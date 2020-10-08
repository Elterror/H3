import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    int[] array = new int[1000];

    String zufallsString;
    public Streams(){
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()*100 +1);
        }


        for (int i = 0; i < 10; i++) {
            zufallsString += (char) (Math.random()*122 +30);
        }

        System.out.println(zufallsString);

    }


    public double average(int[] numbers) {
        return Arrays.stream(array).average().orElse(0);
    }
    
    public List<String> upperCase(String[] strings) {
        return null;
    }
    
    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        return null;
    }
    
    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        return null;
    }
    
    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return null;
    }
    
    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        return null;
    }
    
    public List<String> toNameList(List<Weapon> weapons) {
        return null;
    }
    
    public int[] toSpeedArray(List<Weapon> weapons) {
        return null;
    }
    
    public int sumUpValues(List<Weapon> weapons) {
        return 0;
    }
    
    public long sumUpHashCodes(List<Weapon> weapons) {
        return 0;
    }
    
    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return null;
    }
    
    public void increaseValuesByTenPercent(List<Weapon> weapons) {
       //implement this
    }
}
