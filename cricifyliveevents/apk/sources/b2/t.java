package b2;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import ua.e1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends c {
    public final int A;
    public final l4.c0 B;
    public final l4.c0 C;
    public o D;
    public HttpURLConnection E;
    public InputStream F;
    public boolean G;
    public int H;
    public long I;
    public long J;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f1731z;

    public t(int i, int i10, l4.c0 c0Var) {
        super(true);
        this.f1731z = i;
        this.A = i10;
        this.B = c0Var;
        this.C = new l4.c0(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012b  */
    @Override // b2.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long B(b2.o r27) throws b2.y {
        /*
            Method dump skipped, instruction units count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.t.B(b2.o):long");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b2.h
    public final void close() {
        try {
            InputStream inputStream = this.F;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e9) {
                    int i = y1.a0.f14551a;
                    throw new y(e9, 2000, 3);
                }
            }
        } finally {
            this.F = null;
            h();
            if (this.G) {
                this.G = false;
                c();
            }
            this.E = null;
            this.D = null;
        }
    }

    public final void h() {
        HttpURLConnection httpURLConnection = this.E;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e9) {
                y1.b.h("DefaultHttpDataSource", "Unexpected error while disconnecting", e9);
            }
        }
    }

    @Override // b2.c, b2.h
    public final Map j() {
        HttpURLConnection httpURLConnection = this.E;
        return httpURLConnection == null ? e1.B : new s(httpURLConnection.getHeaderFields());
    }

    public final HttpURLConnection l(URL url, int i, byte[] bArr, long j4, long j7, boolean z10, boolean z11, Map map) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f1731z);
        httpURLConnection.setReadTimeout(this.A);
        HashMap map2 = new HashMap();
        l4.c0 c0Var = this.B;
        if (c0Var != null) {
            map2.putAll(c0Var.O());
        }
        map2.putAll(this.C.O());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = b0.a(j4, j7);
        if (strA != null) {
            httpURLConnection.setRequestProperty("Range", strA);
        }
        httpURLConnection.setRequestProperty("Accept-Encoding", z10 ? "gzip" : "identity");
        httpURLConnection.setInstanceFollowRedirects(z11);
        httpURLConnection.setDoOutput(bArr != null);
        httpURLConnection.setRequestMethod(o.b(i));
        if (bArr == null) {
            httpURLConnection.connect();
            return httpURLConnection;
        }
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        httpURLConnection.connect();
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(bArr);
        outputStream.close();
        return httpURLConnection;
    }

    public final void m(long j4) throws IOException {
        if (j4 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j4 > 0) {
            int iMin = (int) Math.min(j4, 4096);
            InputStream inputStream = this.F;
            int i = y1.a0.f14551a;
            int i10 = inputStream.read(bArr, 0, iMin);
            if (Thread.currentThread().isInterrupted()) {
                throw new y(new InterruptedIOException(), 2000, 1);
            }
            if (i10 == -1) {
                throw new y(2008);
            }
            j4 -= (long) i10;
            b(i10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: IOException -> 0x0032, TRY_LEAVE, TryCatch #0 {IOException -> 0x0032, blocks: (B:5:0x0004, B:7:0x000d, B:10:0x0017, B:11:0x001d, B:14:0x0028), top: B:19:0x0004 }] */
    @Override // v1.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int read(byte[] r7, int r8, int r9) throws b2.y {
        /*
            r6 = this;
            if (r9 != 0) goto L4
            r7 = 0
            return r7
        L4:
            long r0 = r6.I     // Catch: java.io.IOException -> L32
            r2 = -1
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r3 = -1
            if (r2 == 0) goto L1d
            long r4 = r6.J     // Catch: java.io.IOException -> L32
            long r0 = r0 - r4
            r4 = 0
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 != 0) goto L17
            goto L27
        L17:
            long r4 = (long) r9     // Catch: java.io.IOException -> L32
            long r0 = java.lang.Math.min(r4, r0)     // Catch: java.io.IOException -> L32
            int r9 = (int) r0     // Catch: java.io.IOException -> L32
        L1d:
            java.io.InputStream r0 = r6.F     // Catch: java.io.IOException -> L32
            int r1 = y1.a0.f14551a     // Catch: java.io.IOException -> L32
            int r7 = r0.read(r7, r8, r9)     // Catch: java.io.IOException -> L32
            if (r7 != r3) goto L28
        L27:
            return r3
        L28:
            long r8 = r6.J     // Catch: java.io.IOException -> L32
            long r0 = (long) r7     // Catch: java.io.IOException -> L32
            long r8 = r8 + r0
            r6.J = r8     // Catch: java.io.IOException -> L32
            r6.b(r7)     // Catch: java.io.IOException -> L32
            return r7
        L32:
            r7 = move-exception
            int r8 = y1.a0.f14551a
            r8 = 2
            b2.y r7 = b2.y.a(r7, r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.t.read(byte[], int, int):int");
    }

    @Override // b2.h
    public final Uri t() {
        HttpURLConnection httpURLConnection = this.E;
        if (httpURLConnection != null) {
            return Uri.parse(httpURLConnection.getURL().toString());
        }
        o oVar = this.D;
        if (oVar != null) {
            return oVar.f1714a;
        }
        return null;
    }
}
