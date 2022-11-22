package review;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @BelongsPackage: review
 * @Author: yca
 * @CreateTime: 2022-11-21  20:52
 * @Description:
 */
public class reviewTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 大数对象
        BigDecimal money = new BigDecimal("1.04");
        BigInteger bigInteger = new BigInteger("1024");
        // 深拷贝与浅拷贝
        Person p1 = new Person(new House(11));
        Person p2 = (Person) p1.clone();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.house);
        System.out.println(p2.house);
        System.out.println(p1.house.aa);
        System.out.println(p2.house.aa);
    }
    public static class Person implements Cloneable{
        House house;

        public Person(House house) {
            this.house = house;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Person person = (Person) super.clone();
            person.house = (House) house.clone();
            return person;
        }
    }
    public static class House implements Cloneable{
        int aa;

        public House(int aa) {
            this.aa = aa;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}