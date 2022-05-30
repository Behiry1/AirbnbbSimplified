package AirBnb;

public class Rate {
    String comment;
    int numOfStars;

    public Rate(String comment, int numOfStars)
    {
        if (numOfStars < 0)
        {
            this.numOfStars = 0;
            this.comment = comment;

        } else if (numOfStars > 5) {
            this.comment = comment;
            this.numOfStars = 5;

        } else {
            this.comment = comment;
            this.numOfStars = numOfStars;
        }

    }
}




