package LeetCodeHot100;

import java.util.Objects;

public class Solution_693 {
    public boolean hasAlternatingBits(int n) {
        int highBit=31;
        for(int i=31;i>=0;i--){
            if((n&(1<<i))==0){
                highBit--;
            }else break;

        }
        int lowBit = n&1;
        for(int i=0;i<=highBit;i++){
            if((lowBit ==1 && (n&(1<<i)) !=0) || (lowBit ==0 && (n&(1<<i)) ==0)) {
                lowBit ^= 1;
            }else{
                return false;
            }
        }
        return true;
    }
}
