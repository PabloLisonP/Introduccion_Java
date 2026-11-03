class Estadio{
    String nombre;
    int aforo;
    int vendidas;
    
    Estadio(String nombre,int aforo){
        this.nombre = nombre;
        this.aforo = aforo;
        this.vendidas = 0;
    }

    void vender() {
        vendidas++;
    }

    String ficha(){
        return("Nombre " + this.nombre + " - (Aforo " + aforo + " ) - vendidas:" + vendidas);
    }
}

public class barrio {
    
    public static void main(String[] args){
    Estadio j1 = new Estadio ("Campo del Garbanzo",40000); 
    Estadio j2 = new Estadio ("Estadio Bollera",30000);
    
    j1.vender();
    j1.vender();
    j2.vender();

    System.out.println(j1.ficha());
    System.out.println(j2.ficha());
}
}
