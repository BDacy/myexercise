package com.ityca.week2;
//1845. 座位预约管理系统
public class SeatManager {
//
//    SeatManager(int n)初始化一个SeatManager对象，它管理从 1到 n编号的n个座位。所有座位初始都是可预约的。
//    int reserve()返回可以预约座位的最小编号，此座位变为不可预约。
//    void unreserve(int seatNumber)将给定编号seatNumber对应的座位变成可以预约。
    private boolean[] seat;
    private int ll;//标记当前最小可预约座位号
    private int nums;//记录座位数量

    public SeatManager(int n) {
        seat=new boolean[n];//默认值是false表示可预约
        ll=1;//初始时最小可预约号为1
        nums=n;
    }

    public int reserve() {
        //取出最小可预约号，计算下一个可预约号
        int res=ll;//记录返回值
        seat[ll-1]=true;//标记为不可预约
        for (int i=ll;i<nums;i++){
            if (seat[i]==false){
                ll=i+1;
                break;
            }
        }
        if (res==ll)
            ll=nums;
        return res;
    }

    public void unreserve(int seatNumber) {
        seat[seatNumber-1]=false;
        if (seatNumber<ll)
            ll=seatNumber;
    }

}
