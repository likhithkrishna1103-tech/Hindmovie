package ld;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import javax.net.ssl.SSLException;
import pc.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f8126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OutputStream f8127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BufferedInputStream f8128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8130e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashMap f8131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashMap f8132h;
    public b i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f8133j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f8134k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ m f8135l;

    public d(m mVar, c cVar, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
        this.f8135l = mVar;
        this.f8126a = cVar;
        this.f8128c = new BufferedInputStream(inputStream, 8192);
        this.f8127b = outputStream;
        this.f8133j = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
        if (!inetAddress.isLoopbackAddress() && !inetAddress.isAnyLocalAddress()) {
            inetAddress.getHostName().getClass();
        }
        this.f8132h = new HashMap();
    }

    public static void b(String str, Map map) {
        String strTrim;
        String strB;
        if (str == null) {
            return;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            int iIndexOf = strNextToken.indexOf(61);
            if (iIndexOf >= 0) {
                strTrim = k.b(strNextToken.substring(0, iIndexOf)).trim();
                strB = k.b(strNextToken.substring(iIndexOf + 1));
            } else {
                strTrim = k.b(strNextToken).trim();
                strB = "";
            }
            List arrayList = (List) map.get(strTrim);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(strTrim, arrayList);
            }
            arrayList.add(strB);
        }
    }

    public static int d(int i, byte[] bArr) {
        int i10;
        int i11 = 0;
        while (true) {
            int i12 = i11 + 1;
            if (i12 >= i) {
                return 0;
            }
            byte b10 = bArr[i11];
            if (b10 == 13 && bArr[i12] == 10 && (i10 = i11 + 3) < i && bArr[i11 + 2] == 13 && bArr[i10] == 10) {
                return i11 + 4;
            }
            if (b10 == 10 && bArr[i12] == 10) {
                return i11 + 2;
            }
            i11 = i12;
        }
    }

    public final void a(BufferedReader bufferedReader, HashMap map, HashMap map2, HashMap map3) throws i {
        String strB;
        try {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            if (!stringTokenizer.hasMoreTokens()) {
                throw new i("BAD REQUEST: Syntax error. Usage: GET /example/file.html");
            }
            map.put("method", stringTokenizer.nextToken());
            if (!stringTokenizer.hasMoreTokens()) {
                throw new i("BAD REQUEST: Missing URI. Usage: GET /example/file.html");
            }
            String strNextToken = stringTokenizer.nextToken();
            int iIndexOf = strNextToken.indexOf(63);
            if (iIndexOf >= 0) {
                b(strNextToken.substring(iIndexOf + 1), map2);
                strB = k.b(strNextToken.substring(0, iIndexOf));
            } else {
                strB = k.b(strNextToken);
            }
            if (stringTokenizer.hasMoreTokens()) {
                this.f8134k = stringTokenizer.nextToken();
            } else {
                this.f8134k = "HTTP/1.1";
                k.f8153d.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
            }
            String line2 = bufferedReader.readLine();
            while (line2 != null && !line2.trim().isEmpty()) {
                int iIndexOf2 = line2.indexOf(58);
                if (iIndexOf2 >= 0) {
                    map3.put(line2.substring(0, iIndexOf2).trim().toLowerCase(Locale.US), line2.substring(iIndexOf2 + 1).trim());
                }
                line2 = bufferedReader.readLine();
            }
            map.put("uri", strB);
        } catch (IOException e10) {
            throw new i("SERVER INTERNAL ERROR: IOException: " + e10.getMessage(), e10);
        }
    }

    public final void c() {
        g gVar = g.f8139y;
        m mVar = this.f8135l;
        c cVar = this.f8126a;
        BufferedInputStream bufferedInputStream = this.f8128c;
        OutputStream outputStream = this.f8127b;
        try {
            try {
                try {
                    try {
                        byte[] bArr = new byte[8192];
                        boolean z2 = false;
                        this.f8129d = 0;
                        this.f8130e = 0;
                        bufferedInputStream.mark(8192);
                        try {
                            int i = bufferedInputStream.read(bArr, 0, 8192);
                            if (i == -1) {
                                k.a(bufferedInputStream);
                                k.a(outputStream);
                                throw new SocketException("NanoHttpd Shutdown");
                            }
                            while (i > 0) {
                                int i10 = this.f8130e + i;
                                this.f8130e = i10;
                                int iD = d(i10, bArr);
                                this.f8129d = iD;
                                if (iD > 0) {
                                    break;
                                }
                                int i11 = this.f8130e;
                                i = bufferedInputStream.read(bArr, i11, 8192 - i11);
                            }
                            if (this.f8129d < this.f8130e) {
                                bufferedInputStream.reset();
                                bufferedInputStream.skip(this.f8129d);
                            }
                            this.f8131g = new HashMap();
                            HashMap map = this.f8132h;
                            if (map == null) {
                                this.f8132h = new HashMap();
                            } else {
                                map.clear();
                            }
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, this.f8130e)));
                            HashMap map2 = new HashMap();
                            a(bufferedReader, map2, this.f8131g, this.f8132h);
                            String str = this.f8133j;
                            if (str != null) {
                                this.f8132h.put("remote-addr", str);
                                this.f8132h.put("http-client-ip", str);
                            }
                            int iC = e6.j.c((String) map2.get("method"));
                            this.f = iC;
                            if (iC == 0) {
                                throw new i("BAD REQUEST: Syntax error. HTTP verb " + ((String) map2.get("method")) + " unhandled.");
                            }
                            this.i = new b(this.f8132h);
                            String str2 = (String) this.f8132h.get("connection");
                            boolean z10 = "HTTP/1.1".equals(this.f8134k) && (str2 == null || !str2.matches("(?i).*close.*"));
                            h hVarE = mVar.e();
                            String str3 = (String) this.f8132h.get("accept-encoding");
                            this.i.b();
                            hVarE.K(this.f);
                            if (k.d(hVarE) && str3 != null && str3.contains("gzip")) {
                                z2 = true;
                            }
                            hVarE.H(z2);
                            hVarE.J(z10);
                            hVarE.x(outputStream);
                            if (!z10 || hVarE.d()) {
                                throw new SocketException("NanoHttpd Shutdown");
                            }
                            k.a(hVarE);
                            cVar.a();
                        } catch (SSLException e10) {
                            throw e10;
                        } catch (IOException unused) {
                            k.a(bufferedInputStream);
                            k.a(outputStream);
                            throw new SocketException("NanoHttpd Shutdown");
                        }
                    } catch (i e11) {
                        k.c(e11.a(), "text/plain", e11.getMessage()).x(outputStream);
                        k.a(outputStream);
                        k.a(null);
                        cVar.a();
                    }
                } catch (SSLException e12) {
                    k.c(gVar, "text/plain", "SSL PROTOCOL FAILURE: " + e12.getMessage()).x(outputStream);
                    k.a(outputStream);
                    k.a(null);
                    cVar.a();
                } catch (IOException e13) {
                    k.c(gVar, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e13.getMessage()).x(outputStream);
                    k.a(outputStream);
                    k.a(null);
                    cVar.a();
                }
            } catch (SocketException e14) {
                throw e14;
            } catch (SocketTimeoutException e15) {
                throw e15;
            }
        } catch (Throwable th) {
            k.a(null);
            cVar.a();
            throw th;
        }
    }
}
