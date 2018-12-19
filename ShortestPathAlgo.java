package Pacman;

import java.util.Iterator;

import Coords.MyCoords;
import Geom.Point3D;

public class ShortestPathAlgo {
	public game game=new game();
	public path b;
	// insert the locations of fruits to array
	// array to store the locations of pacmans
	pacman[] pacmans= new pacman[game.pacmancounter];
	fruit[] fruits= new fruit[game.fruitcounter];
	double [][] distance = new double [fruits.length][pacmans.length];


	public ShortestPathAlgo(game x) {
		game=x;
		int i=0;
		Iterator <pacman> here= game.pacmans.iterator();
		// fullfil the array in pacman's locations using iterator
		while(here.hasNext()) {
			pacman temp=here.next();
			pacmans[i++]=temp;
		}
		i=0;
		Iterator <fruit> there= game.fruits.iterator();
		there=game.fruits.iterator();
		while(there.hasNext()) {
			fruit temp=there.next();
			fruits[i++]=temp;
		}
	}

//	public int closest(double[] a) {
//		double min=a[0];
//		int j=0;
//		for(int i=1;i<a.length;i++) {
//			if (a[i]<min) {
//				min=a[i];
//				j=i;
//			}
//		}
//		return j;
//	}
	public double[] cal() {
		//get the time matrix
		double [][] time = timepath(pacmans,fruits);
		//variables to save the shortest time between pacman and fruit
		int u=0,v=0;
		//find the shortest 
		double min=time[0][0];
		for (int i = 0; i < time.length; i++) {
			for (int j = 0; j < time[0].length; j++) {
				if(time[i][j]<min) {
					min=time[i][j];
					u=i; v=j;
				}
			}
		}
		// change location of the pacman to the location of the fruit
		pacmans[u].location.setAlt(fruits[v].location.getx());

		double [] result= {pacmans[u].id,fruits[v].id,time[u][v]};
		return result;

	}

	private int[] clean(double[] x,int j) {
		distance=timepath(pacmans,fruits);
		int u=0;
		double []temp= new double [x.length];
		for(int i=0; i<x.length;i++) {
			if (x[i]!=-1) {
				double d=distance[j][i];
				temp[u++]=d;
				
			}
		}
		return null;
	}

	public void bubblesort(double []x) {
		int n=x.length;
		for(int i=0; i < n; i++){  
			for(int j=1; j < (n-i); j++){  
				if(x[j-1] > x[j]){  
					//swap elements  
					double temp = x[j-1];  
					x[j-1] = x[j];  
					x[j] = temp;  
				}  

			}  
		}
	}



	public double[][] timepath(pacman [] a,fruit [] b) {
		MyCoords object=new MyCoords();
		double [][] temp = new double [a.length][b.length];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				temp[i][j]= (object.distance3d(a[i].location, b[j].location))/a[i].mps;
			}
		}

		return temp;
	}
}
