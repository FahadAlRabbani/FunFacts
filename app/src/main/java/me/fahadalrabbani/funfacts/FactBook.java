package me.fahadalrabbani.funfacts;

import java.util.Random;

/**
 * Created by achernar on 04/08/15.
 */
public class FactBook {
    //public member variables (properties about the object)
    public String[] mFacts =
    {
            "Ostriches can run faster than horses.",
            "Slugs have four noses.",
            "The state of Florida is bigger than England.",
            "Mark Twain didn't graduate from elementary school.",
            "If you want something done ask someone busy.",
            "On average, it takes 66 days to form a new habit.",
            "You are born with 300 bones; by the time you are an adult you will have 206.",
            "A quarter has 119 grooves on its edge, a dime has one less groove.",
            "Mammoths still walked the earth when the Great Pyramid was being built.",
            "More people use blue toothbrushes than red ones.",
            "It takes about 8 minutes for light from the Sun to reach Earth.",
            "Some bamboo plants can grow almost a meter in just one day.",
            "Some penguins can leap 2-3 meters out of the water.",
            "Ants stretch when they wake up in the morning."
    };

    //method (abilities: things the object can do)
    public String getFact() {
        //initialise a fact to empty strings.
        String fact = "";

        //Randomly select a fact
        Random randomGen = new Random(); //Construct a new Random number generator
        int randomNumber = randomGen.nextInt(mFacts.length);

        //Set the fact with text from mFacts.
        fact = mFacts[randomNumber];

        return fact;
    }
}
