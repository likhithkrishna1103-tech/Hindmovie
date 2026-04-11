package q0;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import nb.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements s0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10337b;

    public /* synthetic */ f(int i, Object obj) {
        this.f10336a = i;
        this.f10337b = obj;
    }

    @Override // s0.a
    public final void accept(Object obj) {
        switch (this.f10336a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g gVar = (g) obj;
                if (gVar == null) {
                    gVar = new g(-3);
                }
                ((w) this.f10337b).L(gVar);
                return;
            default:
                g gVar2 = (g) obj;
                synchronized (h.f10342c) {
                    try {
                        v.k kVar = h.f10343d;
                        ArrayList arrayList = (ArrayList) kVar.get((String) this.f10337b);
                        if (arrayList == null) {
                            return;
                        }
                        kVar.remove((String) this.f10337b);
                        for (int i = 0; i < arrayList.size(); i++) {
                            ((s0.a) arrayList.get(i)).accept(gVar2);
                        }
                        return;
                    } finally {
                    }
                }
        }
    }
}
