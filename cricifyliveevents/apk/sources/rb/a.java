package rb;

import android.util.Base64;
import android.util.JsonReader;
import cc.d;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p6.c;
import qb.a0;
import qb.a2;
import qb.b;
import qb.b0;
import qb.b1;
import qb.b2;
import qb.c0;
import qb.c1;
import qb.c2;
import qb.d0;
import qb.d1;
import qb.d2;
import qb.e;
import qb.e0;
import qb.e1;
import qb.e2;
import qb.f;
import qb.f0;
import qb.f1;
import qb.f2;
import qb.g;
import qb.g0;
import qb.g1;
import qb.g2;
import qb.h;
import qb.h0;
import qb.h1;
import qb.h2;
import qb.i;
import qb.i0;
import qb.i1;
import qb.i2;
import qb.j;
import qb.j0;
import qb.j1;
import qb.j2;
import qb.k;
import qb.k0;
import qb.k2;
import qb.l;
import qb.l0;
import qb.l2;
import qb.m;
import qb.m0;
import qb.m2;
import qb.n;
import qb.n0;
import qb.n2;
import qb.o;
import qb.o1;
import qb.p;
import qb.p0;
import qb.p1;
import qb.q;
import qb.q0;
import qb.q1;
import qb.r;
import qb.r0;
import qb.r1;
import qb.s;
import qb.s0;
import qb.s1;
import qb.t;
import qb.t0;
import qb.t1;
import qb.u;
import qb.u0;
import qb.u1;
import qb.v;
import qb.v0;
import qb.v1;
import qb.w;
import qb.w0;
import qb.w1;
import qb.x;
import qb.x0;
import qb.x1;
import qb.y;
import qb.y0;
import qb.y1;
import qb.z;
import qb.z0;
import qb.z1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10920a;

    static {
        d dVar = new d();
        qb.d dVar2 = qb.d.f10519a;
        dVar.a(n2.class, dVar2);
        dVar.a(b0.class, dVar2);
        j jVar = j.f10600a;
        dVar.a(m2.class, jVar);
        dVar.a(j0.class, jVar);
        g gVar = g.f10559a;
        dVar.a(u1.class, gVar);
        dVar.a(k0.class, gVar);
        h hVar = h.f10569a;
        dVar.a(t1.class, hVar);
        dVar.a(l0.class, hVar);
        z zVar = z.f10779a;
        dVar.a(l2.class, zVar);
        dVar.a(j1.class, zVar);
        y yVar = y.f10769a;
        dVar.a(k2.class, yVar);
        dVar.a(i1.class, yVar);
        i iVar = i.f10577a;
        dVar.a(v1.class, iVar);
        dVar.a(n0.class, iVar);
        t tVar = t.f10729a;
        dVar.a(j2.class, tVar);
        dVar.a(p0.class, tVar);
        k kVar = k.f10622a;
        dVar.a(d2.class, kVar);
        dVar.a(q0.class, kVar);
        m mVar = m.f10647a;
        dVar.a(b2.class, mVar);
        dVar.a(r0.class, mVar);
        p pVar = p.f10689a;
        dVar.a(a2.class, pVar);
        dVar.a(v0.class, pVar);
        q qVar = q.f10698a;
        dVar.a(z1.class, qVar);
        dVar.a(x0.class, qVar);
        n nVar = n.f10665a;
        dVar.a(x1.class, nVar);
        dVar.a(t0.class, nVar);
        b bVar = b.f10484a;
        dVar.a(p1.class, bVar);
        dVar.a(d0.class, bVar);
        qb.a aVar = qb.a.f10463a;
        dVar.a(o1.class, aVar);
        dVar.a(e0.class, aVar);
        o oVar = o.f10679a;
        dVar.a(y1.class, oVar);
        dVar.a(u0.class, oVar);
        l lVar = l.f10637a;
        dVar.a(w1.class, lVar);
        dVar.a(s0.class, lVar);
        qb.c cVar = qb.c.f10507a;
        dVar.a(q1.class, cVar);
        dVar.a(f0.class, cVar);
        r rVar = r.f10709a;
        dVar.a(c2.class, rVar);
        dVar.a(z0.class, rVar);
        s sVar = s.f10719a;
        dVar.a(e2.class, sVar);
        dVar.a(b1.class, sVar);
        u uVar = u.f10741a;
        dVar.a(f2.class, uVar);
        dVar.a(c1.class, uVar);
        x xVar = x.f10762a;
        dVar.a(i2.class, xVar);
        dVar.a(g1.class, xVar);
        v vVar = v.f10746a;
        dVar.a(h2.class, vVar);
        dVar.a(e1.class, vVar);
        w wVar = w.f10754a;
        dVar.a(g2.class, wVar);
        dVar.a(f1.class, wVar);
        e eVar = e.f10542a;
        dVar.a(s1.class, eVar);
        dVar.a(g0.class, eVar);
        f fVar = f.f10552a;
        dVar.a(r1.class, fVar);
        dVar.a(h0.class, fVar);
        dVar.f2136d = true;
        f10920a = new c(6, dVar);
    }

    public static x0 a(JsonReader jsonReader) throws IOException {
        w0 w0Var = new w0();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "offset":
                    w0Var.f10760d = jsonReader.nextLong();
                    w0Var.f = (byte) (w0Var.f | 2);
                    break;
                case "symbol":
                    String strNextString = jsonReader.nextString();
                    if (strNextString == null) {
                        throw new NullPointerException("Null symbol");
                    }
                    w0Var.f10758b = strNextString;
                    break;
                    break;
                case "pc":
                    w0Var.f10757a = jsonReader.nextLong();
                    w0Var.f = (byte) (w0Var.f | 1);
                    break;
                case "file":
                    w0Var.f10759c = jsonReader.nextString();
                    break;
                case "importance":
                    w0Var.f10761e = jsonReader.nextInt();
                    w0Var.f = (byte) (w0Var.f | 4);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return w0Var.a();
    }

    public static f0 b(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("key")) {
                strNextString = jsonReader.nextString();
                if (strNextString == null) {
                    throw new NullPointerException("Null key");
                }
            } else if (strNextName.equals("value")) {
                strNextString2 = jsonReader.nextString();
                if (strNextString2 == null) {
                    throw new NullPointerException("Null value");
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        if (strNextString != null && strNextString2 != null) {
            return new f0(strNextString, strNextString2);
        }
        StringBuilder sb = new StringBuilder();
        if (strNextString == null) {
            sb.append(" key");
        }
        if (strNextString2 == null) {
            sb.append(" value");
        }
        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
    }

    public static d0 c(JsonReader jsonReader) throws IOException {
        c0 c0Var = new c0();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "buildIdMappingForArch":
                    c0Var.i = d(jsonReader, new nc.l(12));
                    break;
                case "pid":
                    c0Var.f10510a = jsonReader.nextInt();
                    c0Var.f10517j = (byte) (c0Var.f10517j | 1);
                    break;
                case "pss":
                    c0Var.f10514e = jsonReader.nextLong();
                    c0Var.f10517j = (byte) (c0Var.f10517j | 8);
                    break;
                case "rss":
                    c0Var.f = jsonReader.nextLong();
                    c0Var.f10517j = (byte) (c0Var.f10517j | 16);
                    break;
                case "timestamp":
                    c0Var.f10515g = jsonReader.nextLong();
                    c0Var.f10517j = (byte) (c0Var.f10517j | 32);
                    break;
                case "processName":
                    String strNextString = jsonReader.nextString();
                    if (strNextString == null) {
                        throw new NullPointerException("Null processName");
                    }
                    c0Var.f10511b = strNextString;
                    break;
                    break;
                case "reasonCode":
                    c0Var.f10512c = jsonReader.nextInt();
                    c0Var.f10517j = (byte) (c0Var.f10517j | 2);
                    break;
                case "traceFile":
                    c0Var.f10516h = jsonReader.nextString();
                    break;
                case "importance":
                    c0Var.f10513d = jsonReader.nextInt();
                    c0Var.f10517j = (byte) (c0Var.f10517j | 4);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return c0Var.a();
    }

    public static List d(JsonReader jsonReader, nc.l lVar) throws IOException {
        Object e0Var;
        Object h0Var;
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            String strNextString = null;
            switch (lVar.f9061v) {
                case 12:
                    jsonReader.beginObject();
                    String strNextString2 = null;
                    String strNextString3 = null;
                    while (jsonReader.hasNext()) {
                        String strNextName = jsonReader.nextName();
                        strNextName.getClass();
                        switch (strNextName) {
                            case "libraryName":
                                strNextString2 = jsonReader.nextString();
                                if (strNextString2 == null) {
                                    throw new NullPointerException("Null libraryName");
                                }
                                break;
                                break;
                            case "arch":
                                String strNextString4 = jsonReader.nextString();
                                if (strNextString4 == null) {
                                    throw new NullPointerException("Null arch");
                                }
                                strNextString = strNextString4;
                                break;
                                break;
                            case "buildId":
                                strNextString3 = jsonReader.nextString();
                                if (strNextString3 == null) {
                                    throw new NullPointerException("Null buildId");
                                }
                                break;
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    if (strNextString == null || strNextString2 == null || strNextString3 == null) {
                        StringBuilder sb = new StringBuilder();
                        if (strNextString == null) {
                            sb.append(" arch");
                        }
                        if (strNextString2 == null) {
                            sb.append(" libraryName");
                        }
                        if (strNextString3 == null) {
                            sb.append(" buildId");
                        }
                        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
                    }
                    e0Var = new e0(strNextString, strNextString2, strNextString3);
                    continue;
                    arrayList.add(e0Var);
                    break;
                case 13:
                    jsonReader.beginObject();
                    byte[] bArrDecode = null;
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.getClass();
                        if (strNextName2.equals("filename")) {
                            String strNextString5 = jsonReader.nextString();
                            if (strNextString5 == null) {
                                throw new NullPointerException("Null filename");
                            }
                            strNextString = strNextString5;
                        } else if (strNextName2.equals("contents")) {
                            bArrDecode = Base64.decode(jsonReader.nextString(), 2);
                            if (bArrDecode == null) {
                                throw new NullPointerException("Null contents");
                            }
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    if (strNextString == null || bArrDecode == null) {
                        StringBuilder sb2 = new StringBuilder();
                        if (strNextString == null) {
                            sb2.append(" filename");
                        }
                        if (bArrDecode == null) {
                            sb2.append(" contents");
                        }
                        throw new IllegalStateException(l0.e.l("Missing required properties:", sb2));
                    }
                    h0Var = new h0(strNextString, bArrDecode);
                    break;
                case 14:
                    d1 d1Var = new d1();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.getClass();
                        switch (strNextName3) {
                            case "parameterKey":
                                String strNextString6 = jsonReader.nextString();
                                if (strNextString6 == null) {
                                    throw new NullPointerException("Null parameterKey");
                                }
                                d1Var.f10538b = strNextString6;
                                break;
                                break;
                            case "templateVersion":
                                d1Var.f10540d = jsonReader.nextLong();
                                d1Var.f10541e = (byte) (d1Var.f10541e | 1);
                                break;
                            case "rolloutVariant":
                                jsonReader.beginObject();
                                String strNextString7 = null;
                                String strNextString8 = null;
                                while (jsonReader.hasNext()) {
                                    String strNextName4 = jsonReader.nextName();
                                    strNextName4.getClass();
                                    if (strNextName4.equals("variantId")) {
                                        strNextString8 = jsonReader.nextString();
                                        if (strNextString8 == null) {
                                            throw new NullPointerException("Null variantId");
                                        }
                                    } else if (strNextName4.equals("rolloutId")) {
                                        strNextString7 = jsonReader.nextString();
                                        if (strNextString7 == null) {
                                            throw new NullPointerException("Null rolloutId");
                                        }
                                    } else {
                                        jsonReader.skipValue();
                                    }
                                }
                                jsonReader.endObject();
                                if (strNextString7 != null && strNextString8 != null) {
                                    d1Var.f10537a = new f1(strNextString7, strNextString8);
                                    break;
                                } else {
                                    StringBuilder sb3 = new StringBuilder();
                                    if (strNextString7 == null) {
                                        sb3.append(" rolloutId");
                                    }
                                    if (strNextString8 == null) {
                                        sb3.append(" variantId");
                                    }
                                    throw new IllegalStateException(l0.e.l("Missing required properties:", sb3));
                                }
                                break;
                            case "parameterValue":
                                String strNextString9 = jsonReader.nextString();
                                if (strNextString9 == null) {
                                    throw new NullPointerException("Null parameterValue");
                                }
                                d1Var.f10539c = strNextString9;
                                break;
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    e0Var = d1Var.a();
                    continue;
                    arrayList.add(e0Var);
                    break;
                case 15:
                    jsonReader.beginObject();
                    List listD = null;
                    byte b8 = 0;
                    int iNextInt = 0;
                    while (jsonReader.hasNext()) {
                        String strNextName5 = jsonReader.nextName();
                        strNextName5.getClass();
                        switch (strNextName5) {
                            case "frames":
                                listD = d(jsonReader, new nc.l(17));
                                if (listD == null) {
                                    throw new NullPointerException("Null frames");
                                }
                                break;
                                break;
                            case "name":
                                strNextString = jsonReader.nextString();
                                if (strNextString == null) {
                                    throw new NullPointerException("Null name");
                                }
                                break;
                            case "importance":
                                iNextInt = jsonReader.nextInt();
                                b8 = (byte) (b8 | 1);
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    if (b8 != 1 || strNextString == null || listD == null) {
                        StringBuilder sb4 = new StringBuilder();
                        if (strNextString == null) {
                            sb4.append(" name");
                        }
                        if ((b8 & 1) == 0) {
                            sb4.append(" importance");
                        }
                        if (listD == null) {
                            sb4.append(" frames");
                        }
                        throw new IllegalStateException(l0.e.l("Missing required properties:", sb4));
                    }
                    h0Var = new v0(strNextString, iNextInt, listD);
                    break;
                case 16:
                    jsonReader.beginObject();
                    String str = null;
                    String str2 = null;
                    byte b10 = 0;
                    long jNextLong = 0;
                    long jNextLong2 = 0;
                    while (jsonReader.hasNext()) {
                        String strNextName6 = jsonReader.nextName();
                        strNextName6.getClass();
                        switch (strNextName6) {
                            case "name":
                                String strNextString10 = jsonReader.nextString();
                                if (strNextString10 == null) {
                                    throw new NullPointerException("Null name");
                                }
                                str = strNextString10;
                                break;
                                break;
                            case "size":
                                b10 = (byte) (b10 | 2);
                                jNextLong2 = jsonReader.nextLong();
                                break;
                            case "uuid":
                                str2 = new String(Base64.decode(jsonReader.nextString(), 2), n2.f10678a);
                                break;
                            case "baseAddress":
                                b10 = (byte) (b10 | 1);
                                jNextLong = jsonReader.nextLong();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    if (b10 != 3 || str == null) {
                        StringBuilder sb5 = new StringBuilder();
                        if ((b10 & 1) == 0) {
                            sb5.append(" baseAddress");
                        }
                        if ((b10 & 2) == 0) {
                            sb5.append(" size");
                        }
                        if (str == null) {
                            sb5.append(" name");
                        }
                        throw new IllegalStateException(l0.e.l("Missing required properties:", sb5));
                    }
                    e0Var = new s0(jNextLong, jNextLong2, str, str2);
                    continue;
                    arrayList.add(e0Var);
                    break;
                default:
                    e0Var = a(jsonReader);
                    continue;
                    arrayList.add(e0Var);
                    break;
            }
            e0Var = h0Var;
            arrayList.add(e0Var);
        }
        jsonReader.endArray();
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static qb.p0 e(android.util.JsonReader r30) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.a.e(android.util.JsonReader):qb.p0");
    }

    public static t0 f(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        int iNextInt = 0;
        String str = null;
        String strNextString = null;
        List list = null;
        t0 t0VarF = null;
        byte b8 = 0;
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endObject();
                if (b8 == 1 && str != null && list != null) {
                    return new t0(str, strNextString, list, t0VarF, iNextInt);
                }
                StringBuilder sb = new StringBuilder();
                if (str == null) {
                    sb.append(" type");
                }
                if (list == null) {
                    sb.append(" frames");
                }
                if ((b8 & 1) == 0) {
                    sb.append(" overflowCount");
                }
                throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
            }
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "frames":
                    List listD = d(jsonReader, new nc.l(17));
                    if (listD == null) {
                        throw new NullPointerException("Null frames");
                    }
                    list = listD;
                    break;
                    break;
                case "reason":
                    strNextString = jsonReader.nextString();
                    break;
                case "type":
                    String strNextString2 = jsonReader.nextString();
                    if (strNextString2 == null) {
                        throw new NullPointerException("Null type");
                    }
                    str = strNextString2;
                    break;
                    break;
                case "causedBy":
                    t0VarF = f(jsonReader);
                    break;
                case "overflowCount":
                    iNextInt = jsonReader.nextInt();
                    b8 = (byte) (b8 | 1);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
    }

    public static z0 g(JsonReader jsonReader) throws IOException {
        y0 y0Var = new y0();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "pid":
                    y0Var.f10775b = jsonReader.nextInt();
                    y0Var.f10778e = (byte) (y0Var.f10778e | 1);
                    break;
                case "processName":
                    String strNextString = jsonReader.nextString();
                    if (strNextString == null) {
                        throw new NullPointerException("Null processName");
                    }
                    y0Var.f10774a = strNextString;
                    break;
                    break;
                case "defaultProcess":
                    y0Var.f10777d = jsonReader.nextBoolean();
                    y0Var.f10778e = (byte) (y0Var.f10778e | 4);
                    break;
                case "importance":
                    y0Var.f10776c = jsonReader.nextInt();
                    y0Var.f10778e = (byte) (y0Var.f10778e | 2);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return y0Var.a();
    }

    public static b0 h(JsonReader jsonReader) throws IOException {
        Charset charset = n2.f10678a;
        a0 a0Var = new a0();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "ndkPayload":
                    jsonReader.beginObject();
                    List listD = null;
                    String strNextString = null;
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.getClass();
                        if (strNextName2.equals("files")) {
                            listD = d(jsonReader, new nc.l(13));
                            if (listD == null) {
                                throw new NullPointerException("Null files");
                            }
                        } else if (strNextName2.equals("orgId")) {
                            strNextString = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    if (listD == null) {
                        throw new IllegalStateException("Missing required properties: files");
                    }
                    a0Var.f10475k = new g0(strNextString, listD);
                    continue;
                    break;
                    break;
                case "sdkVersion":
                    String strNextString2 = jsonReader.nextString();
                    if (strNextString2 == null) {
                        throw new NullPointerException("Null sdkVersion");
                    }
                    a0Var.f10467a = strNextString2;
                    break;
                    break;
                case "appQualitySessionId":
                    a0Var.f10472g = jsonReader.nextString();
                    break;
                case "appExitInfo":
                    a0Var.f10476l = c(jsonReader);
                    break;
                case "buildVersion":
                    String strNextString3 = jsonReader.nextString();
                    if (strNextString3 == null) {
                        throw new NullPointerException("Null buildVersion");
                    }
                    a0Var.f10473h = strNextString3;
                    break;
                    break;
                case "firebaseAuthenticationToken":
                    a0Var.f = jsonReader.nextString();
                    break;
                case "gmpAppId":
                    String strNextString4 = jsonReader.nextString();
                    if (strNextString4 == null) {
                        throw new NullPointerException("Null gmpAppId");
                    }
                    a0Var.f10468b = strNextString4;
                    break;
                    break;
                case "installationUuid":
                    String strNextString5 = jsonReader.nextString();
                    if (strNextString5 == null) {
                        throw new NullPointerException("Null installationUuid");
                    }
                    a0Var.f10470d = strNextString5;
                    break;
                    break;
                case "firebaseInstallationId":
                    a0Var.f10471e = jsonReader.nextString();
                    break;
                case "platform":
                    a0Var.f10469c = jsonReader.nextInt();
                    a0Var.f10477m = (byte) (a0Var.f10477m | 1);
                    break;
                case "displayVersion":
                    String strNextString6 = jsonReader.nextString();
                    if (strNextString6 == null) {
                        throw new NullPointerException("Null displayVersion");
                    }
                    a0Var.i = strNextString6;
                    break;
                    break;
                case "session":
                    i0 i0Var = new i0();
                    i0Var.f = false;
                    i0Var.f10595m = (byte) (i0Var.f10595m | 2);
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.getClass();
                        switch (strNextName3) {
                            case "startedAt":
                                i0Var.f10588d = jsonReader.nextLong();
                                i0Var.f10595m = (byte) (i0Var.f10595m | 1);
                                break;
                            case "appQualitySessionId":
                                i0Var.f10587c = jsonReader.nextString();
                                break;
                            case "identifier":
                                i0Var.f10586b = new String(Base64.decode(jsonReader.nextString(), 2), n2.f10678a);
                                break;
                            case "endedAt":
                                i0Var.f10589e = Long.valueOf(jsonReader.nextLong());
                                break;
                            case "device":
                                m0 m0Var = new m0();
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String strNextName4 = jsonReader.nextName();
                                    strNextName4.getClass();
                                    switch (strNextName4) {
                                        case "simulator":
                                            m0Var.f = jsonReader.nextBoolean();
                                            m0Var.f10659j = (byte) (m0Var.f10659j | 16);
                                            break;
                                        case "manufacturer":
                                            String strNextString7 = jsonReader.nextString();
                                            if (strNextString7 == null) {
                                                throw new NullPointerException("Null manufacturer");
                                            }
                                            m0Var.f10658h = strNextString7;
                                            break;
                                            break;
                                        case "ram":
                                            m0Var.f10655d = jsonReader.nextLong();
                                            m0Var.f10659j = (byte) (m0Var.f10659j | 4);
                                            break;
                                        case "arch":
                                            m0Var.f10652a = jsonReader.nextInt();
                                            m0Var.f10659j = (byte) (m0Var.f10659j | 1);
                                            break;
                                        case "diskSpace":
                                            m0Var.f10656e = jsonReader.nextLong();
                                            m0Var.f10659j = (byte) (m0Var.f10659j | 8);
                                            break;
                                        case "cores":
                                            m0Var.f10654c = jsonReader.nextInt();
                                            m0Var.f10659j = (byte) (m0Var.f10659j | 2);
                                            break;
                                        case "model":
                                            String strNextString8 = jsonReader.nextString();
                                            if (strNextString8 == null) {
                                                throw new NullPointerException("Null model");
                                            }
                                            m0Var.f10653b = strNextString8;
                                            break;
                                            break;
                                        case "state":
                                            m0Var.f10657g = jsonReader.nextInt();
                                            m0Var.f10659j = (byte) (m0Var.f10659j | 32);
                                            break;
                                        case "modelClass":
                                            String strNextString9 = jsonReader.nextString();
                                            if (strNextString9 == null) {
                                                throw new NullPointerException("Null modelClass");
                                            }
                                            m0Var.i = strNextString9;
                                            break;
                                            break;
                                        default:
                                            jsonReader.skipValue();
                                            break;
                                    }
                                }
                                jsonReader.endObject();
                                i0Var.f10592j = m0Var.a();
                                break;
                            case "events":
                                ArrayList arrayList = new ArrayList();
                                jsonReader.beginArray();
                                while (jsonReader.hasNext()) {
                                    arrayList.add(e(jsonReader));
                                }
                                jsonReader.endArray();
                                i0Var.f10593k = Collections.unmodifiableList(arrayList);
                                break;
                            case "os":
                                h1 h1Var = new h1();
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String strNextName5 = jsonReader.nextName();
                                    strNextName5.getClass();
                                    switch (strNextName5) {
                                        case "buildVersion":
                                            String strNextString10 = jsonReader.nextString();
                                            if (strNextString10 == null) {
                                                throw new NullPointerException("Null buildVersion");
                                            }
                                            h1Var.f10574c = strNextString10;
                                            break;
                                            break;
                                        case "jailbroken":
                                            h1Var.f10575d = jsonReader.nextBoolean();
                                            h1Var.f10576e = (byte) (h1Var.f10576e | 2);
                                            break;
                                        case "version":
                                            String strNextString11 = jsonReader.nextString();
                                            if (strNextString11 == null) {
                                                throw new NullPointerException("Null version");
                                            }
                                            h1Var.f10573b = strNextString11;
                                            break;
                                            break;
                                        case "platform":
                                            h1Var.f10572a = jsonReader.nextInt();
                                            h1Var.f10576e = (byte) (h1Var.f10576e | 1);
                                            break;
                                        default:
                                            jsonReader.skipValue();
                                            break;
                                    }
                                }
                                jsonReader.endObject();
                                i0Var.i = h1Var.a();
                                break;
                            case "app":
                                jsonReader.beginObject();
                                String strNextString12 = null;
                                String strNextString13 = null;
                                String strNextString14 = null;
                                String strNextString15 = null;
                                String strNextString16 = null;
                                String strNextString17 = null;
                                while (jsonReader.hasNext()) {
                                    String strNextName6 = jsonReader.nextName();
                                    strNextName6.getClass();
                                    switch (strNextName6) {
                                        case "identifier":
                                            strNextString12 = jsonReader.nextString();
                                            if (strNextString12 == null) {
                                                throw new NullPointerException("Null identifier");
                                            }
                                            break;
                                            break;
                                        case "developmentPlatform":
                                            strNextString16 = jsonReader.nextString();
                                            break;
                                        case "developmentPlatformVersion":
                                            strNextString17 = jsonReader.nextString();
                                            break;
                                        case "version":
                                            strNextString13 = jsonReader.nextString();
                                            if (strNextString13 == null) {
                                                throw new NullPointerException("Null version");
                                            }
                                            break;
                                            break;
                                        case "installationUuid":
                                            strNextString15 = jsonReader.nextString();
                                            break;
                                        case "displayVersion":
                                            strNextString14 = jsonReader.nextString();
                                            break;
                                        default:
                                            jsonReader.skipValue();
                                            break;
                                    }
                                }
                                jsonReader.endObject();
                                if (strNextString12 != null && strNextString13 != null) {
                                    i0Var.f10590g = new k0(strNextString12, strNextString13, strNextString14, strNextString15, strNextString16, strNextString17);
                                    break;
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    if (strNextString12 == null) {
                                        sb.append(" identifier");
                                    }
                                    if (strNextString13 == null) {
                                        sb.append(" version");
                                    }
                                    throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
                                }
                                break;
                            case "user":
                                jsonReader.beginObject();
                                String strNextString18 = null;
                                while (jsonReader.hasNext()) {
                                    if (jsonReader.nextName().equals("identifier")) {
                                        strNextString18 = jsonReader.nextString();
                                        if (strNextString18 == null) {
                                            throw new NullPointerException("Null identifier");
                                        }
                                    } else {
                                        jsonReader.skipValue();
                                    }
                                }
                                jsonReader.endObject();
                                if (strNextString18 == null) {
                                    throw new IllegalStateException("Missing required properties: identifier");
                                }
                                i0Var.f10591h = new j1(strNextString18);
                                break;
                                break;
                            case "generator":
                                String strNextString19 = jsonReader.nextString();
                                if (strNextString19 == null) {
                                    throw new NullPointerException("Null generator");
                                }
                                i0Var.f10585a = strNextString19;
                                break;
                                break;
                            case "crashed":
                                i0Var.f = jsonReader.nextBoolean();
                                i0Var.f10595m = (byte) (i0Var.f10595m | 2);
                                break;
                            case "generatorType":
                                i0Var.f10594l = jsonReader.nextInt();
                                i0Var.f10595m = (byte) (i0Var.f10595m | 4);
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    a0Var.f10474j = i0Var.a();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a0Var.a();
    }

    public static b0 i(String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                b0 b0VarH = h(jsonReader);
                jsonReader.close();
                return b0VarH;
            } finally {
            }
        } catch (IllegalStateException e9) {
            throw new IOException(e9);
        }
    }
}
