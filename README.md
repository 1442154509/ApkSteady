# 综合马甲

#############################   命名规则 #########################

layout:
	模块名+业务名+功能名+描述名1+描述名2....

	ps1:如果是common; 用 模块名+业务名 = common
	ps2:描述可多项，也可没有

	模块名：app，bus,msg,common
	业务名：根据实际情况顶
	功能名：activity，fragment,item,include
	描述名：根据实际情况顶
	eg:
		1.bus_me_fragment
		2.bus_me_item_user
		3.common_recycler

string,raw,styles ,array, dimens,ids,attrs,anim:
	模块名+业务名+描述名1+描述名2....

	ps1:如果是common; 用 模块名+业务名 = common
	ps2:描述可多项，也可没有

	模块名：app，bus,msg,common
	业务名：根据实际情况顶
	描述名：根据实际情况顶
	eg:
		1.bus_login_password_empty = "密码为空"
		2.common_fail = “失败”

color:
	英文开头 就用颜色小写
	数字开头 c+颜色小写
	eg:
		1.f4f4f4
		2.c59c1ff


mipmap:
	模块名+业务名+功能名+描述名1+描述名2....

	ps1:如果是common;用 模块名+业务名 = common
	ps2:描述可多项，也可没有

	模块名：app，bus,msg,common
	业务名：根据实际情况顶
	功能名：icon，bg,holder(占位图)
	描述名：根据实际情况顶
	eg:
		1.bus_me_icon_user
		2.bus_me_bg
		3.common_default_user

drawable:
	圆角：
		corners_(描边色)_(背景色)_(角度)_(边宽)
		全部都是必选项
		颜色为空就用trans代替
		数字为空就用0替换，不带单位
		eg:
			corners_333333_trans_15_1
			corners_trans_999999_15_0

	圆：
		oval_(背景色)_(宽）
		oval_(背景色)_(宽)_(描边色)_(边宽)
		全部都是必选项
		颜色为空就用trans代替
		数字为空就用0替换，不带单位
		eg:
			oval_999999_15
			oval_999999_15_33333_1

	缺边角的园：
	    half_corners_(描边色)_(背景色)_(角度)_(边宽)


	其他：layer,selector ....
		功能名+模块名+业务名+描述名1+描述名2....

		ps1:如果是common; 用 模块名+业务名 = common
		ps2:描述可多项，也可没有

		功能名：layer，selector...
		模块名：app，bus,msg,common
		业务名：根据实际情况顶
		描述名：根据实际情况顶
		eg:
			1.layer_bus_me_boy_left
			2.selector_bus_me_girl

	渐变：
		gradient+模块名+业务名+描述名1+描述名2....
		eg:
		1.gradient_bus_me_boy_left


xml的ID 命名
    控件名+描述名1+描述名2....

    eg:
    1.text_view_name
    2.image_view_user


#############################   命名规则 #########################

