package f9;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i1 extends v.j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f4217h = 0;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(l1 l1Var) {
        super(20);
        this.i = l1Var;
    }

    @Override // v.j
    public final Object c(Object obj) {
        LinkedHashMap linkedHashMap;
        switch (this.f4217h) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String str = (String) obj;
                o8.u.d(str);
                l1 l1Var = (l1) this.i;
                l1Var.n1();
                o8.u.d(str);
                n nVar = l1Var.f4215x.f4355x;
                q4.P(nVar);
                androidx.emoji2.text.v vVarS2 = nVar.s2(str);
                if (vVarS2 == null) {
                    return null;
                }
                w0 w0Var = ((r1) l1Var.f307w).A;
                r1.g(w0Var);
                w0Var.J.b(str, "Populate EES config from database on cache miss. appId");
                l1Var.u1(str, l1Var.v1(str, (byte[]) vVarS2.f888w));
                i1 i1Var = l1Var.F;
                synchronized (((z) i1Var.f12539g)) {
                    Set setEntrySet = ((w.b) i1Var.f).f13746a.entrySet();
                    ge.i.d(setEntrySet, "<get-entries>(...)");
                    linkedHashMap = new LinkedHashMap(setEntrySet.size());
                    Set<Map.Entry> setEntrySet2 = ((w.b) i1Var.f).f13746a.entrySet();
                    ge.i.d(setEntrySet2, "<get-entries>(...)");
                    for (Map.Entry entry : setEntrySet2) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                        break;
                    }
                }
                return (com.google.android.gms.internal.measurement.d0) linkedHashMap.get(str);
            default:
                String str2 = (String) obj;
                ge.i.e(str2, "key");
                return ((y4.h) this.i).f14853v.c0(str2);
        }
    }

    @Override // v.j
    public void d(boolean z10, Object obj, Object obj2, Object obj3) throws Exception {
        switch (this.f4217h) {
            case 1:
                Object obj4 = (String) obj;
                c5.c cVar = (c5.c) obj2;
                ge.i.e(obj4, "key");
                ge.i.e(cVar, "oldValue");
                cVar.close();
                super.d(z10, obj4, cVar, (c5.c) obj3);
                break;
            default:
                super.d(z10, obj, obj2, obj3);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(y4.h hVar) {
        super(25);
        this.i = hVar;
    }
}
