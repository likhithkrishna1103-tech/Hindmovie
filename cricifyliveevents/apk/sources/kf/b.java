package kf;

import java.io.IOException;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f7436b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f7437c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f7438d = new b();

    public static final h a(b bVar, String str) {
        h hVar = new h(str);
        h.f7466d.put(str, hVar);
        return hVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static d0 c(String str) {
        ge.i.e(str, "javaName");
        int iHashCode = str.hashCode();
        if (iHashCode != 79201641) {
            if (iHashCode != 79923350) {
                switch (iHashCode) {
                    case -503070503:
                        if (str.equals("TLSv1.1")) {
                            return d0.f7458z;
                        }
                        break;
                    case -503070502:
                        if (str.equals("TLSv1.2")) {
                            return d0.f7457y;
                        }
                        break;
                    case -503070501:
                        if (str.equals("TLSv1.3")) {
                            return d0.f7456x;
                        }
                        break;
                }
            } else if (str.equals("TLSv1")) {
                return d0.A;
            }
        } else if (str.equals("SSLv3")) {
            return d0.B;
        }
        throw new IllegalArgumentException("Unexpected TLS version: ".concat(str));
    }

    public static v d(String str) throws IOException {
        if (str.equals("http/1.0")) {
            return v.f7573x;
        }
        if (str.equals("http/1.1")) {
            return v.f7574y;
        }
        if (str.equals("h2_prior_knowledge")) {
            return v.B;
        }
        if (str.equals("h2")) {
            return v.A;
        }
        if (str.equals("spdy/3.1")) {
            return v.f7575z;
        }
        if (str.equals("quic")) {
            return v.C;
        }
        if (ne.o.Z(str, "h3", false)) {
            return v.D;
        }
        throw new IOException("Unexpected protocol: ".concat(str));
    }

    public synchronized h b(String str) {
        h hVar;
        String strConcat;
        try {
            ge.i.e(str, "javaName");
            LinkedHashMap linkedHashMap = h.f7466d;
            hVar = (h) linkedHashMap.get(str);
            if (hVar == null) {
                if (ne.o.Z(str, "TLS_", false)) {
                    String strSubstring = str.substring(4);
                    ge.i.d(strSubstring, "substring(...)");
                    strConcat = "SSL_".concat(strSubstring);
                } else if (ne.o.Z(str, "SSL_", false)) {
                    String strSubstring2 = str.substring(4);
                    ge.i.d(strSubstring2, "substring(...)");
                    strConcat = "TLS_".concat(strSubstring2);
                } else {
                    strConcat = str;
                }
                hVar = (h) linkedHashMap.get(strConcat);
                if (hVar == null) {
                    hVar = new h(str);
                }
                linkedHashMap.put(str, hVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return hVar;
    }
}
