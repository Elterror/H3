import java.io.*;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static List<Weapon> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {


        /*try(BufferedReader br = new BufferedReader(new FileReader("weapons.csv"))){
            String line = br.readLine();
            while(line !=null){
                String[] arr = line.split(";");
                list.add(new Weapon(arr[0], CombatType.valueOf(arr[1]),DamageType.valueOf(arr[2]), Integer.parseInt(arr[3]),Integer.parseInt(arr[4]), Integer.parseInt(arr[5]),Integer.parseInt(arr[6])));
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        list = Files.lines(new File("weapons.csv").toPath())
                .skip(1)
                .map(s -> s.split(";"))
                .map(s -> new Weapon(
                        s[0],
                        CombatType.valueOf(s[1]),
                        DamageType.valueOf(s[2]),
                        Integer.parseInt(s[3]),
                        Integer.parseInt(s[4]),
                        Integer.parseInt(s[5]),
                        Integer.parseInt(s[6])
                ))
                .collect(Collectors.toList());

        //



        //list.forEach(System.out::println);

        /*list.forEach(w ->
            System.out.println(w.toString()));*/
        listSortedByDamage(list);
       Printable printable = (w -> w.forEach(t -> System.out.println(t.toString2())));
       printable.print(list);


       Streams streams = new Streams();



    }

    public static List<Weapon> listSortedByDamage(List<Weapon> l){
        l.sort((w1, w2) -> Integer.compare(w1.getDamage(), w2.getDamage()));
        return l;
    }

    public static List<Weapon> listSortedByCombatUsw(List<Weapon> l){
        l.sort((w1, w2) -> {
            String weapon1 = w1.getCombatType().toString() + w1.getDamageType().toString() + w1.getName();
            String weapon2 = w2.getCombatType().toString() + w2.getDamageType().toString() + w2.getName();
            return weapon1.compareTo(weapon2);});
        return l;
    }
}
