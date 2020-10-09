import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Streams {

    int[] array = new int[10000];


    String[] stringArr = new String[10];
    public Streams(){
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()*100 +1);
        }


        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 10; i++) {
            String zufallsString = "";
            for (int j = 0; j < 10; j++) {
                zufallsString += abc.charAt((int)(Math.random()*48+1));
            }
            stringArr[i] = zufallsString;
        }


    }


    public double average(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(0);
    }
    
    public List<String> upperCase(String[] strings) {
        return Arrays.stream(strings).map(m -> m.toUpperCase()).collect(Collectors.toList());
    }
    
    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        return weapons.stream().min(Comparator.comparing(Weapon::getDamage)).orElse(null);
    }
    
    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        return weapons.stream().max(Comparator.comparing(Weapon::getMinStrength)).orElse(null);
    }
    
    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return weapons.stream().filter(w-> w.getDamageType()==DamageType.MISSILE).collect(Collectors.toList());
    }
    
    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
         return weapons.stream().max((o1, o2) -> o1.getName().length()-o2.getName().length()).orElse(null);
    }
    
    public List<String> toNameList(List<Weapon> weapons) {
        return weapons.stream().map(weapon -> weapon.getName()).collect(Collectors.toList());
    }
    
    public int[] toSpeedArray(List<Weapon> weapons) {
         return weapons.stream().mapToInt(weapon -> weapon.getSpeed()).toArray();

    }
    
    public int sumUpValues(List<Weapon> weapons) {
        return weapons.stream().mapToInt(value -> value.getValue()).sum();
    }
    
    public long sumUpHashCodes(List<Weapon> weapons) {
        return weapons.stream().mapToInt(value -> value.hashCode()).sum();
    }
    
    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return weapons.stream().map(weapon -> weapon).collect(Collectors.toList());
    }
    
    public void increaseValuesByTenPercent(List<Weapon> weapons) {
       weapons.stream().forEach(v -> v.setValue((int) (v.getValue()*1.1)));
    }
}
