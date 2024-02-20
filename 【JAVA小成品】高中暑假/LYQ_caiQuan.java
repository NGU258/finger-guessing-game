//猜拳小游戏（java语言编写）
//package caiQuan.lyq.test; //该文件所在包的路径
import java.util.Random; //导入Random类所在包,产生随机数
import java.text.SimpleDateFormat;//导入日期格式化用的类所在包
import java.util.Date;//导入日期所用的类所在包
import java.util.Scanner;//导入Scanner类所在包
public class LYQ_caiQuan {//用户类

	static Scanner lyq=new Scanner(System.in);//导入Scanner类，用于键盘输入
	
	//属性值
	public String name;//用户名
	public String pwd;//用户密码
	public int score;//用户分数
	public int rm;//用于存储随机数，判断出拳
	
	public LYQ_caiQuan()//声明一个无参的构造方法，用于创建对象
	{
		
	}
	
	public LYQ_caiQuan(String user,String pwd)//声明一个有参的构造方法，用于创建对象
	{
		this.name=user;//把创建对象时传过来的用户名给指定对象赋值
		this.pwd=pwd;//把创建对象时传过来的用户密码给指定给对象赋值
	}
	
	
	public static void Cuser1()//定义一个普通的方法，用于猜拳等操作
	{
		//提示语1
		System.out.println("\n游戏启动中………… 祝你玩得愉快!");
		System.out.println("\n请输入您的用户名：");
		String user=lyq.next();
		System.out.println("请输入您的密码：");
		String pwd=lyq.next();
		
		LYQ_caiQuan user1=new LYQ_caiQuan(user,pwd);//创建玩家账户，并把之前输入的用户账号给该账户
		
		Random s=new Random();//创建Random类的对象
		user1.score=s.nextInt(100)+1;//用该对象产生随机数，给玩家随机分配，分数在1~99之间
		
		//提示语2
		System.out.println("\n创建成功，请查看您的用户界面");
		System.out.println("玩家："+user1.name+"	 密码:"+user1.pwd);
		System.out.println("\n正在匹配中………………");
		System.out.println("匹配成功！\n");
		
		//创建电脑用户
		String[] users= {"魔皇战神","不死魔皇","黑鹰战将","帝仙使者","火焰使者","皮卡丘","皮皮虾","黑暗大帝","帝之天使","光明大帝","泰坦巨猿","龙皇","鬼帝","电击小子"};//创建电脑名称
		LYQ_caiQuan c_user=new LYQ_caiQuan();//创建User类对象，即电脑用户
		
		int xb=s.nextInt(users.length);//用来生成数组下标
		c_user.name=users[xb];//给电脑名字赋值
		
		//提示语3
		System.out.println("您要挑战的玩家是 ("+c_user.name+") !\n");
		System.out.println("系统正在初始化你们的分数，请稍等……\n");
		
		c_user.score=user1.score;//让玩家与电脑的用户分数保持一致
		c_user.rm=s.nextInt(3);//给电脑产生随机数0~2，规则： 0：石头 1：剪刀 2：布
		
		long start=System.currentTimeMillis();//返回此时的毫秒数(long型)，为之后计算运行时间做铺垫。
		int m=10;//用于控制循环数，赋值为3就循环3次。
		for(int i=m-1,j=1;i>=0;i--,j++)//作十次循环，即十次挑战
		{
			//提示语5
			if(j==1)  System.out.println("初始化完毕，游戏开始！\n\n开始计时中……(注意你们共有"+(i+1)+"次挑战机会哦，最终分数最高者获胜！)");
			String u1=" ",u2=" ",cq="请出拳吧。";
			if(user1.score>c_user.score) u1="(暂时领先)";//用于判断谁领先
			else if(user1.score<c_user.score) u2="(暂时领先)";
			else System.out.println("");
			
			System.out.println("\n————————————————————————————————————————————————————————————————————————");
			System.out.println("		     第  [ "+j+" ] 轮\n");
			System.out.println("("+user1.name+") [目前分数："+user1.score+"分  "+u1+"]    VS    ("+c_user.name+") [目前分数："+c_user.score+"分  "+u2+"]  ");
			System.out.println("\n     	  	   Really go !");
			System.out.println("————————————————————————————————————————————————————————————————————————\n");
			System.out.println("		[0:石头 	1:剪刀 	2:布]");
			if(i==0) cq="给予对手最后一击吧！";
			System.out.println("根据上述提示输入对应数字(赢一局得10分哦,分数最高者获胜) ，"+cq);
			
			user1.rm=lyq.nextInt();//用户手动输入数字
			if(user1.rm<0||user1.rm>2)//如果输入的数字不是0 1 2则重新输入
			{
				System.out.println("不好意思，你输入的数字有误，请检查后重新输入");
				j--;//防止continue语句之后j多加了一次,因为此时并没有开始一轮
				i++;//防止continue语句之后i多减了一次,因为此时并没有开始一轮
				continue;
			}
			
			System.out.println("————————————————————————————————————————————————————————————————————————");
			
			int sign;//用于比较谁胜谁败 0指平局 1指用户玩家获胜 -1指电脑玩家获胜
			String yq1,yq2;//用于存储用户玩家与电脑玩家输入的是石头，剪刀还是布，yp1是指用户玩家 yp2是指电脑玩家 。
			
			//判断用户玩家输入的是石头，剪刀还是布
			if(user1.rm==0) yq1="石头";
			else if(user1.rm==1) yq1="剪刀";
			else  yq1="布";
			
			//判断电脑玩家输入的是石头，剪刀还是布
			if(c_user.rm==0) yq2="石头";
			else if(c_user.rm==1) yq2="剪刀";
			else  yq2="布";
			
			if("石头".equals(yq1))//假若用户玩家输入的是石头
			{
				if("石头".equals(yq2))//如果电脑玩家也是出石头，则为平局
				{
					sign=0;//平局的标志
				}else if("剪刀".equals(yq2))//如果电脑玩家出剪刀，则用户玩家胜
				{
					sign=1;//用户玩家胜的标志
				}
				else sign=-1;//电脑玩家出的布，电脑玩家胜的标志
			}
			else if("剪刀".equals(yq1))//假若用户玩家输入的是剪刀
			{
				if("石头".equals(yq2))//如果电脑玩家出的是石头，则电脑玩家胜
				{
					sign=-1;//电脑玩家胜的标志
				}else if("剪刀".equals(yq2))//如果电脑玩家出的也是剪刀，则打成平局
				{
					sign=0;//平局的标志
				}
				else sign=1;//否则电脑玩家就是出的布，即用户玩家胜的标志
			}
			else//最后一种就是用户玩家出的布
			{
				if("石头".equals(yq2))//如果电脑玩家出的是石头，则用户玩家胜
				{
					sign=1;//用户玩家胜的标志
				}else if("剪刀".equals(yq2))//如果电脑玩家出的是剪刀,则电脑玩家胜
				{
					sign=-1;//电脑玩家胜的标志
				}
				else sign=0;//否则电脑玩家出的是布，打成平局
			}
			
			String win;//用于存谁胜谁败的信息
			if(sign==-1)//如果标志是-1，则说明电脑玩家胜利
			{
				 win="恭喜玩家 ("+c_user.name+") 击败玩家 ("+user1.name+")  获得 10[分] !";//给字符串变量赋值，为后面的输出作铺垫
				 c_user.score+=10;//电脑玩家分数加10

			}
			else if(sign==1)//如果标志是1，则说明用户玩家胜利
			{
				 win="恭喜玩家 ("+user1.name+") 击败玩家 ("+c_user.name+")  获得 10[分] !";//给字符串变量赋值，为后面的输出作铺垫
				 user1.score+=10;//用户玩家分数加10
			}
			else win="恭喜你们打成平手，再拉再励！";//sign=0的情况 ，即打成平局，给字符串变量赋值，为后面的输出作铺垫
			
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("玩家 ("+user1.name+") 输入的是 ["+yq1+"]");//把用户玩家的名字与出拳的结果输出
			System.out.println("玩家 ("+c_user.name+") 输入的是 ["+yq2+"]\n");//把电脑玩家的名字与出拳的结果输出
			System.out.println(win);//最后输出存谁胜谁败的信息
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\n正在统计分数中……");
			
			c_user.rm=s.nextInt(3);//让电脑的出拳标志更新，继续出拳，否则若不更新此数据，电脑玩家就会一直输出一样的结果
			
			if(i==0) break;//如果循环已到最后一轮了，就可以结束了，后面的就没必要输出了
			String lx;//用于存储谁领先谁落后的信息。
			int fs=0;//用于存储领先或落后的分数
			
			if(user1.score>c_user.score)//如果用户玩家的分数大于电脑玩家
			{
				lx="领先对手[";//给lx这个字符串变量赋值
				fs=user1.score-c_user.score;//保存用户玩家大于电脑玩家的分数
			}
			else if(user1.score<c_user.score)//如果用户玩家的分数低于电脑玩家
			{
				lx="落后对手[";//给lx这个字符串变量赋值
				fs=c_user.score-user1.score;//保存电脑玩家大于用户玩家的分数
			}
			else//分数一致
			{
				lx="与对手打成平局!";
			}
			//提示语6
			if("与对手打成平局!".equals(lx))  System.out.println("统计完毕，玩家("+user1.name+") 您还剩下【"+i+"】次挑战机会，当前分数：【 "+user1.score+" 】分    "+lx);//如果打成平局，就不用输出fs存在分数
			else System.out.println("统计完毕，玩家("+user1.name+") 您还剩下【"+i+"】次挑战机会，当前分数："+user1.score+"分    "+lx+fs+"]分!");
			System.out.println("\n请输入任意键进行下一轮挑战！");
			String q=lyq.next();//用于暂停
			System.out.println("");//用于换行
			
		}//循环结止处
		
		long end=System.currentTimeMillis();//记录游戏结束时的毫秒数。
		long hMiao=end-start;//计算程序运行时间
		double Miao=hMiao/1000;//毫秒转换成秒，之间相差1000
		
		//提示语6
		System.out.println("\n游戏结束，玩家("+user1.name+")的最终得分是:("+user1.score+")分， 玩家("+c_user.name+")的最终得分是:("+c_user.score+")分  总共用时【"+Miao+"】秒\n");
		
		if(user1.score>c_user.score) //假若用户玩家分数大于电脑玩家分数
		{	
			//输出用户玩家获胜信息
			System.out.println("恭喜最终获胜者为玩家（"+user1.name+")!   \n\n");
			System.out.println("恭喜玩家("+user1.name+")取得最终胜利，正在发送奖励\n\n");
			System.out.println("————————————————————————————————————————————————————————————————————————");
			System.out.println("叮咚……恭喜玩家("+user1.name+")获得屠龙神器全套\n");
			System.out.println("叮咚……恭喜玩家("+user1.name+")获得四大神兽（神话级）！\n");
			System.out.println("叮咚……恭喜玩家("+user1.name+")获得斗罗大陆世界的入场券\n");
			System.out.println("叮咚……恭喜玩家("+user1.name+")获得宠物神圣天使（灭世级）\n");
			System.out.println("叮咚……恭喜玩家("+user1.name+")获得仙女的庇护\n");
			System.out.println("叮咚……恭喜玩家("+user1.name+")获得圣女的庇护");
			System.out.println("————————————————————————————————————————————————————————————————————————\n");
			System.out.println("礼物发放完毕，欢迎下次光临！");
		}
		else if(user1.score<c_user.score)//假若用户玩家分数低于电脑玩家分数
		{
			//输出电脑玩家获胜信息
			System.out.println("恭喜最终获胜者为玩家（"+c_user.name+")!  \n\n");
			System.out.println("————————————————————————————————————————————————————————————————————————");
			System.out.println("不好意思，玩家（"+user1.name+"）挑战失败，游戏结束。不过不要气馁，本系统相信你一定会卷土重来的！");
			System.out.println("————————————————————————————————————————————————————————————————————————");
		}
		else //否则就是分数一样，打成平局
		{
			//输出平局信息
			System.out.println("\n\n————————————————————————————————————————————————————————————————————————");
			System.out.println("真是奇迹，你们的分数竟在最后时刻一样，打成平手 .  \n");
			System.out.println("作为参与此次大赛的奖励，恭喜玩家("+c_user.name+")获得黑暗神器套装，恭喜玩家("+user1.name+")获得神圣天使套装！\n");
			System.out.println("奖品已发放完毕，本系统正在退出中……");
			System.out.println("————————————————————————————————————————————————————————————————————————");
			
		}
	}
	
	public static void main(String[] args)//类似于c语言中的Main函数
	{
		gameBegain();//调用方法，在C中是叫调用函数
	}

	public static  void gameBegain()//定义普通方法（函数）
	{
		while(1==1)//作死循环，用于下面if的第三种情况，这个JAVA与C不一样，不能直接写1，要写1==1才行。
		{
			Date date=new Date();//创建日期类对象,获取当前日期
			SimpleDateFormat f1=new SimpleDateFormat("yyyy年MM月dd日  HH时 mm分");//创建用于格式化日期类对象的对象
			String sdate=f1.format(date);//将日期类对象转化为字符串格式。
			//提示语
			System.out.println("\n————————————————————————————————————————————————————————————————————————");
			System.out.println("欢迎来到 [猜拳小游戏]\n");
			System.out.println("最终获胜的玩家将获得超级大奖哦！\n");
			System.out.println("现在是["+sdate+"]   游戏开始后将会计时哦\n");
			System.out.println("————————————————————————————————————————————————————————————————————————");
			System.out.println("1.开始游戏  2.退出系统\n");
			System.out.println("请开始您的选择：");
			
			int n=lyq.nextInt();//用变量n来获取用户输入的数据 
			
			if(n==1)//如果该数据等于1，则开始游戏
			{
				Cuser1();//调用方法，开始游戏
				break;
				
			}else if(n==2)//如果该数据等于2，则退出游戏
			{
				//退出的提示语
				System.out.println("\n感谢您的来访，欢迎下次光临");
				break;
			}else //否则输入的数据不是1与2，则重新输入
			{
				System.out.println("您输入数学有误，请重新输入");
			}
		}
	}
}
