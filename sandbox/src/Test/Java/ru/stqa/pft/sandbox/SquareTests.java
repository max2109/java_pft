package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by Alexey on 1/26/2017.
 */
public class SquareTests {

    @Test
    public void testArea(){
        Square s = new Square (5);
        s.area();
    }
}
