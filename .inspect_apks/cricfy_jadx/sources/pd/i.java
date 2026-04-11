package pd;

import f9.s0;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f10211d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ServerSocket f10212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Thread f10213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s0 f10214c;

    static {
        Pattern.compile("([ |\t]*Content-Disposition[ |\t]*:)(.*)", 2);
        Pattern.compile("([ |\t]*content-type[ |\t]*:)(.*)", 2);
        Pattern.compile("[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]");
        f10211d = Logger.getLogger(i.class.getName());
    }

    public static void a(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else {
                    if (!(obj instanceof ServerSocket)) {
                        throw new IllegalArgumentException("Unknown object to close");
                    }
                    ((ServerSocket) obj).close();
                }
            } catch (IOException e9) {
                f10211d.log(Level.SEVERE, "Could not close", (Throwable) e9);
            }
        }
    }

    public static String b(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e9) {
            f10211d.log(Level.WARNING, "Encoding not supported, ignored", (Throwable) e9);
            return null;
        }
    }

    public static f c(e eVar, String str, String str2) {
        byte[] bytes;
        a aVar = new a(str);
        if (str2 == null) {
            return new f(eVar, str, new ByteArrayInputStream(new byte[0]), 0L);
        }
        String str3 = "US-ASCII";
        String str4 = aVar.f10185c;
        try {
            if (!Charset.forName(str4 == null ? "US-ASCII" : str4).newEncoder().canEncode(str2) && str4 == null) {
                aVar = new a(str.concat("; charset=UTF-8"));
            }
            String str5 = aVar.f10185c;
            if (str5 != null) {
                str3 = str5;
            }
            bytes = str2.getBytes(str3);
        } catch (UnsupportedEncodingException e9) {
            f10211d.log(Level.SEVERE, "encoding problem, responding nothing", (Throwable) e9);
            bytes = new byte[0];
        }
        return new f(eVar, aVar.f10183a, new ByteArrayInputStream(bytes), bytes.length);
    }

    public static boolean d(f fVar) {
        String str = fVar.f10203w;
        if (str != null) {
            return str.toLowerCase().contains("text/") || str.toLowerCase().contains("/json");
        }
        return false;
    }
}
