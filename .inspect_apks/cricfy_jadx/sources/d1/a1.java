package d1;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a1 implements pe.h0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3205v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f3206w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f3207x;

    public /* synthetic */ a1(int i, Object obj, Object obj2) {
        this.f3205v = i;
        this.f3206w = obj;
        this.f3207x = obj2;
    }

    @Override // pe.h0
    public final void b() {
        switch (this.f3205v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String str = (String) this.f3206w;
                b1 b1Var = (b1) this.f3207x;
                synchronized (c1.f3214b) {
                    LinkedHashMap linkedHashMap = c1.f3215c;
                    c1 c1Var = (c1) linkedHashMap.get(str);
                    if (c1Var != null) {
                        c1Var.f3216a.remove(b1Var);
                        if (c1Var.f3216a.isEmpty()) {
                            linkedHashMap.remove(str);
                            c1Var.stopWatching();
                        }
                    }
                    break;
                }
                return;
            default:
                qe.c cVar = (qe.c) this.f3206w;
                cVar.f10807x.removeCallbacks((pe.k1) this.f3207x);
                return;
        }
    }
}
