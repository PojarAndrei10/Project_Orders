public class Main {
    public static void main(String[] args) {
        InterfataPrincipala interfataPrincipala=new InterfataPrincipala();
        InterfataPrincipalaController interfataPrincipalaController;
        interfataPrincipalaController=new InterfataPrincipalaController(interfataPrincipala);
        interfataPrincipala.setVisible(true);
    }
}