

public class Fraction {
    private int numerator;
    private int denominator;

    public static int gcd(int num, int den){
        int tempa = num; int tempb = den;
        while(tempa != 0 && tempb !=0){
            int rem = tempa % tempb;
            tempa = tempb;
            tempb = rem;
        }
        return tempa;
    }



    public Fraction(int numerator, int denominator){
        if (denominator == 0)
        {
            throw new IllegalArgumentException("denominator can't be zero");
        }
        else if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
        else {
            this.numerator =  numerator;
            this.denominator = denominator;
        }
    }

    public Fraction(int numerator){
        this(numerator, 1);
    }

    public Fraction(){
        this(0,1);
    }

    public int getNumerator(){
        return this.numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    public String toString(){
        return Integer.toString(this.numerator)+"/"+Integer.toString(this.denominator);
    }

    public Double toDouble(){
        return (double)(this.numerator / this.denominator);
    }

    public Fraction add(Fraction other){
        int commonDenominator = other.getDenominator() * this.getDenominator();
        int newNumerator = this.numerator*other.getDenominator() + this.denominator*other.getNumerator();
        Fraction addFraction = new Fraction(commonDenominator,newNumerator);
        addFraction.toLowestTerms();
        return addFraction;
    }

    public Fraction subtract(Fraction other){
        int commonDenominator = other.getDenominator() * this.getDenominator();
        int newNumerator = this.numerator*other.getDenominator() - other.getNumerator()*this.denominator;
        Fraction subFraction = new Fraction(commonDenominator,newNumerator);
        subFraction.toLowestTerms();
        return subFraction;
    }

    public Fraction multiply(Fraction other){
        int commonDenominator = other.getDenominator() * this.denominator;
        int newNumerator = this.numerator*other.getNumerator();
        Fraction mulFraction = new Fraction(commonDenominator,newNumerator);
        mulFraction.toLowestTerms();
        return mulFraction;
    }

    public Fraction divide(Fraction other){
        int commonDenominator = this.denominator * other.getNumerator();
        int newNumerator = this.numerator * other.getDenominator();
        Fraction divFraction =new Fraction(commonDenominator,newNumerator);
        divFraction.toLowestTerms();
        return divFraction;
    }


    //method to check weather 2 parameters are equal
    public boolean equals(Object other){
        if(!(other instanceof Fraction)){
            return false;
        }

        return this.numerator * ((Fraction) other).getDenominator() == ((Fraction) other).getNumerator() * this.denominator ? true : false;
    }

    public void toLowestTerms(){
        int gcd = Fraction.gcd(this.numerator,this.denominator);
        this.numerator = this.numerator/gcd;
        this.denominator = this.denominator/gcd;
    }
}
