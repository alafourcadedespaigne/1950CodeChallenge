/**
 * Class that represents a Marbles entity
 */
public class Marbles implements Comparable<Marbles>{

    private Integer id;
    private String color;
    private String name;
    private double weight;

    public Marbles(Integer id, String color, String name, double weight) {
        this.id = id;
        this.color = color;
        this.name = name;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Marbles{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
    @Override
    public int compareTo(Marbles o) {
        return Double.compare(this.weight, o.getWeight());
    }
}
