package LeetCodeHot100;

public class Solution_190 {
    public static int reverseBits(int n) {
        //0101 1+4=5  1010 2+8=10
        n = ((n&0x55555555)<<1) | ((n&0xaaaaaaaa)>>>1);
        //0011 1+2=3  1100 4+8=12 a b c
        n = ((n&0x33333333)<<2) | ((n&0xcccccccc)>>>2);
        //0000 1111 = 1+2+4+8=f 1111 0000
        n = ((n&0x0f0f0f0f)<<4) | ((n&0xf0f0f0f0)>>>4);
        //0000 0000 1111 1111
        n = ((n&0x00ff00ff)<<8) | ((n&0xff00ff00)>>>8);
        n = ((n&0x0000ffff)<<16) | ((n&0xffff0000)>>>16);
        return n;
    }
    public static void printBinary(int n){
        for(int i=31;i>=0;i--){
            System.out.print((n&(1<<i))!=0?1:0);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 43261596;
        printBinary(n);
        reverseBits(n);
    }
}
