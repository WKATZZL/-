# 简单的灰度发布组件 Greyscale Release
现如今，互联网产品往往有许多灰度发布的需求：即让特定比例的用户看到新实现的功能，以快速收集用户反馈，持续改进产品。产品功能层面的灰度发布往往通过API网关配置等方式实现。

近期，由于项目服务端代码进行了大规模重构，毛哥要求你实现一套灰度发布组件以支持代码层面的灰度发布。

已知客户端的每次调用都会带有客户的唯一ID（13位手机号）。**你的灰度发布组件应通过这一ID以及请求的业务类型判断该次请求是否使用新链路。**
灰度发布规则从文本文件中加载，若有n个业务类型，则灰度发布规则文件共3n行，内容示例如下所示
```text
key: api_registerUser
enabled: true
rule: {187,139,135-136,%30}
key: api_playMusic
enabled: false
rule: {139,181-183}
```

在规则配置文件中，每一条规则占3行。
第一行key代表了业务类型，由英文字母及下划线组成。第二行enabled表示该规则是否开启。不开启时一律使用旧链路。
第三行rule由括号包裹的多个判断规则组成。多个规则由逗号分隔，满足其中之一即使用新链路。判断规则应至少支持如下三种

|形式|示例|描述|
|:----|:----|:----|
|单个整数x (x ∈[100, 200])|187|187开头的用户请求使用新链路|
|整数区间x-y (x,y ∈[100, 200])|181-183|181、182、183开头的用户请求均使用新链路|
|百分号+整数x|%30|30%的随机概率使用新链路|

需实现规则配置文件的热更新。启动后，程序应每10秒重载一次规则配置文件。

实现一个 public 方法以开始读取规则配置文件。另实现一个 public 方法以接受业务类型和 client id 作为输入，返回该请求是否应提供新功能。

完成上述方法的相关测试用例。

Nowadays, greyscale release is common for Internet-based products: when a new feature is implemented, it is firstly available to a certain portion of users only, 
for quickly collecting feedback. Grayscale release is often achieved by API gateway configurations and other related ways.

Recently, due to a massive refactoring of a project’s server code, the project manager, Mao Ge, 
has asked you to implement a component for supporting grayscale release at the code level.

It is known that each call from the client will carry the client’s unique ID (i.e. 13-digit phone number). Your grayscale release component should use this ID and the requested business type to determine whether the client should be served with the new feature. The grayscale release rules will be loaded from a plain text file, which contains 3n lines if there are n business types. A sample is given as below:

```text
api_registerUser
true
{187,139,135-136,%30}
api_playMusic
false
{139,181-183}
```
In the rule specification file, each rule occupies 3 lines. The first line represents the business type, which consists of letters and underscores only. 
The second line indicates whether the rule is enabled or not: if enabled, the request will be served with the new feature; otherwise, the request will be served with the old feature. 
The third line consists of multiple conditions wrapped in parentheses: they are separated by commas, and if anyone of them is satisfied, the new feature will be served with. The conditions will be represented in the following three forms:

|**Form**|**Example**|**Description**|
|:----|:----|:----|
|single integer x (x ∈[100, 200])|187|requests from users whose ID starts with 187 call the new program|
|integer range x-y (x,y ∈[100, 200])|181-183|requests from users whose ID starts with 181, 182 and 183 call the new program|
|perceent+integer x|%30|30% random probability of calling the new program|

Hot updates on the rule specification file should be supported. Once started, your program should reload the rule specification file every 10 seconds.

Implement a public method to start reading the rule specification file. Implement another public method which accepts the business type and client ID as input, 
and tells whether the new feature should be served with for that request.

Provide test cases for all the above methods.