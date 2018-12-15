/*阶段划分：
第一阶段：分析数据主体(重难点)
第二阶段：分析并完成整体框架(重难点)
第三阶段：分析并完成退出功能
第四阶段：分析完成订餐功能
第五阶段：分析并完成查看餐袋功能
第六届段：分析并完成签收订单功能
第七阶段：完成并分析删除功能(重难点)
第八阶段：我要点赞*/
import java.util.*;
public class ChiHuoLianMeng {
	public static void main(String[] args) {
		//数据主体，一组订单信息
		String[] names= new String[4];//订餐人
		String[] dishMegs= new String[4];//所定餐品信息
		int[] times= new int[4];//送餐时间
		String[] addre= new String[4];//送餐地址
		int[] states =new int[4];//订单状态，0；已预订，1；已完成
		double[] sumPrices= new double[4];//总金额
		
		//初始化2条订单信息
		names[0]="张晴";
		dishMegs[0]="鱼香肉丝 1份";
		times[0]=12;
		addre[0]="天成路209号";
		states[0]=1;
		sumPrices[0]=24.0;
		
		names[1]="张晴";
		dishMegs[1]="红烧带鱼  2份";
		times[1]=12;
		addre[1]="天成路209号";
		states[1]=0;
		sumPrices[1]=76.0;
		
		//数据主体，一组餐品信息
		String[] dishNames={"红烧带鱼","鱼香肉丝","时令蔬菜"};
		double[] prices={38.0,18.0,10.0};
		int[] praiseNum=new int[3];
		
		//循环(do-while)
		/*循环操作：
		      显示操作；
		      提示用户输入编号，并执行相应功能；
		   提示输入0返回
		   循环条件： 输入0*/
		Scanner input= new Scanner(System.in);//记录一个位空的位置，可以插入false:没有找到
		int num=-1; //记录用户输入的数字
		do{
			//显示主菜单
			System.out.println("************主菜单***********");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("*************************");
	//提示用户输入功能编号，并执行相应功能
			System.out.print("请选择：");
			int choose=input.nextInt();
			boolean isAdd= false;
			
			switch(choose){
			case 1:
				//1.我要订餐
				System.out.println("***我要订餐***");
				//查找要插入的位置
				for(int i=0;i<names.length;i++){
					//找到空的位置，记录下来
					if(names[i]==null){
						isAdd=true;//记录已找到为空的位值
						
						
						
						System.out.println("序号\t餐品名\t单价");
						for(int j=0;j<dishNames.length;j++){
							String price=prices[j]+"圆";
							String praise=praiseNum[j]+"赞";
							System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
						}
						//输入所选餐品编号和份数
						System.out.print("请选择所定餐品序号：");
						int chooseDish=input.nextInt();
						System.out.print("请选择所定份数:");
						int number=input.nextInt();
						String disMeg=dishNames[chooseDish-1]+" "+number+"份"; 
						
						
						//输入订餐人姓名
						System.out.print("输入订餐人姓名：");
						String name=input.next();
						
						//输入送餐时间
						System.out.print("请输入送餐时间（10~20整点送餐）");
						int time =input.nextInt();
						while(time<10||time>20){
							System.out.println("对不起，你输入的有误，请从新输入（10~20整点送餐）");
							time=input.nextInt();
						}
							//输入送餐地点
						System.out.print("请输入送餐地点：");
						String address=input.next();
						
						//输入餐费
						double sumprice=prices[chooseDish-1]*number;
						//送餐费，当达到50元，可免6元送餐费
						double deliCharge = sumprice>=50?0.0:6.0; //三目运算符
						
						//显示订餐信息
						System.out.println("订餐成功！");
						System.out.println("您的订单是："+disMeg);
						System.out.println("订餐人："+name);
						System.out.println("送餐时间："+time+"点");
						System.out.println("送餐地点是:"+address);
						System.out.println("餐费："+sumprice+",送餐费："+deliCharge+"元");
						
						//保存数据
						names[i]=name;
						dishMegs[i]=disMeg;
						addre[i]=address;
						times[i]=time;
						sumPrices[i]=sumprice+deliCharge;
						
						break;
					}
				}
				if(!isAdd){
					System.out.println("对不起，餐袋已满");
				}
				break;
			case 2:
				//2.查看餐袋
				System.out.println("*********查看餐袋*********");
				System.out.println("序号\t订餐人\t所定餐品信息\t送餐时间\t送餐地址\t\t总金额\t状态");
				//遍历数组
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String time=times[i]+"点";
						String sumPrice=sumPrices[i]+"元";
						String state= states[i]==0?"已预订":"已完成";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+time+"\t"+addre[i]+"\t"+sumPrice+"\t"+state);		
					}
				}
				
				break;
			case 3:
				//3.签收订单
				System.out.println("********签收订单*******");
//				要求用户输入一个签收的订单序号
				System.out.print("请输入要签收的订单序号:");
				int signOrderId=input.nextInt();
				boolean isFind= false;
//				查找这条订单（循环遍历）
				for(int i=0;i<names.length;i++){
					if(names[i]!=null&&states[i]==1&&signOrderId==i+1){
						System.out.println("对不起，您选择的订单已经签收完成，不能再次签收！");
						isFind=true;
						break;
					}else if(names[i]!=null && states[i]==0 && signOrderId==i+1){
						states[i]=1;//状态改为已完成
						System.out.println("订单已经签收！");
						isFind= true;
						break;			
					}
				}
				if(!isFind){
					System.out.println("抱歉，此订单不存在");
				}
//				 1.找到，状态是已完成（已经签收完）；提示不能再签收
//				 2.找到，状态是一预定（没有完成签收）；可以签收
//				 3.没找到，提示信息没有找到
				
				break;
			case 4:
				//4.删除订单
//				1.输入要删除的订单序号（从一开始）
				System.out.print("输入要删除的订单序号：");
				int delId=input.nextInt();
				int delIndex=-1;
				boolean isDelFind=false;
//				2.循环查找此条订单
				for(int i=0;i<names.length;i++){
//					找到，以签收，执行炒作
//					找到，未签收，提示信息
					if(names[i]!=null && states[i]==1 && delId==i+1){
						delIndex=i;
						isDelFind=true;
						break;
					}else if(names[i]!=null&& states[i]==0 && delId==i+1){
						System.out.println("您选择的订单未签收，不能删除！");
						isDelFind=true;
						break;
					}
				}
//					没找到，提示信息
				if(!isDelFind){
					System.out.println("对不起，此条订单不存在！");
				}
				//执行删除操作
				if(delIndex!=-1){
					for(int i=delIndex+1;i<names.length-1;i++){
						names[i-1]=names[i];
						dishMegs[i-1]=dishMegs[i];
						times[i-1]=times[i];
						addre[i-1]=addre[i];
						states[i-1]=states[i];
						sumPrices[i-1]=sumPrices[i];
						
						
						names[names.length-1]=null;
						dishMegs[names.length-1]=null;
						times[names.length-1]=0;
						addre[names.length-1]=null;
						states[names.length-1]=0;
						sumPrices[names.length-1]=0.0;
						
					}
					System.out.println("订单已删除！");
				}
						
				break;
			case 5:
				//5.我要点赞
				System.out.println("**********我要点赞********");
//				显示点赞的餐品列表
				System.out.println("序号\t餐品名\t单价\t点赞");
				for(int j=0;j<dishNames.length;j++){
					String price=prices[j]+"圆";
					String praise=praiseNum[j]+"赞";
					System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
				}
//				输入要赞的餐品序号
				
					
				System.out.print("请输入要点赞的餐品序号：");
				int dishId=input.nextInt();
				while(dishId-1>3||dishId-1<0){
					System.out.print("输入有误，请重新输入：");
					 dishId=input.nextInt();
				}
//				该序号的餐品点赞数+1
				praiseNum[dishId-1]++;
//				显示
				System.out.println("点赞成功！");
				System.out.println(dishNames[dishId-1]+"\t"+praiseNum[dishId-1]+"赞");
				
				break;
			case 6:
				
				//6.退出系统
				break;
			default:
				break;
			}
			if(choose<1||choose>5){
				break;
			}else{
				System.out.print("输入0返回：");
				num =input.nextInt();
			}
			
			//用户输入编号为1-5之外的数字时，退出循环，否则会提示输入0返回
	//t提示输入0返回		
			
			
		}while(num==0);
		System.out.println("谢谢使用，欢迎下次使用");
	}
}
