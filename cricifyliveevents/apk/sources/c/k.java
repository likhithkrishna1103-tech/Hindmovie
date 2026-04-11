package c;

import android.content.Intent;
import android.content.IntentSender;
import android.util.Pair;
import androidx.media3.decoder.DecoderInputBuffer;
import g2.e1;
import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f1964v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f1965w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ int f1966x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f1967y;

    public /* synthetic */ k(Object obj, int i, Object obj2, int i10) {
        this.f1964v = i10;
        this.f1965w = obj;
        this.f1966x = i;
        this.f1967y = obj2;
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, l2.l] */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1964v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                l lVar = (l) this.f1965w;
                Serializable serializable = (Serializable) ((pc.c) this.f1967y).f10180v;
                String str = (String) lVar.f1968a.get(Integer.valueOf(this.f1966x));
                if (str != null) {
                    e.e eVar = (e.e) lVar.f1972e.get(str);
                    if ((eVar != null ? eVar.f3739a : null) == null) {
                        lVar.f1973g.remove(str);
                        lVar.f.put(str, serializable);
                    } else {
                        e.b bVar = eVar.f3739a;
                        if (lVar.f1971d.remove(str)) {
                            bVar.i(serializable);
                        }
                    }
                    break;
                }
                break;
            case 1:
                ((l) this.f1965w).a(this.f1966x, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) this.f1967y));
                break;
            case 2:
                e1 e1Var = (e1) this.f1965w;
                Pair pair = (Pair) this.f1967y;
                ((h2.f) e1Var.f4667w.i).O(((Integer) pair.first).intValue(), (s2.c0) pair.second, this.f1966x);
                break;
            case 3:
                l2.k kVar = (l2.k) this.f1965w;
                this.f1967y.O(kVar.f7671a, kVar.f7672b, this.f1966x);
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                ((t4.b) ((ff.l) this.f1965w).f4594d).j(this.f1966x, this.f1967y);
                break;
            default:
                CopyOnWriteArraySet<y1.o> copyOnWriteArraySet = (CopyOnWriteArraySet) this.f1965w;
                y1.m mVar = (y1.m) this.f1967y;
                for (y1.o oVar : copyOnWriteArraySet) {
                    if (!oVar.f14590d) {
                        int i = this.f1966x;
                        if (i != -1) {
                            oVar.f14588b.b(i);
                        }
                        oVar.f14589c = true;
                        mVar.a(oVar.f14587a);
                    }
                }
                break;
        }
    }

    public /* synthetic */ k(Object obj, Object obj2, int i, int i10) {
        this.f1964v = i10;
        this.f1965w = obj;
        this.f1967y = obj2;
        this.f1966x = i;
    }
}
