package experimental.json;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;

public class JsonReaderFromStream {


    public static void main(String[] args) throws IOException {

        if (args.length < 1) {
            System.err.println("Usage: JavaWordCount <file>");
            System.exit(1);
        }
        System.out.println(args[0]+ "-"+args[1] );

        JsonReaderFromStream jR = new JsonReaderFromStream();
        File file = new File("/Users/sudhanshu/Documents/practice/src/main/java/experimental/json/sample.json");

        jR.findJsonObjectUsingStack(file);

        //jR.findJsonObjectUsingJavaLib(file);
        return;


    }

    public void findJsonObjectUsingJavaLib(File file) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
        int r;
        int jsonObjectCount = 0;
        boolean objectFound = false;
        StringBuilder s = new StringBuilder();


        while ((r = reader.read()) != -1) {
            char ch = (char) r;
            if (ch == '{') {
                objectFound = true;
                s.append('{');
                break;
            }
        }

        if (!objectFound) {
            return;
        }

        while ((r = reader.read()) != -1) {
            char ch = (char) r;
            if (objectFound) {
                s.append(ch);
            } else if (ch == '{') {
                objectFound = true;
                s.append('{');
            }

            //System.out.println("string-" + s + "-" + ch + "-");
            if (isJSONValid(s.toString())) {
                jsonObjectCount++;
                System.out.println("found " + jsonObjectCount + " json object" + s);
                s = new StringBuilder();
                objectFound = false;
            }
        }
    }

    private boolean isJSONValid(String test) {
        try {
            new JSONObject(test);
            return true;
        } catch (JSONException ex) {
            return false;
        }
    }

    public void findJsonObjectUsingStack(File file) throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
        int r;
        int jsonObjectCount = 0;
        boolean skipNext = false;
        boolean objectStart = false;
        boolean objectFound = false;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while ((r = reader.read()) != -1) {
            char ch = (char) r;
            if (ch == '{') {
                sb.append(ch);
                stack.push(ch);
                break;
            }
        }

        while ((r = reader.read()) != -1) {
            char ch = (char) r;
            if (sb.length() == 0 && (ch == ' ' || ch == '\n' || ch == '\t' || ch == ',' || ch == '[')) {
                continue;
            }
            sb.append(ch);
            if (skipNext) {
                skipNext = false;
                continue;
            } else if (ch != '"' && !stack.empty() && stack.peek() == '"') {
                if(ch =='\\'){
                    skipNext = true;
                }
                continue;
            }

            //System.out.println("string-" + s + "-" + ch + "-");

            switch (ch) {
                case '"':
                    if (!stack.empty() && stack.peek().equals(ch)) {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                    break;
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case '}':
                    if (stack.peek().equals('{')) {
                        stack.pop();
                    }
                    if (stack.empty()) {
                        objectFound = true;
                    }
                    break;
                case ']':
                    if (!stack.empty() && stack.peek().equals('[')) {
                        stack.pop();
                    }
                    break;
                case '\\':
                    skipNext = true;
                    break;
            }

            if (objectFound) {
                jsonObjectCount++;
                System.out.println("found " + jsonObjectCount + " json object" + sb);
                sb = new StringBuilder();
                objectFound = false;
            }

        }

        System.out.println("total " + jsonObjectCount + " json object ");

        reader.close();

    }
}
