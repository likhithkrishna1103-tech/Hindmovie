package n0;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.k4;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements p0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8622b;

    public /* synthetic */ f(int i, Object obj) {
        this.f8621a = i;
        this.f8622b = obj;
    }

    @Override // p0.a
    public final void accept(Object obj) {
        switch (this.f8621a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g gVar = (g) obj;
                if (gVar == null) {
                    gVar = new g(-3);
                }
                ((k4) this.f8622b).w(gVar);
                return;
            default:
                g gVar2 = (g) obj;
                synchronized (h.f8627c) {
                    try {
                        s.i iVar = h.f8628d;
                        ArrayList arrayList = (ArrayList) iVar.get((String) this.f8622b);
                        if (arrayList == null) {
                            return;
                        }
                        iVar.remove((String) this.f8622b);
                        for (int i = 0; i < arrayList.size(); i++) {
                            ((p0.a) arrayList.get(i)).accept(gVar2);
                        }
                        return;
                    } finally {
                    }
                }
        }
    }
}
