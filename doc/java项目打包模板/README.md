# java项目打包说明

## 说明

本文档旨在指导生成统一标准的发布提测文件（tar.gz包和sh安装脚本）

服务名：maven项目的artifactId

tar.gz包命名：服务名-版本.tar.gz
服务安装脚本命名：服务名-install.sh

安装目录：~/服务名
服务启动脚本命名：服务名.sh
jar包命名：服务名-版本.jar
启动脚本放bin目录
配置文件放config目录
日志文件输出到logs目录

调用maven项目的package命令，提测文件会输出到target\devops目录下。

## 步骤

1. 重命名示例服务启动脚本demo.sh、示例服务安装脚本demo-install.sh，例如myservice.sh、myservice-install.sh。
2. 复制所有文件（除本README.md文档外）到项目根目录下（保持目录结构不变）。
3. 在项目文件pom.xml中添加相关插件配置，添加配置后pom.xml文件如下。

```XML
<project>

    [...]

    <build>

        [...]

        <plugins>

            [...]

            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <includes>
                        <include>
                            <groupId>nothing</groupId>
                            <artifactId>nothing</artifactId>
                        </include>
                    </includes>
                </configuration>
            </plugin>
            <plugin>
                <artifactId>maven-jar-plugin</artifactId>
                <configuration>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <classpathPrefix>lib/</classpathPrefix>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
            <plugin>
                <artifactId>maven-assembly-plugin</artifactId>
                <configuration>
                    <appendAssemblyId>false</appendAssemblyId>
                    <outputDirectory>${project.build.directory}/devops/tgz</outputDirectory>
                    <descriptors>
                        <descriptor>src/assembly/tgz.xml</descriptor>
                    </descriptors>
                </configuration>
                <executions>
                    <execution>
                        <id>make-assembly</id>
                        <phase>package</phase>
                        <goals>
                            <goal>single</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <artifactId>maven-resources-plugin</artifactId>
                <executions>
                    <execution>
                        <id>copy-sh</id>
                        <phase>package</phase>
                        <goals>
                            <goal>copy-resources</goal>
                        </goals>
                        <configuration>
                            <outputDirectory>${project.build.directory}/devops/install</outputDirectory>
                            <resources>
                                <resource>
                                    <directory>${basedir}</directory>
                                    <includes>
                                        <include>${project.artifactId}-install.sh</include>
                                    </includes>
                                </resource>
                            </resources>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

    [...]

</project>
```

## 其它说明

如果服务名和maven项目的artifactId不相同，请手动修改pom.xml和tgz.xml文件中的${project.artifactId}为服务名即可。
