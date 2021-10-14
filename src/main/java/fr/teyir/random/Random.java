package fr.teyir.random;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe pour l'expansion
 *
 * Il faut ajouter cette expansion dans le dossier expansion de PlaceholderAPI
 */
public class Random extends PlaceholderExpansion {



    @Override
    public boolean canRegister() {
        return true;
    }


    @Override
    public String getPlugin() {
        return null;
    }


    // Version de l'expansion
    @Override
    public String getVersion() {
        return "2.1.0";
    }


    /**
     * Enregistrement de l'auteur pour l'expansion
     * @author Teyir
     *
     */

    @Override
    public String getAuthor() {
        return "Teyir";
    }


    // Identifier de l'expansion (le prefix)
    @Override
    public String getIdentifier() {
        return "random";
    }




    public String onPlaceholderRequest(Player p, String identifier) {

        //Max random number
        if(identifier.toLowerCase().startsWith("max_")){
            String value=identifier.split("(?i)max_")[1];

            int maxRandom = Integer.parseInt(value);

            return String.valueOf(new java.util.Random().nextInt(maxRandom));

        }

        //Range random number
        if(identifier.toLowerCase().startsWith("range_")){
            String data=identifier.split("(?i)range_")[1];
            String[] arr = data.split("-");


            String value1 = arr[0];
            String value2 = arr[1];

            if(checkIsPlaceholder(value1)){
                value1 = parsePlaceholder(value1, p);
            }

            int minRandom = Integer.parseInt(value1);
            int maxRandom = Integer.parseInt(value2);

            if (minRandom <= maxRandom){
                return String.valueOf(ThreadLocalRandom.current().nextInt(minRandom, maxRandom + 1));
            }else{
                return "&cLa valeur minimum doit être inférieur à la valeur maximum ! Exemple: %random_range_10-50%";
            }

        }

        //Random classique color
        if (identifier.toLowerCase().startsWith("colorclassique")) {

        String [] listeColors = {"&0","&1","&2","&3","&4","&5","&6","&7","&8","&9","&a","&b","&c","&d","&e","&f"};

        int randomNumber = new java.util.Random().nextInt(listeColors.length);

        return listeColors[randomNumber];

        }


        if (identifier.equals("Teyir")) {
            return "Le plus beau bien évidement <3<3";
        }

        return "&cPlaceholder invalide";
    }



    public static boolean checkIsPlaceholder(String name){
        return name.toLowerCase().startsWith("{")&&name.endsWith("}");
    }

    public static String parsePlaceholder(String placeholder, Player p){
        String place = placeholder.replaceAll("\\{","%").replaceAll("\\}","%");
        return PlaceholderAPI.setPlaceholders(p, place);
    }
}