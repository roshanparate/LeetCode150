package mathandgeometry;

public class Pow {

    public static void main(String[] args) {
        Pow pow = new Pow();
        double x = 2.0;
        int n = 10;
        double result = pow.myPow(x, n);
        System.out.println("Result of " + x + "^" + n + " is: " + result);
    }

    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }else{
            double temp =  myPow(x, n/2);
            if(n%2==0){
                return temp*temp;
            }else{
                if(n > 0){
                    return temp*temp*x;
                }else{
                    return (temp*temp)/x;
                }
            }
        }
    }
}
