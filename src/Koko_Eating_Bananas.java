package src;

public class Koko_Eating_Bananas {
    public int minEatingSpeed(int[] piles, int h) {
        //Find biggest pile to allow us understand what is the maximum rate at which Koko can eat
        int biggestPile = Integer.MIN_VALUE;
        for(int p : piles){ biggestPile = Math.max(p, biggestPile); }
        //binary search on 1 to biggestPile and store the rate into minSpeed (which will hold the min rate)
        int head = 1, tail = biggestPile;
        int minSpeed = Integer.MAX_VALUE;
        if(h == piles.length) return biggestPile;
        while(head<=tail){
            int rate = (head+tail)/2;
            int totalHoursForThisRate = 0;
            for(int i=0; i< piles.length; i++){
                totalHoursForThisRate += Math.ceil((double)piles[i]/rate);
                if(totalHoursForThisRate > h)
                    break;
            }
            if(totalHoursForThisRate > h){
                head = rate + 1;
            }
            else {
                minSpeed = Math.min(minSpeed, rate);
                tail = rate - 1;
            }
        }
        return minSpeed;
    }

    //Tests
    public static void main(String[] args) {
        Koko_Eating_Bananas k = new Koko_Eating_Bananas();
        if(k.minEatingSpeed(new int[]{10,1,3,7}, 6) != 5) throw new RuntimeException("Expected 5");
        if(k.minEatingSpeed(new int[]{10,1,3,10}, 5) != 10) throw new RuntimeException("Expected 10");
        if(k.minEatingSpeed(new int[]{1,1,1,3}, 5) != 2) throw new RuntimeException("Expected 2");
        if(k.minEatingSpeed(new int[]{0,0,1,100}, 5) != 25) throw new RuntimeException("Expected 25");
        if(k.minEatingSpeed(new int[]{0,0,1,3}, 5) != 1) throw new RuntimeException("Expected 1");
        if(k.minEatingSpeed(new int[]{10,1,3,7}, 15) != 2) throw new RuntimeException("Expected 2");
        if(k.minEatingSpeed(new int[]{100}, 4) != 25) throw new RuntimeException("Expected 25");
        if(k.minEatingSpeed(new int[]{100}, 1) != 100) throw new RuntimeException("Expected 100");
    }
}
