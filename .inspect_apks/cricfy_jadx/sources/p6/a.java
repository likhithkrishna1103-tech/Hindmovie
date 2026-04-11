package p6;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Closeable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HttpURLConnection f10028v;

    public a(HttpURLConnection httpURLConnection) {
        this.f10028v = httpURLConnection;
    }

    public static String g(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }

    public final String a() {
        HttpURLConnection httpURLConnection = this.f10028v;
        boolean z10 = false;
        try {
            try {
                if (httpURLConnection.getResponseCode() / 100 == 2) {
                    z10 = true;
                }
            } catch (NullPointerException e9) {
                e = e9;
            }
        } catch (IOException unused) {
        }
        if (z10) {
            return null;
        }
        try {
            return "Unable to fetch " + httpURLConnection.getURL() + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + g(httpURLConnection);
        } catch (IOException e10) {
            e = e10;
        }
        s6.c.c("get error failed ", e);
        return e.getMessage();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f10028v.disconnect();
    }
}
