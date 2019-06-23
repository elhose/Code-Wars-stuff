public class Main {

    public static void main(String[] args) {
        race(80,91,37);
    }

    public static int[] race(int v1, int v2, int g){
        int[] time = new int[3];
        if (v1 >= v2){
            return null;
        }

        time[0] = g/(v2-v1);
        time[1] = (g*60)/(v2-v1)-time[0]*60;
        time[2] = (g*3600)/(v2-v1)-time[0]*3600-time[1]*60;

        return time;
    }


}
