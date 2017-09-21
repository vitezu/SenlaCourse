package run;

import artist.Artist;
import composition.PopComposition;
import composition.RockComposition;
import disk.Disk;

import java.util.Arrays;

public class Run {
    public static void main(String[] args) {
        Artist artist1 = new Artist("Pink Floyd", "Britannia");
        Artist artist2 = new Artist ("Hands Up", "Russia");

        RockComposition composition1 = new RockComposition("What Do You Want From Me", artist1, 180, 3);
        RockComposition composition2 = new RockComposition("Learning To Fly", artist1, 240, 1);
        RockComposition composition3 = new RockComposition("Welcome To The Machine", artist1, 230, 2);
        PopComposition composition4 = new PopComposition("Student", artist2, 190, 95);
        PopComposition composition5 = new PopComposition("Ay-ya", artist2, 220, 97);

        Disk disk = new Disk("Mix", 2001);
        disk.addCompositions(composition1);
        disk.addCompositions(composition2);
        disk.addCompositions(composition3);
        disk.addCompositions(composition4);
        disk.addCompositions(composition5);

//        Test
//        System.out.println(Arrays.toString(disk.getCompositions()));

        System.out.println("Duration disk is " + disk.getSumDuration(disk) + " sec");

        if (composition1.getRockCount()>composition4.getPopCount()) {
            System.out.println("Disk genre is rock");
        } else {
            System.out.println("Disk genre is pop");
        }
    }
}
