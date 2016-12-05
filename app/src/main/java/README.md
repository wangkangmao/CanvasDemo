##Canvas
这个类相当于是一个画布，你可以在里面画很多东西；
我们可以把这个Canvas理解成系统提供给我们的一块内存区域（但实际上它只是一套画图的API，
真正的内存是下面的Bitmap），而且它还提供了一整套对这个内存区域进行操作的方法，
所有这些操作都是画图的API。也就是说在这种方式下我们已经能一笔一划或者使用Graphic来画我们所需要的东西了，
要画什么要显示什么都由我们自己控制。

这种方法根据环境还分为两种：一种就是使用普通View和Canvas画图，还有一种就是使用专门的SurfaceView的Canvas来画图。
两种的主要区别就是可以在SurfaceView中定义一个专门的线程来完成画图的工作，应用程序不需要等待View的刷图，提高性能。
前面一种适合处理量比较小，帧率比较小的动画，比如说象棋游戏之类的；后一种主要用在游戏，高画质动画方面的画图。

##Canvas常用的用法
drawRect(RectF rect,Paint paint)//绘制区域，参数为RectF的一个区域
drawPath(Path path,Paint paint)//绘制一个路径，参数为Path路径对象。
drawBitmap(Bitmap bitmap,Rect src,Rect dst,Paint paint)//贴图，参数就是我们常规的Bitmap对象
drawPoint(float x,float y,Paint paint)//画点，参数1:水平x轴; 参数2：垂直y轴，参数3：Paint对象
drawText(String text,float x,float y,Paint paint)//绚烂文本，Canvas类除了上面的还可以绘制文字，参数1：String类型的文本
drawOval(RectF oval,Paint paint)//画椭圆，参数1：扫描区域，参数2：Paint对象
drawCircle(float x,float y, float radius,Paint paint)//绘制圆，参数1：中心点的x轴，参数2：中心点的y轴，参数3：半径 ;参数4：paint对象
drawArc(RectF oval,float startAngle,float sweepAngle,boolean useCenter,Paint paint) //画圆弧，参数1：RectF对象，一个矩形区域椭圆形的界限用于定义在形状、
大小、电弧；参数2：其实角度；参数3：扫描角度，开始顺时针测量的，参数4
