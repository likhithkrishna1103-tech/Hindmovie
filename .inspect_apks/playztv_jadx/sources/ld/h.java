package ld;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Closeable {
    public int A;
    public boolean B;
    public boolean C;
    public boolean D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final g f8143u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f8144v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ByteArrayInputStream f8145w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f8146x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final e f8147y = new e(this);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final HashMap f8148z = new HashMap();

    public h(g gVar, String str, ByteArrayInputStream byteArrayInputStream, long j5) {
        this.f8143u = gVar;
        this.f8144v = str;
        this.f8145w = byteArrayInputStream;
        this.f8146x = j5;
        this.B = j5 < 0;
        this.D = true;
    }

    public static void v(PrintWriter printWriter, String str, String str2) {
        printWriter.append((CharSequence) str).append(": ").append((CharSequence) str2).append("\r\n");
    }

    public final void F(OutputStream outputStream, long j5) throws IOException {
        byte[] bArr = new byte[(int) 16384];
        boolean z2 = j5 == -1;
        while (true) {
            if (j5 <= 0 && !z2) {
                return;
            }
            int i = this.f8145w.read(bArr, 0, (int) (z2 ? 16384L : Math.min(j5, 16384L)));
            if (i <= 0) {
                return;
            }
            outputStream.write(bArr, 0, i);
            if (!z2) {
                j5 -= (long) i;
            }
        }
    }

    public final long G(PrintWriter printWriter, long j5) {
        String strA = a("content-length");
        if (strA != null) {
            try {
                j5 = Long.parseLong(strA);
            } catch (NumberFormatException unused) {
                k.f8153d.severe("content-length was no number ".concat(strA));
            }
        }
        printWriter.print("Content-Length: " + j5 + "\r\n");
        return j5;
    }

    public final void H(boolean z2) {
        this.C = z2;
    }

    public final void J(boolean z2) {
        this.D = z2;
    }

    public final void K(int i) {
        this.A = i;
    }

    public final String a(String str) {
        return (String) this.f8148z.get(str.toLowerCase());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ByteArrayInputStream byteArrayInputStream = this.f8145w;
        if (byteArrayInputStream != null) {
            byteArrayInputStream.close();
        }
    }

    public final boolean d() {
        return "close".equals(a("connection"));
    }

    public final void x(OutputStream outputStream) {
        String str = this.f8144v;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        g gVar = this.f8143u;
        try {
            if (gVar == null) {
                throw new Error("sendResponse(): Status can't be null.");
            }
            String str2 = new a(str).f8122c;
            if (str2 == null) {
                str2 = "US-ASCII";
            }
            PrintWriter printWriter = new PrintWriter((Writer) new BufferedWriter(new OutputStreamWriter(outputStream, str2)), false);
            printWriter.append("HTTP/1.1 ").append("" + gVar.f8141u + " " + gVar.f8142v).append(" \r\n");
            if (str != null) {
                v(printWriter, "Content-Type", str);
            }
            if (a("date") == null) {
                v(printWriter, "Date", simpleDateFormat.format(new Date()));
            }
            for (Map.Entry entry : this.f8147y.entrySet()) {
                v(printWriter, (String) entry.getKey(), (String) entry.getValue());
            }
            if (a("connection") == null) {
                v(printWriter, "Connection", this.D ? "keep-alive" : "close");
            }
            if (a("content-length") != null) {
                this.C = false;
            }
            if (this.C) {
                v(printWriter, "Content-Encoding", "gzip");
                this.B = true;
            }
            ByteArrayInputStream byteArrayInputStream = this.f8145w;
            long jG = byteArrayInputStream != null ? this.f8146x : 0L;
            if (this.A != 5 && this.B) {
                v(printWriter, "Transfer-Encoding", "chunked");
            } else if (!this.C) {
                jG = G(printWriter, jG);
            }
            printWriter.append("\r\n");
            printWriter.flush();
            if (this.A != 5 && this.B) {
                f fVar = new f(outputStream);
                if (this.C) {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(fVar);
                    F(gZIPOutputStream, -1L);
                    gZIPOutputStream.finish();
                } else {
                    F(fVar, -1L);
                }
                fVar.a();
            } else if (this.C) {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
                F(gZIPOutputStream2, -1L);
                gZIPOutputStream2.finish();
            } else {
                F(outputStream, jG);
            }
            outputStream.flush();
            k.a(byteArrayInputStream);
        } catch (IOException e10) {
            k.f8153d.log(Level.SEVERE, "Could not send response to the client", (Throwable) e10);
        }
    }
}
