package xa;

import android.util.Base64;
import android.util.JsonReader;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import u5.d;
import wa.a0;
import wa.a2;
import wa.b;
import wa.b0;
import wa.b1;
import wa.b2;
import wa.c;
import wa.c0;
import wa.c1;
import wa.c2;
import wa.d0;
import wa.d1;
import wa.d2;
import wa.e;
import wa.e0;
import wa.e1;
import wa.e2;
import wa.f;
import wa.f0;
import wa.f1;
import wa.f2;
import wa.g;
import wa.g0;
import wa.g1;
import wa.g2;
import wa.h;
import wa.h0;
import wa.h1;
import wa.h2;
import wa.i;
import wa.i0;
import wa.i1;
import wa.i2;
import wa.j;
import wa.j0;
import wa.j1;
import wa.j2;
import wa.k;
import wa.k0;
import wa.k2;
import wa.l;
import wa.l0;
import wa.l2;
import wa.m;
import wa.m0;
import wa.m2;
import wa.n;
import wa.n0;
import wa.n2;
import wa.o;
import wa.o1;
import wa.p;
import wa.p0;
import wa.p1;
import wa.q;
import wa.q0;
import wa.q1;
import wa.r;
import wa.r0;
import wa.r1;
import wa.s;
import wa.s0;
import wa.s1;
import wa.t;
import wa.t0;
import wa.t1;
import wa.u;
import wa.u0;
import wa.u1;
import wa.v;
import wa.v0;
import wa.v1;
import wa.w;
import wa.w0;
import wa.w1;
import wa.x;
import wa.x0;
import wa.x1;
import wa.y;
import wa.y0;
import wa.y1;
import wa.z;
import wa.z0;
import wa.z1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f14333a;

    static {
        ib.d dVar = new ib.d();
        wa.d dVar2 = wa.d.f13816a;
        dVar.a(n2.class, dVar2);
        dVar.a(b0.class, dVar2);
        j jVar = j.f13897a;
        dVar.a(m2.class, jVar);
        dVar.a(j0.class, jVar);
        g gVar = g.f13856a;
        dVar.a(u1.class, gVar);
        dVar.a(k0.class, gVar);
        h hVar = h.f13866a;
        dVar.a(t1.class, hVar);
        dVar.a(l0.class, hVar);
        z zVar = z.f14076a;
        dVar.a(l2.class, zVar);
        dVar.a(j1.class, zVar);
        y yVar = y.f14066a;
        dVar.a(k2.class, yVar);
        dVar.a(i1.class, yVar);
        i iVar = i.f13874a;
        dVar.a(v1.class, iVar);
        dVar.a(n0.class, iVar);
        t tVar = t.f14026a;
        dVar.a(j2.class, tVar);
        dVar.a(p0.class, tVar);
        k kVar = k.f13919a;
        dVar.a(d2.class, kVar);
        dVar.a(q0.class, kVar);
        m mVar = m.f13944a;
        dVar.a(b2.class, mVar);
        dVar.a(r0.class, mVar);
        p pVar = p.f13986a;
        dVar.a(a2.class, pVar);
        dVar.a(v0.class, pVar);
        q qVar = q.f13995a;
        dVar.a(z1.class, qVar);
        dVar.a(x0.class, qVar);
        n nVar = n.f13962a;
        dVar.a(x1.class, nVar);
        dVar.a(t0.class, nVar);
        b bVar = b.f13781a;
        dVar.a(p1.class, bVar);
        dVar.a(d0.class, bVar);
        wa.a aVar = wa.a.f13760a;
        dVar.a(o1.class, aVar);
        dVar.a(e0.class, aVar);
        o oVar = o.f13976a;
        dVar.a(y1.class, oVar);
        dVar.a(u0.class, oVar);
        l lVar = l.f13934a;
        dVar.a(w1.class, lVar);
        dVar.a(s0.class, lVar);
        c cVar = c.f13804a;
        dVar.a(q1.class, cVar);
        dVar.a(f0.class, cVar);
        r rVar = r.f14006a;
        dVar.a(c2.class, rVar);
        dVar.a(z0.class, rVar);
        s sVar = s.f14016a;
        dVar.a(e2.class, sVar);
        dVar.a(b1.class, sVar);
        u uVar = u.f14038a;
        dVar.a(f2.class, uVar);
        dVar.a(c1.class, uVar);
        x xVar = x.f14059a;
        dVar.a(i2.class, xVar);
        dVar.a(g1.class, xVar);
        v vVar = v.f14043a;
        dVar.a(h2.class, vVar);
        dVar.a(e1.class, vVar);
        w wVar = w.f14051a;
        dVar.a(g2.class, wVar);
        dVar.a(f1.class, wVar);
        e eVar = e.f13839a;
        dVar.a(s1.class, eVar);
        dVar.a(g0.class, eVar);
        f fVar = f.f13849a;
        dVar.a(r1.class, fVar);
        dVar.a(h0.class, fVar);
        dVar.f6481d = true;
        f14333a = new d(17, dVar);
    }

    public static x0 a(JsonReader jsonReader) throws IOException {
        w0 w0Var = new w0();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "offset":
                    w0Var.f14057d = jsonReader.nextLong();
                    w0Var.f = (byte) (w0Var.f | 2);
                    break;
                case "symbol":
                    String strNextString = jsonReader.nextString();
                    if (strNextString == null) {
                        throw new NullPointerException("Null symbol");
                    }
                    w0Var.f14055b = strNextString;
                    break;
                    break;
                case "pc":
                    w0Var.f14054a = jsonReader.nextLong();
                    w0Var.f = (byte) (w0Var.f | 1);
                    break;
                case "file":
                    w0Var.f14056c = jsonReader.nextString();
                    break;
                case "importance":
                    w0Var.f14058e = jsonReader.nextInt();
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
        StringBuilder sb2 = new StringBuilder();
        if (strNextString == null) {
            sb2.append(" key");
        }
        if (strNextString2 == null) {
            sb2.append(" value");
        }
        throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static d0 c(JsonReader jsonReader) throws IOException {
        c0 c0Var = new c0();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            byte b10 = -1;
            switch (strNextName.hashCode()) {
                case -1516200806:
                    if (strNextName.equals("buildIdMappingForArch")) {
                        b10 = 0;
                    }
                    break;
                case 110987:
                    if (strNextName.equals("pid")) {
                        b10 = 1;
                    }
                    break;
                case 111312:
                    if (strNextName.equals("pss")) {
                        b10 = 2;
                    }
                    break;
                case 113234:
                    if (strNextName.equals("rss")) {
                        b10 = 3;
                    }
                    break;
                case 55126294:
                    if (strNextName.equals("timestamp")) {
                        b10 = 4;
                    }
                    break;
                case 202325402:
                    if (strNextName.equals("processName")) {
                        b10 = 5;
                    }
                    break;
                case 722137681:
                    if (strNextName.equals("reasonCode")) {
                        b10 = 6;
                    }
                    break;
                case 723857505:
                    if (strNextName.equals("traceFile")) {
                        b10 = 7;
                    }
                    break;
                case 2125650548:
                    if (strNextName.equals("importance")) {
                        b10 = 8;
                    }
                    break;
            }
            int i = 16;
            switch (b10) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    c0Var.i = d(jsonReader, new r2.h(i));
                    break;
                case 1:
                    c0Var.f13807a = jsonReader.nextInt();
                    c0Var.f13814j = (byte) (c0Var.f13814j | 1);
                    break;
                case 2:
                    c0Var.f13811e = jsonReader.nextLong();
                    c0Var.f13814j = (byte) (c0Var.f13814j | 8);
                    break;
                case 3:
                    c0Var.f = jsonReader.nextLong();
                    c0Var.f13814j = (byte) (16 | c0Var.f13814j);
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    c0Var.f13812g = jsonReader.nextLong();
                    c0Var.f13814j = (byte) (c0Var.f13814j | 32);
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    String strNextString = jsonReader.nextString();
                    if (strNextString == null) {
                        throw new NullPointerException("Null processName");
                    }
                    c0Var.f13808b = strNextString;
                    break;
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    c0Var.f13809c = jsonReader.nextInt();
                    c0Var.f13814j = (byte) (c0Var.f13814j | 2);
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    c0Var.f13813h = jsonReader.nextString();
                    break;
                case 8:
                    c0Var.f13810d = jsonReader.nextInt();
                    c0Var.f13814j = (byte) (c0Var.f13814j | 4);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return c0Var.a();
    }

    public static List d(JsonReader jsonReader, r2.h hVar) throws IOException {
        Object e0Var;
        Object h0Var;
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            String strNextString = null;
            switch (hVar.f11319u) {
                case 16:
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
                        StringBuilder sb2 = new StringBuilder();
                        if (strNextString == null) {
                            sb2.append(" arch");
                        }
                        if (strNextString2 == null) {
                            sb2.append(" libraryName");
                        }
                        if (strNextString3 == null) {
                            sb2.append(" buildId");
                        }
                        throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
                    }
                    e0Var = new e0(strNextString, strNextString2, strNextString3);
                    continue;
                    arrayList.add(e0Var);
                    break;
                case 17:
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
                        StringBuilder sb3 = new StringBuilder();
                        if (strNextString == null) {
                            sb3.append(" filename");
                        }
                        if (bArrDecode == null) {
                            sb3.append(" contents");
                        }
                        throw new IllegalStateException(e6.j.o("Missing required properties:", sb3));
                    }
                    h0Var = new h0(strNextString, bArrDecode);
                    break;
                case 18:
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
                                d1Var.f13835b = strNextString6;
                                break;
                                break;
                            case "templateVersion":
                                d1Var.f13837d = jsonReader.nextLong();
                                d1Var.f13838e = (byte) (d1Var.f13838e | 1);
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
                                    d1Var.f13834a = new f1(strNextString7, strNextString8);
                                    break;
                                } else {
                                    StringBuilder sb4 = new StringBuilder();
                                    if (strNextString7 == null) {
                                        sb4.append(" rolloutId");
                                    }
                                    if (strNextString8 == null) {
                                        sb4.append(" variantId");
                                    }
                                    throw new IllegalStateException(e6.j.o("Missing required properties:", sb4));
                                }
                                break;
                            case "parameterValue":
                                String strNextString9 = jsonReader.nextString();
                                if (strNextString9 == null) {
                                    throw new NullPointerException("Null parameterValue");
                                }
                                d1Var.f13836c = strNextString9;
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
                case 19:
                    jsonReader.beginObject();
                    List listD = null;
                    byte b10 = 0;
                    int iNextInt = 0;
                    while (jsonReader.hasNext()) {
                        String strNextName5 = jsonReader.nextName();
                        strNextName5.getClass();
                        switch (strNextName5) {
                            case "frames":
                                listD = d(jsonReader, new r2.h(21));
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
                                b10 = (byte) (b10 | 1);
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    if (b10 != 1 || strNextString == null || listD == null) {
                        StringBuilder sb5 = new StringBuilder();
                        if (strNextString == null) {
                            sb5.append(" name");
                        }
                        if ((b10 & 1) == 0) {
                            sb5.append(" importance");
                        }
                        if (listD == null) {
                            sb5.append(" frames");
                        }
                        throw new IllegalStateException(e6.j.o("Missing required properties:", sb5));
                    }
                    h0Var = new v0(strNextString, iNextInt, listD);
                    break;
                case 20:
                    jsonReader.beginObject();
                    String str = null;
                    String str2 = null;
                    byte b11 = 0;
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
                                b11 = (byte) (b11 | 2);
                                jNextLong2 = jsonReader.nextLong();
                                break;
                            case "uuid":
                                str2 = new String(Base64.decode(jsonReader.nextString(), 2), n2.f13975a);
                                break;
                            case "baseAddress":
                                b11 = (byte) (b11 | 1);
                                jNextLong = jsonReader.nextLong();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    if (b11 != 3 || str == null) {
                        StringBuilder sb6 = new StringBuilder();
                        if ((b11 & 1) == 0) {
                            sb6.append(" baseAddress");
                        }
                        if ((b11 & 2) == 0) {
                            sb6.append(" size");
                        }
                        if (str == null) {
                            sb6.append(" name");
                        }
                        throw new IllegalStateException(e6.j.o("Missing required properties:", sb6));
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
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static wa.p0 e(android.util.JsonReader r28) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xa.a.e(android.util.JsonReader):wa.p0");
    }

    public static t0 f(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        int iNextInt = 0;
        String str = null;
        String strNextString = null;
        List list = null;
        t0 t0VarF = null;
        byte b10 = 0;
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endObject();
                if (b10 == 1 && str != null && list != null) {
                    return new t0(str, strNextString, list, t0VarF, iNextInt);
                }
                StringBuilder sb2 = new StringBuilder();
                if (str == null) {
                    sb2.append(" type");
                }
                if (list == null) {
                    sb2.append(" frames");
                }
                if ((b10 & 1) == 0) {
                    sb2.append(" overflowCount");
                }
                throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
            }
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "frames":
                    List listD = d(jsonReader, new r2.h(21));
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
                    b10 = (byte) (b10 | 1);
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
                    y0Var.f14072b = jsonReader.nextInt();
                    y0Var.f14075e = (byte) (y0Var.f14075e | 1);
                    break;
                case "processName":
                    String strNextString = jsonReader.nextString();
                    if (strNextString == null) {
                        throw new NullPointerException("Null processName");
                    }
                    y0Var.f14071a = strNextString;
                    break;
                    break;
                case "defaultProcess":
                    y0Var.f14074d = jsonReader.nextBoolean();
                    y0Var.f14075e = (byte) (y0Var.f14075e | 4);
                    break;
                case "importance":
                    y0Var.f14073c = jsonReader.nextInt();
                    y0Var.f14075e = (byte) (y0Var.f14075e | 2);
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
        Charset charset = n2.f13975a;
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
                            listD = d(jsonReader, new r2.h(17));
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
                    a0Var.f13772k = new g0(strNextString, listD);
                    continue;
                    break;
                    break;
                case "sdkVersion":
                    String strNextString2 = jsonReader.nextString();
                    if (strNextString2 == null) {
                        throw new NullPointerException("Null sdkVersion");
                    }
                    a0Var.f13764a = strNextString2;
                    break;
                    break;
                case "appQualitySessionId":
                    a0Var.f13769g = jsonReader.nextString();
                    break;
                case "appExitInfo":
                    a0Var.f13773l = c(jsonReader);
                    break;
                case "buildVersion":
                    String strNextString3 = jsonReader.nextString();
                    if (strNextString3 == null) {
                        throw new NullPointerException("Null buildVersion");
                    }
                    a0Var.f13770h = strNextString3;
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
                    a0Var.f13765b = strNextString4;
                    break;
                    break;
                case "installationUuid":
                    String strNextString5 = jsonReader.nextString();
                    if (strNextString5 == null) {
                        throw new NullPointerException("Null installationUuid");
                    }
                    a0Var.f13767d = strNextString5;
                    break;
                    break;
                case "firebaseInstallationId":
                    a0Var.f13768e = jsonReader.nextString();
                    break;
                case "platform":
                    a0Var.f13766c = jsonReader.nextInt();
                    a0Var.f13774m = (byte) (a0Var.f13774m | 1);
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
                    i0Var.f13892m = (byte) (i0Var.f13892m | 2);
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.getClass();
                        switch (strNextName3) {
                            case "startedAt":
                                i0Var.f13885d = jsonReader.nextLong();
                                i0Var.f13892m = (byte) (i0Var.f13892m | 1);
                                break;
                            case "appQualitySessionId":
                                i0Var.f13884c = jsonReader.nextString();
                                break;
                            case "identifier":
                                i0Var.f13883b = new String(Base64.decode(jsonReader.nextString(), 2), n2.f13975a);
                                break;
                            case "endedAt":
                                i0Var.f13886e = Long.valueOf(jsonReader.nextLong());
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
                                            m0Var.f13956j = (byte) (m0Var.f13956j | 16);
                                            break;
                                        case "manufacturer":
                                            String strNextString7 = jsonReader.nextString();
                                            if (strNextString7 == null) {
                                                throw new NullPointerException("Null manufacturer");
                                            }
                                            m0Var.f13955h = strNextString7;
                                            break;
                                            break;
                                        case "ram":
                                            m0Var.f13952d = jsonReader.nextLong();
                                            m0Var.f13956j = (byte) (m0Var.f13956j | 4);
                                            break;
                                        case "arch":
                                            m0Var.f13949a = jsonReader.nextInt();
                                            m0Var.f13956j = (byte) (m0Var.f13956j | 1);
                                            break;
                                        case "diskSpace":
                                            m0Var.f13953e = jsonReader.nextLong();
                                            m0Var.f13956j = (byte) (m0Var.f13956j | 8);
                                            break;
                                        case "cores":
                                            m0Var.f13951c = jsonReader.nextInt();
                                            m0Var.f13956j = (byte) (m0Var.f13956j | 2);
                                            break;
                                        case "model":
                                            String strNextString8 = jsonReader.nextString();
                                            if (strNextString8 == null) {
                                                throw new NullPointerException("Null model");
                                            }
                                            m0Var.f13950b = strNextString8;
                                            break;
                                            break;
                                        case "state":
                                            m0Var.f13954g = jsonReader.nextInt();
                                            m0Var.f13956j = (byte) (m0Var.f13956j | 32);
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
                                i0Var.f13889j = m0Var.a();
                                break;
                            case "events":
                                ArrayList arrayList = new ArrayList();
                                jsonReader.beginArray();
                                while (jsonReader.hasNext()) {
                                    arrayList.add(e(jsonReader));
                                }
                                jsonReader.endArray();
                                i0Var.f13890k = Collections.unmodifiableList(arrayList);
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
                                            h1Var.f13871c = strNextString10;
                                            break;
                                            break;
                                        case "jailbroken":
                                            h1Var.f13872d = jsonReader.nextBoolean();
                                            h1Var.f13873e = (byte) (h1Var.f13873e | 2);
                                            break;
                                        case "version":
                                            String strNextString11 = jsonReader.nextString();
                                            if (strNextString11 == null) {
                                                throw new NullPointerException("Null version");
                                            }
                                            h1Var.f13870b = strNextString11;
                                            break;
                                            break;
                                        case "platform":
                                            h1Var.f13869a = jsonReader.nextInt();
                                            h1Var.f13873e = (byte) (h1Var.f13873e | 1);
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
                                    i0Var.f13887g = new k0(strNextString12, strNextString13, strNextString14, strNextString15, strNextString16, strNextString17);
                                    break;
                                } else {
                                    StringBuilder sb2 = new StringBuilder();
                                    if (strNextString12 == null) {
                                        sb2.append(" identifier");
                                    }
                                    if (strNextString13 == null) {
                                        sb2.append(" version");
                                    }
                                    throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
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
                                i0Var.f13888h = new j1(strNextString18);
                                break;
                                break;
                            case "generator":
                                String strNextString19 = jsonReader.nextString();
                                if (strNextString19 == null) {
                                    throw new NullPointerException("Null generator");
                                }
                                i0Var.f13882a = strNextString19;
                                break;
                                break;
                            case "crashed":
                                i0Var.f = jsonReader.nextBoolean();
                                i0Var.f13892m = (byte) (i0Var.f13892m | 2);
                                break;
                            case "generatorType":
                                i0Var.f13891l = jsonReader.nextInt();
                                i0Var.f13892m = (byte) (i0Var.f13892m | 4);
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    a0Var.f13771j = i0Var.a();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a0Var.a();
    }

    public static b0 i(String str) {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                b0 b0VarH = h(jsonReader);
                jsonReader.close();
                return b0VarH;
            } finally {
            }
        } catch (IllegalStateException e10) {
            throw new IOException(e10);
        }
    }
}
