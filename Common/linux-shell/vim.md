vim操作
---
####模式简介
	
	1. Normal 
	2. Insert
	3. Visual

1. 用v命令进入的字符可视化模式（Characterwise visual mode)。文本选择是以字符为单位的。
2. 用V命令进入的行可视化模式（Linewise visual mode)。文本选择是以行为单位的。
3. 用ctrl-V进入的块可视化模式（Blockwise visual mode）。可以选择一个矩形内的文本。（注意：在Windows中，ctrl-V可能已经被影射为粘贴操作，可以使用ctrl-Q进入块可视化模式。）


####复制粘贴操作
	
	yy复制游标所在行整行。或大写一个Y。 
	2yy或y2y复制两行。
	y^复制至行首，或y0。不含游标所在处字元。 
	y$复制至行尾。含游标所在处字元。 
	yw复制一个word。 
	y2w复制两个字（单词）。 
	yG复制至档尾。 
	y1G复制至档首。 
	p小写p代表贴至游标后（下）。 
	P大写P代表贴至游标前（上）。 

####光标移动操作


