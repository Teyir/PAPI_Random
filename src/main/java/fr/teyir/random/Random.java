package fr.teyir.random;

import org.bukkit.entity.Player;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;

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
        return "2.0.0";
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



        if (identifier.equals("Teyir")) {
            return "Le plus beau bien évidement <3<3";
        }

        return "&cPlaceholder invalide";
    }
}