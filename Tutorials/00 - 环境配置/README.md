# 环境搭建

在环境搭建之前，你需要了解开发杀戮尖塔mod需要的技术知识和东西：
* Java
* Json
* 简单的图像处理（PS）
* 耐心

*杀戮尖塔是使用Java编写的LibGDX游戏框架编写的，所以首先你需要一个开发Java的环境。*

## 1.安装Java

杀戮尖塔使用Java8开发，首先你需要安装Java8。你可以选择[Oracle](https://www.oracle.com/java/technologies/downloads/#java8-windows)或者[Adoptium](https://adoptium.net/zh-CN/temurin/releases/?version=8&os=any&arch=any)或者其他发行版。

![001](https://i.loli.net/2021/11/09/BGyPpiD7kYzrn1d.png)<br>
*注意Java版本、电脑操作系统和32位和64位（x64是64位）*

*如果你选择IDEA作为编辑器，那么可以自动下载所需的Java版本，具体自行搜索。*

## 2.选择开发工具

理论上使用什么编辑器都可以，可使用的有<b>Eclipse,IntelliJ,VSCode或~~记事本~~</b>。对于新手建议使用[Intellij](https://www.jetbrains.com/idea/download/#section=windows)，本教程对于<b>Intellij</b>和<b>VSCode</b>的使用都会讲解。

### Intellij IDEA（以下简称idea）

1. 安装<br>

点击下方链接下载idea，注意<b>下载免费社区版（Community）</b>开发mod足够了。
https://www.jetbrains.com/idea/download/#section=windows

2. 创建新项目<br>

安装完成后打开idea，点击New Project创建新项目。如果你下载了其他人的样板代码，可以通过Open导入。<br>
![002](https://s2.loli.net/2023/10/04/WXTPfl16ICBoktJ.png)


如图，创建一个maven项目。注意jdk版本。<br>
![003](https://s2.loli.net/2023/10/04/hvyLNbQFlfkrWqu.png)

3. 创建配置文件<br>

需要书写`pom.xml`和`ModTheSpire.json`文件，两者<b>缺一不可</b>。

选择你的mod名称和路径。创建完成后，会索引到一个pom.xml文件。这是maven项目的管理文件，制作杀戮尖塔mod可以直接复制以下文本。（<b>注意注释的下方一行需要改动以适配你的环境</b>）

pom.xml:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <!-- 改成你需要的名称 -->
    <groupId>example-mod</groupId>
    <!-- 改成你需要的名称 -->
    <artifactId>example-mod</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <!-- 改成你需要的名称 -->
    <name>ExampleMod</name>
    <!-- 改不改由你 -->
    <description>a sts mod.</description>

    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <SlayTheSpire.version>12-22-2020</SlayTheSpire.version>
        <ModTheSpire.version>3.23.2</ModTheSpire.version>
        <!-- *****一定要改 ***** -->
        <!-- 改成你的steam安装路径位置，指向steamapps文件夹（该目录安装了杀戮尖塔及mod） -->
        <!-- 注意使用正斜杠（/）而不是反斜杠（\） -->
        <Steam.path>D:/xxx/steam/steamapps</Steam.path>
    </properties>

    <dependencies>
        <dependency>
            <groupId>com.megacrit.cardcrawl</groupId>
            <artifactId>slaythespire</artifactId>
            <version>2020-11-30</version>
            <scope>system</scope>
            <systemPath>${Steam.path}/common/SlayTheSpire/desktop-1.0.jar</systemPath>
        </dependency>
        <dependency>
            <groupId>basemod</groupId>
            <artifactId>basemod</artifactId>
            <version>5.33.1</version>
            <scope>system</scope>
            <systemPath>${Steam.path}/workshop/content/646570/1605833019/BaseMod.jar</systemPath>
        </dependency>
        <dependency>
            <groupId>com.evacipated.cardcrawl</groupId>
            <artifactId>ModTheSpire</artifactId>
            <version>3.23.2</version>
            <scope>system</scope>
            <systemPath>${Steam.path}/workshop/content/646570/1605060445/ModTheSpire.jar</systemPath>
        </dependency>
    </dependencies>

    <build>
        <finalName>${project.artifactId}</finalName>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.7.0</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-antrun-plugin</artifactId>
                <version>1.8</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <configuration>
                            <target>
                                <copy file="target/${project.artifactId}.jar" tofile="${Steam.path}/common/SlayTheSpire/mods/${project.artifactId}.jar"/>
                            </target>
                        </configuration>
                        <goals>
                            <goal>run</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

修改完成后，右上角如果有一个刷新按钮，点击刷新。

打开左方的项目文件夹，找到以下结构。
* src
    * main
        * java
        * resources

*其中java文件夹是你代码放置的位置，resources是你资源（如图片、本地化文本等）放置的位置。*

接下来在`resources`文件夹下创建一个新文件`ModTheSpire.json`。（右键->new->file）据下方内容根据你的要求填写。

```json
{
  "modid": "ExampleMod", // 你mod的唯一标识，取得独特一些以防重名
  "name": "事例Mod", // 该mod在读取界面显示的名称
  "author_list": ["REME"], // 作者们（一定要写花括号）
  "description": "作为教程的mod。", // mod在读取界面的介绍
  "version": "0.0.1", // mod版本
  "sts_version": "12-22-2020", // 游戏本体版本，根据时间填写你当前能运行的版本即可
  "mts_version": "3.23.2", // Mod The Spire版本
  "dependencies": ["basemod"] // 该mod的所有依赖。目前我们只需要basemod。
}
```

TIPS:
* <b>*这里的json注释是不合法的，请在你的文件中删掉json的注释！！！*</b>
* 版本号怎么写没有具体要求，你写mod的打包时间也可以。（例如"2021-11-10"）
* 当你依赖了一个其他mod如stslib，一定要在这里加上。

4. 打包项目

编辑器界面右侧有个maven，点击并找到以下按钮，双击运行。

![005](https://i.loli.net/2021/11/10/RmJ9BQF1gqnUjtM.png)

等到命令行显示`BUILD SUCCESS`或其他打包成功信息时，说明打包成功。（你搁这搁这呢）

如果你一切配置成功，那么打开mod版杀戮尖塔就可以在mod界面找到你刚制作的mod。在菜单打开mods并确保找到你的mod。

![006](https://i.loli.net/2021/11/10/Jjds51Vawg6DyK9.png)

*如果没有，回头看看哪里出错了。*

那么恭喜你！迈出了mod制作的第一步。翻阅接下来的mod学习如何为你的mod制作内容。

<br><br><br>

*后面的内容是关于vscode的配置的。如果你不需要跳过即可。*

### VSCode

vscode简洁美观，并且可以自由使用许多插件。首先下载[VSCode](https://code.visualstudio.com/download)。

1. 在扩展中安装`Extension Pack for Java`插件。（如何安装插件参考搜索引擎，由于时间原因以下不可参考）

![007](https://i.loli.net/2021/11/10/TIo9HjxsrZlkUCw.png)

~~确保该界面出现以下信息。（如有错误可以自行搜索vscode如何安装java开发环境）~~

![008](https://i.loli.net/2021/11/10/5HGlJyvrT2VEwxU.png)

2. 第二步需要安装[MAVEN](https://www.runoob.com/maven/maven-setup.html)，确保添加到`PATH`。

3. 第三步创建项目。使用vscode自带的创建项目有些麻烦，你可以直接复制该文件夹下的项目作为你的开始项目。(<b>`pom.xml`和`ModTheSpire.json`文件需要配置，请参照上方idea的文件配置一节</b>)

4. 设置调试环境。

在`.vscode/launch.json`文件中添加以下内容。

```json
{
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "java",
      "name": "Launch Java Program",
      "request": "launch",
      "mainClass": "com.megacrit.cardcrawl.desktop.DesktopLauncher",
    // ModTheSpire的命令行配置，参考https://github.com/kiooeht/ModTheSpire/wiki/Command-Line-Arguments
    //   "args": ["--mods", "basemod"],
    // 杀戮尖塔根目录
      "cwd": "path\\to\\your\\SlayTheSpire",
    // Java8的路径
      "javaExec": "path\\to\\your\\bin\\java.exe",
      "preLaunchTask": "maven-package",
    // Steam的路径
      "classPaths": [
        "path\\to\\your\\Steam\\steamapps\\workshop\\content\\646570\\1605060445\\ModTheSpire.jar"
      ]
    }
  ]
}
}
```

在`.vscode/tasks.json`文件中添加以下内容。

```json
{
    "version": "2.0.0",
    "tasks": [
        {
            "label": "maven-package",
            "type": "shell",
            "command": "mvn package",
            "group": {
                "kind": "build",
                "isDefault": true
            },
            "presentation": {
                // "reveal": "silent",
                "clear": true,
                "panel": "shared"
            },
            "problemMatcher": [
                "$msCompile"
            ]
        }
    ]
}
```

然后按`F5`即可调试。