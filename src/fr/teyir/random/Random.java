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
        return "1.0.1";
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
	
		
		
			switch(identifier) {
				case "10":
					return String.valueOf(new java.util.Random().nextInt(10));
				case "32":
					return String.valueOf(new java.util.Random().nextInt(32));
				case "64":
					return String.valueOf(new java.util.Random().nextInt(64));
				case "100":
					return String.valueOf(new java.util.Random().nextInt(100));
				case "128":
					return String.valueOf(new java.util.Random().nextInt(128));
				case "256":
					return String.valueOf(new java.util.Random().nextInt(256));
				case "1000":
					return String.valueOf(new java.util.Random().nextInt(1000));
				case "2304":
					return String.valueOf(new java.util.Random().nextInt(2304));
			
			}
		
	         
	        
	        if (identifier.equals("Teyir")) {
	        	return "Le plus beau bien évidement <3<3";
	        }
	        
	               
	        
	        return "&cNombre invalide, voici la liste: 10 - 32 - 64 - 100 - 128 - 256 - 1000 - 2304";    
	    }
}