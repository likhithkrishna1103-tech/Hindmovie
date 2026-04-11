package dd;

import android.os.Handler;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4139u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ h f4140v;

    private final void a() {
        h hVar = this.f4140v;
        synchronized (hVar.f) {
        }
        a aVar = (a) hVar.f4153c;
        ((Handler) hVar.f4152b).post(new d(hVar, aVar.x(true), aVar.x(false)));
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4139u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                return;
            default:
                h hVar = this.f4140v;
                synchronized (hVar.f) {
                }
                Iterator it = ((LinkedHashSet) hVar.f4156g).iterator();
                if (it.hasNext()) {
                    throw l4.a.k(it);
                }
                hVar.a();
                hVar.b();
                return;
        }
    }

    public /* synthetic */ d(h hVar, boolean z2, boolean z10) {
        this.f4140v = hVar;
    }
}
