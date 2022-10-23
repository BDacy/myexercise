package com.ityca.week4;

public class demo5 {
//    实现 Bank 类：
//
//    Bank(long[] balance) 使用下标从 0 开始的整数数组 balance 初始化该对象。
//    boolean transfer(int account1, int account2, long money) 从编号为
//    account1 的账户向编号为 account2 的账户转帐 money 美元。如果交易成功，返回 true ，否则，返回 false 。
//    boolean deposit(int account, long money) 向编号为
//    account 的账户存款 money 美元。如果交易成功，返回 true ；否则，返回 false 。
//    boolean withdraw(int account, long money) 从编号为 account 的账户取款 money 美元。如果交易成功，返回 true ；否则，返回 false 。
class Bank {
    private long[] money;
    private int k=0;//账户数量;
    public Bank(long[] balance) {
        int n=balance.length;
        money=new long[n+1];
        k=n;
        for (int i=0;i<n;i++){
            money[i+1]=balance[i];
        }
    }
    //转账
    public boolean transfer(int account1, int account2, long money) {
        if (withdraw(account1,money)){
            if (deposit(account2,money))
            return true;
            deposit(account1,money);
            return false;
        }
        return false;
    }
    //存款
    public boolean deposit(int account, long money) {
        if (account<1||account>k)return false;
        this.money[account]+=money;
        return true;
    }
    //取款
    public boolean withdraw(int account, long money) {
        if (account<1||account>k)return false;
        if (money>this.money[account]) return false;
        this.money[account]-=money;
        return true;
    }
}
}
