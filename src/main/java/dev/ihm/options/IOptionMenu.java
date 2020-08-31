package dev.ihm.options;

public interface IOptionMenu {
	
	 default int getPoids() {
	        return 100;
	    }

	
    String getTitre();

    void executer();
}
