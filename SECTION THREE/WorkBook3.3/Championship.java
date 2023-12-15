public class Championship {
    public static void main(String[] args) {
        //Modified passage from Harry Potter
        int gryffindor = 850;   //gryffindor points
        int ravenclaw = 500;    //revenclaw points

        int margin = gryffindor - ravenclaw;

        if (margin >= 300) {
            System.out.println("gryffindor takes the house cup");
        } else if (margin >= 0) {
            System.out.println("In second place, Gryffindor");
        } else if (margin >= -100) {
            System.out.println("In third place, Gryffindor!");
        } else {
            System.out.println("In fourth place, Gryffindor");
        }
    }
}
