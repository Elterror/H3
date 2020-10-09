import java.io.*;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static List<Weapon> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        Main m= new Main();

        m.einlesenMitStream();
        m.printInTable();




       Streams streams = new Streams();



    }

    public void printInTable(){

        System.out.printf("%-20s", " | " + "Name");
        System.out.printf("%-9s", " | " + "CombatType");
        System.out.printf("%-11s ", " | " + "DamageType");
        System.out.printf("%-6s", " | " + "Damage");
        System.out.printf("%-3s", " | " + "Speed");
        System.out.printf("%-6s", " | " + "Lenghth");
        System.out.printf("%-7s %n", " | " + "Value");
        System.out.println("+---------------------------------------------------------------------------------+");

        Printable tablePrint = (w) -> w.forEach(t ->{
            System.out.printf("%-20s", " | " + t.getName());
            System.out.printf("%-13s", " | " + t.getCombatType());
            System.out.printf("%-13s ", " | " + t.getDamageType());
            System.out.printf("%-9s", " | " + t.getDamage());
            System.out.printf("%-8s", " | " + t.getSpeed());
            System.out.printf("%-10s", " | " + t.getMinStrength());
            System.out.printf("%-7s %n", " | " + t.getValue());
            System.out.println("+---------------------------------------------------------------------------------+");
        });
        tablePrint.print(list);
    }

    public void listSortedByDamage(){
        listSortedByDamage(list);
    }

    public void listMitPrintable(){
        Printable printable = (w -> w.forEach(t -> System.out.println(t.toString())));
        printable.print(list);
    }

    public void einlesenMitStream() throws IOException {
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
    }

    public void foreachAusgeben(){
        list.forEach(System.out::println);
    }

    public void einlesenohneStream(){
         try(BufferedReader br = new BufferedReader(new FileReader("weapons.csv"))){
            String line = br.readLine();
            while(line !=null){
                String[] arr = line.split(";");
                list.add(new Weapon(arr[0], CombatType.valueOf(arr[1]),DamageType.valueOf(arr[2]), Integer.parseInt(arr[3]),Integer.parseInt(arr[4]), Integer.parseInt(arr[5]),Integer.parseInt(arr[6])));
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void aufgabeVier() {
        final int result = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter((s) -> s % 2 == 1).map((s) -> s * s).sum();
        System.out.println(result);
    }

    public void aufgabeDrei(List<Integer> intList, List<String> stringList){
        final Predicate<Integer> isEven =e -> e % 2 == 0;
        final Predicate<Integer> isPositive = e-> e>0;
        final Predicate<Integer> isNull = Objects::isNull;
        final Predicate<Integer> is0 = e-> e==0;
        final Predicate<String> isShortWord = e-> e.length()<4;

        intList.stream().filter(isEven.and(isPositive));
        intList.stream().filter(isEven.negate().and(isPositive));
    }
}
