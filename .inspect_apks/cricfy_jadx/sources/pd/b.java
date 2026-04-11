package pd;

import h0.t;
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
import z5.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i6.c f10186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OutputStream f10187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BufferedInputStream f10188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10190e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashMap f10191g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashMap f10192h;
    public t i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f10193j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f10194k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ l f10195l;

    public b(l lVar, i6.c cVar, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
        this.f10195l = lVar;
        this.f10186a = cVar;
        this.f10188c = new BufferedInputStream(inputStream, 8192);
        this.f10187b = outputStream;
        this.f10193j = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
        if (!inetAddress.isLoopbackAddress() && !inetAddress.isAnyLocalAddress()) {
            inetAddress.getHostName().getClass();
        }
        this.f10192h = new HashMap();
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
                strTrim = i.b(strNextToken.substring(0, iIndexOf)).trim();
                strB = i.b(strNextToken.substring(iIndexOf + 1));
            } else {
                strTrim = i.b(strNextToken).trim();
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
            byte b8 = bArr[i11];
            if (b8 == 13 && bArr[i12] == 10 && (i10 = i11 + 3) < i && bArr[i11 + 2] == 13 && bArr[i10] == 10) {
                return i11 + 4;
            }
            if (b8 == 10 && bArr[i12] == 10) {
                return i11 + 2;
            }
            i11 = i12;
        }
    }

    public final void a(BufferedReader bufferedReader, HashMap map, HashMap map2, HashMap map3) throws g {
        String strB;
        try {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            if (!stringTokenizer.hasMoreTokens()) {
                throw new g("BAD REQUEST: Syntax error. Usage: GET /example/file.html");
            }
            map.put("method", stringTokenizer.nextToken());
            if (!stringTokenizer.hasMoreTokens()) {
                throw new g("BAD REQUEST: Missing URI. Usage: GET /example/file.html");
            }
            String strNextToken = stringTokenizer.nextToken();
            int iIndexOf = strNextToken.indexOf(63);
            if (iIndexOf >= 0) {
                b(strNextToken.substring(iIndexOf + 1), map2);
                strB = i.b(strNextToken.substring(0, iIndexOf));
            } else {
                strB = i.b(strNextToken);
            }
            if (stringTokenizer.hasMoreTokens()) {
                this.f10194k = stringTokenizer.nextToken();
            } else {
                this.f10194k = "HTTP/1.1";
                i.f10211d.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
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
        } catch (IOException e9) {
            throw new g("SERVER INTERNAL ERROR: IOException: " + e9.getMessage(), e9);
        }
    }

    public final void c() {
        e eVar = e.f10199z;
        l lVar = this.f10195l;
        i6.c cVar = this.f10186a;
        BufferedInputStream bufferedInputStream = this.f10188c;
        OutputStream outputStream = this.f10187b;
        try {
            try {
                try {
                    try {
                        byte[] bArr = new byte[8192];
                        boolean z10 = false;
                        this.f10189d = 0;
                        this.f10190e = 0;
                        bufferedInputStream.mark(8192);
                        try {
                            int i = bufferedInputStream.read(bArr, 0, 8192);
                            if (i == -1) {
                                i.a(bufferedInputStream);
                                i.a(outputStream);
                                throw new SocketException("NanoHttpd Shutdown");
                            }
                            while (i > 0) {
                                int i10 = this.f10190e + i;
                                this.f10190e = i10;
                                int iD = d(i10, bArr);
                                this.f10189d = iD;
                                if (iD > 0) {
                                    break;
                                }
                                int i11 = this.f10190e;
                                i = bufferedInputStream.read(bArr, i11, 8192 - i11);
                            }
                            if (this.f10189d < this.f10190e) {
                                bufferedInputStream.reset();
                                bufferedInputStream.skip(this.f10189d);
                            }
                            this.f10191g = new HashMap();
                            HashMap map = this.f10192h;
                            if (map == null) {
                                this.f10192h = new HashMap();
                            } else {
                                map.clear();
                            }
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, this.f10190e)));
                            HashMap map2 = new HashMap();
                            a(bufferedReader, map2, this.f10191g, this.f10192h);
                            String str = this.f10193j;
                            if (str != null) {
                                this.f10192h.put("remote-addr", str);
                                this.f10192h.put("http-client-ip", str);
                            }
                            int iB = l0.e.b((String) map2.get("method"));
                            this.f = iB;
                            if (iB == 0) {
                                throw new g("BAD REQUEST: Syntax error. HTTP verb " + ((String) map2.get("method")) + " unhandled.");
                            }
                            this.i = new t(this.f10192h);
                            String str2 = (String) this.f10192h.get("connection");
                            boolean z11 = "HTTP/1.1".equals(this.f10194k) && (str2 == null || !str2.matches("(?i).*close.*"));
                            f fVarE = lVar.e();
                            String str3 = (String) this.f10192h.get("accept-encoding");
                            this.i.c();
                            fVarE.O(this.f);
                            if (i.d(fVarE) && str3 != null && str3.contains("gzip")) {
                                z10 = true;
                            }
                            fVarE.C(z10);
                            fVarE.J(z11);
                            fVarE.s(outputStream);
                            if (!z11 || fVarE.g()) {
                                throw new SocketException("NanoHttpd Shutdown");
                            }
                            i.a(fVarE);
                            cVar.b();
                        } catch (SSLException e9) {
                            throw e9;
                        } catch (IOException unused) {
                            i.a(bufferedInputStream);
                            i.a(outputStream);
                            throw new SocketException("NanoHttpd Shutdown");
                        }
                    } catch (g e10) {
                        i.c(e10.a(), "text/plain", e10.getMessage()).s(outputStream);
                        i.a(outputStream);
                        i.a(null);
                        cVar.b();
                    }
                } catch (SSLException e11) {
                    i.c(eVar, "text/plain", "SSL PROTOCOL FAILURE: " + e11.getMessage()).s(outputStream);
                    i.a(outputStream);
                    i.a(null);
                    cVar.b();
                } catch (IOException e12) {
                    i.c(eVar, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e12.getMessage()).s(outputStream);
                    i.a(outputStream);
                    i.a(null);
                    cVar.b();
                }
            } catch (SocketException e13) {
                throw e13;
            } catch (SocketTimeoutException e14) {
                throw e14;
            }
        } catch (Throwable th) {
            i.a(null);
            cVar.b();
            throw th;
        }
    }
}
