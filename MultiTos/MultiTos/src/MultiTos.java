/*To print the no, square and the cube (Number chart) Using Multithreading.*/
/**
 * @author Jainam
 */


class Num extends Thread    //To print the number
{
	public void run()
	{
		int i;
		for(i=1;i<=10;i++)
		{
			System.out.print("\n");
			System.out.print(i);
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				System.out.println("Error:");
			}
		}
	}
}

class Square extends Thread 	//to print the squares
{
	public void run()
	{
		
		int i;
		for(i=1;i<=10;i++)
		{
			System.out.print("\t"+(i*i));
			try
			{
				Thread.sleep(505);
			}
			catch(Exception e)
			{
				System.out.println("Error:");
			}
		}
	}
}

class Cube extends Thread	//to print the cubes
{
	public void run()
	{
		int i;
		for(i=1;i<=10;i++)
		{
			System.out.print("\t"+(i*i*i));
			try
			{
				Thread.sleep(510);
			}
			catch(Exception e)
			{
				System.out.println("Error:");
			}
		}
	}
}

class MultiTos	//Main Class
{
	public static void main(String args[])
	{
		Num n1=new Num();
		Square s1=new Square();
		Cube c1=new Cube();
		Thread t1=new Thread(n1);
		Thread t2=new Thread(s1);
		Thread t3=new Thread(c1);
		System.out.print("Number \t Square \t Cube\n"); 
		n1.start();
		s1.start();
		c1.start();
	}
}