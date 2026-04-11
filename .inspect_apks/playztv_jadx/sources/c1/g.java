package c1;

import a2.y0;
import androidx.datastore.preferences.protobuf.b0;
import androidx.datastore.preferences.protobuf.k;
import androidx.datastore.preferences.protobuf.w;
import androidx.datastore.preferences.protobuf.y;
import androidx.media3.decoder.DecoderInputBuffer;
import b1.j;
import be.h;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import od.i;
import od.t;
import z0.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f2237a = new g();

    public final b a(FileInputStream fileInputStream) throws z0.a {
        try {
            b1.f fVarL = b1.f.l(fileInputStream);
            b bVar = new b(false);
            e[] eVarArr = (e[]) Arrays.copyOf(new e[0], 0);
            h.e(eVarArr, "pairs");
            if (bVar.f2232b.get()) {
                throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
            }
            if (eVarArr.length > 0) {
                e eVar = eVarArr[0];
                throw null;
            }
            Map mapJ = fVarL.j();
            h.d(mapJ, "preferencesProto.preferencesMap");
            for (Map.Entry entry : mapJ.entrySet()) {
                String str = (String) entry.getKey();
                j jVar = (j) entry.getValue();
                h.d(str, "name");
                h.d(jVar, "value");
                int iX = jVar.x();
                switch (iX == 0 ? -1 : f.f2236a[v.e.c(iX)]) {
                    case -1:
                        throw new z0.a("Value case is null.", null);
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    default:
                        throw new y0();
                    case 1:
                        bVar.b(new d(str), Boolean.valueOf(jVar.p()));
                        break;
                    case 2:
                        bVar.b(new d(str), Float.valueOf(jVar.s()));
                        break;
                    case 3:
                        bVar.b(new d(str), Double.valueOf(jVar.r()));
                        break;
                    case j.LONG_FIELD_NUMBER /* 4 */:
                        bVar.b(new d(str), Integer.valueOf(jVar.t()));
                        break;
                    case j.STRING_FIELD_NUMBER /* 5 */:
                        bVar.b(new d(str), Long.valueOf(jVar.u()));
                        break;
                    case j.STRING_SET_FIELD_NUMBER /* 6 */:
                        d dVar = new d(str);
                        String strV = jVar.v();
                        h.d(strV, "value.string");
                        bVar.b(dVar, strV);
                        break;
                    case j.DOUBLE_FIELD_NUMBER /* 7 */:
                        d dVar2 = new d(str);
                        y yVarK = jVar.w().k();
                        h.d(yVarK, "value.stringSet.stringsList");
                        bVar.b(dVar2, i.j0(yVarK));
                        break;
                    case 8:
                        throw new z0.a("Value not set.", null);
                }
            }
            Map mapUnmodifiableMap = Collections.unmodifiableMap(bVar.f2231a);
            h.d(mapUnmodifiableMap, "unmodifiableMap(preferencesMap)");
            return new b(t.K(mapUnmodifiableMap), true);
        } catch (b0 e10) {
            throw new z0.a("Unable to parse preferences proto.", e10);
        }
    }

    public final void b(Object obj, m mVar) throws IOException {
        w wVarA;
        Map mapUnmodifiableMap = Collections.unmodifiableMap(((b) obj).f2231a);
        h.d(mapUnmodifiableMap, "unmodifiableMap(preferencesMap)");
        b1.d dVarK = b1.f.k();
        for (Map.Entry entry : mapUnmodifiableMap.entrySet()) {
            d dVar = (d) entry.getKey();
            Object value = entry.getValue();
            String str = dVar.f2235a;
            if (value instanceof Boolean) {
                b1.i iVarY = j.y();
                boolean zBooleanValue = ((Boolean) value).booleanValue();
                iVarY.c();
                j.m((j) iVarY.f1139v, zBooleanValue);
                wVarA = iVarY.a();
            } else if (value instanceof Float) {
                b1.i iVarY2 = j.y();
                float fFloatValue = ((Number) value).floatValue();
                iVarY2.c();
                j.n((j) iVarY2.f1139v, fFloatValue);
                wVarA = iVarY2.a();
            } else if (value instanceof Double) {
                b1.i iVarY3 = j.y();
                double dDoubleValue = ((Number) value).doubleValue();
                iVarY3.c();
                j.l((j) iVarY3.f1139v, dDoubleValue);
                wVarA = iVarY3.a();
            } else if (value instanceof Integer) {
                b1.i iVarY4 = j.y();
                int iIntValue = ((Number) value).intValue();
                iVarY4.c();
                j.o((j) iVarY4.f1139v, iIntValue);
                wVarA = iVarY4.a();
            } else if (value instanceof Long) {
                b1.i iVarY5 = j.y();
                long jLongValue = ((Number) value).longValue();
                iVarY5.c();
                j.i((j) iVarY5.f1139v, jLongValue);
                wVarA = iVarY5.a();
            } else if (value instanceof String) {
                b1.i iVarY6 = j.y();
                iVarY6.c();
                j.j((j) iVarY6.f1139v, (String) value);
                wVarA = iVarY6.a();
            } else {
                if (!(value instanceof Set)) {
                    throw new IllegalStateException(h.h(value.getClass().getName(), "PreferencesSerializer does not support type: "));
                }
                b1.i iVarY7 = j.y();
                b1.g gVarL = b1.h.l();
                gVarL.c();
                b1.h.i((b1.h) gVarL.f1139v, (Set) value);
                iVarY7.c();
                j.k((j) iVarY7.f1139v, gVarL);
                wVarA = iVarY7.a();
            }
            dVarK.getClass();
            dVarK.c();
            b1.f.i((b1.f) dVarK.f1139v).put(str, (j) wVarA);
        }
        b1.f fVar = (b1.f) dVarK.a();
        int iA = fVar.a();
        Logger logger = k.f1076h;
        if (iA > 4096) {
            iA = 4096;
        }
        k kVar = new k(mVar, iA);
        fVar.c(kVar);
        if (kVar.f > 0) {
            kVar.B();
        }
    }
}
