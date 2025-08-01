package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Json {
    private String attr;
    private String[] taskArray = new String[50];
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public String toJson(ManagerTask mt) {
        StringBuilder json = new StringBuilder("{tasks:[");

        for (int i=0;i<mt.getTasks().size();i++) {
            //if (i < mt.getTasks().size()-2) {
            json.append("{" + "\"id\":" + mt.getTasks().get(i).getId() + ", " + "\"description\":" + "\"" + mt.getTasks().get(i).getDescription() + "\" , " + "\"status\":" + "\"" + mt.getTasks().get(i).getStatus() + "\" , " + "\"createAt\":" + "\"" + mt.getTasks().get(i).getCreateAt() + "\", " + "\"updateAt\":" + "\"" + mt.getTasks().get(i).getUpdateAt() + "\"},");
        }

        json.append("]}");

        return json.toString();
    }

    public ArrayList toObject(String attr) {
        attr = attr.replaceAll("(\\{|})", "");
        attr = attr.replaceAll("\"", "");
        attr = attr.replaceAll(":", "");
        attr = attr.replaceAll("(tasks|id|description|status|createAt|updateAt)", "");
        attr = attr.replaceAll("\\[|]", "");
        this.taskArray = attr.split(",");
        // System.out.println(Arrays.toString(taskArray));

        Task localTask = new Task();
        int count = 0;
        for (int i=0;i<(taskArray.length/5);i++) {
            localTask = new Task();

            localTask.setId(Integer.parseInt(this.taskArray[count]));
            count++;

            localTask.setDescription(this.taskArray[count]);
            count++;

            localTask.setStatus(this.taskArray[count]);
            count++;

            localTask.setCreateAt(this.taskArray[count]);
            count++;

            localTask.setUpdateAt(this.taskArray[count]);
            count++;

            this.tasks.add(localTask);
            //System.out.println(this.tasks.get(i));
        }
        return this.tasks;
    }

    public ArrayList toObject(InputStream inStream) throws IOException {
        String attr = new String(inStream.readAllBytes());

        attr = attr.replaceAll("(\\{|})", "");
        attr = attr.replaceAll("\"", "");
        attr = attr.replaceAll(":", "");
        attr = attr.replaceAll("(tasks|id|description|status|createAt|updateAt)", "");
        attr = attr.replaceAll("\\[|]", "");
        this.taskArray = attr.split(",");
        // System.out.println(Arrays.toString(taskArray));

        Task localTask = new Task();
        int count = 0;
        for (int i=0;i<(taskArray.length/5);i++) {
            localTask = new Task();

            localTask.setId(Integer.parseInt(this.taskArray[count].trim()));
            count++;

            localTask.setDescription(this.taskArray[count].trim());
            count++;

            localTask.setStatus(this.taskArray[count].trim());
            count++;

            localTask.setCreateAt(this.taskArray[count].trim());
            count++;

            localTask.setUpdateAt(this.taskArray[count].trim());
            count++;

            this.tasks.add(localTask);
            //System.out.println(this.tasks.get(i));
        }
        return this.tasks;
    }
}
