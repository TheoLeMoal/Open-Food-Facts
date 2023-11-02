package TraitementFichier;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TraitementFichier {
	public static void main(String[] args) {
        Path path = Paths.get("E:\\Projets java\\Open-Food-Facts\\src\\main\\java\\TraitementFichier\\open-food-facts.csv");
        Recensement.traitementFichier(path);
	}
}
