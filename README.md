# Utils
自己开发所需的工具类
# 添加项目依赖
# step 1.
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  # step 2.
  dependencies {
	        implementation 'com.github.jiuzhidaoxiabb:Utils:Tag'
	}
