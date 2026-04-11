package ue;

import androidx.lifecycle.j0;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class v {
    public static void a(String str) {
        if (str.length() <= 0) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ('!' > cCharAt || cCharAt >= 127) {
                throw new IllegalArgumentException(ve.b.g("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
            }
        }
    }

    public static void b(String str, String str2) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ve.b.g("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i), str2));
                sb2.append(ve.b.o(str2) ? "" : ": ".concat(str));
                throw new IllegalArgumentException(sb2.toString().toString());
            }
        }
    }

    public static final u e(byte[] bArr) {
        be.h.e(bArr, "<this>");
        int length = bArr.length;
        ve.b.b(bArr.length, 0, length);
        return new u(null, length, bArr);
    }

    public static int f(int i, int i10, String str, boolean z2) {
        while (i < i10) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z2)) {
                return i;
            }
            i++;
        }
        return i10;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static b0 g(String str) {
        be.h.e(str, "javaName");
        int iHashCode = str.hashCode();
        if (iHashCode != 79201641) {
            if (iHashCode != 79923350) {
                switch (iHashCode) {
                    case -503070503:
                        if (str.equals("TLSv1.1")) {
                            return b0.f12939x;
                        }
                        break;
                    case -503070502:
                        if (str.equals("TLSv1.2")) {
                            return b0.f12938w;
                        }
                        break;
                    case -503070501:
                        if (str.equals("TLSv1.3")) {
                            return b0.f12937v;
                        }
                        break;
                }
            } else if (str.equals("TLSv1")) {
                return b0.f12940y;
            }
        } else if (str.equals("SSLv3")) {
            return b0.f12941z;
        }
        throw new IllegalArgumentException("Unexpected TLS version: ".concat(str));
    }

    public static l h(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        List listJ = od.q.f9570u;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") ? true : cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
            throw new IOException("cipherSuite == ".concat(cipherSuite));
        }
        h hVarC = h.f12958b.c(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        b0 b0VarG = g(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
        }
        List listJ2 = peerCertificates != null ? ve.b.j(Arrays.copyOf(peerCertificates, peerCertificates.length)) : listJ;
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listJ = ve.b.j(Arrays.copyOf(localCertificates, localCertificates.length));
        }
        return new l(b0VarG, hVarC, listJ, new j0(3, listJ2));
    }

    public static q i(String str) {
        be.h.e(str, "<this>");
        Matcher matcher = q.f13015c.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
        }
        String strGroup = matcher.group(1);
        be.h.d(strGroup, "typeSubtype.group(1)");
        Locale locale = Locale.US;
        be.h.d(locale, "US");
        be.h.d(strGroup.toLowerCase(locale), "this as java.lang.String).toLowerCase(locale)");
        String strGroup2 = matcher.group(2);
        be.h.d(strGroup2, "typeSubtype.group(2)");
        be.h.d(strGroup2.toLowerCase(locale), "this as java.lang.String).toLowerCase(locale)");
        ArrayList arrayList = new ArrayList();
        Matcher matcher2 = q.f13016d.matcher(str);
        int iEnd = matcher.end();
        while (iEnd < str.length()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                StringBuilder sb2 = new StringBuilder("Parameter is not formatted correctly: \"");
                String strSubstring = str.substring(iEnd);
                be.h.d(strSubstring, "this as java.lang.String).substring(startIndex)");
                sb2.append(strSubstring);
                sb2.append("\" for: \"");
                sb2.append(str);
                sb2.append('\"');
                throw new IllegalArgumentException(sb2.toString().toString());
            }
            String strGroup3 = matcher2.group(1);
            if (strGroup3 == null) {
                iEnd = matcher2.end();
            } else {
                String strGroup4 = matcher2.group(2);
                if (strGroup4 == null) {
                    strGroup4 = matcher2.group(3);
                } else if (ie.n.M(strGroup4, "'", false) && ie.n.H(strGroup4, "'") && strGroup4.length() > 2) {
                    strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                    be.h.d(strGroup4, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                arrayList.add(strGroup3);
                arrayList.add(strGroup4);
                iEnd = matcher2.end();
            }
        }
        return new q(str, (String[]) arrayList.toArray(new String[0]));
    }

    public static t j(String str) throws IOException {
        if (str.equals("http/1.0")) {
            return t.f13046v;
        }
        if (str.equals("http/1.1")) {
            return t.f13047w;
        }
        if (str.equals("h2_prior_knowledge")) {
            return t.f13050z;
        }
        if (str.equals("h2")) {
            return t.f13049y;
        }
        if (str.equals("spdy/3.1")) {
            return t.f13048x;
        }
        if (str.equals("quic")) {
            return t.A;
        }
        throw new IOException("Unexpected protocol: ".concat(str));
    }

    public static m k(String... strArr) {
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        int length = strArr2.length;
        int i = 0;
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr2[i10];
            if (str == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i10] = ie.e.b0(str).toString();
        }
        int iO = cf.d.o(0, strArr2.length - 1, 2);
        if (iO >= 0) {
            while (true) {
                String str2 = strArr2[i];
                String str3 = strArr2[i + 1];
                a(str2);
                b(str3, str2);
                if (i == iO) {
                    break;
                }
                i += 2;
            }
        }
        return new m(strArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long l(java.lang.String r14, int r15) {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ue.v.l(java.lang.String, int):long");
    }

    public static String m(X509Certificate x509Certificate) throws NoSuchAlgorithmException {
        StringBuilder sb2 = new StringBuilder("sha256/");
        hf.i iVar = hf.i.f6114x;
        byte[] encoded = x509Certificate.getPublicKey().getEncoded();
        be.h.d(encoded, "publicKey.encoded");
        int length = encoded.length;
        int i = 0;
        b8.h.c(encoded.length, 0, length);
        a.a.c(length, encoded.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(encoded, 0, length);
        be.h.d(bArrCopyOfRange, "copyOfRange(...)");
        hf.i iVar2 = new hf.i(bArrCopyOfRange);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bArrCopyOfRange, 0, iVar2.a());
        byte[] bArrDigest = messageDigest.digest();
        be.h.b(bArrDigest);
        new hf.i(bArrDigest);
        byte[] bArr = hf.a.f6097a;
        be.h.e(bArr, "map");
        byte[] bArr2 = new byte[((bArrDigest.length + 2) / 3) * 4];
        int length2 = bArrDigest.length - (bArrDigest.length % 3);
        int i10 = 0;
        while (i < length2) {
            byte b10 = bArrDigest[i];
            int i11 = i + 2;
            byte b11 = bArrDigest[i + 1];
            i += 3;
            byte b12 = bArrDigest[i11];
            bArr2[i10] = bArr[(b10 & 255) >> 2];
            bArr2[i10 + 1] = bArr[((b10 & 3) << 4) | ((b11 & 255) >> 4)];
            int i12 = i10 + 3;
            bArr2[i10 + 2] = bArr[((b11 & 15) << 2) | ((b12 & 255) >> 6)];
            i10 += 4;
            bArr2[i12] = bArr[b12 & 63];
        }
        int length3 = bArrDigest.length - length2;
        if (length3 == 1) {
            byte b13 = bArrDigest[i];
            bArr2[i10] = bArr[(b13 & 255) >> 2];
            bArr2[i10 + 1] = bArr[(b13 & 3) << 4];
            bArr2[i10 + 2] = 61;
            bArr2[i10 + 3] = 61;
        } else if (length3 == 2) {
            int i13 = i + 1;
            byte b14 = bArrDigest[i];
            byte b15 = bArrDigest[i13];
            bArr2[i10] = bArr[(b14 & 255) >> 2];
            bArr2[i10 + 1] = bArr[((b14 & 3) << 4) | ((b15 & 255) >> 4)];
            bArr2[i10 + 2] = bArr[(b15 & 15) << 2];
            bArr2[i10 + 3] = 61;
        }
        sb2.append(new String(bArr2, ie.a.f6599a));
        return sb2.toString();
    }

    public abstract long c();

    public abstract q d();

    public abstract void n(hf.p pVar);
}
