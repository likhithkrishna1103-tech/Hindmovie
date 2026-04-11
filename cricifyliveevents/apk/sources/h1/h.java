package h1;

import androidx.datastore.preferences.protobuf.l;
import androidx.datastore.preferences.protobuf.v;
import androidx.datastore.preferences.protobuf.w;
import androidx.datastore.preferences.protobuf.x;
import androidx.datastore.preferences.protobuf.z;
import androidx.media3.decoder.DecoderInputBuffer;
import d1.f1;
import d1.n1;
import ge.i;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import sd.j;
import sd.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f5479a = new h();

    @Override // d1.f1
    public final Object a() {
        return new b(true);
    }

    @Override // d1.f1
    public final void b(Object obj, n1 n1Var) throws IOException {
        v vVarA;
        Map mapA = ((b) obj).a();
        g1.b bVarN = g1.d.n();
        for (Map.Entry entry : mapA.entrySet()) {
            e eVar = (e) entry.getKey();
            Object value = entry.getValue();
            String str = eVar.f5477a;
            if (value instanceof Boolean) {
                g1.g gVarD = g1.h.D();
                boolean zBooleanValue = ((Boolean) value).booleanValue();
                gVarD.c();
                g1.h.q((g1.h) gVarD.f795w, zBooleanValue);
                vVarA = gVarD.a();
            } else if (value instanceof Float) {
                g1.g gVarD2 = g1.h.D();
                float fFloatValue = ((Number) value).floatValue();
                gVarD2.c();
                g1.h.r((g1.h) gVarD2.f795w, fFloatValue);
                vVarA = gVarD2.a();
            } else if (value instanceof Double) {
                g1.g gVarD3 = g1.h.D();
                double dDoubleValue = ((Number) value).doubleValue();
                gVarD3.c();
                g1.h.o((g1.h) gVarD3.f795w, dDoubleValue);
                vVarA = gVarD3.a();
            } else if (value instanceof Integer) {
                g1.g gVarD4 = g1.h.D();
                int iIntValue = ((Number) value).intValue();
                gVarD4.c();
                g1.h.s((g1.h) gVarD4.f795w, iIntValue);
                vVarA = gVarD4.a();
            } else if (value instanceof Long) {
                g1.g gVarD5 = g1.h.D();
                long jLongValue = ((Number) value).longValue();
                gVarD5.c();
                g1.h.l((g1.h) gVarD5.f795w, jLongValue);
                vVarA = gVarD5.a();
            } else if (value instanceof String) {
                g1.g gVarD6 = g1.h.D();
                gVarD6.c();
                g1.h.m((g1.h) gVarD6.f795w, (String) value);
                vVarA = gVarD6.a();
            } else if (value instanceof Set) {
                g1.g gVarD7 = g1.h.D();
                g1.e eVarO = g1.f.o();
                eVarO.c();
                g1.f.l((g1.f) eVarO.f795w, (Set) value);
                gVarD7.c();
                g1.h.n((g1.h) gVarD7.f795w, (g1.f) eVarO.a());
                vVarA = gVarD7.a();
            } else {
                if (!(value instanceof byte[])) {
                    throw new IllegalStateException("PreferencesSerializer does not support type: ".concat(value.getClass().getName()));
                }
                g1.g gVarD8 = g1.h.D();
                byte[] bArr = (byte[]) value;
                androidx.datastore.preferences.protobuf.g gVarC = androidx.datastore.preferences.protobuf.g.c(bArr, 0, bArr.length);
                gVarD8.c();
                g1.h.p((g1.h) gVarD8.f795w, gVarC);
                vVarA = gVarD8.a();
            }
            bVarN.getClass();
            str.getClass();
            bVarN.c();
            g1.d.l((g1.d) bVarN.f795w).put(str, (g1.h) vVarA);
        }
        g1.d dVar = (g1.d) bVarN.a();
        int iA = dVar.a(null);
        Logger logger = l.f738n;
        if (iA > 4096) {
            iA = 4096;
        }
        l lVar = new l(n1Var, iA);
        dVar.b(lVar);
        if (lVar.f742l > 0) {
            lVar.J();
        }
    }

    @Override // d1.f1
    public final Object c(FileInputStream fileInputStream) throws d1.c {
        byte[] bArr;
        try {
            g1.d dVarO = g1.d.o(fileInputStream);
            b bVar = new b(false);
            f[] fVarArr = (f[]) Arrays.copyOf(new f[0], 0);
            i.e(fVarArr, "pairs");
            bVar.b();
            if (fVarArr.length > 0) {
                f fVar = fVarArr[0];
                throw null;
            }
            Map mapM = dVarO.m();
            i.d(mapM, "preferencesProto.preferencesMap");
            for (Map.Entry entry : mapM.entrySet()) {
                String str = (String) entry.getKey();
                g1.h hVar = (g1.h) entry.getValue();
                i.d(str, "name");
                i.d(hVar, "value");
                int iC = hVar.C();
                switch (iC == 0 ? -1 : g.f5478a[y.e.c(iC)]) {
                    case -1:
                        throw new d1.c("Value case is null.", null);
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    default:
                        throw new a9.l();
                    case 1:
                        bVar.e(new e(str), Boolean.valueOf(hVar.t()));
                        break;
                    case 2:
                        bVar.e(new e(str), Float.valueOf(hVar.x()));
                        break;
                    case 3:
                        bVar.e(new e(str), Double.valueOf(hVar.w()));
                        break;
                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                        bVar.e(new e(str), Integer.valueOf(hVar.y()));
                        break;
                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                        bVar.e(new e(str), Long.valueOf(hVar.z()));
                        break;
                    case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                        e eVar = new e(str);
                        String strA = hVar.A();
                        i.d(strA, "value.string");
                        bVar.e(eVar, strA);
                        break;
                    case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                        e eVarM = w8.e.m(str);
                        w wVarN = hVar.B().n();
                        i.d(wVarN, "value.stringSet.stringsList");
                        bVar.e(eVarM, j.u0(wVarN));
                        break;
                    case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                        e eVar2 = new e(str);
                        androidx.datastore.preferences.protobuf.g gVarU = hVar.u();
                        int size = gVarU.size();
                        if (size == 0) {
                            bArr = x.f809b;
                        } else {
                            byte[] bArr2 = new byte[size];
                            gVarU.d(size, bArr2);
                            bArr = bArr2;
                        }
                        i.d(bArr, "value.bytes.toByteArray()");
                        bVar.e(eVar2, bArr);
                        break;
                    case 9:
                        throw new d1.c("Value not set.", null);
                }
            }
            return new b(s.D(bVar.a()), true);
        } catch (z e9) {
            throw new d1.c("Unable to parse preferences proto.", e9);
        }
    }
}
