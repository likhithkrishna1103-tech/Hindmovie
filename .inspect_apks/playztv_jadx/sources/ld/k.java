package ld;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f8153d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ServerSocket f8154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Thread f8155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public af.a f8156c;

    static {
        Pattern.compile("([ |\t]*Content-Disposition[ |\t]*:)(.*)", 2);
        Pattern.compile("([ |\t]*content-type[ |\t]*:)(.*)", 2);
        Pattern.compile("[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]");
        f8153d = Logger.getLogger(k.class.getName());
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
            } catch (IOException e10) {
                f8153d.log(Level.SEVERE, "Could not close", (Throwable) e10);
            }
        }
    }

    public static String b(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e10) {
            f8153d.log(Level.WARNING, "Encoding not supported, ignored", (Throwable) e10);
            return null;
        }
    }

    public static h c(g gVar, String str, String str2) {
        byte[] bytes;
        a aVar = new a(str);
        if (str2 == null) {
            return new h(gVar, str, new ByteArrayInputStream(new byte[0]), 0L);
        }
        String str3 = "US-ASCII";
        String str4 = aVar.f8122c;
        try {
            if (!Charset.forName(str4 == null ? "US-ASCII" : str4).newEncoder().canEncode(str2) && str4 == null) {
                aVar = new a(str.concat("; charset=UTF-8"));
            }
            String str5 = aVar.f8122c;
            if (str5 != null) {
                str3 = str5;
            }
            bytes = str2.getBytes(str3);
        } catch (UnsupportedEncodingException e10) {
            f8153d.log(Level.SEVERE, "encoding problem, responding nothing", (Throwable) e10);
            bytes = new byte[0];
        }
        return new h(gVar, aVar.f8120a, new ByteArrayInputStream(bytes), bytes.length);
    }

    public static boolean d(h hVar) {
        String str = hVar.f8144v;
        if (str != null) {
            return str.toLowerCase().contains("text/") || str.toLowerCase().contains("/json");
        }
        return false;
    }
}
