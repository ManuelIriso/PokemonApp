package deirisobarcia.manuel.pokemonapp;



public class Pokemon {
    private String name;
    private String imageUrl;
    private String type;
    private double weight;
    private double height;

    public Pokemon(String name, String imageUrl, String type, double weight, double height) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.type = type;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
}
