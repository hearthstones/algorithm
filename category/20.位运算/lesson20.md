### 位运算

#### 一、位运算实战要点
> 
> 1.除以2：x / 2 => x >> 1  
> 
> 2.判断奇偶  
> - x % 2 == 1 => (x & 1) == 1
> - x % 2 == 0 => (x & 1) == 0
> 
> 3.异或
> - x ^ 0 = x
> - x ^ x = 0
>
> 4.指定位置
> - 获取x在二进制下的第n位（0或1）：(x >> n) & 1
>
> 5.lowbit
> - 得到最低位的1：x & -x
> - 清零最低位的1：x = x & (x - 1)

#### 二、题目列表
- [191.位1的个数（Easy）](https://github.com/hearthstones/algorithm/tree/main/category/20.%E4%BD%8D%E8%BF%90%E7%AE%97/NumberOf1Bits.java)
- [231.2的幂（Easy）](https://github.com/hearthstones/algorithm/tree/main/category/20.%E4%BD%8D%E8%BF%90%E7%AE%97/PowerOfTwo.java)
- [190.颠倒二进制位（Easy）](https://github.com/hearthstones/algorithm/tree/main/category/20.%E4%BD%8D%E8%BF%90%E7%AE%97/ReverseBits.java)
- [338.比特位计数（Easy）](https://github.com/hearthstones/algorithm/tree/main/category/20.%E4%BD%8D%E8%BF%90%E7%AE%97/CountingBits.java)
- [50.Pow(x, n) （Medium）- 快速幂](https://github.com/hearthstones/algorithm/tree/main/category/20.%E4%BD%8D%E8%BF%90%E7%AE%97/PowxN.java)
