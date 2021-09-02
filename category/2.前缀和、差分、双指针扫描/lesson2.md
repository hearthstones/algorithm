### 一、前缀和、差分



### 二、双指针
> 场景：用于解决一类基于“子段”的统计问题。
> 
> 策略：
> 
> 1.固定右端点，看左端点的取值范围
> 
> 2.移动一个端点，看另一个端点的变化情况
> - 滑动窗口：一个端点跟随另一个端点单调移动
> - 双指针夹逼：两侧往中间移动。模板167，15、18、11都是根据模板来发散，注意15、18要先排序。

- [1.两数之和（Easy）](https://github.com/hearthstones/algorithm/tree/main/category/2.%E5%89%8D%E7%BC%80%E5%92%8C%E3%80%81%E5%B7%AE%E5%88%86%E3%80%81%E5%8F%8C%E6%8C%87%E9%92%88%E6%89%AB%E6%8F%8F/TwoSum.java)
- [167.两数之和 II - 输入有序数组（Easy）](https://github.com/hearthstones/algorithm/tree/main/category/2.%E5%89%8D%E7%BC%80%E5%92%8C%E3%80%81%E5%B7%AE%E5%88%86%E3%80%81%E5%8F%8C%E6%8C%87%E9%92%88%E6%89%AB%E6%8F%8F/TwoSumIiInputArrayIsSorted.java)
- [15.三数之和（Medium）](https://github.com/hearthstones/algorithm/tree/main/category/2.%E5%89%8D%E7%BC%80%E5%92%8C%E3%80%81%E5%B7%AE%E5%88%86%E3%80%81%E5%8F%8C%E6%8C%87%E9%92%88%E6%89%AB%E6%8F%8F/ThreeSum.java)
- [18.四数之和（Medium）](https://github.com/hearthstones/algorithm/tree/main/category/2.%E5%89%8D%E7%BC%80%E5%92%8C%E3%80%81%E5%B7%AE%E5%88%86%E3%80%81%E5%8F%8C%E6%8C%87%E9%92%88%E6%89%AB%E6%8F%8F/FourSum.java)
- [11.盛最多水的容器（Medium）](https://github.com/hearthstones/algorithm/tree/main/category/2.%E5%89%8D%E7%BC%80%E5%92%8C%E3%80%81%E5%B7%AE%E5%88%86%E3%80%81%E5%8F%8C%E6%8C%87%E9%92%88%E6%89%AB%E6%8F%8F/ContainerWithMostWater.java)


### 三、单调栈、单调队列
