import os
import shutil
import zipfile


# 空文件 便于写入此空文件到apk包中作为channel文件
src_empty_file = 'temp.txt'
# 创建一个空文件（不存在则创建）
f = open(src_empty_file, 'w') 
f.close()

# 获取渠道列表
channel_file = 'marketlist.txt'
f = open(channel_file)
lines = f.readlines()
f.close()


# 获取当前目录中所有的apk源包
src_apks = []
for file in os.listdir():
	if os.path.isfile(file):
		extension = os.path.splitext(file)[1][1:]
		if extension in 'apk':
			src_apks.append(file)
			
			
# file name (with extension)
src_apk = src_apks[0]
src_apk_file_name = os.path.basename(src_apk)
# 分割文件名与后缀
temp_list = os.path.splitext(src_apk_file_name)
# name without extension
src_apk_name = temp_list[0]
# 后缀名，包含.   例如: ".apk "
src_apk_extension = temp_list[1]

# 创建生成目录,与文件名相关
output_dir = src_apk_name +"各渠道包"+ '/'
# 目录不存在则创建
if not os.path.exists(output_dir):
	os.mkdir(output_dir)
# 遍历渠道号并创建对应渠道号的apk文件
linesIndex = 1
for line in lines:
	# 获取当前渠道号，因为从渠道文件中获得带有\n,所有strip一下
	target_channel = line.strip()
	if "#" in line[0:1] : 
		print("渠道"+target_channel[1:]+"跳过")
		continue		
	# 拼接对应渠道号的apk
	target_apk = output_dir + src_apk_name + "_" + target_channel + src_apk_extension  
	# 拷贝建立新apk
	shutil.copy(src_apk,  target_apk)
	# zip获取新建立的apk文件
	zipped = zipfile.ZipFile(target_apk, 'a', zipfile.ZIP_DEFLATED)
	# 初始化渠道信息
	empty_channel_file = "META-INF/kdlcchannel_"+target_channel
	# 写入渠道信息
	zipped.write(src_empty_file, empty_channel_file)
	# 关闭zip流
	zipped.close()
	print(linesIndex,".渠道 "+target_channel+" 打包完成")
	linesIndex = linesIndex + 1
	