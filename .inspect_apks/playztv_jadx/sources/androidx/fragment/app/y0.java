package androidx.fragment.app;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y0 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f1419u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ z0 f1420v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ j f1421w;

    public /* synthetic */ y0(j jVar, z0 z0Var, int i) {
        this.f1419u = i;
        this.f1421w = jVar;
        this.f1420v = z0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1419u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ArrayList arrayList = this.f1421w.f1288b;
                z0 z0Var = this.f1420v;
                if (arrayList.contains(z0Var)) {
                    l4.a.a(z0Var.f1429c.f1378a0, z0Var.f1427a);
                }
                break;
            default:
                j jVar = this.f1421w;
                ArrayList arrayList2 = jVar.f1288b;
                z0 z0Var2 = this.f1420v;
                arrayList2.remove(z0Var2);
                jVar.f1289c.remove(z0Var2);
                break;
        }
    }
}
