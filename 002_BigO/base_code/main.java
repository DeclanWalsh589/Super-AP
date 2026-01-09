import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.io.BufferedWriter;



class main {
	public static void main(String args[]) {
		int [] times = {10, 100, 1000, 10000, 100000, 1000000, 10000000};
		int [] nums = new int[100];
		ArrayList<DayBirth> birth = new ArrayList<DayBirth>();
		Stopwatch s = new Stopwatch();
		DayBirth b;
      String csvFilePath = "births.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");
                if(values[0].equals("year")){
                    continue;
                }
                if(!values[2].equals("null")){
                    b = new DayBirth(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2]), values[3], Integer.parseInt(values[4]));
                }
                else{
                    b = new DayBirth(Integer.parseInt(values[0]), Integer.parseInt(values[1]), null, values[3], Integer.parseInt(values[4]));
                }
                birth.add(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        DayBirth [] arrayBirths = new DayBirth[birth.size()];
        for(int i = 0; i < birth.size(); i ++){
            arrayBirths[i] = birth.get(i);
        }
		System.out.println("-------------------Test-------------------");
		System.out.println("");
		for(int i : times){
			System.out.println("Interval: " + i);
			s.start();	
			nums = new int[i];
		  Put your method between these two comments
			randomize(nums);
			//
			//search(nums);
			//bubbleSort(nums, nums.length);
			//insertionSort(nums, nums.length);
			//selectionSort(nums, nums.length);
			//mergeSort(nums, 0, nums.length-1);
			//mergeSort(arrayBirths, 0, arrayBirths.length-1);
			//quickSort(nums, 0, nums.length -1);
			quickSort(arrayBirths, 0, arrayBirths.length-1);
			s.stop();
			try (BufferedWriter writer = new BufferedWriter(new FileWriter("sortedMEN.csv"))) {
			    writer.flush();
 
            writer.write("year,month,day,gender,births"); 
            writer.newLine();

            for (DayBirth v : arrayBirths) {
                if(v.gender.equals("M")){
                    String line = v.year + "," + v.month + "," + v.day + "," + v.gender + "," + v.births;
                    writer.write(line);
                    writer.newLine();
                }
                // System.out.println(line);
            }
            
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sortedWOMEN.csv"))) {
			    writer.flush();
            writer.write("year,month,day,gender,births"); 
            writer.newLine();

            for (DayBirth v : arrayBirths) {
                if(v.gender.equals("F")){
                    String line = v.year + "," + v.month + "," + v.day + "," + v.gender + "," + v.births;
                     writer.write(line);
                    writer.newLine();
                }
                // System.out.println(line);
               
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
			System.out.println("Duration: " + Stopwatch.readable(s.read()));
			System.out.println("");
		}
	
	public static void randomize(int array[]){
		for(int i = 0; i < array.length; i++){
			array[i] = (int)(Math.random() * 200000);
		}
	}
	public static boolean search(int array[]){
		int num = (int)(Math.random() * 200000);
		for(int i = 0; i < array.length; i ++){
			if(num == array[i]){
				return true;
			}
		}
		return false;
	}
	public static void bubbleSort(int array[], int n){
		int temp;
		for(int i = 0; i < n-1; i ++){
			for(int j = 0; j < n-i-1; j ++){
				if(array[j] > array[j + 1]){
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	public static void insertionSort(int array[], int n){
		int key;
		int j;
		for(int i = 0; i < n; i++){
			key = array[i];
			j = i -1;
			while(j >= 0 && array[j] > key){
				array[j + 1] = array[j];
				j=j-1;
			}
			array[j+1] = key;
		}
	}
	public static void selectionSort(int array[], int n){
		int min_index;
		int temp;
		for(int i = 0; i < n-1; i++){
			min_index = i;
			for(int j = i + 1; j< n; j++){
				if(array[j] < array[min_index]){
					min_index = j;
					temp = array[min_index];
					array[min_index] = array[j];
					array[j] = min_index;
				}
			}
		}
	}
	static void merge(DayBirth arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;


        DayBirth L[] = new DayBirth[n1];
        DayBirth R[] = new DayBirth[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getBirths() <= R[j].getBirths()) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

 
    static void mergeSort(DayBirth arr[], int l, int r){
        
        if (l < r) {

   
            int m = l + (r - l) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }
    static int partition(DayBirth[] arr, int low, int high) {
        

        int pivot = arr[high].births;
        
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j].births < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        swap(arr, i + 1, high);  
        return i + 1;
    }
    static void swap(DayBirth[] arr, int i, int j) {
        DayBirth temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void quickSort(DayBirth[] arr, int low, int high) {
        if (low < high) {
            
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}

class DayBirth{
        public int year;
        public int month;
        public Integer day;
        public String gender;
        public int births;
        DayBirth(int y,int m, Integer d,String g, int b){
            year = y;
            month = m;
            day = d;
            gender = g;
            births = b;
        }
        public int getBirths(){
            return births;
        }
    }
