import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Closure {

    static class Player {
        
        private final String name;
        private final String nation;
        private final int age;
    
        public Player(String name, String nation, int age) {
            this.name = name;
            this.nation = nation;
            this.age = age;
        }
    
        public String getName() {
            return this.name;
        }
    
        public String getNation() {
            return this.nation;
        }
    
        public int getAge() {
            return this.age;
        }
    
        public Object getValueByProperty(String property) {
            switch (property) {
                case "name": return this.getName();
                case "nation": return this.getNation();
                case "age": return this.getAge();
                default: return null; 
            }
        }
           
        @Override
        public String toString() {
            return "{" +
                " name='" + getName() + "'" +
                ", nation='" + getNation() + "'" +
                ", age='" + getAge() + "'" +
                "}";
        }
    }
    
    private static final List<Player> players = Arrays.asList(
        new Player("messi", "argentina", 33),
        new Player("ronaldo", "portugal", 35),
        new Player("son", "korea", 29),
        new Player("park", "korea", 39)
    );

    private static Predicate<Player> distinctBy(String key) {
        Set<String> set = new HashSet<>();
        return player -> {
            String value = (String) player.getValueByProperty(key);
            return Optional.ofNullable(value).map(set::add).orElse(false);
        };
    }

    public static void main(String[] args) {
        List<String> nations = players.stream()
            .filter(distinctBy("nation"))
            .map(player -> player.getNation())
            .collect(Collectors.toList());

        System.out.println(nations);
    }
}
