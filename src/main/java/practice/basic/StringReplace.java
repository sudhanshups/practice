package practice.basic;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;

public class StringReplace {
    public static void main(String[] args) throws IOException {
        StringReplace a = new StringReplace();
        a.stringReplace();



    }


    private void stringReplace() throws IOException {
        String value = "1234567890";   // imagine a large string loaded from a file

        String value1 = value.replace("12", "ab")
                .replace("34", "cd")
                .replace("56", "ef")
                .replace("78", "gh")
                .replace("90", "ij");

        System.out.println(value1);


        Map<String, String> tokens = new HashMap<String, String>();
        tokens.put("token1", "value1");
        tokens.put("token2", "JJ ROCKS!!!");

        MapTokenResolver resolver = new MapTokenResolver(tokens);

        Reader source =
                new StringReader("1234567890${token1}abcdefg${token2}XYZ$000");

        Reader reader = new TokenReplacingReader(source, resolver);

        int data = reader.read();
        while (data != -1) {
            System.out.print((char) data);
            data = reader.read();
        }

    }
}

class MapTokenResolver implements ITokenResolver {
    protected Map<String, String> tokenMap = new HashMap<>();

    public MapTokenResolver(Map<String, String> tokenMap) {
        this.tokenMap = tokenMap;
    }

    public String resolveToken(String tokenName) {
        return this.tokenMap.get(tokenName);
    }
}

interface ITokenResolver {
    public String resolveToken(String tokenName);
}

class TokenReplacingReader extends Reader {

    protected PushbackReader pushbackReader = null;
    protected ITokenResolver tokenResolver = null;
    protected StringBuilder tokenNameBuffer = new StringBuilder();
    protected String tokenValue = null;
    protected int tokenValueIndex = 0;

    public TokenReplacingReader(Reader source, ITokenResolver resolver) {
        this.pushbackReader = new PushbackReader(source, 2);
        this.tokenResolver = resolver;
    }

    public int read(CharBuffer target) throws IOException {
        throw new RuntimeException("Operation Not Supported");
    }

    public int read() throws IOException {
        if (this.tokenValue != null) {
            if (this.tokenValueIndex < this.tokenValue.length()) {
                return this.tokenValue.charAt(this.tokenValueIndex++);
            }
            if (this.tokenValueIndex == this.tokenValue.length()) {
                this.tokenValue = null;
                this.tokenValueIndex = 0;
            }
        }

        int data = this.pushbackReader.read();
        if (data != '$') return data;

        data = this.pushbackReader.read();
        if (data != '{') {
            this.pushbackReader.unread(data);
            return '$';
        }
        this.tokenNameBuffer.delete(0, this.tokenNameBuffer.length());

        data = this.pushbackReader.read();
        while (data != '}') {
            this.tokenNameBuffer.append((char) data);
            data = this.pushbackReader.read();
        }

        this.tokenValue = this.tokenResolver.resolveToken(this.tokenNameBuffer.toString());

        if (this.tokenValue == null) {
            this.tokenValue = "${" + this.tokenNameBuffer.toString() + "}";
        }
        if (this.tokenValue.length() == 0) {
            return read();
        }
        return this.tokenValue.charAt(this.tokenValueIndex++);


    }

    public int read(char cbuf[]) throws IOException {
        return read(cbuf, 0, cbuf.length);
    }

    public int read(char cbuf[], int off, int len) throws IOException {
        int charsRead = 0;
        for (int i = 0; i < len; i++) {
            int nextChar = read();
            if (nextChar == -1) {
                if (charsRead == 0) {
                    charsRead = -1;
                }
                break;
            }
            charsRead = i + 1;
            cbuf[off + i] = (char) nextChar;
        }
        return charsRead;
    }

    public void close() throws IOException {
        this.pushbackReader.close();
    }

    public long skip(long n) throws IOException {
        throw new RuntimeException("Operation Not Supported");
    }

    public boolean ready() throws IOException {
        return this.pushbackReader.ready();
    }

    public boolean markSupported() {
        return false;
    }

    public void mark(int readAheadLimit) throws IOException {
        throw new RuntimeException("Operation Not Supported");
    }

    public void reset() throws IOException {
        throw new RuntimeException("Operation Not Supported");
    }
}