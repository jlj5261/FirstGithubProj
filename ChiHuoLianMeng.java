/*�׶λ��֣�
��һ�׶Σ�������������(���ѵ�)
�ڶ��׶Σ����������������(���ѵ�)
�����׶Σ�����������˳�����
���Ľ׶Σ�������ɶ��͹���
����׶Σ���������ɲ鿴�ʹ�����
������Σ����������ǩ�ն�������
���߽׶Σ���ɲ�����ɾ������(���ѵ�)
�ڰ˽׶Σ���Ҫ����*/
import java.util.*;
public class ChiHuoLianMeng {
	public static void main(String[] args) {
		//�������壬һ�鶩����Ϣ
		String[] names= new String[4];//������
		String[] dishMegs= new String[4];//������Ʒ��Ϣ
		int[] times= new int[4];//�Ͳ�ʱ��
		String[] addre= new String[4];//�Ͳ͵�ַ
		int[] states =new int[4];//����״̬��0����Ԥ����1�������
		double[] sumPrices= new double[4];//�ܽ��
		
		//��ʼ��2��������Ϣ
		names[0]="����";
		dishMegs[0]="������˿ 1��";
		times[0]=12;
		addre[0]="���·209��";
		states[0]=1;
		sumPrices[0]=24.0;
		
		names[1]="����";
		dishMegs[1]="���մ���  2��";
		times[1]=12;
		addre[1]="���·209��";
		states[1]=0;
		sumPrices[1]=76.0;
		
		//�������壬һ���Ʒ��Ϣ
		String[] dishNames={"���մ���","������˿","ʱ���߲�"};
		double[] prices={38.0,18.0,10.0};
		int[] praiseNum=new int[3];
		
		//ѭ��(do-while)
		/*ѭ��������
		      ��ʾ������
		      ��ʾ�û������ţ���ִ����Ӧ���ܣ�
		   ��ʾ����0����
		   ѭ�������� ����0*/
		Scanner input= new Scanner(System.in);//��¼һ��λ�յ�λ�ã����Բ���false:û���ҵ�
		int num=-1; //��¼�û����������
		do{
			//��ʾ���˵�
			System.out.println("************���˵�***********");
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ǩ�ն���");
			System.out.println("4.ɾ������");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("*************************");
	//��ʾ�û����빦�ܱ�ţ���ִ����Ӧ����
			System.out.print("��ѡ��");
			int choose=input.nextInt();
			boolean isAdd= false;
			
			switch(choose){
			case 1:
				//1.��Ҫ����
				System.out.println("***��Ҫ����***");
				//����Ҫ�����λ��
				for(int i=0;i<names.length;i++){
					//�ҵ��յ�λ�ã���¼����
					if(names[i]==null){
						isAdd=true;//��¼���ҵ�Ϊ�յ�λֵ
						
						
						
						System.out.println("���\t��Ʒ��\t����");
						for(int j=0;j<dishNames.length;j++){
							String price=prices[j]+"Բ";
							String praise=praiseNum[j]+"��";
							System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
						}
						//������ѡ��Ʒ��źͷ���
						System.out.print("��ѡ��������Ʒ��ţ�");
						int chooseDish=input.nextInt();
						System.out.print("��ѡ����������:");
						int number=input.nextInt();
						String disMeg=dishNames[chooseDish-1]+" "+number+"��"; 
						
						
						//���붩��������
						System.out.print("���붩����������");
						String name=input.next();
						
						//�����Ͳ�ʱ��
						System.out.print("�������Ͳ�ʱ�䣨10~20�����Ͳͣ�");
						int time =input.nextInt();
						while(time<10||time>20){
							System.out.println("�Բ����������������������루10~20�����Ͳͣ�");
							time=input.nextInt();
						}
							//�����Ͳ͵ص�
						System.out.print("�������Ͳ͵ص㣺");
						String address=input.next();
						
						//����ͷ�
						double sumprice=prices[chooseDish-1]*number;
						//�Ͳͷѣ����ﵽ50Ԫ������6Ԫ�Ͳͷ�
						double deliCharge = sumprice>=50?0.0:6.0; //��Ŀ�����
						
						//��ʾ������Ϣ
						System.out.println("���ͳɹ���");
						System.out.println("���Ķ����ǣ�"+disMeg);
						System.out.println("�����ˣ�"+name);
						System.out.println("�Ͳ�ʱ�䣺"+time+"��");
						System.out.println("�Ͳ͵ص���:"+address);
						System.out.println("�ͷѣ�"+sumprice+",�Ͳͷѣ�"+deliCharge+"Ԫ");
						
						//��������
						names[i]=name;
						dishMegs[i]=disMeg;
						addre[i]=address;
						times[i]=time;
						sumPrices[i]=sumprice+deliCharge;
						
						break;
					}
				}
				if(!isAdd){
					System.out.println("�Բ��𣬲ʹ�����");
				}
				break;
			case 2:
				//2.�鿴�ʹ�
				System.out.println("*********�鿴�ʹ�*********");
				System.out.println("���\t������\t������Ʒ��Ϣ\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t�ܽ��\t״̬");
				//��������
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String time=times[i]+"��";
						String sumPrice=sumPrices[i]+"Ԫ";
						String state= states[i]==0?"��Ԥ��":"�����";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+time+"\t"+addre[i]+"\t"+sumPrice+"\t"+state);		
					}
				}
				
				break;
			case 3:
				//3.ǩ�ն���
				System.out.println("********ǩ�ն���*******");
//				Ҫ���û�����һ��ǩ�յĶ������
				System.out.print("������Ҫǩ�յĶ������:");
				int signOrderId=input.nextInt();
				boolean isFind= false;
//				��������������ѭ��������
				for(int i=0;i<names.length;i++){
					if(names[i]!=null&&states[i]==1&&signOrderId==i+1){
						System.out.println("�Բ�����ѡ��Ķ����Ѿ�ǩ����ɣ������ٴ�ǩ�գ�");
						isFind=true;
						break;
					}else if(names[i]!=null && states[i]==0 && signOrderId==i+1){
						states[i]=1;//״̬��Ϊ�����
						System.out.println("�����Ѿ�ǩ�գ�");
						isFind= true;
						break;			
					}
				}
				if(!isFind){
					System.out.println("��Ǹ���˶���������");
				}
//				 1.�ҵ���״̬������ɣ��Ѿ�ǩ���꣩����ʾ������ǩ��
//				 2.�ҵ���״̬��һԤ����û�����ǩ�գ�������ǩ��
//				 3.û�ҵ�����ʾ��Ϣû���ҵ�
				
				break;
			case 4:
				//4.ɾ������
//				1.����Ҫɾ���Ķ�����ţ���һ��ʼ��
				System.out.print("����Ҫɾ���Ķ�����ţ�");
				int delId=input.nextInt();
				int delIndex=-1;
				boolean isDelFind=false;
//				2.ѭ�����Ҵ�������
				for(int i=0;i<names.length;i++){
//					�ҵ�����ǩ�գ�ִ�г���
//					�ҵ���δǩ�գ���ʾ��Ϣ
					if(names[i]!=null && states[i]==1 && delId==i+1){
						delIndex=i;
						isDelFind=true;
						break;
					}else if(names[i]!=null&& states[i]==0 && delId==i+1){
						System.out.println("��ѡ��Ķ���δǩ�գ�����ɾ����");
						isDelFind=true;
						break;
					}
				}
//					û�ҵ�����ʾ��Ϣ
				if(!isDelFind){
					System.out.println("�Բ��𣬴������������ڣ�");
				}
				//ִ��ɾ������
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
					System.out.println("������ɾ����");
				}
						
				break;
			case 5:
				//5.��Ҫ����
				System.out.println("**********��Ҫ����********");
//				��ʾ���޵Ĳ�Ʒ�б�
				System.out.println("���\t��Ʒ��\t����\t����");
				for(int j=0;j<dishNames.length;j++){
					String price=prices[j]+"Բ";
					String praise=praiseNum[j]+"��";
					System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
				}
//				����Ҫ�޵Ĳ�Ʒ���
				
					
				System.out.print("������Ҫ���޵Ĳ�Ʒ��ţ�");
				int dishId=input.nextInt();
				while(dishId-1>3||dishId-1<0){
					System.out.print("�����������������룺");
					 dishId=input.nextInt();
				}
//				����ŵĲ�Ʒ������+1
				praiseNum[dishId-1]++;
//				��ʾ
				System.out.println("���޳ɹ���");
				System.out.println(dishNames[dishId-1]+"\t"+praiseNum[dishId-1]+"��");
				
				break;
			case 6:
				
				//6.�˳�ϵͳ
				break;
			default:
				break;
			}
			if(choose<1||choose>5){
				break;
			}else{
				System.out.print("����0���أ�");
				num =input.nextInt();
			}
			
			//�û�������Ϊ1-5֮�������ʱ���˳�ѭ�����������ʾ����0����
	//t��ʾ����0����		
			
			
		}while(num==0);
		System.out.println("ллʹ�ã���ӭ�´�ʹ��");
	}
}
