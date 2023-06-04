public class RandomNum {
    public static int Generate(int min, int max) {
        return (int)Math.floor(Math.random()*(max-min+1));
    }
}
