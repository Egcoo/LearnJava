```markdown
哈希表 (在使用的时候认为时间复杂度都是常数级别)
1.HashSet
2.HashMap(key,value) 
    1.put()方法加入新元素，或者更新；
    2.remove()连同key和value一起删掉
    3.containsKey()可以查询key存在或者不存在，也可以把key对应的value拿出来

3.快慢指针：快指针一次走两步，慢指针一次走一步，等快指针走完的时候，慢指针正好到中点位置，需要定制一些边界条件
```