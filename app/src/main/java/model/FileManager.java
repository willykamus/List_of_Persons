package model;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileManager {

    public static ArrayList<Person> readEmployeesFromFile(Context context, String fileName) {

        ArrayList<Person> list = new ArrayList<>();

        AssetManager assetManager = context.getResources().getAssets();

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(assetManager.open(fileName));

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String oneline = bufferedReader.readLine();

            while (oneline!=null){

                StringTokenizer st = new StringTokenizer(oneline,",");
                String type = st.nextToken();

                if(type.equals("E")){

                    String name = st.nextToken();
                    int age = Integer.valueOf(st.nextToken());
                    int id = Integer.valueOf(st.nextToken());
                    String programmer = st.nextToken();
                    Double salary = Double.valueOf(st.nextToken());

                    list.add(new Employee(name,age,id,programmer,salary));

                }

                // Read next line
                oneline = bufferedReader.readLine();
            }

            bufferedReader.close();
            inputStreamReader.close();

        } catch (Exception e) {

            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();

        }

        return list;

    }

    public static ArrayList<Person> readStudentsFromFile(Context context, String fileName) {

        ArrayList<Person> list = new ArrayList<>();

        AssetManager assetManager = context.getResources().getAssets();

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(assetManager.open(fileName));

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String oneline = bufferedReader.readLine();

            while (oneline!=null){

                StringTokenizer st = new StringTokenizer(oneline,",");
                String type = st.nextToken();

                if(type.equals("S")){

                    String name = st.nextToken();
                    int age = Integer.valueOf(st.nextToken());
                    int id = Integer.valueOf(st.nextToken());
                    String program = st.nextToken();

                    list.add(new Student(name,age,id,program));

                }

                // Read next line
                oneline = bufferedReader.readLine();
            }

            bufferedReader.close();
            inputStreamReader.close();

        } catch (Exception e) {

            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();

        }

        return list;

    }

}
