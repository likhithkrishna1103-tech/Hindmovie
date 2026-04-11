package df;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import c.x;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import vc.g0;
import vc.h0;
import w4.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements fe.l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3713v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f3714w;

    public /* synthetic */ l(int i, Object obj) {
        this.f3713v = i;
        this.f3714w = obj;
    }

    @Override // fe.l
    public final Object a(Object obj) {
        int i = this.f3713v;
        rd.l lVar = rd.l.f11003a;
        Object obj2 = this.f3714w;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                n nVar = (n) obj2;
                int iIntValue = ((Integer) obj).intValue();
                return nVar.f3721e[iIntValue] + ": " + nVar.j(iIntValue).b();
            case 1:
                fc.j jVar = (fc.j) obj2;
                h1.b bVar = (h1.b) obj;
                h1.e eVar = fc.j.f4557c;
                long j4 = 0;
                for (Map.Entry entry : bVar.a().entrySet()) {
                    if (entry.getValue() instanceof Set) {
                        h1.e eVar2 = (h1.e) entry.getKey();
                        Set set = (Set) entry.getValue();
                        String strD = jVar.d(System.currentTimeMillis());
                        if (set.contains(strD)) {
                            Object[] objArr = {strD};
                            HashSet hashSet = new HashSet(1);
                            Object obj3 = objArr[0];
                            Objects.requireNonNull(obj3);
                            if (!hashSet.add(obj3)) {
                                throw new IllegalArgumentException("duplicate element: " + obj3);
                            }
                            bVar.d(eVar2, Collections.unmodifiableSet(hashSet));
                            j4++;
                        } else {
                            bVar.c(eVar2);
                        }
                    }
                }
                if (j4 == 0) {
                    bVar.c(eVar);
                } else {
                    bVar.d(eVar, Long.valueOf(j4));
                }
                return null;
            case 2:
                ge.i.e(obj, "it");
                return ((x) obj2).b();
            case 3:
                return ((ne.f) obj2).b(((Integer) obj).intValue());
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return obj == ((sd.a) obj2) ? "(this Collection)" : String.valueOf(obj);
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                d1.c cVar = (d1.c) obj;
                ge.i.e(cVar, "ex");
                Log.w("FirebaseSessions", "CorruptionException in session data DataStore", cVar);
                return new g0(((h0) obj2).f13632a.a(null), null, null);
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                d5.b bVar2 = (d5.b) obj;
                ge.i.e(bVar2, "db");
                ((b0.e) obj2).f1601h = bVar2;
                return lVar;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                w4.a aVar = (w4.a) obj;
                ge.i.e(aVar, "config");
                return ((t) obj2).f(aVar);
            default:
                ((xe.c) obj2).a(null);
                return lVar;
        }
    }

    public /* synthetic */ l(xe.c cVar, xe.b bVar) {
        this.f3713v = 8;
        this.f3714w = cVar;
    }
}
