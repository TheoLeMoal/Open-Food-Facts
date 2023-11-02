package TraitementFichier;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dao.Jdbc.AdditifDao;
import Dao.Jdbc.AllergeneDao;
import Dao.Jdbc.CategorieDao;
import Dao.Jdbc.ErreurDao;
import Dao.Jdbc.IngredientDao;
import Dao.Jdbc.MarqueDao;
import Dao.Jdbc.ProduitDao;
import Dao.Jdbc.VitamineDao;
import Entities.Additif;
import Entities.Allergene;
import Entities.Categorie;
import Entities.Erreur;
import Entities.Ingredient;
import Entities.Marque;
import Entities.NutriScore;
import Entities.Produit;
import Entities.ValeurNutritionnelle;
import Entities.Vitamine;

public class Recensement {
	public static void traitementFichier(Path path) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("open-food-facts-recencement");
        EntityManager em = emf.createEntityManager();
        
        //Dao
        IngredientDao ingredientDao = new IngredientDao(em);
        ProduitDao produitDao = new ProduitDao(em);
        MarqueDao marqueDao = new MarqueDao(em);
        CategorieDao categorieDao = new CategorieDao(em);
        AdditifDao additifDao = new AdditifDao(em);
        AllergeneDao allergeneDao = new AllergeneDao(em);
        VitamineDao vitamineDao = new VitamineDao(em);
        ErreurDao erreurDao = new ErreurDao(em);
        
        int nbrLigne = 0;
        String line = null;
        
    	try {
			List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			lines.remove(0);
			
			for (nbrLigne = 0; nbrLigne < lines.size(); nbrLigne++) {
				try {
					line = lines.get(nbrLigne);
					Produit produitObj = new Produit();
					
					String token[] = line.split("\\|", 31);
					
					String categorie = token[0];
					String marques = token[1];
					String produit = token[2];
					String nutritionGradeFr = token[3];
					String ingredient = token[4];
					String energie100g = token[5];
					String graisse100g = token[6];
					String sucres100g = token[7];
					String fibres100g = token[8];
					String proteines100g = token[9];
					String sel100g = token[10];
					String vitA100g = token[11];
					String vitD100g = token[12];
					String vitE100g = token[13];
					String vitK100g = token[14];
					String vitC100g = token[15];
					String vitB1100g = token[16];
					String vitB2100g = token[17];
					String vitPP100g = token[18];
					String vitB6100g = token[19];
					String vitB9100g = token[20];
					String vitB12100g = token[21];
					String calcium100g = token[22];
					String magnesium100g = token[23];
					String fer100g = token[25];
					String betaCarotene100g = token[26];
					String presenceHuilePalme = token[27];
					String allergenes = token[28];
					String additifs = token[29];
					
					//Categorie
					Categorie categorieObj = categorieDao.findByName(categorie);
					if (categorieObj == null) {
						categorieObj = new Categorie();
						categorieObj.setNom(categorie);
						categorieDao.create(categorieObj);
					}
					produitObj.setCategorie(categorieObj);
					
					
					//Marque
					String[] marqueTab = marques.split(",");
					for (String marque : marqueTab) {
						Marque marqueObj = marqueDao.findByName(marque);
						if (marqueObj == null) {
							marqueObj = new Marque();
							marqueObj.setNom(marque);
							marqueDao.create(marqueObj);
						}
						produitObj.getMarque().add(marqueObj);
						
					}
					
					//Ingredient
					String[] ingredientFiltre1 = ingredient.split(",");
					for (String ingredientF1 : ingredientFiltre1) {
						String[] ingredientFiltre2 = ingredientF1.split(";");
						if (ingredientFiltre2.length > 1) {
							String ingredientNum = ingredientFiltre2[1].trim();
							int indexCarac = ingredientNum.indexOf(":");
							if (indexCarac >= 0) {
								ingredientNum = ingredientNum.substring(indexCarac + 1).trim();
							}
							ingredientNum = ingredientNum.replaceAll("_", " ");
							ingredientNum = ingredientNum.replaceAll("\\(.*\\)", " ");
							ingredientNum = ingredientNum.replaceAll("\\d*", "");
							ingredientNum = ingredientNum.replaceAll("%", "");
							ingredientNum = ingredientNum.replaceAll("\\.", "");
							ingredientNum = ingredientNum.replaceAll("\\*", "");
							ingredientNum = ingredientNum.replaceAll("\\]", "");
							ingredientNum = ingredientNum.replaceAll("\\)", "").trim();
							Ingredient ingredientObj = ingredientDao.findByName(ingredientNum);
							if (ingredientObj == null) {
								ingredientObj = new Ingredient();
								ingredientObj.setNom(ingredientNum);
								ingredientDao.create(ingredientObj);
							}
							produitObj.getIngredients().add(ingredientObj);
							
						}
					}
		            
					//Valeur Nutritionnel
					ValeurNutritionnelle valeurNutritionnelleObj = new ValeurNutritionnelle();
					if (energie100g != null && !energie100g.isEmpty()) {
					    valeurNutritionnelleObj.setEnergie_100g(Float.parseFloat(energie100g));
					} else {
					    valeurNutritionnelleObj.setEnergie_100g(0);
					}
					
					if (graisse100g != null && !graisse100g.isEmpty()) {
					    valeurNutritionnelleObj.setGraisse_100g(Float.parseFloat(graisse100g));
					} else {
					    valeurNutritionnelleObj.setGraisse_100g(0);
					}
					
					if (proteines100g != null && !proteines100g.isEmpty()) {
					    valeurNutritionnelleObj.setProteines_100g(Float.parseFloat(proteines100g));
					} else {
					    valeurNutritionnelleObj.setProteines_100g(0);
					}
					
					if (fibres100g != null && !fibres100g.isEmpty()) {
					    valeurNutritionnelleObj.setFibres_100g(Float.parseFloat(fibres100g));
					} else {
					    valeurNutritionnelleObj.setFibres_100g(0);
					}
					
					if (sucres100g != null && !sucres100g.isEmpty()) {
					    valeurNutritionnelleObj.setSucres_100g(Float.parseFloat(sucres100g));
					} else {
					    valeurNutritionnelleObj.setSucres_100g(0);
					}
					
					if (sel100g != null && !sel100g.isEmpty()) {
					    valeurNutritionnelleObj.setSel_100g(Float.parseFloat(sel100g));
					} else {
					    valeurNutritionnelleObj.setSel_100g(0);
					}
					
					// Additif
					String tokenAdditif[] = additifs.split(",");
					for (String additif : tokenAdditif) {
					    String additifTab[] = additif.split("-", 2);
					    if (additifTab.length >= 2) {
					        String nomAdditif = additifTab[1];
					        nomAdditif = nomAdditif.toLowerCase().replace("-", " ").trim();
					        Additif additifObj = additifDao.findByName(nomAdditif);
					        if (additifObj == null) {
					            additifObj = new Additif();
					            additifObj.setNom(nomAdditif);
					            additifObj.setCode(additifTab[0]);
					            additifDao.create(additifObj);
							}
					        produitObj.getAdditifs().add(additifObj);
					    } else {
					        System.err.println("Erreur : Impossible de diviser l'additif - " + additif);
					    }
					}
					
					//Allergene
					allergenes = allergenes.toLowerCase().replaceAll("-", " ").trim();
					String allergeneTab[] = allergenes.split(",");
					for (String allergene : allergeneTab) {
						Allergene allergeneObj = allergeneDao.findByName(allergene.trim());
						if (allergeneObj == null) {
							allergeneObj = new Allergene();
							allergeneObj.setNom(allergene);
							allergeneDao.create(allergeneObj);
						}
						produitObj.getAllergenes().add(allergeneObj);
					}
					
					//Vitamine
					Vitamine vitamineObj = new Vitamine();
					vitamineObj.setVitA100g(parseFloatWithDefault(vitA100g));
					vitamineObj.setVitB1100g(parseFloatWithDefault(vitB1100g));
					vitamineObj.setVitB12100g(parseFloatWithDefault(vitB12100g));
					vitamineObj.setVitB2100g(parseFloatWithDefault(vitB2100g));
					vitamineObj.setVitB6100g(parseFloatWithDefault(vitB6100g));
					vitamineObj.setVitB9100g(parseFloatWithDefault(vitB9100g));
					vitamineObj.setVitC100g(parseFloatWithDefault(vitC100g));
					vitamineObj.setVitD100g(parseFloatWithDefault(vitD100g));
					vitamineObj.setVitE100g(parseFloatWithDefault(vitE100g));
					vitamineObj.setVitK100g(parseFloatWithDefault(vitK100g));
					vitamineObj.setVitPP100g(parseFloatWithDefault(vitPP100g));
					vitamineDao.create(vitamineObj);
					
					//Produit
					produitObj.setCategorie(categorieObj);
					produitObj.setNom(produit);
					produitObj.setNutritionGrade(NutriScore.valueOf(nutritionGradeFr.toUpperCase()));
					produitObj.setPresenceHuilePalme(Integer.parseInt(presenceHuilePalme));
					produitObj.setValeurNutritionnelle(valeurNutritionnelleObj);
					produitObj.setVitamines(vitamineObj);
					
					//Mise en plase dans la base de donnée

					produitDao.create(produitObj);
				} catch (Exception e) {
		            //Générer une erreur
		            Erreur erreur = new Erreur();
		            erreur.setContenu(line);
		            erreur.setLigne(nbrLigne);
		            erreur.setErreurStackTrace(e.getMessage());
		            erreurDao.create(erreur);
				}
			}
        } catch (Exception e) {
            if (em.getTransaction() != null && em.getTransaction().isActive()) {
            	em.getTransaction().rollback();
            }
            e.printStackTrace();

        } finally {
            em.close();
            emf.close();
        }
	}
	
	ValeurNutritionnelle VerifValeurNutritionnelle(){
		return null;
	}
	
	private static float parseFloatWithDefault(String value) {
	    if (value != null && !value.isEmpty()) {
	        try {
	            return Float.parseFloat(value);
	        } catch (NumberFormatException e) {
	        }
	    }
	    return 0.0f;
	}
}
