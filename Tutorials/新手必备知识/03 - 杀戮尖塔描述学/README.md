# 杀戮尖塔描述写法（中文）

## 卡牌描述

卡牌描述与其他描述不同，总之几条（都需要前后空格）：
* `NL`换行。
* `!B!`,`!D!`,`!M!`分别被伤害数值、格挡数值、特殊值替代。
```java
    this.damage = 6;
    this.block = 6;
    this.magicNumber = 6;
```
```json
    "造成 !D! 点伤害 !M! 次。 NL 获得 !B! 点 格挡 。"
```
* `*`可以染成黄色。
* 原版游戏关键词前后空格可以染色。
* `[E]`表示能量图标。`[R]` `[G]` `[P]` `[B]`也是，但单只一个角色的。

### 扩展

#### 自定义颜色

使用十六进制颜色可以染成自定义颜色。
```json
    "这是一段 [#87CEEB]描述[] 。" // 天蓝色
```

#### 自定义变量

自定义变量可向basemod注册使用。
https://github.com/daviscook477/BaseMod/wiki/Dynamic-Variables

```json
    "给予 !M! 层 虚弱  !ExampleMod:M2! 次。" // 若你注册了DynamicVariable且key()返回“ExampleMod:M2”
```
*注意自定义变量不能在行尾，不然会出bug*

### 自定义关键词

自定义关键词可以在向basemod注册后使用。
```java
    BaseMod.addKeyword("examplemod", keyword.NAMES[0], keyword.NAMES, keyword.DESCRIPTION);
```

// TODO 添加关键词教程

```json
    "给予 !M! 层 examplemod:恐惧 。" // 如果你注册了关键词恐惧
```

## 遗物，TIP，能力，姿态等描述

所有小方框的描述都适用。（也需要前后空格）

* `NL`换行。
* `#b`,`#r`,`#g`,`#y`,`#p`分别染成蓝色、红色、绿色、黄色、紫色。
* `[E]`表示能量图标。