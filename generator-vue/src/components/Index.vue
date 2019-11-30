<template>
  <div class="main">
    <div class="content">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>在线生成项目工具</span>
          <!-- <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button> -->
        </div>
        <div v-loading="submitLoading" class="card-content">
          <div class="div">
            <h3>项目说名：</h3>
            <p>本在线工具是基于 SpringBoot（2.0.6） + Mybtais-plus（3.1.1） + Mysql 在线根据数据库的表生成对应表的curd 以及 简单的项目结构，数据JOSN交互，restfulApi 风格的接口，以及全局错误处理,加上切面打印日志。</p>
            <p>项目结构 往下看</p>
          </div>
          <div class="div">
            <h3>数据库参数配置:</h3>
            <p style="color:red">⚠️ 本网站不会保留你的任何账户密码！请放心</p>
            <p>当前数据库为测试数据库：可以使用工具去连接创建或者导入数据;或者连接自己可外网访问的数据库</p>
            <p>连接数据库：获取表，选择表 生成对应的curd</p>
            <div class="demo-input-size">
              <label>
                host:
                <el-input
                  style="width:200px;!important"
                  v-model="dbConfig.dbHost"
                  size="mini"
                  placeholder="127.0.0.1"
                ></el-input>
              </label>
              &nbsp;&nbsp;&nbsp;
              <label>
                port:
                <el-input v-model="dbConfig.dbPort" size="mini" placeholder="3306"></el-input>
              </label>
              &nbsp;&nbsp;&nbsp;
              <label>
                root:
                <el-input v-model="dbConfig.dbRoot" size="mini" type placeholder="username"></el-input>
              </label>
              &nbsp;&nbsp;&nbsp;
              <label>
                password:
                <el-input
                  v-model="dbConfig.dbPwd"
                  size="mini"
                  type="password"
                  placeholder="password"
                ></el-input>
              </label>
              &nbsp;&nbsp;&nbsp;
              <label>
                dataBase:
                <el-input v-model="dbConfig.dbName" size="mini" type="text" placeholder="test"></el-input>
              </label>
              <label>
                &nbsp;&nbsp;&nbsp;
                <el-link type="primary" @click="testConnect" v-loading="testloading">测试连接</el-link>
                <span v-if="connectDbTip=='0'" style="padding-left:10px;color:green">successful</span>
              </label>
            </div>
            <div
              v-if="connectDbTip!='0'"
              style="padding:5px;text-align:center;color:red"
            >{{connectDbTip}}</div>
          </div>

          <div class="div">
            <h3>项目参数配置:</h3>
            <div class="demo-input-project">
              <label>
                <span>classAuthor:&nbsp;&nbsp;</span>
                <el-input size="mini" v-model="projectConfig.classAuthor"></el-input>
                <i>*</i>
                <i>类作者名字</i>
              </label>
              &nbsp;&nbsp;&nbsp;
              <label>
                <span>project-name:&nbsp;&nbsp;</span>
                <el-input size="mini" v-model="projectConfig.projectName"></el-input>
                <i>*</i>
                <i>项目名</i>
              </label>
              &nbsp;&nbsp;&nbsp;
              <label>
                <span>package-name:&nbsp;&nbsp;</span>
                <el-input size="mini" v-model="projectConfig.packageName"></el-input>
                <i>*</i>
                <i>项目包名</i>
              </label>
              &nbsp;&nbsp;&nbsp;
              <label>
                <span>groupId:&nbsp;&nbsp;</span>
                <el-input size="mini" v-model="projectConfig.groupId"></el-input>
                <i>*</i>
                <i>groupId</i>
              </label>
              &nbsp;&nbsp;&nbsp;
              <label>
                <span>artifactId:&nbsp;&nbsp;</span>
                <el-input size="mini" v-model="projectConfig.artifactId"></el-input>
                <i>*</i>
                <i>artifactId</i>
              </label>
              &nbsp;&nbsp;&nbsp;
              <label>
                <span>table-prefix:&nbsp;&nbsp;</span>
                <el-input
                  size="mini"
                  type="text"
                  placeholder="例如：tb_user,如果存在,生成实体的时候，会自动去除tb_,生成实体类：User"
                  v-model="projectConfig.tablePrefix"
                ></el-input>
                <i>表前缀</i>
              </label>
              <label style="padding:20px 0;">
                <span>start-hump:&nbsp;&nbsp;</span>
                <el-radio style="padding-top:5px;" v-model="projectConfig.hump" :label="true">ON</el-radio>
                <el-radio style="padding-top:5px;" v-model="projectConfig.hump" :label="false">OFF</el-radio>
                <i>*</i>
                <i>是否开启驼峰命名，例如表里的字段 user_id,开启驼峰则生成，userId ，否则原样输出</i>
              </label>
              <label>
                <span>start-lombok:&nbsp;&nbsp;</span>
                <el-radio style="padding-top:5px;" v-model="projectConfig.lombok" :label="true">ON</el-radio>
                <el-radio style="padding-top:5px;" v-model="projectConfig.lombok" :label="false">OFF</el-radio>
                <i>*</i>
                <i>是否开启lombok 注解，省去 getter、setter的编写</i>
              </label>
              <div class="transfer-my">
                <span>table:&nbsp;&nbsp;</span>
                <el-transfer
                  :props="transfer.props"
                  :titles="transfer.titles"
                  v-model="transfer.value"
                  :data="transfer.tablse"
                ></el-transfer>
                <i>*</i>
              </div>
              <p
                style="color:red"
              >选择表，则生成 entity、mapper、service、serviceImpl、controller 三层分类，包括每张表基于mybatis-plus的增删改分页查询</p>
              <label>
                <span>exist Dependent:&nbsp;&nbsp;</span>
                <div class="dependent-manager">
                  <div class="dependent">
                    com.alibaba
                    fastjson
                    (v1.2.47)
                  </div>
                  <div class="dependent">
                    mysql
                    mysql-connector-java
                  </div>

                  <div class="dependent">
                    commons-collections
                    commons-collections
                    (v3.2.2)
                  </div>
                  <div class="dependent">
                    org.apache.commons
                    commons-lang3
                    (v3.8.1)
                  </div>

                  <div class="dependent">
                    org.projectlombok
                    lombok
                  </div>

                  <div class="dependent">
                    com.baomidou
                    mybatis-plus-boot-starter
                    (v3.1.1)
                  </div>

                  <div class="dependent">
                    org.springframework.boot
                    spring-boot-starter-web
                  </div>
                  <div class="dependent">
                    org.springframework.boot
                    spring-boot-starter-aop
                  </div>
                </div>
              </label>
            </div>
          </div>

          <div class="operate">
            <el-row>
              <el-button @click="submit" type="primary">提交</el-button>
            </el-row>
          </div>

          <!-- 项目结构 -->
          <div class="div">
            <h3>项目结构说明:</h3>
            <div class="desrc">
              <h3>1.项目结构</h3>
              <div class>
                <img src="../assets/project.png" />
                <img src="../assets/project-detail.png" />
              </div>
            </div>
          </div>

          <!-- 项目文件说明 -->
          <div class="div">
            <h3>项目文件说明:</h3>
            <div class="desrc">
              <h3>1.common 包</h3>
              <div class>
                <p>公用的工具以及一些配置相关的包，包括全局异常处理</p>
                <ul>
                  <li>
                    common
                    <ol>
                      config：配置类文件包，比如mybatis-plus的配置
                      <ol>
                        MpConfig.java:mybatis-plus 配置类
                        <ol>paginationInterceptor()方法：分页插件</ol>
                        <ol>
                          sqlInjector()：逻辑删除。
                          <a
                            href="https://mybatis.plus/guide/logic-delete.html"
                            target="_blank"
                          >点击详情</a>
                        </ol>
                        <ol>performanceInterceptor()：sql格式化打印输出</ol>
                      </ol>
                    </ol>
                    <ol>
                      exception: 全局异常处理相关类，所有的异常都统一JSON 格式 定义自己的，code 以及 错误提示
                      <ol>
                        Error.java：定义错误枚举，自定义code 和默认的错误信息
                        <ol>
                          <img src="../assets/error.png" />
                        </ol>
                      </ol>

                      <ol>
                        GlobalExceptionHandler.java：全局异常捕获,拦截对应的异常，对异常进行捕获处理，统一响应错误信息
                        <ol>
                          <img src="../assets/GlobException.png" />
                        </ol>
                      </ol>

                      <ol>
                        MyException.java：自定义异常类
                        <ol>
                          <img src="../assets/myException.png" />
                        </ol>
                      </ol>
                    </ol>
                    <ol>utils：工具包</ol>
                    <ol>
                      web： 公用的java类 例如 做日志的切面，controller的父类，统一的响应类的封装
                      <ol>
                        BaseController.java:
                        <img src="../assets/baseController1.png" />
                        <img src="../assets/baseController2.png" />
                      </ol>
                    </ol>
                  </li>
                  <li>
                    core：core 包就是系统的业务处理类，实体bean mapper 接口，service controller 类
                    <ol>
                      <img src="../assets/core.png" />
                    </ol>
                  </li>
                  <li>
                    resources.mapper：mapper.xml文件
                    <ol>
                      <img src="../assets/mapper.png" />
                    </ol>
                  </li>

                  <li>
                    application.yml：SpringBoot项目配置文件
                    <ol>
                      <img src="../assets/yml.png" />
                    </ol>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      testloading: false,
      submitLoading: false,
      transfer: {
        props: {
          key: "tableName",
          label: "tableName"
        },
        tablse: [],
        value: [],
        titles: ["Exclude", "Include"]
      },
      connectDbTip: "",
      dbConfig: {
        dbHost: "www.memoryoverflow.cn",
        dbPort: "3306",
        dbName: "test",
        dbRoot: "tiger",
        dbPwd: "tiger!.."
      },
      dbConfigSuccess: "",
      projectConfig: {
        classAuthor: "永健",
        groupId: "generator",
        artifactId: "generator-demo",
        packageName: "generator.test.demo",
        tablePrefix: "",
        projectName: "generator-demo",
        includeTableName: "",
        hump: true,
        lombok: true
      },
      URL: {
        host: this.$glob.server,
        getTables: "/getTables",
        create: "/create/project"
      }
    };
  },
  created() {},
  methods: {
    submit() {
      this.submitLoading = true;
      for (const key in this.dbConfig) {
        if (this.dbConfig.hasOwnProperty(key)) {
          const element = this.dbConfig[key];
          if (element == "") {
            this.$warning("请配全置数据库参数");
            this.submitLoading = false;
            return;
          }
          this.projectConfig[key] = element;
        }
      }
      this.projectConfig.includeTableName = this.transfer.value.join(",");
      this.$post(this.URL.create, this.projectConfig).then(res => {
        if (res.code == 0) {
          window.open(
            this.URL.host + "/generator/downLoad?path=" + res.data,
            "_blank"
          );
        } else {
          this.$error(res.msg);
        }
        this.submitLoading = false;
      });
    },
    testConnect() {
      this.testloading = true;
      for (const key in this.dbConfig) {
        if (this.dbConfig.hasOwnProperty(key)) {
          const element = this.dbConfig[key];
          if (element == "") {
            this.$warning("请配全置数据库参数");
            this.testloading = false;
            return;
          }
        }
      }
      this.$get(this.URL.getTables, this.dbConfig).then(res => {
        console.log(res);
        if (res.code == 0) {
          this.transfer.tablse = res.data;
          this.connectDbTip = "0";
          this.dbConfigSuccess = JSON.parse(JSON.stringify(this.dbConfig));
        } else {
          if (res.code == 7) {
            this.connectDbTip = res.msg;
          } else {
            this.connectDbTip = "";
          }
        }
        this.testloading = false;
      });
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.main {
  display: flex;
  flex-direction: column;
}
.demo-input-size .el-input {
  width: 80px;
}
.demo-input-project label,
.transfer-my {
  display: flex;
  flex-direction: row;
}

.transfer-my {
  padding: 15px 0;
}
.demo-input-project label span,
.transfer-my span {
  width: 150px;
  text-align: right;
}
i {
  color: red;
  position: relative;
  top: 5px;
}
.demo-input-project .el-input {
  width: 70%;
}
.dependent-manager {
  width: 80%;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}
.dependent {
  border-radius: 10px;
  border: 1px solid #ebebeb;
  padding: 10px;
  margin: 5px 10px;
  color: rgb(66, 91, 231);
}

.desrc h3 {
  text-indent: 2em;
}
.div p {
  text-indent: 2em;
  color: gray;
}
.operate button {
  width: 100%;
}
.operate {
  border-bottom: 1px solid #ebebeb;
  padding: 20px;
  text-align: center;
}
.div li {
  font-size: 25px;
  font-weight: bolder;
}
</style>
