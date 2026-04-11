package pd;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Closeable {
    public int B;
    public boolean C;
    public boolean D;
    public boolean E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final e f10202v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f10203w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ByteArrayInputStream f10204x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f10205y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f10206z = new c(this);
    public final HashMap A = new HashMap();

    public f(e eVar, String str, ByteArrayInputStream byteArrayInputStream, long j4) {
        this.f10202v = eVar;
        this.f10203w = str;
        this.f10204x = byteArrayInputStream;
        this.f10205y = j4;
        this.C = j4 < 0;
        this.E = true;
    }

    public static void q(PrintWriter printWriter, String str, String str2) {
        printWriter.append((CharSequence) str).append(": ").append((CharSequence) str2).append("\r\n");
    }

    public final long A(PrintWriter printWriter, long j4) {
        String strA = a("content-length");
        if (strA != null) {
            try {
                j4 = Long.parseLong(strA);
            } catch (NumberFormatException unused) {
                i.f10211d.severe("content-length was no number ".concat(strA));
            }
        }
        printWriter.print("Content-Length: " + j4 + "\r\n");
        return j4;
    }

    public final void C(boolean z10) {
        this.D = z10;
    }

    public final void J(boolean z10) {
        this.E = z10;
    }

    public final void O(int i) {
        this.B = i;
    }

    public final String a(String str) {
        return (String) this.A.get(str.toLowerCase());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ByteArrayInputStream byteArrayInputStream = this.f10204x;
        if (byteArrayInputStream != null) {
            byteArrayInputStream.close();
        }
    }

    public final boolean g() {
        return "close".equals(a("connection"));
    }

    public final void s(OutputStream outputStream) {
        String str = this.f10203w;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        e eVar = this.f10202v;
        try {
            if (eVar == null) {
                throw new Error("sendResponse(): Status can't be null.");
            }
            String str2 = new a(str).f10185c;
            if (str2 == null) {
                str2 = "US-ASCII";
            }
            PrintWriter printWriter = new PrintWriter((Writer) new BufferedWriter(new OutputStreamWriter(outputStream, str2)), false);
            printWriter.append("HTTP/1.1 ").append("" + eVar.f10200v + " " + eVar.f10201w).append(" \r\n");
            if (str != null) {
                q(printWriter, "Content-Type", str);
            }
            if (a("date") == null) {
                q(printWriter, "Date", simpleDateFormat.format(new Date()));
            }
            for (Map.Entry entry : this.f10206z.entrySet()) {
                q(printWriter, (String) entry.getKey(), (String) entry.getValue());
            }
            if (a("connection") == null) {
                q(printWriter, "Connection", this.E ? "keep-alive" : "close");
            }
            if (a("content-length") != null) {
                this.D = false;
            }
            if (this.D) {
                q(printWriter, "Content-Encoding", "gzip");
                this.C = true;
            }
            ByteArrayInputStream byteArrayInputStream = this.f10204x;
            long jA = byteArrayInputStream != null ? this.f10205y : 0L;
            if (this.B != 5 && this.C) {
                q(printWriter, "Transfer-Encoding", "chunked");
            } else if (!this.D) {
                jA = A(printWriter, jA);
            }
            printWriter.append("\r\n");
            printWriter.flush();
            if (this.B != 5 && this.C) {
                d dVar = new d(outputStream);
                if (this.D) {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(dVar);
                    z(gZIPOutputStream, -1L);
                    gZIPOutputStream.finish();
                } else {
                    z(dVar, -1L);
                }
                dVar.a();
            } else if (this.D) {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
                z(gZIPOutputStream2, -1L);
                gZIPOutputStream2.finish();
            } else {
                z(outputStream, jA);
            }
            outputStream.flush();
            i.a(byteArrayInputStream);
        } catch (IOException e9) {
            i.f10211d.log(Level.SEVERE, "Could not send response to the client", (Throwable) e9);
        }
    }

    public final void z(OutputStream outputStream, long j4) throws IOException {
        byte[] bArr = new byte[(int) 16384];
        boolean z10 = j4 == -1;
        while (true) {
            if (j4 <= 0 && !z10) {
                return;
            }
            int i = this.f10204x.read(bArr, 0, (int) (z10 ? 16384L : Math.min(j4, 16384L)));
            if (i <= 0) {
                return;
            }
            outputStream.write(bArr, 0, i);
            if (!z10) {
                j4 -= (long) i;
            }
        }
    }
}
