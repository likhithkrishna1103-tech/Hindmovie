package v1;

import aa.h1;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q extends c {
    public final p2.c A;
    public final p2.c B;
    public m C;
    public HttpURLConnection D;
    public InputStream E;
    public boolean F;
    public int G;
    public long H;
    public long I;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f13172y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f13173z;

    public q(int i, int i10, p2.c cVar) {
        super(true);
        this.f13172y = i;
        this.f13173z = i10;
        this.A = cVar;
        this.B = new p2.c(21);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // v1.h
    public final void close() {
        try {
            InputStream inputStream = this.E;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                    int i = s1.b0.f11647a;
                    throw new v(2000, 3, e10);
                }
            }
        } finally {
            this.E = null;
            j();
            if (this.F) {
                this.F = false;
                c();
            }
            this.D = null;
            this.C = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012b  */
    @Override // v1.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long h(v1.m r27) throws v1.v {
        /*
            Method dump skipped, instruction units count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.q.h(v1.m):long");
    }

    public final void j() {
        HttpURLConnection httpURLConnection = this.D;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e10) {
                s1.b.h("DefaultHttpDataSource", "Unexpected error while disconnecting", e10);
            }
        }
    }

    @Override // v1.c, v1.h
    public final Map k() {
        HttpURLConnection httpURLConnection = this.D;
        return httpURLConnection == null ? h1.A : new p(httpURLConnection.getHeaderFields());
    }

    @Override // v1.h
    public final Uri o() {
        HttpURLConnection httpURLConnection = this.D;
        if (httpURLConnection != null) {
            return Uri.parse(httpURLConnection.getURL().toString());
        }
        m mVar = this.C;
        if (mVar != null) {
            return mVar.f13157a;
        }
        return null;
    }

    public final HttpURLConnection p(URL url, int i, byte[] bArr, long j5, long j8, boolean z2, boolean z10, Map map) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f13172y);
        httpURLConnection.setReadTimeout(this.f13173z);
        HashMap map2 = new HashMap();
        p2.c cVar = this.A;
        if (cVar != null) {
            map2.putAll(cVar.l());
        }
        map2.putAll(this.B.l());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = y.a(j5, j8);
        if (strA != null) {
            httpURLConnection.setRequestProperty("Range", strA);
        }
        httpURLConnection.setRequestProperty("Accept-Encoding", z2 ? "gzip" : "identity");
        httpURLConnection.setInstanceFollowRedirects(z10);
        httpURLConnection.setDoOutput(bArr != null);
        httpURLConnection.setRequestMethod(m.b(i));
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

    public final void q(long j5) throws IOException {
        if (j5 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j5 > 0) {
            int iMin = (int) Math.min(j5, 4096);
            InputStream inputStream = this.E;
            int i = s1.b0.f11647a;
            int i10 = inputStream.read(bArr, 0, iMin);
            if (Thread.currentThread().isInterrupted()) {
                throw new v(2000, 1, new InterruptedIOException());
            }
            if (i10 == -1) {
                throw new v(2008);
            }
            j5 -= (long) i10;
            b(i10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: IOException -> 0x0032, TRY_LEAVE, TryCatch #0 {IOException -> 0x0032, blocks: (B:5:0x0004, B:7:0x000d, B:10:0x0017, B:11:0x001d, B:14:0x0028), top: B:19:0x0004 }] */
    @Override // p1.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int read(byte[] r7, int r8, int r9) throws v1.v {
        /*
            r6 = this;
            if (r9 != 0) goto L4
            r7 = 0
            return r7
        L4:
            long r0 = r6.H     // Catch: java.io.IOException -> L32
            r2 = -1
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r3 = -1
            if (r2 == 0) goto L1d
            long r4 = r6.I     // Catch: java.io.IOException -> L32
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
            java.io.InputStream r0 = r6.E     // Catch: java.io.IOException -> L32
            int r1 = s1.b0.f11647a     // Catch: java.io.IOException -> L32
            int r7 = r0.read(r7, r8, r9)     // Catch: java.io.IOException -> L32
            if (r7 != r3) goto L28
        L27:
            return r3
        L28:
            long r8 = r6.I     // Catch: java.io.IOException -> L32
            long r0 = (long) r7     // Catch: java.io.IOException -> L32
            long r8 = r8 + r0
            r6.I = r8     // Catch: java.io.IOException -> L32
            r6.b(r7)     // Catch: java.io.IOException -> L32
            return r7
        L32:
            r7 = move-exception
            int r8 = s1.b0.f11647a
            r8 = 2
            v1.v r7 = v1.v.a(r8, r7)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.q.read(byte[], int, int):int");
    }
}
