package com;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;

public class JsonFileReader {

    public static void showJsonData(String path) throws IOException {
        if (new File(path).exists()) {
            Reader reader = new FileReader(path);
            JsonReader jsonReader = new JsonReader(reader);
            DefaultTableModel firstTableModel = new DefaultTableModel();
            DefaultTableModel secondTableModel = new DefaultTableModel();
            JTable firstTable = new JTable(firstTableModel);
            JTable secondTable = new JTable(secondTableModel);

            firstTableModel.addColumn("Keys");
            firstTableModel.addColumn("Values");

            // READING JSON AND PUSHING DATA IN THE TABLE
            String name = "";
            while (jsonReader.hasNext()) {
                JsonToken nextToken = jsonReader.peek();
                switch (nextToken) {
                    case BEGIN_OBJECT:
                        jsonReader.beginObject();
                        break;

                    case END_OBJECT:
                        jsonReader.endObject();
                        break;

                    case NAME:
                        name = jsonReader.nextName();
                        break;

                    case STRING:
                        String value = jsonReader.nextString();
                        // System.out.print("val={" + value + "} ");
                        break;

                    case NUMBER:
                        // String value = jsonReader.nextString();
                        break;

                    case NULL:
                        jsonReader.nextNull();
                        break;

                    case BEGIN_ARRAY:
                        jsonReader.beginArray();
                        List<Object> elements = new ArrayList<Object>();
                        while (!nextToken.equals(JsonToken.END_ARRAY)) {
                            nextToken = jsonReader.peek();
                            switch (nextToken) {
                                case STRING:
                                    String str = jsonReader.nextString();
                                    elements.add(str);
                                case NUMBER:
                                    String obj_string = jsonReader.nextString();
                                    elements.add(obj_string);
                                    break;
                                case END_ARRAY:
                                    jsonReader.endArray();
                                    break;
                            }
                        }
                        firstTableModel.insertRow(firstTableModel.getRowCount(), new Object[]{name, elements});
                        secondTableModel.addColumn(name, elements.toArray());
                        break;

                    case END_ARRAY:
                        jsonReader.endArray();
                        break;

                    case BOOLEAN:
                        break;

                    case END_DOCUMENT:
                        return;

                    default:
                        System.out.println("Json file is empty.");
                        break;
                }
            }
            JFrame firstFrame = new JFrame();
            firstFrame.setTitle("First Table");
            firstFrame.setSize(1080, 1080);
            firstFrame.add(new JScrollPane(firstTable));
            firstFrame.setVisible(true);
            firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JFrame secondFrame = new JFrame();
            secondFrame.setTitle("Second Table");
            secondFrame.setSize(1080, 1080);
            secondFrame.add(new JScrollPane(secondTable));
            secondFrame.setVisible(true);
            secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else {
            System.out.println("File doesn't exists!");
        }
    }
}
