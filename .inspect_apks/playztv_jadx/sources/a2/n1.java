package a2;

import android.content.Intent;
import android.content.IntentSender;
import android.util.Pair;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n1 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f338u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f339v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f340w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f341x;

    public /* synthetic */ n1(Object obj, int i, Object obj2, int i10) {
        this.f338u = i10;
        this.f340w = obj;
        this.f339v = i;
        this.f341x = obj2;
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [f2.l, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f338u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                q1 q1Var = (q1) this.f340w;
                Pair pair = (Pair) this.f341x;
                ((b2.h) q1Var.f389v.i).s(((Integer) pair.first).intValue(), (o2.d0) pair.second, this.f339v);
                break;
            case 1:
                c.k kVar = (c.k) this.f340w;
                Serializable serializable = (Serializable) ((u5.c) this.f341x).f12782v;
                String str = (String) kVar.f2175a.get(Integer.valueOf(this.f339v));
                if (str != null) {
                    e.e eVar = (e.e) kVar.f2179e.get(str);
                    if ((eVar != null ? eVar.f4219a : null) == null) {
                        kVar.f2180g.remove(str);
                        kVar.f.put(str, serializable);
                    } else {
                        e.b bVar = eVar.f4219a;
                        if (kVar.f2178d.remove(str)) {
                            bVar.j(serializable);
                        }
                    }
                    break;
                }
                break;
            case 2:
                ((c.k) this.f340w).a(this.f339v, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) this.f341x));
                break;
            case 3:
                f2.k kVar2 = (f2.k) this.f340w;
                this.f341x.s(kVar2.f4739a, kVar2.f4740b, this.f339v);
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                ((o4.a) this.f340w).f9336b.m(this.f339v, this.f341x);
                break;
            default:
                CopyOnWriteArraySet<s1.o> copyOnWriteArraySet = (CopyOnWriteArraySet) this.f340w;
                s1.m mVar = (s1.m) this.f341x;
                for (s1.o oVar : copyOnWriteArraySet) {
                    if (!oVar.f11685d) {
                        int i = this.f339v;
                        if (i != -1) {
                            oVar.f11683b.d(i);
                        }
                        oVar.f11684c = true;
                        mVar.a(oVar.f11682a);
                    }
                }
                break;
        }
    }

    public /* synthetic */ n1(Object obj, Object obj2, int i, int i10) {
        this.f338u = i10;
        this.f340w = obj;
        this.f341x = obj2;
        this.f339v = i;
    }
}
