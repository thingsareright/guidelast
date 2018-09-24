# GUIDE后台接口文档

1. ## 规范说明

   ### 1.1 通信协议

   HTTPS协议

   ### 1.2 请求方法

   支持GET与POST请求

   ### 1.3 字符编码

   所有接口均只支持UTF-8字符编码格式

   ### 1.4 格式说明

   | 符号 | 说明                                        |
   | ---- | ------------------------------------------- |
   | R    | 报文中该元素必须出现（Required）            |
   | O    | 报文中该元素可选出现（Optional）            |
   | C    | 报文中该元素在一定条件下出现（Conditional） |

2. ## 接口分类说明

   ### 2.1 账号有关接口

   #### 2.1.1 请求发送邮件验证码接口

   | 接口地址                | http://maxerwinsmith.qicp.io:49291/sendEmailAndReturnState |
   | ----------------------- | ---------------------------------------------------------- |
   | 请求类型                | GET                                                        |
   | 参数1：emailAddress（R) | 表示请求向此邮箱地址发送验证码                             |

   ​	返回结果：返回状态码及含义如下：

   | 1    | 发送六位整型验证码成功，有效时间为30分钟 |
   | ---- | ---------------------------------------- |
   | 2    | 该邮箱已被注册                           |
   | 3    | 无法发送验证码                           |

   #### 2.1.2 请求注册接口

   | 接口地址               | http://maxerwinsmith.qicp.io:49291/registerWithEmailAddress |
   | ---------------------- | ----------------------------------------------------------- |
   | 请求类型               | POST                                                        |
   | 参数1：emailAddress    | 邮箱地址                                                    |
   | 参数2：token           | 六位整型验证码                                              |
   | 参数3：name            | 用户名                                                      |
   | 参数4：sex             | 性别，字符串类型，1表示男性，0表示女性                      |
   | 参数5：birthday        | 生日，字符串类型，格式是"year-month-day"                    |
   | 参数6：password        | 用户的密码                                                  |
   | 参数7：confirmPassword | 用户的确认密码                                              |
   | 参数8：userPictureUrl  | 用户头像，目前造假，共有"0","1","2"三个有效值可选           |

   <!--注意：以上参数均为可选值。-->

   ​	返回的结果（状态码）：

   | 状态码 | 含义                   |
   | ------ | ---------------------- |
   | 1      | 注册成功               |
   | 2      | 邮箱已经被他人注册     |
   | 3      | 六位验证码失效或者错误 |
   | 4      | 两次输入的密码错误     |

   #### 2.1.3 登录接口

   | 接口地址            | http://maxerwinsmith.qicp.io:49291/login |
   | ------------------- | ---------------------------------------- |
   | 接口类型            | POST                                     |
   | 参数1：emailAddress | 用户的邮箱地址                           |
   | 参数2：password     | 用户的密码                               |

   ​	返回的结果（状态码）：

   | 状态码 | 意义                 |
   | ------ | -------------------- |
   | 1      | 登录成功             |
   | 2      | 邮箱未被注册         |
   | 3      | 邮箱地址与密码不匹配 |

   ### 2.2 地理位置信息有关接口

   #### 2.2.1 APP主界面根据地理位置信息选取最近的景点列表（注意最多十条，可能少于）

   | 接口地址         | http://maxerwinsmith.qicp.io:49291/map/requestMainInterfaceScenicSpotInfos |
   | ---------------- | ------------------------------------------------------------ |
   | 请求类型         | GET                                                          |
   | 参数1：longitude | 定位地点的经度（float）                                      |
   | 参数2：dimension | 定位地点的维度（float）                                      |
   | 请求示例         | http://maxerwinsmith.qicp.io:49291/map/requestMainInterfaceScenicSpotInfos?longitude=11.2&dimension=12.3 |



   ​	返回类型（JSON格式串示例）：

```json
   [{"scenicSpotId":1,"scenicSpotName":"图书馆","pictureUrl":"a.jpg"}]
```

#### 2.2.2APP请求某个景点的介绍信息

| 接口地址           | http://maxerwinsmith.qicp.io:49291/map/requestScenicSpotIntroduceInfo |
| ------------------ | ------------------------------------------------------------ |
| 请求类型           | GET                                                          |
| 参数：scenicSpotId | 景点的位置标记                                               |
| 请求示例           | http://maxerwinsmith.qicp.io:49291/map/requestScenicSpotIntroduceInfo?scenicSpotId=1 |

   ​	返回类型（JSON格式串示例）：

```json
   {"scenicSpotId":1,"pictureUrl":"a.jpg","scenicSpotName":"图书馆","scenicSpotIntroduce":"这是读书的好地方"}
```

#### 2.2.3 根据景点的名字返回与名字相似度最高的记录集（最多十条）

| 接口地址       | http://maxerwinsmith.qicp.io:49291/map/requestSearchScenicSpotByName |
| -------------- | ------------------------------------------------------------ |
| 请求类型       | GET                                                          |
| 请求参数：name | 景点的名称                                                   |
| 请求示例       | http://maxerwinsmith.qicp.io:49291/map/requestSearchScenicSpotByName?name=图书馆 |

   ​	返回类型（JSON格式串示例）：

```json
   [{"scenicSpotId":1,"scenicSpotName":"图书馆","pictureUrl":"a.jpg"}]
```

#### 2.2.4 随机选取最多十条记录做为兴趣点推荐

| 接口地址 | http://maxerwinsmith.qicp.io:49291/map/requestSearchScenicSpotRandom |
| -------- | ------------------------------------------------------------ |
| 请求类型 | GET                                                          |
| 无参数   | 无                                                           |

   ​	返回类型（JSON格式串）：

```json
   [{"scenicSpotId":1,"scenicSpotName":"图书馆","pictureUrl":"a.jpg"}]
```

### 2.3  语音有关接口

#### 2.3.1 获取离某地理位置最近的景点的介绍信息

| 接口地址        | http://maxerwinsmith.qicp.io:49291/voice/requestVoiceExplain |
| --------------- | ------------------------------------------------------------ |
| 请求类型        | GET                                                          |
| 参数1:longitude | 地理位置的经度                                               |
| 参数2:dimension | 地理位置的纬度                                               |
| 请求示例        | http://maxerwinsmith.qicp.io:49291/voice/requestVoiceExplain?longitude=11.2&dimension=12.3 |

   ​	返回类型（JSON格式串）：

```json
   {"scenicSpotName":"图书馆","scenicSpotIntroduce":"这是读书的好地方"}
```

#### 2.3.2 传给我一个景点的名字，返回匹配度最高的景点介绍的接口

| 接口地址          | http://maxerwinsmith.qicp.io:49291/voice/requestIntroduceVoiceHelper |
| ----------------- | ------------------------------------------------------------ |
| 请求类型          | GET                                                          |
| 参数：voiceHelper | 需要介绍的景点的名字                                         |
| 请求示例          | http://maxerwinsmith.qicp.io:49291/voice/requestIntroduceVoiceHelper?voiceHelper=书 |

   ​	返回类型（JSON格式串）：

   ​	如果有相应的匹配景点（以当前数据库数据为例）：

   请求地址：http://maxerwinsmith.qicp.io:49291/voice/requestIntroduceVoiceHelper?voiceHelper=书

   返回JSON格式串：

```json
   这是读书的好地方
```

   ​	如果没有相应的匹配景点则：

   请求地址：http://maxerwinsmith.qicp.io:49291/voice/requestIntroduceVoiceHelper?voiceHelper=书1

   返回JSON格式串：

```json
   没有发现您说的景点，请用普通话说出景点名称哦
```

### 2.4个人信息接口

#### 2.4.1 查询个人信息接口

| 请求路径            | http://maxerwinsmith.qicp.io:49291/findARecordByEmailAndPassword |
| ------------------- | ------------------------------------------------------------ |
| 请求类型            | POST                                                         |
| 参数1：emailAddress | 用户的邮箱地址                                               |
| 参数2：password     | 用户的密码                                                   |

​	返回类型（状态码）：

```
{"userEmail":"mengleizzu@163.com","userPassword":"123456","userName":"张杰","userPictureUrl":"2","userSex":1,"userBirthday":"2018-01-01"}
```



#### 2.4.2 更改个人头像接口

| 请求路径            | http://maxerwinsmith.qicp.io:49291/updateHeadByEmailAddressAndPassword |
| ------------------- | ------------------------------------------------------------ |
| 请求类型            | POST                                                         |
| 参数1：emailAddress | 用户的邮箱地址                                               |
| 参数2：password     | 用户的密码                                                   |
| 参数3：headFlag     | 头像的标识，1,2，或者3（字符串）                             |

​	返回类型（状态码）：

| 状态码 | 意义     |
| ------ | -------- |
| 1      | 修改成功 |
| 0      | 未修改   |

#### 2.4.3 更改个人除密码外所有信息接口（推荐使用，以便统一接口形式）

| 请求路径            | http://maxerwinsmith.qicp.io:49291/updateUserByEmailAddressAndPassword |
| ------------------- | ------------------------------------------------------------ |
| 请求类型            | POST                                                         |
| 参数1：emailAddress | 用户的邮箱地址                                               |
| 参数2：password     | 用户的密码                                                   |
| 参数3：headUrl      | 头像的标识，1,2，或者3（字符串）                             |
| 参数4：userName     | 用户的昵称（暂时没有任何用处）                               |
| 参数5：sex          | 性别标识                                                     |
| 参数6：birthday     | 日期，字符串形式（"2010-01-01"）                             |

​	返回类型（状态码）：

| 状态码 | 意义     |
| ------ | -------- |
| 1      | 修改成功 |
| 0      | 未修改   |

#### 2.4.4 更改个人密码接口

| 请求路径            | http://maxerwinsmith.qicp.io:49291/updatePassword |
| ------------------- | ------------------------------------------------- |
| 请求类型            | POST                                              |
| 参数1：emailAddress | 用户的邮箱地址                                    |
| 参数2：oldPassword  | 用户的现密码                                      |
| 参数3：newPassword  | 用户的新密码                                      |

​	返回类型（状态码）：

| 状态码 | 意义     |
| ------ | -------- |
| 1      | 修改成功 |
| 0      | 未修改   |

### 2.5 优惠卡的接口

#### 2.5.1 获取所有卡的信息的接口

| 请求路径 | http://maxerwinsmith.qicp.io:49291/findAllRecord |
| -------- | ------------------------------------------------ |
| 请求类型 | GET                                              |

​	返回类型（JSON格式串）：

```json
[{"cardId":1,"storeName":"蜜雪冰城","storeDiscount":8.8,"starttime":1537513652000,"endtime":1538118459000}]
```

